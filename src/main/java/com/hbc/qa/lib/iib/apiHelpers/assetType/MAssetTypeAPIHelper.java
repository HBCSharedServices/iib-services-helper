/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package com.hbc.qa.lib.iib.apiHelpers.assetType;


import com.hbc.qa.lib.apiHelpers.APIRequestHelper;
import com.hbc.qa.lib.common.MBaseAPIHelper;
import com.hbc.qa.lib.connection.ConnectionResponse;

public class MAssetTypeAPIHelper extends MBaseAPIHelper {
	private final String createOrUpdateAssetTypeEndpoint = "/assettypes";
	private final String getOrDeleteSingleAssetTypeEndpointAbstract = "/assettypes/{assetTypeId}";
	private final String getAllAssetTypesEndpoint = "/assettypes";

	public String getGetOrDeleteSingleAssetTypeEndpointAbstract() {
		return getOrDeleteSingleAssetTypeEndpointAbstract;
	}

	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders) {
		return super.create(microservice, environment, createOrUpdateAssetTypeEndpoint, payload, apiRequestHeaders);
	}

	public void delete(String microservice, String environment, String assetTypeId, APIRequestHelper apiRequestHeaders) {
		super.delete(microservice, environment, replaceAssetTypeIdInSingleAssetTypeEndpoint(assetTypeId), apiRequestHeaders);
	}

	public ConnectionResponse update(String microservice, String environment, String payload, String assetTypeId, APIRequestHelper apiRequestHeaders) {
		return super.update(microservice, environment, replaceAssetTypeIdInSingleAssetTypeEndpoint(assetTypeId), payload, apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, getAllAssetTypesEndpoint, apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, String assetTypeId, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, replaceAssetTypeIdInSingleAssetTypeEndpoint(assetTypeId), apiRequestHeaders);
	}

	protected String replaceAssetTypeIdInSingleAssetTypeEndpoint(String assetTypeId) {
		String singleAssetTypeEndpoint = getOrDeleteSingleAssetTypeEndpointAbstract.replace("{assetTypeId}", assetTypeId);
		return singleAssetTypeEndpoint;
	}
}
