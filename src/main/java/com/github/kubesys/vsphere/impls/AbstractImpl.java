/**
 * Copyright (2020, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.vsphere.impls;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kubesys.vsphere.VsphereClient;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * wuheng@otcaix.iscas.ac.cn
 *
 */
public abstract class AbstractImpl {

	/**
	 * client
	 */
	protected final VsphereClient client;

	public AbstractImpl(VsphereClient client) {
		super();
		this.client = client;
	}

	protected Headers getHeaders(String cookie, String token) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");
		
		if (cookie != null) {
			map.put("Cookie", cookie + "; vmware-api-session-id=" + client.getSession());
		} else {
			map.put("Cookie", "vmware-api-session-id=" + client.getSession());
		}
		
		if (token != null) {
			map.put("X-VSPHERE-UI-XSRF-TOKEN", token);
		}
		return Headers.of(map);
	}
	

	protected JsonNode listWithoutCookie(String url) throws Exception {
		Request request = new Request.Builder()
				.url(url)
				.headers(getHeaders(null, null))
				.method("GET", null)
				.build();
		return valid(new ObjectMapper().readTree(client.getHttpClient().newCall(request).execute().body().byteStream()));
	}
	
	
	protected JsonNode deleteWithoutCookie(String url) throws Exception {
		Request request = new Request.Builder()
				.url(url)
				.headers(getHeaders(null, null))
				.method("DELETE", null)
				.build();
		return new ObjectMapper().readTree(client.getHttpClient().newCall(request).execute().body().byteStream());
	}
	
	protected JsonNode getWithoutCookie(String url) throws Exception {
		Request request = new Request.Builder()
				.url(url)
				.headers(getHeaders(null, null))
				.method("GET", null)
				.build();
		return valid(new ObjectMapper().readTree(client.getHttpClient().newCall(request).execute().body().byteStream()));
	}
	

	@SuppressWarnings("deprecation")
	protected JsonNode postWithoutCookie(String url, String str) throws Exception {
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, str);
		Request request = new Request.Builder()
				.url(url)
				.headers(getHeaders(null, null))
				.method("POST", body)
				.build();
		return valid(new ObjectMapper().readTree(client.getHttpClient().newCall(request).execute().body().byteStream()));
	}
	
	@SuppressWarnings("deprecation")
	protected JsonNode patchWithoutCookie(String url, String str) throws Exception {
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, str);
		Request request = new Request.Builder()
				.url(url)
				.headers(getHeaders(null, null))
				.method("PATCH", body)
				.build();
		return valid(new ObjectMapper().readTree(client.getHttpClient().newCall(request).execute().body().byteStream()));
	}
	
	@SuppressWarnings("deprecation")
	protected JsonNode postWithCookie(String url, String str, String cookie, String token) throws Exception {
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, str);
		Request request = new Request.Builder()
				.url(url)
				.headers(getHeaders(cookie, token))
				.method("POST", body)
				.build();
		return valid(new ObjectMapper().readTree(client.getHttpClient().newCall(request).execute().body().byteStream()));
	}
	
	@SuppressWarnings("deprecation")
	protected JsonNode postWithCookie(OkHttpClient newClient, String url, String str, String cookie, String token) throws Exception {
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, str);
		Request request = new Request.Builder()
				.url(url)
				.headers(getHeaders(cookie, token))
				.method("POST", body)
				.build();
		
		InputStream byteStream = newClient.newCall(request).execute().body().byteStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(byteStream));
		
		StringBuilder sb = new StringBuilder();
		String line = null;
		
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		return valid(new ObjectMapper().readTree(sb.toString()));
	}

	@SuppressWarnings("deprecation")
	protected JsonNode removeWithoutCookie(String url, String str) throws Exception {
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, str);
		Request request = new Request.Builder()
				.url(url)
				.headers(getHeaders(null, null))
				.method("DELETE", body)
				.build();
		return valid(new ObjectMapper().readTree(client.getHttpClient().newCall(request).execute().body().byteStream()));
	}

	protected JsonNode listWithCookie(String url, String cookie) throws Exception {
		Request request = new Request.Builder()
				.url(url)
				.headers(getHeaders(cookie, null))
				.method("GET", null)
				.build();
		ResponseBody body = client.getHttpClient().newCall(request).execute().body();
		return valid(new ObjectMapper().readTree(body.byteStream()));

	}

	public String searchRealname(String name, String type, String cookie) {

		try {
			String clusterIdUrl = this.client.getUrl() + "/ui/search/quicksearch/?opId=0&query=" + name;

			JsonNode objects = listWithCookie(clusterIdUrl, cookie);

			int objList = objects.size();

			for (int i = 0; i < objList; i++) {
				JsonNode obj = objects.get(i);
				if (obj.get("label").asText().equals(type)) {

					JsonNode results = obj.get("results");

					int resList = results.size();

					for (int j = 0; j < resList; j++) {

						JsonNode res = results.get(j);

						if (res.get("name").asText().equals(name)) {

							return res.get("id").asText();
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public JsonNode detail(String id, String model, String cookie) throws Exception {
		String url = this.client.getUrl() + "/ui/data/" + id + "?model=" + model;
		return valid(listWithCookie(url, cookie));
	}
	
	
	
	public JsonNode info(String id, String model, String cookie) throws Exception {
		return valid(listWithCookie(this.client.getUrl() + "/ui/data/" 
							+ id + "?model=" + model, cookie));
	}
	
	public JsonNode search(String name, String type, String cookie) {

		try {
			String clusterIdUrl = this.client.getUrl() + "/ui/search/quicksearch/?opId=0&query=" + name;

			JsonNode objects = listWithCookie(clusterIdUrl, cookie);

			int objList = objects.size();

			for (int i = 0; i < objList; i++) {
				JsonNode obj = objects.get(i);
				String asText = obj.get("label").asText();
				if (asText.equals(type)) {

					JsonNode results = obj.get("results");

					int resList = results.size();

					for (int j = 0; j < resList; j++) {

						JsonNode res = results.get(j);

						if (res.get("name").asText().equals(name)) {

							return res;
						}
					}
					
					return results.get(0);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public JsonNode searchUUID(String name, String type, String cookie) {

		try {
			
			String clusterIdUrl = this.client.getUrl() + "/ui/search/quicksearch/?opId=0&query=" + name;
			return valid(listWithCookie(clusterIdUrl, cookie));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public JsonNode valid(JsonNode json)  throws Exception {
		if (json.has("value") && json.get("value").has("messages")) {
			throw new Exception(json.get("value").get("messages").toString());
		} 
		return json;
	}
}
