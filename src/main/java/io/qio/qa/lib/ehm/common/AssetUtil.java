/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.common;

import io.qio.qa.lib.ehm.apiHelpers.MAssetAPIHelper;
import io.qio.qa.lib.ehm.model.asset.AssetRequest;
import io.qio.qa.lib.ehm.model.asset.AssetResponse;
import io.qio.qa.lib.ehm.model.asset.helper.AssetRequestHelper;
import io.qio.qa.lib.ehm.model.assetType.helper.AttributeDataType;
import io.qio.qa.lib.ehm.model.assetType.helper.ParameterDataType;
import io.qio.qa.lib.common.MAbstractAPIHelper;

public class AssetUtil extends BaseTestUtil {

	private MAssetAPIHelper assetAPI = new MAssetAPIHelper();
	private AssetRequestHelper assetRequestHelper;
	private static AssetRequest requestAsset;
	private final String MICROSERVICE_NAME = "asset";
	private String userType = "test";

	public AssetResponse createAssetWithCreatingAssetTypeAndTenant(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType) {
		initSetup(userType);
		String assetMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);
		assetRequestHelper = new AssetRequestHelper();
		requestAsset = assetRequestHelper.getAssetWithCreatingAssetTypeAndTenant(assetTypeFlavor, attributeDataType, parameterDataType);

		return MAbstractAPIHelper.getResponseObjForCreate(requestAsset, assetMicroservice, environment, apiRequestHelper, assetAPI, AssetResponse.class);
	}
}