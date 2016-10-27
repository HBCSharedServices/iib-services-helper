/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.common;

import io.qio.qa.lib.ehm.apiHelpers.insights.MInsightTypeAPIHelper;
import io.qio.qa.lib.ehm.model.insight.insightType.InsightType;
import io.qio.qa.lib.ehm.model.insight.insightType.helper.InsightTypeHelper;
import io.qio.qa.lib.ehm.model.insight.insightType.helper.AttributeDataType;


public class InsightTypeUtil extends BaseTestUtil {

	private MInsightTypeAPIHelper insightTypeAPI = new MInsightTypeAPIHelper();
	private InsightTypeHelper insightTypeHelper;
	private InsightType requestInsightType;
	private final String MICROSERVICE_NAME = "insight";
	private String userType = "superuser";

	/**
	 * 
	 * @param insightTypeFlavor
	 * @param attributeDataType
	 *            -- will require a valid AttributeDataType for the option WithOneAttribute, else pass in null
	 */
	public InsightType createInsightType(String insightTypeFlavor, AttributeDataType attributeDataType) {
		initSetup(userType);
		String insightTypeMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);
		insightTypeHelper = new InsightTypeHelper();

		switch (insightTypeFlavor) {
		case "WithNoAttributes":
			requestInsightType = insightTypeHelper.getInsightTypeWithNoAttributes();
			break;
		case "WithOneAttribute":
			requestInsightType = insightTypeHelper.getInsightTypeWithOneAttribute(attributeDataType);
			break;
		case "WithAllAttributes":
			requestInsightType = insightTypeHelper.getInsightTypeWithAllAttributes();
			break;
		default:
			requestInsightType = insightTypeHelper.getInsightTypeWithNoAttributes();
		}
		return APITestUtil.getResponseObjForCreate(requestInsightType, insightTypeMicroservice, environment, apiRequestHelper, insightTypeAPI, InsightType.class);
	}
}