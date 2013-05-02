/**
 * 
 */
package com.mdmp.client;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mdmp.client.app.App;
import com.mdmp.client.app.AppClient;

/**
 * @author zhefang
 *
 */
public class TestApp {
	static String orgId = "o180fe12-93cc-417e-8b99-b1b9710838e5"; // Init Report
	static String memberId = "u180fe12-93cc-417e-8b99-b1b9710838e5";
	static String modelId = "m180fe12-93cc-417e-8b99-b1b9710838e5";
	
	static Map<String, Object> map;
	
	AppClient appClient = null;
	
	@Before
	public void setUp() {
		appClient = ClientFactory.getAppClient();
		map = MockContext.mock(orgId, memberId, modelId);
	}
	
	@Test
	public void testCreateGet() throws Exception{
		App ori = (App)map.get("app");
		App app = appClient.create(ori);
		System.out.println(app.getId() + " " + app.getOid());
		assertEquals(app.getOid(), ori.getOid());
	}
}
