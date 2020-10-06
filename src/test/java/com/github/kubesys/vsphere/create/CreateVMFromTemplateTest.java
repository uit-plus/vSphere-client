package com.github.kubesys.vsphere.create;

import com.github.kubesys.vsphere.VsphereClientTest;

/**
 * Unit test for simple App.
 */
public class CreateVMFromTemplateTest extends VsphereClientTest {
	
	public static void main(String[] args) throws Exception {
		String cookie = "CastleSessionvsphere.test=_a508022e065a2d5503343de398632031; VSPHERE-UI-JSESSIONID=B681433D517C97FC2BE8760E5F26C013; VSPHERE-USERNAME=Administrator%40VSPHERE.TEST; VSPHERE-CLIENT-SESSION-INDEX=_8795d65ad8206903ef6b688c6322a663";
		String token = "e99269fa-9682-4b5a-9478-04ec88a5d210";
		System.out.println(getClient().virtualMachines().createFromTemplate("henry20", "vm-43", "group-v3", 
				"datastore-10", "resgroup-17", "9e4a98b3-189a-475b-b093-f5cda70cd2a5", cookie, token));
	}
}

