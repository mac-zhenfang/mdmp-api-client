/**
 * 
 */
package com.mdmp.client.app;

import java.util.List;

import com.mdmp.client.APIConstants;
import com.mdmp.client.util.Context;
import com.mdmp.client.util.Utils;

/**
 * @author zhefang
 * 
 */
public class AppClient {
	private static String CREATE_APP_URL = "create.app.url";
	private static String GET_APP_URL = "get.app.definition.url";
	private static String LIST_APP_BY_ORG = "list.apps.by.org.url";
	private Context context;

	public AppClient(Context context) {
		this.context = context;
	}

	public App create(App app) throws Exception {
		return Utils.request(
				context.get(APIConstants.API_URI)
						+ context.getUrl(CREATE_APP_URL),
				context.getMethod(CREATE_APP_URL), app, Utils.getEmptyHeader(),
				App.class);
	}

	public App get(String appId) throws Exception {
		return Utils.request(
				String.format(
						context.get(APIConstants.API_URI)
								+ context.getUrl(GET_APP_URL), appId),
				context.getMethod(GET_APP_URL), null, Utils.getEmptyHeader(),
				App.class);
	}

	public List<App> listAppsByOrg(String orgId) throws Exception {
		return Utils.requestList(
				String.format(
						context.get(APIConstants.API_URI)
								+ context.getUrl(GET_APP_URL), orgId),
				context.getMethod(GET_APP_URL), null, Utils.getEmptyHeader(),
				App.class);
	}
}
