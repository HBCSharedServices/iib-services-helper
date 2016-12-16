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
	Dictionary dictionary = null;
	AssetUtil assetUtil = null;
	final static Logger logger = Logger.getRootLogger();

	private void initDefaultDictionary() {
		dictionary = new Dictionary(getCurrentTimeStamp());
	}

	public Dictionary getDictionary() {
		initDefaultDictionary();
		return dictionary;
	}

	public Dictionary getDictionaryWithPredefinedAssetAndTenantForParameter(String assetId, String tenantId, String parameterId, String dataType){
		initDefaultDictionary();
		dictionary.setAsset(assetId);
		dictionary.setTenant(tenantId);
		dictionary.setParameter(parameterId);
		dictionary.setType(dataType);
		return dictionary;
	}

	public List<Dictionary> getDictionaryWithCreatingAssetAndTenant(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType){
		List<Dictionary> dictionaryList = null;
		assetUtil = new AssetUtil();

		AssetResponse assetResponse = assetUtil.createAssetWithCreatingAssetTypeAndTenant(assetTypeFlavor, attributeDataType, parameterDataType);
		String assetId = assetResponse.getAssetId();
		String tenantId = assetResponse.getTenant();
		List<AssetTypeParameter> parameters = assetResponse.getAssetType().getParameters();
		for (AssetTypeParameter parameter : parameters) {
			dictionaryList.add(getDictionaryWithPredefinedAssetAndTenantForParameter (assetId, tenantId, parameter.getId(), parameter.getDatatype()));
		}
		return dictionaryList;
	}

	public List<Dictionary> getDictionaryWithPredefinedTenantWithCreatingAsset(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType, String tenantId){
		List<Dictionary> dictionaryList = null;
		assetUtil = new AssetUtil();

		AssetResponse assetResponse = assetUtil.createAssetWithPredefinedTenantAndWithCreatingAssetType(assetTypeFlavor, attributeDataType, parameterDataType, tenantId);
		String assetId = assetResponse.getAssetId();
		List<AssetTypeParameter> parameters = assetResponse.getAssetType().getParameters();
		for (AssetTypeParameter parameter : parameters) {
			dictionaryList.add(getDictionaryWithPredefinedAssetAndTenantForParameter (assetId, tenantId, parameter.getId(), parameter.getDatatype()));
		}
		return dictionaryList;
	}
}