/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package com.hbc.qa.lib.iib.model.dictionary.helper;

import com.hbc.qa.lib.iib.common.AssetUtil;
import com.hbc.qa.lib.iib.model.asset.AssetResponse;
import com.hbc.qa.lib.iib.model.assetType.AssetTypeParameter;
import com.hbc.qa.lib.iib.model.assetType.helper.AttributeDataType;
import com.hbc.qa.lib.iib.model.assetType.helper.ParameterDataType;
import com.hbc.qa.lib.iib.model.dictionary.Dictionary;
import org.apache.log4j.Logger;
import java.util.List;
import static com.hbc.qa.lib.common.BaseHelper.getCurrentTimeStamp;

public class DictionaryHelper {
	private Dictionary dictionary;
	private AssetUtil assetUtil = new AssetUtil();
	private AssetTypeParameter parameter;
	private List<Dictionary> dictionaryList;
	private String tag;

	final static Logger logger = Logger.getRootLogger();

	private void initDefaultDictionary() {
		dictionary = new Dictionary(getCurrentTimeStamp());
	}

	public Dictionary getDictionary() {
		initDefaultDictionary();
		return dictionary;
	}

	public Dictionary getDictionaryForPredefinedAssetAndTenantForAParameter(String tag, String assetId, String tenantId, String parameterId, String dataType, String sourceUnit, String destinationUnit, String conversionFormula){
		initDefaultDictionary();
		dictionary.setTag(tag);
		dictionary.setAsset(assetId);
		dictionary.setTenant(tenantId);
		dictionary.setParameter(parameterId);
		dictionary.setType(dataType);
		dictionary.setSourceUint(sourceUnit);
		dictionary.setDestinationUnit(destinationUnit);
		dictionary.setConversionFormula(conversionFormula);
		return dictionary;
	}

	public Dictionary getDictionaryForPredefinedAssetAndTenantForAParameter(String tag, String assetId, String tenantId, String parameterId, String sourceUnit, String conversionFormula){
		initDefaultDictionary();
		parameter = assetUtil.getAssetTypeParameterObjectForAssetAndParameterId(assetId, parameterId);

		dictionary.setTag(tag);
		dictionary.setAsset(assetId);
		dictionary.setTenant(tenantId);
		dictionary.setParameter(parameterId);
		dictionary.setType(parameter.getDatatype());
		dictionary.setSourceUint(sourceUnit);
		dictionary.setDestinationUnit(parameter.getBaseuom());
		dictionary.setConversionFormula(conversionFormula);
		return dictionary;
	}

	public List<Dictionary> getDictionaryListForPredefinedAsset(String assetId){
		dictionaryList = null;

		AssetResponse asset = assetUtil.getAssetObjectForAssetId(assetId);
		String tenantId = asset.getTenant();
		List<AssetTypeParameter> parameters = asset.getAssetType().getParameters();

		for (AssetTypeParameter parameter : parameters) {
			tag = asset.getAbbreviation()+parameter.getAbbreviation();
			dictionaryList.add(getDictionaryForPredefinedAssetAndTenantForAParameter(tag, assetId, tenantId, parameter.getParameterId(), parameter.getDatatype(), parameter.getBaseuom(), parameter.getBaseuom(), "val"));
		}
		return dictionaryList;
	}

	public List<Dictionary> getDictionaryListWithCreatingAssetAndTenant(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType){
		dictionaryList = null;

		AssetResponse assetResponse = assetUtil.createAssetWithCreatingAssetTypeAndTenant(assetTypeFlavor, attributeDataType, parameterDataType);
		String assetId = assetResponse.getAssetId();
		String tenantId = assetResponse.getTenant();
		List<AssetTypeParameter> parameters = assetResponse.getAssetType().getParameters();
		for (AssetTypeParameter parameter : parameters) {
			tag = assetResponse.getAbbreviation()+parameter.getAbbreviation();
			dictionaryList.add(getDictionaryForPredefinedAssetAndTenantForAParameter(tag, assetId, tenantId, parameter.getParameterId(), parameter.getDatatype(), parameter.getBaseuom(), parameter.getBaseuom(), "val"));
		}
		return dictionaryList;
	}

	public List<Dictionary> getDictionaryListForPredefinedTenantWithCreatingAsset(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType, String tenantId, String conversionFormula){
		dictionaryList = null;

		AssetResponse assetResponse = assetUtil.createAssetWithPredefinedTenantAndWithCreatingAssetType(assetTypeFlavor, attributeDataType, parameterDataType, tenantId);
		String assetId = assetResponse.getAssetId();
		List<AssetTypeParameter> parameters = assetResponse.getAssetType().getParameters();
		for (AssetTypeParameter parameter : parameters) {
			tag = assetResponse.getAbbreviation()+parameter.getAbbreviation();
			dictionaryList.add(getDictionaryForPredefinedAssetAndTenantForAParameter(tag, assetId, tenantId, parameter.getParameterId(), parameter.getDatatype(), parameter.getBaseuom(), parameter.getBaseuom(), conversionFormula));
		}
		return dictionaryList;
	}
}