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
import io.qio.qa.lib.common.MAbstractAPIHelper;
import io.qio.qa.lib.mongoHelpers.MAbstractMongoHelper;
import org.bson.Document;
import static io.qio.qa.lib.common.BaseHelper.getCurrentTimeStamp;

public class AssetTypeUtil extends BaseTestUtil {

	private MAssetTypeAPIHelper assetTypeAPI = new MAssetTypeAPIHelper();
	private AssetTypeHelper assetTypeHelper;
	private AssetType requestAssetType;
	private final String MICROSERVICE_NAME = "asset";
	private String userType = "user";

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
        case "WithAllAttributes":
            requestAssetType = assetTypeHelper.getAssetTypeWithAllAttributes();
            break;
		case "WithAllAttributesAndParameters":
			requestAssetType = assetTypeHelper.getAssetTypeWithAllAttributesAndParameters();
			break;
		default:
			requestAssetType = assetTypeHelper.getAssetTypeWithNoAttributesAndParameters();
		}
		return MAbstractAPIHelper.getResponseObjForCreate(requestAssetType, assetTypeMicroservice, environment, apiRequestHelper, assetTypeAPI, AssetType.class);
	}

	public AssetType createAssetTypeBasedOnExistingAssetType(String existingAssetTypeId, String newAbbreviation, String newDesc) {
		initSetup(userType);
		String assetTypeMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);
		assetTypeHelper = new AssetTypeHelper();

		AssetType assetTypeQueryResponse = MAbstractAPIHelper.getResponseObjForRetrieve(assetTypeMicroservice, environment, existingAssetTypeId, apiRequestHelper, assetTypeAPI, AssetType.class);
		assetTypeQueryResponse.setAbbreviation(newAbbreviation+"-"+getCurrentTimeStamp());
		assetTypeQueryResponse.setDescription(newDesc);
		return MAbstractAPIHelper.getResponseObjForCreate(assetTypeQueryResponse, assetTypeMicroservice, environment, apiRequestHelper, assetTypeAPI, AssetType.class);
	}

	public String getAssetTypeIdBasedOnAbbreviationSearch(String abbreviation) {
		initSetup(userType);
		baseInitMongoSetupBeforeAllTests("asset");
		String assetURI = "mongodb://" + mongoUsername + ":" + mongoPassword + "@" + mongoDbServer + ":" + mongoDbServerPort + "/" + mongoDb;

		Document queryAssetType = new Document();
		queryAssetType.put("abbreviation", abbreviation);

		Object asssetTypeColItem = MAbstractMongoHelper.findOneCollectionItemInMongoDBCollection(queryAssetType, assetURI, mongoDb, "assettype");

		if (asssetTypeColItem == null) {
			return null;
		} else {
			String asssetTypeColItemString = asssetTypeColItem.toString();
			int start = asssetTypeColItemString.indexOf("_id=") + 4;
			int end = asssetTypeColItemString.indexOf("_class=") - 2;

			return asssetTypeColItemString.substring(start, end);
		}
	}
}