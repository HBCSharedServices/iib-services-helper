/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.common;

import io.qio.qa.lib.ehm.apiHelpers.asset.MAssetAPIHelper;
import io.qio.qa.lib.ehm.model.asset.AssetRequest;
import io.qio.qa.lib.ehm.model.asset.AssetResponse;
import io.qio.qa.lib.ehm.model.asset.helper.AssetRequestHelper;
import io.qio.qa.lib.ehm.model.assetType.AssetType;
import io.qio.qa.lib.ehm.model.assetType.AssetTypeParameter;
import io.qio.qa.lib.ehm.model.assetType.helper.AttributeDataType;
import io.qio.qa.lib.ehm.model.assetType.helper.ParameterDataType;
import io.qio.qa.lib.common.MAbstractAPIHelper;

public class AssetUtil extends BaseTestUtil {

	private MAssetAPIHelper assetAPI = new MAssetAPIHelper();
	private AssetRequestHelper assetRequestHelper;
	private static AssetRequest requestAsset;
	private final String MICROSERVICE_NAME = "asset";
	private String userType = "user";

	public AssetResponse createAssetWithCreatingAssetTypeAndTenant(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType) {
		initSetup(userType);
		String assetMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);
		assetRequestHelper = new AssetRequestHelper();
		requestAsset = assetRequestHelper.getAssetWithCreatingAssetTypeAndTenant(assetTypeFlavor, attributeDataType, parameterDataType);

		return MAbstractAPIHelper.getResponseObjForCreate(requestAsset, assetMicroservice, environment, apiRequestHelper, assetAPI, AssetResponse.class);
	}

	public AssetResponse createAssetWithPredefinedTenantAndWithCreatingAssetType(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType, String tenantId) {
		initSetup(userType);
		String assetMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);
		assetRequestHelper = new AssetRequestHelper();
		requestAsset = assetRequestHelper.getAssetWithPredefinedTenantAndWithCreatingAssetType(assetTypeFlavor, attributeDataType, parameterDataType, tenantId);

		return MAbstractAPIHelper.getResponseObjForCreate(requestAsset, assetMicroservice, environment, apiRequestHelper, assetAPI, AssetResponse.class);
	}

	public AssetResponse createAssetWithPredefinedAssetTypeAndWithCreatingTenant(String assetTypeId) {
		initSetup(userType);
		String assetMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);
		assetRequestHelper = new AssetRequestHelper();
		requestAsset = assetRequestHelper.getAssetWithPredefinedAssetTypeAndWithCreatingTenant(assetTypeId);

		return MAbstractAPIHelper.getResponseObjForCreate(requestAsset, assetMicroservice, environment, apiRequestHelper, assetAPI, AssetResponse.class);
	}

	public String getTenantForAsset (String assetId) {
		initSetup(userType);

		String assetMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);

		AssetResponse committedAsset = MAbstractAPIHelper.getResponseObjForRetrieve(assetMicroservice, environment, assetId, apiRequestHelper, assetAPI, AssetResponse.class);
		return(committedAsset.getTenant());
	}

	public String getAssetTypeForAsset (String assetId) {
		initSetup(userType);

		String assetMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);

		AssetResponse committedAsset = MAbstractAPIHelper.getResponseObjForRetrieve(assetMicroservice, environment, assetId, apiRequestHelper, assetAPI, AssetResponse.class);
		return(committedAsset.getAssetType().getAssetTypeId());
	}

	public AssetType getAssetTypeObjectForAsset (String assetId) {
		initSetup(userType);

		String assetMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);

		AssetResponse committedAsset = MAbstractAPIHelper.getResponseObjForRetrieve(assetMicroservice, environment, assetId, apiRequestHelper, assetAPI, AssetResponse.class);
		return(committedAsset.getAssetType());
	}

	public AssetTypeParameter getAssetTypeParameterObjectForAssetAndParameterId (String assetId, String parameterId) {
		initSetup(userType);

		String assetMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);

		AssetResponse committedAsset = MAbstractAPIHelper.getResponseObjForRetrieve(assetMicroservice, environment, assetId, apiRequestHelper, assetAPI, AssetResponse.class);

		for (AssetTypeParameter parameter : committedAsset.getAssetType().getParameters()) {
			if (parameter.getParameterId().equals(parameterId)) return parameter;
		}
		return null;
	}

	public AssetResponse getAssetObjectForAssetId (String assetId) {
		initSetup(userType);

		String assetMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);

		AssetResponse committedAsset = MAbstractAPIHelper.getResponseObjForRetrieve(assetMicroservice, environment, assetId, apiRequestHelper, assetAPI, AssetResponse.class);

		return committedAsset;
	}
}