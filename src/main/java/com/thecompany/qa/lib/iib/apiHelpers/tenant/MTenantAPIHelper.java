/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */

package com.thecompany.qa.lib.iib.apiHelpers.tenant;

import com.thecompany.qa.lib.apiHelpers.APIHeaderRequestHelper;
import com.thecompany.qa.lib.common.MBaseAPIHelper;
import com.thecompany.qa.lib.connection.ConnectionResponse;

public class MTenantAPIHelper extends MBaseAPIHelper {
	//FOR MVP3
	//private final String createOrUpdateTenantEndpointAbstract = "/organizations/{organizationId}/tenants";
	private final String createOrUpdateTenantEndpoint = "/tenants";
	private final String getOrDeleteSingleTenantEndpointAbstract = "/tenants/{tenantId}";
	private final String getAllTenantsEndpoint = "/tenants";
	
	public ConnectionResponse create(String microservice, String environment, String payload, APIHeaderRequestHelper apiHeaderRequestHelper){
		//For MVP3, the REST API for tenant creation got modified - for now I hard coded the organization to unblock all the tests that need tenant
		//String createOrUpdateTenantEndpoint = createOrUpdateTenantEndpointAbstract.replace("{organizationId}", "57a254994b4a500096510892");
		return super.create(microservice, environment, createOrUpdateTenantEndpoint, payload, apiHeaderRequestHelper);
	}
	
	public void delete(String microservice, String environment, String tenantId, APIHeaderRequestHelper apiHeaderRequestHelper) {
		super.delete(microservice, environment, replaceTenantIdInSingleTenantEndpoint(tenantId), apiHeaderRequestHelper);
	}

	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.retrieve(microservice, environment, getAllTenantsEndpoint, apiHeaderRequestHelper);
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, String tenantId, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.retrieve(microservice, environment, replaceTenantIdInSingleTenantEndpoint(tenantId), apiHeaderRequestHelper);
	}
	
	private String replaceTenantIdInSingleTenantEndpoint(String tenantId) {
		return getOrDeleteSingleTenantEndpointAbstract.replace("{tenantId}", tenantId);
	}
}
