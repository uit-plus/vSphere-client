package com.github.kubesys.vsphere.login;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.kubesys.vsphere.VsphereClient;
import com.github.kubesys.vsphere.VsphereClientTest;

/**
 * Unit test for simple App.
 */
public class UITest extends VsphereClientTest {
	
	public static void main(String[] args) throws Exception {
		VsphereClient httpClient = getClient();
		String cookie = httpClient.getCookie();
		JsonNode jsonNode = httpClient.uiUrl(cookie);
		System.out.println(httpClient.getKeyInHeader("Set-Cookie", jsonNode));
	}
}

