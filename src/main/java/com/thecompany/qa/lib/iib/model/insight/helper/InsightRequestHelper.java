/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */
package com.thecompany.qa.lib.iib.model.insight.helper;

import com.thecompany.qa.lib.iib.common.TokenUtil;
import com.thecompany.qa.lib.iib.model.token.TokenRequest;
import com.thecompany.qa.lib.iib.model.token.helper.AttributeDataType;
import com.thecompany.qa.lib.iib.common.TenantUtil;
import com.thecompany.qa.lib.iib.model.insight.InsightRequest;
import com.thecompany.qa.lib.iib.model.tenant.Tenant;

import static com.thecompany.qa.lib.common.BaseHelper.getCurrentTimeStamp;

public class InsightRequestHelper {
	InsightRequest insight = null;
	TokenUtil tokenUtil = null;
	TenantUtil tenantUtil = null;


	private void initDefaultInsight(String insightTypeId, String tenantId) {
		insight = new InsightRequest(getCurrentTimeStamp(), insightTypeId, tenantId);
	}

	public InsightRequest getInsightWithPredefinedInsightTypeAndTenant(String insightTypeId, String tenantId) {
		initDefaultInsight(insightTypeId, tenantId);
		return insight;
	}

	public InsightRequest getInsightWithCreatingInsightTypeAndTenant(String insightTypeFlavor, AttributeDataType attributeDataType) {
		tokenUtil = new TokenUtil();
		tenantUtil = new TenantUtil();

		TokenRequest tokenRequest = tokenUtil.createInsightType(insightTypeFlavor);

		Tenant tenant = tenantUtil.createTenant();
		String tenantId = tenant.getTenantId();

		return getInsightWithPredefinedInsightTypeAndTenant("insightTypeId", tenantId);
	}
}