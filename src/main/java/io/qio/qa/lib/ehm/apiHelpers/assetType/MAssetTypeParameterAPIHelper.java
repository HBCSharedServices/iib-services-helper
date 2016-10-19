/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.apiHelpers.assetType;

import io.qio.qa.lib.apiHelpers.APIRequestHelper;
import io.qio.qa.lib.connection.ConnectionResponse;

public class MAssetTypeParameterAPIHelper extends MAssetTypeAPIHelper {
	private final String getAllAssetTypeParametersEndpoint = "/parameters";
	private final String getSingleAssetTypeParameterEndpoint = "/parameters/{assetTypeParameterId}";

	public ConnectionResponse retrieve(String microservice, String environment, String assetTypeId, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, assetTypeId + getAllAssetTypeParametersEndpoint, apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, String assetTypeId, String assetTypeParameterId,
			APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, assetTypeId + replaceAssetTypeParameterIdInSingleAssetTypeParameterEndpoint(
				assetTypeParameterId), apiRequestHeaders);
	}

	private String replaceAssetTypeParameterIdInSingleAssetTypeParameterEndpoint(String assetTypeParameterId) {
		String singleAssetTypeParameterEndpoint = getSingleAssetTypeParameterEndpoint.replace("{assetTypeParameterId}", assetTypeParameterId);
		return singleAssetTypeParameterEndpoint;
	}
}
