/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.insight.helper;

//import io.qio.qa.lib.ehm.common.APITestUtil;
import io.qio.qa.lib.ehm.common.InsightTypeUtil;
import io.qio.qa.lib.ehm.common.TenantUtil;
import io.qio.qa.lib.ehm.model.insight.InsightRequest;
import io.qio.qa.lib.ehm.model.insight.insightType.InsightType;
import io.qio.qa.lib.ehm.model.insight.insightType.helper.AttributeDataType;
import io.qio.qa.lib.ehm.model.tenant.Tenant;

public class InsightRequestHelper {
	InsightRequest insight = null;
	InsightTypeUtil insightTypeUtil = null;
	TenantUtil tenantUtil = null;

	private void initDefaultInsight() {
		java.util.Date date = new java.util.Date();
		String timestamp = Long.toString(date.getTime());
		insight = new InsightRequest(timestamp, "", "");
	}

	public InsightRequest getInsightWithPredefinedInsightTypeAndTenant(String insightTypeId, String tenantId) {
		initDefaultInsight();
		insight.setInsightTypeId(insightTypeId);
		insight.setTenantId(tenantId);
		return insight;
	}

	public InsightRequest getInsightWithCreatingInsightTypeAndTenant(String insightTypeFlavor, AttributeDataType attributeDataType) {
		insightTypeUtil = new InsightTypeUtil();
		tenantUtil = new TenantUtil();

		InsightType insightType = insightTypeUtil.createInsightType(insightTypeFlavor, attributeDataType);
		//String insightTypeId = APITestUtil.getElementId(insightType.get_links().getSelfLink().getHref());
		String insightTypeId = insightType.getInsightTypeId();

		Tenant tenant = tenantUtil.createTenant();
		String tenantId = tenant.getTenantId();

		return getInsightWithPredefinedInsightTypeAndTenant(insightTypeId, tenantId);
	}
}