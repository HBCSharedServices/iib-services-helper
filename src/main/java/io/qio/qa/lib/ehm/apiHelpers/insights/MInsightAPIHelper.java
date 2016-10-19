/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.apiHelpers.insights;


import io.qio.qa.lib.apiHelpers.APIRequestHelper;
import io.qio.qa.lib.common.MBaseAPIHelper;
import io.qio.qa.lib.connection.ConnectionResponse;

public class MInsightAPIHelper extends MBaseAPIHelper {
	private final String createOrUpdateInsightEndpoint = "/insights";
	private final String getOrDeleteSingleInsightEndpointAbstract = "/insights/{insightId}";
	private final String getAllInsightsEndpoint = "/insights";
	
	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders){
		return super.create(microservice, environment, createOrUpdateInsightEndpoint, payload, apiRequestHeaders);
	}
	
	public void delete(String microservice, String environment, String insightId, APIRequestHelper apiRequestHeaders) {
		super.delete(microservice, environment, replaceInsightIdInSingleInsightEndpoint(insightId), apiRequestHeaders);
	}

	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, getAllInsightsEndpoint, apiRequestHeaders);
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, String insightId, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, replaceInsightIdInSingleInsightEndpoint(insightId), apiRequestHeaders);
	}
	
	private String replaceInsightIdInSingleInsightEndpoint(String insightId) {
		String singleInsightEndpoint = getOrDeleteSingleInsightEndpointAbstract.replace("{insightId}", insightId);
		return singleInsightEndpoint;
	}
}
