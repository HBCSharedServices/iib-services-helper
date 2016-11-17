/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.assetType.helper;

import io.qio.qa.lib.ehm.model.assetType.AssetType;
import io.qio.qa.lib.ehm.model.assetType.AssetTypeAttribute;
import io.qio.qa.lib.ehm.model.assetType.AssetTypeParameter;
import static io.qio.qa.lib.common.BaseHelper.getCurrentTimeStamp;

import java.util.ArrayList;
import java.util.List;

public class AssetTypeHelper {
	AssetType assetType = null;

	/*
	 * This method is invoked from each of the following methods to make sure every time a new assettype is created with a unique timestamp.
	 */
	private void initDefaultAssetType() {
		assetType = new AssetType(getCurrentTimeStamp());
	}

	/*
	 * AssetType objects with Attributes only
	 */

	public AssetType getAssetTypeWithNoAttributes() {
		initDefaultAssetType();
		assetType.setAttributes(null);
		return assetType;
	}

	@SuppressWarnings("serial")
	public AssetType getAssetTypeWithOneAttribute(AttributeDataType attributeDataType) {
		initDefaultAssetType();
		assetType.setAttributes(new ArrayList<AssetTypeAttribute>() {
			{
				add(getAssetTypeAttributeWithInputDataType(attributeDataType));
			}
		});
		assetType.setParameters(null);
		return assetType;
	}

	public AssetType getAssetTypeWithAllAttributes() {
		List<AssetTypeAttribute> assetTypeAttributeAll = new ArrayList<AssetTypeAttribute>();
		for (AttributeDataType dataType : AttributeDataType.values()) {
			assetTypeAttributeAll.add(getAssetTypeAttributeWithInputDataType(dataType));
		}
		initDefaultAssetType();
		assetType.setAttributes(assetTypeAttributeAll);
		assetType.setParameters(null);
		return assetType;
	}

	public AssetTypeAttribute getAssetTypeAttributeWithInputDataType(AttributeDataType attributeDataType) {
		String attributeDataTypePrefix = "ABBR" + attributeDataType.toString();
		return new AssetTypeAttribute(attributeDataTypePrefix, attributeDataTypePrefix + " Name", attributeDataTypePrefix + " Desc", "Unit",
				attributeDataType.toString());
	}

	public AssetType getAssetTypeWithDefaultAttribute() {
		initDefaultAssetType();
		assetType.setParameters(null);
		return assetType;
	}

	/*
	 * AssetType objects with Parameters only
	 */

	public AssetType getAssetTypeWithNoParameters() {
		initDefaultAssetType();
		assetType.setParameters(null);
		return assetType;
	}

	@SuppressWarnings("serial")
	public AssetType getAssetTypeWithOneParameter(ParameterDataType parameterDataType) {
		initDefaultAssetType();
		assetType.setParameters(new ArrayList<AssetTypeParameter>() {
			{
				add(getAssetTypeParameterWithInputDataType(parameterDataType));
			}
		});
		assetType.setAttributes(null);
		return assetType;
	}

	public AssetType getAssetTypeWithAllParameters() {
		List<AssetTypeParameter> assetTypeParameterAll = new ArrayList<AssetTypeParameter>();
		for (ParameterDataType dataType : ParameterDataType.values()) {
			assetTypeParameterAll.add(getAssetTypeParameterWithInputDataType(dataType));
		}
		initDefaultAssetType();
		assetType.setParameters(assetTypeParameterAll);
		assetType.setAttributes(null);
		return assetType;
	}

	public AssetTypeParameter getAssetTypeParameterWithInputDataType(ParameterDataType parameterDataType) {
		String parameterDataTypePrefix = "ABBR" + parameterDataType.toString();
		return new AssetTypeParameter(parameterDataTypePrefix, parameterDataTypePrefix + " Desc", "Unit", parameterDataType.toString());
	}

	public AssetType getAssetTypeWithDefaultParameter() {
		initDefaultAssetType();
		assetType.setAttributes(null);
		return assetType;
	}

	/*
	 * AssetType objects with Attributes and Parameters
	 */

	public AssetType getAssetTypeWithNoAttributesAndParameters() {
		initDefaultAssetType();
		assetType.setAttributes(null);
		assetType.setParameters(null);
		return assetType;
	}

	public AssetType getAssetTypeWithAllAttributesAndParameters() {
		AssetType assetTypeAttrTemp = getAssetTypeWithAllAttributes();
		AssetType assetTypeParamTemp = getAssetTypeWithAllParameters();
		initDefaultAssetType();
		assetType.setAttributes(assetTypeAttrTemp.getAttributes());
		assetType.setParameters(assetTypeParamTemp.getParameters());
		return assetType;
	}
}