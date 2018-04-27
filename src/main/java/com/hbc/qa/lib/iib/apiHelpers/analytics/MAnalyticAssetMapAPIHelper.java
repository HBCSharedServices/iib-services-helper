/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package com.hbc.qa.lib.iib.apiHelpers.analytics;


import com.hbc.qa.lib.apiHelpers.APIRequestHelper;
import com.hbc.qa.lib.common.MBaseAPIHelper;
import com.hbc.qa.lib.connection.ConnectionResponse;

public class MAnalyticAssetMapAPIHelper extends MBaseAPIHelper {
	private final String createOrUpdateUserGroupEndpoint = "/analyticassetmap";
	private final String getOrDeleteSingleUserGroupEndpointAbstract = "/analyticassetmap/{analyticAssetMapId}";
	private final String getAllUserGroupsEndpoint = "/analyticassetmap";

	public String getGetOrDeleteSingleUserGroupEndpointAbstract() {
		return getOrDeleteSingleUserGroupEndpointAbstract;
	}

	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders) {
		return super.create(microservice, environment, createOrUpdateUserGroupEndpoint, payload, apiRequestHeaders);
	}

	public void delete(String microservice, String environment, String analyticAssetMapId, APIRequestHelper apiRequestHeaders) {
		super.delete(microservice, environment, replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(analyticAssetMapId), apiRequestHeaders);
	}

	public ConnectionResponse update(String microservice, String environment, String payload, String analyticAssetMapId, APIRequestHelper apiRequestHeaders) {
		return super.update(microservice, environment, replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(analyticAssetMapId), payload, apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, getAllUserGroupsEndpoint, apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, String analyticAssetMapId, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(analyticAssetMapId), apiRequestHeaders);
	}

	protected String replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(String analyticAssetMapId) {
		String singleAnalyticAssetMapEndpoint = getOrDeleteSingleUserGroupEndpointAbstract.replace("{analyticAssetMapId}", analyticAssetMapId);
		return singleAnalyticAssetMapEndpoint;
	}
}
