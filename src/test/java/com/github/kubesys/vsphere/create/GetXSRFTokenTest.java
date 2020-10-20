package com.github.kubesys.vsphere.create;

import com.github.kubesys.vsphere.VsphereClientTest;

/**
 * Unit test for simple App.
 */
public class GetXSRFTokenTest extends VsphereClientTest {
	
	public static void main(String[] args) throws Exception {
		String cookie = "CastleSessionvsphere.test=_424d98e6bf7f8dbd59938bc407f7e5f8; VSPHERE-UI-JSESSIONID=5AE72AC5D6E6A03172263404A1EA76B9; VSPHERE-USERNAME=Administrator%40VSPHERE.TEST; VSPHERE-CLIENT-SESSION-INDEX=_d37aaf00513f9c71b082544f5fd8f506";
		System.out.println(getClient().getXSRFToken(cookie));
	}
}

