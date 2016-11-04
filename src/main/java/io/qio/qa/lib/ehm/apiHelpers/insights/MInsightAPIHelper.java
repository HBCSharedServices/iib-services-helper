/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.apiHelpers.insights;


import io.qio.qa.lib.apiHelpers.APIRequestHelper;
import io.qio.qa.lib.common.MBaseAPIHelper;
import io.qio.qa.lib.connection.ConnectionResponse;
import org.apache.log4j.Logger;

public class MInsightAPIHelper extends MBaseAPIHelper {
	private final String createOrUpdateInsightEndpoint = "/insights";
	private final String getOrDeleteSingleInsightEndpoint = "/insights/{insightId}";
	private final String getAllInsightsEndpoint = "/insights";
	final static Logger logger = Logger.getRootLogger();
	
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
		return getOrDeleteSingleInsightEndpoint.replace("{insightId}", insightId);
	}
}
