/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package com.hbc.qa.lib.iib.apiHelpers.insights;


import com.hbc.qa.lib.apiHelpers.APIRequestHelper;
import com.hbc.qa.lib.common.MBaseAPIHelper;
import com.hbc.qa.lib.connection.ConnectionResponse;

public class MInsightTypeAPIHelper extends MBaseAPIHelper {
	private final String createOrUpdateInsightTypeEndpoint = "/insighttypes";
	private final String getOrDeleteSingleInsightTypeEndpointAbstract = "/insighttypes/{insightTypeId}";
	private final String getAllInsightTypesEndpoint = "/insighttypes";

	public String getGetOrDeleteSingleInsightTypeEndpointAbstract() {
		return getOrDeleteSingleInsightTypeEndpointAbstract;
	}

	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders) {
		return super.create(microservice, environment, createOrUpdateInsightTypeEndpoint, payload, apiRequestHeaders);
	}

	public void delete(String microservice, String environment, String insightTypeId, APIRequestHelper apiRequestHeaders) {
		super.delete(microservice, environment, replaceInsightTypeIdInSingleInsightTypeEndpoint(insightTypeId), apiRequestHeaders);
	}

	public ConnectionResponse update(String microservice, String environment, String payload, String insightTypeId, APIRequestHelper apiRequestHeaders) {
		return super.update(microservice, environment, replaceInsightTypeIdInSingleInsightTypeEndpoint(insightTypeId), payload, apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, getAllInsightTypesEndpoint, apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, String insightTypeId, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, replaceInsightTypeIdInSingleInsightTypeEndpoint(insightTypeId), apiRequestHeaders);
	}

	protected String replaceInsightTypeIdInSingleInsightTypeEndpoint(String insightTypeId) {
		return getOrDeleteSingleInsightTypeEndpointAbstract.replace("{insightTypeId}", insightTypeId);
	}
}
