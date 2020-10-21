package com.github.kubesys.vsphere.create;

import com.github.kubesys.vsphere.VsphereClientTest;

/**
 * Unit test for simple App.
 */
public class GetXSRFTokenTest extends VsphereClientTest {
	
	public static void main(String[] args) throws Exception {
		String cookie = "CastleSessionvsphere.test=_118030de4da039a72c7c5ef9631c860d; VSPHERE-UI-JSESSIONID=3622472ACB9CEA40519E938F1E4E067F; VSPHERE-USERNAME=Administrator%40VSPHERE.TEST; VSPHERE-CLIENT-SESSION-INDEX=_134d8adfaac236857d1b7623d940d05d";
		System.out.println(getClient().getXSRFToken(cookie));
	}
}

