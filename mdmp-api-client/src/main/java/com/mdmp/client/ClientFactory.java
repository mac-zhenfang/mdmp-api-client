package com.mdmp.client;

import com.mdmp.client.app.AppClient;
import com.mdmp.client.report.ReportClient;
import com.mdmp.client.util.Context;

public class ClientFactory {

	static Context context = new Context();
	static ReportClient reportClient = null;
	static AppClient appClient = null;
	public static ReportClient getReportClient() {
		if (null == reportClient) {
			reportClient = new ReportClient(context);
		}
		return reportClient;
	}
	
	public static AppClient getAppClient() {
		if (null == appClient) {
			appClient = new AppClient(context);
		}
		return appClient;
	}
	
}
