/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.insightType.helper;

import com.hbc.qa.lib.iib.model.insightType.InsightType;
import com.hbc.qa.lib.iib.model.insightType.InsightTypeAttribute;
import static com.hbc.qa.lib.common.BaseHelper.getCurrentTimeStamp;

import java.util.ArrayList;
import java.util.List;


public class InsightTypeHelper {
	InsightType insightType = null;

	/*
	 * This method is invoked from each of the following methods to make sure every time a new insighttype is created with a unique timestamp.
	 */
	private void initDefaultInsightType() {
		insightType = new InsightType(getCurrentTimeStamp());
	}


	public InsightType getInsightTypeWithNoAttributes() {
		initDefaultInsightType();
		insightType.setAttributes(null);
		return insightType;
	}

	@SuppressWarnings("serial")
	public InsightType getInsightTypeWithOneAttribute(AttributeDataType attributeDataType) {
		initDefaultInsightType();
		insightType.setAttributes(new ArrayList<InsightTypeAttribute>() {
			{
				add(getInsightTypeAttributeWithInputDataType(attributeDataType));
			}
		});
		return insightType;
	}

	public InsightType getInsightTypeWithAllAttributes() {
		List<InsightTypeAttribute> insightTypeAttributeAll = new ArrayList<InsightTypeAttribute>();
		for (AttributeDataType dataType : AttributeDataType.values()) {
			insightTypeAttributeAll.add(getInsightTypeAttributeWithInputDataType(dataType));
		}
		initDefaultInsightType();
		insightType.setAttributes(insightTypeAttributeAll);
		return insightType;
	}

	public InsightTypeAttribute getInsightTypeAttributeWithInputDataType(AttributeDataType attributeDataType) {
		String attributeDataTypePrefix = "ABBR" + attributeDataType.toString();
		return new InsightTypeAttribute(attributeDataTypePrefix, attributeDataTypePrefix + " Name", attributeDataTypePrefix + " Desc", "Unit",
				attributeDataType.toString());
	}

	public InsightType getInsightTypeWithDefaultAttribute() {
		initDefaultInsightType();
		return insightType;
	}
}