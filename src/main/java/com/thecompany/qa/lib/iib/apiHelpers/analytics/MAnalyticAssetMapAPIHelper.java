/**
 * /**
 *  * © TheCompany QA 2019. All rights reserved.
 *  * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 *  */

package com.thecompany.qa.lib.iib.apiHelpers.analytics;

import com.thecompany.qa.lib.apiHelpers.APIRequestHelper;
import com.thecompany.qa.lib.common.MBaseAPIHelper;
import com.thecompany.qa.lib.connection.ConnectionResponse;

public class MAnalyticAssetMapAPIHelper extends MBaseAPIHelper {
	private final String createOrUpdateAnalyticAssetMapEndpoint = "/analyticassetmap";
	private final String getOrDeleteSingleAnalyticAssetMapEndpoint = "/analyticassetmap/{analyticAssetMapId}";
	private final String getAllAnalyticAssetMapsEndpoint = "/analyticassetmap";

	public String getOrDeleteSingleAnalyticAssetMapEndpoint() {
		return getOrDeleteSingleAnalyticAssetMapEndpoint;
	}

	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders) {
		return super.create(microservice, environment, createOrUpdateAnalyticAssetMapEndpoint, payload, apiRequestHeaders);
	}

	public void delete(String microservice, String environment, String analyticAssetMapId, APIRequestHelper apiRequestHeaders) {
		super.delete(microservice, environment, replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(analyticAssetMapId), apiRequestHeaders);
	}

	public ConnectionResponse update(String microservice, String environment, String payload, String analyticAssetMapId, APIRequestHelper apiRequestHeaders) {
		return super.update(microservice, environment, replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(analyticAssetMapId), payload, apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, getAllAnalyticAssetMapsEndpoint, apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, String analyticAssetMapId, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(analyticAssetMapId), apiRequestHeaders);
	}

	protected String replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(String analyticAssetMapId) {
		String singleAnalyticAssetMapEndpoint = getOrDeleteSingleAnalyticAssetMapEndpoint.replace("{analyticAssetMapId}", analyticAssetMapId);
		return singleAnalyticAssetMapEndpoint;
	}
}
