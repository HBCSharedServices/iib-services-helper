/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package com.hbc.qa.lib.iib.common;


import com.hbc.qa.lib.iib.apiHelpers.tenant.MTenantAPIHelper;
import com.hbc.qa.lib.iib.model.tenant.helper.TenantHelper;
import com.hbc.qa.lib.common.BaseHelper;
import com.hbc.qa.lib.iib.model.tenant.Tenant;
import com.hbc.qa.lib.common.MAbstractAPIHelper;
import com.hbc.qa.lib.idm.model.userGroup.UserGroup;
import com.hbc.qa.lib.idm.apiHelpers.MUserGroupAPIHelper;

import org.apache.log4j.Logger;

public class TenantUtil extends BaseTestUtil {
	private MTenantAPIHelper tenantAPI = new MTenantAPIHelper();
	private String MICROSERVICE_NAME = "tenant";
	private TenantHelper tenantHelper;
	private Tenant requestTenant;
	private MUserGroupAPIHelper groupAPI;
	private String userType = "admin";
	final static Logger logger = Logger.getRootLogger();

	public Tenant createTenant() {
		initSetup(userType);
		String tenantMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);

		tenantHelper = new TenantHelper();
		requestTenant = tenantHelper.getTenant();

		return MAbstractAPIHelper.getResponseObjForCreate(requestTenant, tenantMicroservice, environment, apiRequestHelper, tenantAPI, Tenant.class);
	}

	public String getIDMGroupForTenant(String tenantId) {
		initSetup(userType);
		groupAPI = new MUserGroupAPIHelper();
		String oauthMicroservice = microserviceConfig.getString(oauthMicroserviceName + "." + envRuntime);

		UserGroup committedGroup = MAbstractAPIHelper.getListResponseObjForRetrieveBySearch(oauthMicroservice, environment, "byNameLike", tenantId, apiRequestHelper, groupAPI, UserGroup.class).get(0);
		return(BaseHelper.getElementId(committedGroup.get_links().getSelfLink().getHref()));
	}
}