/**
 * 
 */
package com.mdmp.client;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.mdmp.client.report.Report;
import com.mdmp.client.report.ReportClient;

/**
 * @author zhefang
 * 
 */
public class TestReport {
	ReportClient reportClient = null;

	static Map<String, Object> map;

	static String orgId = "o180fe12-93cc-417e-8b99-b1b9710838e5"; // Init Report
	static String memberId = "u180fe12-93cc-417e-8b99-b1b9710838e5";
	static String appId = "ad2eb651-93ea-4cc6-8541-267896ee2762";
	static String dataSourceId = "dd2eb651-93ea-4cc6-8541-267896ee2762";
	static String modelId = "m180fe12-93cc-417e-8b99-b1b9710838e5";
	static String reportId = "rd2eb651-93ea-4cc6-8541-267896ee2762";

	@Before
	public void setUp() {
		reportClient = ClientFactory.getReportClient();
		map = MockContext.mock(orgId, memberId, appId, dataSourceId, modelId,
				reportId);
	}

	@Test
	public void testCreateReport() throws Exception {
		Report report = (Report) map.get("report");
		reportClient.create(report);
	}
	@Test
	public void testGetReport() throws Exception {
		Report report = reportClient.get(reportId);
		Report oriReport = (Report) map.get("report");
		System.out.println(report);
		assertEquals(report.getId(), oriReport.getId());
	}
	

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}
}
