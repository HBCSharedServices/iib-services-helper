/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */


package com.hbc.qa.lib.iib.apiHelpers.asset;


import com.hbc.qa.lib.apiHelpers.APIRequestHelper;
import com.hbc.qa.lib.common.MBaseAPIHelper;
import com.hbc.qa.lib.connection.ConnectionResponse;

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
		return getOrDeleteSingleAssetEndpointAbstract.replace("{assetId}", assetId);
	}
}