package com.mdmp.client;

import com.mdmp.client.report.ReportClient;
import com.mdmp.client.util.Context;

public class ClientFactory {

	static Context context = new Context();
	static ReportClient reportClient = null;

	public static ReportClient getReportClient() {
		if (null == reportClient) {
			reportClient = new ReportClient(context);
		}
		return reportClient;
	}
}
