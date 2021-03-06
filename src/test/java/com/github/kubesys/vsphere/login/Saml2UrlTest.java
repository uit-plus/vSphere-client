package com.github.kubesys.vsphere.login;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.kubesys.vsphere.VsphereClient;
import com.github.kubesys.vsphere.VsphereClientTest;

import okhttp3.Response;

/**
 * Unit test for simple App.
 */
public class Saml2UrlTest extends VsphereClientTest {
	
	public static void main(String[] args) throws Exception {
		VsphereClient httpClient = getClient();
		JsonNode jsonNode = httpClient.loginUrl();
		String cookie = httpClient.getKeyInHeader("Set-Cookie", jsonNode);
		String url = httpClient.getKeyInHeader("Location", jsonNode);
		Response resp = httpClient.saml2Url(url, cookie);
		System.out.println(resp.header("Set-Cookie"));
		System.out.println(
				httpClient.getSAMLResponse(resp.body().byteStream()));
	}
}

