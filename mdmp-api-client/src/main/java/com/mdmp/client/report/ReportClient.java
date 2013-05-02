/**
 * 
 */
package com.mdmp.client.report;

import com.mdmp.client.APIConstants;
import com.mdmp.client.util.Context;
import com.mdmp.client.util.Utils;

/**
 * @author zhefang
 * 
 */
public class ReportClient {
	private static String CREATE_REPORT_URL = "create.report.url";
	private Context context;

	public ReportClient(Context context) {
		this.context = context;
	}

	public Report create(Report report) throws Exception {
		return Utils.request(
				context.get(APIConstants.API_URI)
						+ context.getUrl(CREATE_REPORT_URL),
				context.getMethod(CREATE_REPORT_URL), report,
				Utils.getEmptyHeader(), Report.class);
	}

	public Report get(String reportId) throws Exception {
		return Utils.request(String.format(context.get(APIConstants.API_URI)
				+ context.getUrl("get.report.definition.url"), reportId),
				context.getMethod("get.report.definition.url"), null, Utils
						.getEmptyHeader(), Report.class);
	}
}
