/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.insightType.helper;

import io.qio.qa.lib.ehm.model.insightType.InsightType;
import io.qio.qa.lib.ehm.model.insightType.InsightTypeAttribute;

import java.util.ArrayList;
import java.util.List;


public class InsightTypeHelper {
	InsightType insightType = null;

	/*
	 * This method is invoked from each of the following methods to make sure every time a new insighttype is created with a unique timestamp.
	 */
	private void initDefaultInsightType() {
		java.util.Date date = new java.util.Date();
		String timestamp = Long.toString(date.getTime());
		insightType = new InsightType(timestamp);
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