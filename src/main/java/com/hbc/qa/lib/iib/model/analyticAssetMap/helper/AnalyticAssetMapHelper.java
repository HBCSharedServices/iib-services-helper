/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package com.hbc.qa.lib.iib.model.analyticAssetMap.helper;

import com.hbc.qa.lib.iib.model.analyticAssetMap.AnalyticAssetMap;
import com.hbc.qa.lib.iib.model.analyticAssetMap.AnalyticInputParameter;
import com.hbc.qa.lib.iib.model.analyticAssetMap.AssetTemplateModelAttribute;
import static com.hbc.qa.lib.common.BaseHelper.getCurrentTimeStamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AnalyticAssetMapHelper {
	AnalyticAssetMap analyticAssetMap = null;

	/*
	 * This method is invoked from each of the following methods to make sure every time a new analytic asset map is created with a unique timestamp.
	 */
	private void initDefaultAnalyticAssetMap() {
		analyticAssetMap = new AnalyticAssetMap(getCurrentTimeStamp(), null);
	}

	public AnalyticAssetMap getAnalyticAssetMapWithNoAssetTemplateModelAttributeAndAnalyticInputParameters() {
		initDefaultAnalyticAssetMap();
		return analyticAssetMap;
	}

	public AssetTemplateModelAttribute getAssetTemplateModelAttributeWithAssetAttributeLink(String analyticAttribute, String assetTypeAttribute, String value) {
		return new AssetTemplateModelAttribute(analyticAttribute, assetTypeAttribute, value);
	}

	public AssetTemplateModelAttribute getAssetTemplateModelAttributeWithoutAssetAttributeLink(String analyticAttribute, String value) {
		return new AssetTemplateModelAttribute(analyticAttribute, null, value);
	}

	public AnalyticInputParameter getAnalyticInputParameter(String analyticInput, String assetTypeParameter) {
		return new AnalyticInputParameter(analyticInput, assetTypeParameter);
	}

	public AnalyticAssetMap getAnalyticAssetMapWithAnalyticInputParameters(Map<String, String> analyticInputs) {
		// ArrayList<String> assetTypeParameters
		List<AnalyticInputParameter> analyticInputParameterAll = new ArrayList<AnalyticInputParameter>();

		for (Iterator it = analyticInputs.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			analyticInputParameterAll.add(getAnalyticInputParameter(key.toString(), value.toString()));
		}

		initDefaultAnalyticAssetMap();
		analyticAssetMap.setAnalyticInputParameters(analyticInputParameterAll);
		return analyticAssetMap;
	}

	public AnalyticAssetMap getAnalyticAssetMapWithAssetTemplateModelAttributes(List<String> analyticAttributesWithoutLinks, Map<String, String> analyticAttributesWithLinks) {
		List<AssetTemplateModelAttribute> assetTemplateModelAttributeAll = new ArrayList<AssetTemplateModelAttribute>();
		for (String analyticAttribute : analyticAttributesWithoutLinks) {
			assetTemplateModelAttributeAll.add(getAssetTemplateModelAttributeWithoutAssetAttributeLink(analyticAttribute, ""));
		}

		for (Iterator it = analyticAttributesWithLinks.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			assetTemplateModelAttributeAll.add(getAssetTemplateModelAttributeWithAssetAttributeLink(key.toString(), value.toString(), ""));
		}

		initDefaultAnalyticAssetMap();
		analyticAssetMap.setAssetTemplateModelAttributes(assetTemplateModelAttributeAll);
		return analyticAssetMap;
	}
	
	public AnalyticAssetMap getAnalyticAssetMapWithAssetTemplateModelAttributesWithAssetAttributeLink(Map<String, String> analyticAttributesWithLinks) {
		List<AssetTemplateModelAttribute> assetTemplateModelAttributeAll = new ArrayList<AssetTemplateModelAttribute>();
		
		for (Iterator it = analyticAttributesWithLinks.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			assetTemplateModelAttributeAll.add(getAssetTemplateModelAttributeWithAssetAttributeLink(key.toString(), value.toString(), ""));
		}

		initDefaultAnalyticAssetMap();
		analyticAssetMap.setAssetTemplateModelAttributes(assetTemplateModelAttributeAll);
		return analyticAssetMap;
	}

	public AnalyticAssetMap getAssetTypeWithAllAttributesAndParameters(List<String> analyticAttributesWithoutLinks, Map<String, String> analyticAttributesWithLinks,
			Map<String, String> analyticInputsMap) {
		AnalyticAssetMap analyticAssetMapAttrTemp = getAnalyticAssetMapWithAssetTemplateModelAttributes(analyticAttributesWithoutLinks, analyticAttributesWithLinks);
		AnalyticAssetMap analyticAssetMapParamTemp = getAnalyticAssetMapWithAnalyticInputParameters(analyticInputsMap);
		initDefaultAnalyticAssetMap();
		analyticAssetMap.setAssetTemplateModelAttributes(analyticAssetMapAttrTemp.getAssetTemplateModelAttributes());
		analyticAssetMap.setAnalyticInputParameters(analyticAssetMapParamTemp.getAnalyticInputParameters());
		return analyticAssetMap;
	}
}