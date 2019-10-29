/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */

package com.thecompany.qa.lib.iib.apiHelpers.analytics;

import com.thecompany.qa.lib.apiHelpers.APIHeaderRequestHelper;
import com.thecompany.qa.lib.common.MBaseAPIHelper;
import com.thecompany.qa.lib.connection.ConnectionResponse;

public class MAnalyticAssetMapAPIHelper extends MBaseAPIHelper {
	private final String createOrUpdateAnalyticAssetMapEndpoint = "/analyticassetmap";
	private final String getOrDeleteSingleAnalyticAssetMapEndpoint = "/analyticassetmap/{analyticAssetMapId}";
	private final String getAllAnalyticAssetMapsEndpoint = "/analyticassetmap";

	public String getOrDeleteSingleAnalyticAssetMapEndpoint() {
		return getOrDeleteSingleAnalyticAssetMapEndpoint;
	}

	public ConnectionResponse create(String microservice, String environment, String payload, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.create(microservice, environment, createOrUpdateAnalyticAssetMapEndpoint, payload, apiHeaderRequestHelper);
	}

	public void delete(String microservice, String environment, String analyticAssetMapId, APIHeaderRequestHelper apiHeaderRequestHelper) {
		super.delete(microservice, environment, replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(analyticAssetMapId), apiHeaderRequestHelper);
	}

	public ConnectionResponse update(String microservice, String environment, String payload, String analyticAssetMapId, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.update(microservice, environment, replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(analyticAssetMapId), payload, apiHeaderRequestHelper);
	}

	public ConnectionResponse retrieve(String microservice, String environment, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.retrieve(microservice, environment, getAllAnalyticAssetMapsEndpoint, apiHeaderRequestHelper);
	}

	public ConnectionResponse retrieve(String microservice, String environment, String analyticAssetMapId, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.retrieve(microservice, environment, replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(analyticAssetMapId), apiHeaderRequestHelper);
	}

	protected String replaceAnalyticAssetMapIdIdInSingleAnalyticAssetMapEndpoint(String analyticAssetMapId) {
		String singleAnalyticAssetMapEndpoint = getOrDeleteSingleAnalyticAssetMapEndpoint.replace("{analyticAssetMapId}", analyticAssetMapId);
		return singleAnalyticAssetMapEndpoint;
	}
}
