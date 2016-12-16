/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.dictionary.helper;

import io.qio.qa.lib.ehm.common.AssetUtil;
import io.qio.qa.lib.ehm.model.asset.AssetResponse;
import io.qio.qa.lib.ehm.model.assetType.AssetTypeParameter;
import io.qio.qa.lib.ehm.model.assetType.helper.AttributeDataType;
import io.qio.qa.lib.ehm.model.assetType.helper.ParameterDataType;
import io.qio.qa.lib.ehm.model.dictionary.Dictionary;
import org.apache.log4j.Logger;
import java.util.List;
import static io.qio.qa.lib.common.BaseHelper.getCurrentTimeStamp;

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

	public Dictionary getDictionaryWithPredefinedAssetAndTenantForParameter(String tag, String assetId, String tenantId, String parameterId, String dataType, String sourceUnit, String destinationUnit, String conversionFormula){
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

	public Dictionary getDictionaryWithPredefinedAssetAndTenantForParameter(String tag, String assetId, String tenantId, String parameterId, String sourceUnit, String conversionFormula){
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

	public List<Dictionary> getDictionaryWithCreatingAssetAndTenant(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType){
		dictionaryList = null;

		AssetResponse assetResponse = assetUtil.createAssetWithCreatingAssetTypeAndTenant(assetTypeFlavor, attributeDataType, parameterDataType);
		String assetId = assetResponse.getAssetId();
		String tenantId = assetResponse.getTenant();
		List<AssetTypeParameter> parameters = assetResponse.getAssetType().getParameters();
		for (AssetTypeParameter parameter : parameters) {
			tag = assetResponse.getAbbreviation()+parameter.getAbbreviation();
			dictionaryList.add(getDictionaryWithPredefinedAssetAndTenantForParameter(tag, assetId, tenantId, parameter.getParameterId(), parameter.getDatatype(), parameter.getBaseuom(), parameter.getBaseuom(), "val"));
		}
		return dictionaryList;
	}

	public List<Dictionary> getDictionaryWithPredefinedTenantWithCreatingAsset(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType, String tenantId, String conversionFormula){
		dictionaryList = null;

		AssetResponse assetResponse = assetUtil.createAssetWithPredefinedTenantAndWithCreatingAssetType(assetTypeFlavor, attributeDataType, parameterDataType, tenantId);
		String assetId = assetResponse.getAssetId();
		List<AssetTypeParameter> parameters = assetResponse.getAssetType().getParameters();
		for (AssetTypeParameter parameter : parameters) {
			tag = assetResponse.getAbbreviation()+parameter.getAbbreviation();
			dictionaryList.add(getDictionaryWithPredefinedAssetAndTenantForParameter(tag, assetId, tenantId, parameter.getParameterId(), parameter.getDatatype(), parameter.getBaseuom(), parameter.getBaseuom(), conversionFormula));
		}
		return dictionaryList;
	}
}