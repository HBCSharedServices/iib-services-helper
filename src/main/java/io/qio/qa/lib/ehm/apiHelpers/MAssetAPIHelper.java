/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */


package io.qio.qa.lib.ehm.apiHelpers;


import io.qio.qa.lib.apiHelpers.APIRequestHelper;
import io.qio.qa.lib.common.MBaseAPIHelper;
import io.qio.qa.lib.connection.ConnectionResponse;

public class MAssetAPIHelper extends MBaseAPIHelper {
	private final String createOrUpdateAssetEndpoint = "/assets";
	private final String getOrDeleteSingleAssetEndpointAbstract = "/assets/{assetId}";
	private final String getAllAssetsEndpoint = "/assets";
	
	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders){
		return super.create(microservice, environment, createOrUpdateAssetEndpoint, payload, apiRequestHeaders);
	}
	
	public void delete(String microservice, String environment, String assetId, APIRequestHelper apiRequestHeaders) {
		super.delete(microservice, environment, replaceAssetIdInSingleAssetEndpoint(assetId), apiRequestHeaders);
	}

	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, getAllAssetsEndpoint, apiRequestHeaders);
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, String assetId, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, replaceAssetIdInSingleAssetEndpoint(assetId), apiRequestHeaders);
	}
	
	private String replaceAssetIdInSingleAssetEndpoint(String assetId) {
		String singleAssetEndpoint = getOrDeleteSingleAssetEndpointAbstract.replace("{assetId}", assetId);
		return singleAssetEndpoint;
	}
}