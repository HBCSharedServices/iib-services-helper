/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.common;

import io.qio.qa.lib.ehm.apiHelpers.assetType.MAssetTypeAPIHelper;
import io.qio.qa.lib.ehm.model.assetType.AssetType;
import io.qio.qa.lib.ehm.model.assetType.helper.AssetTypeHelper;
import io.qio.qa.lib.ehm.model.assetType.helper.AttributeDataType;
import io.qio.qa.lib.ehm.model.assetType.helper.ParameterDataType;

public class AssetTypeUtil extends BaseTestUtil {

	private MAssetTypeAPIHelper assetTypeAPI = new MAssetTypeAPIHelper();
	private AssetTypeHelper assetTypeHelper;
	private AssetType requestAssetType;
	private final String MICROSERVICE_NAME = "asset";
	private String userType = "test";

	/**
	 * 
	 * @param assetTypeFlavor
	 * @param attributeDataType
	 *            -- will require a valid AttributeDataType for the option WithOneAttribute, else pass in null
	 * @param parameterDataType
	 *            -- will require a valid ParameterDataType for the option WithOneParameter, else pass in null
	 */
	public AssetType createAssetType(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType) {
		initSetup(userType);
		String assetTypeMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);
		assetTypeHelper = new AssetTypeHelper();

		switch (assetTypeFlavor) {
		case "WithNoAttributesAndParameters":
			requestAssetType = assetTypeHelper.getAssetTypeWithNoAttributesAndParameters();
			break;
		case "WithOneAttribute":
			requestAssetType = assetTypeHelper.getAssetTypeWithOneAttribute(attributeDataType);
			break;
		case "WithOneParameter":
			requestAssetType = assetTypeHelper.getAssetTypeWithOneParameter(parameterDataType);
			break;
		case "WithAllParameters":
			requestAssetType = assetTypeHelper.getAssetTypeWithAllParameters();
			break;
		case "WithAllAttributesAndParameters":
			requestAssetType = assetTypeHelper.getAssetTypeWithAllAttributesAndParameters();
			break;
		default:
			requestAssetType = assetTypeHelper.getAssetTypeWithNoAttributesAndParameters();
		}
		return APITestUtil.getResponseObjForCreate(requestAssetType, assetTypeMicroservice, environment, apiRequestHelper, assetTypeAPI, AssetType.class);
	}
}