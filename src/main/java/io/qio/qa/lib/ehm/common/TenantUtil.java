/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.common;


import io.qio.qa.lib.ehm.apiHelpers.MTenantAPIHelper;
import io.qio.qa.lib.ehm.model.tenant.Tenant;
import io.qio.qa.lib.ehm.model.tenant.helper.TenantHelper;

public class TenantUtil extends BaseTestUtil {

	private MTenantAPIHelper tenantAPI = new MTenantAPIHelper();
	private String MICROSERVICE_NAME = "tenant";
	private TenantHelper tenantHelper;
	private Tenant requestTenant;
	private String userType = "admin";

	public Tenant createTenant() {
		initSetup(userType);
		String tenantMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);

		tenantHelper = new TenantHelper();
		requestTenant = tenantHelper.getTenant();

		return APITestUtil.getResponseObjForCreate(requestTenant, tenantMicroservice, environment, apiRequestHelper, tenantAPI, Tenant.class);
	}
}