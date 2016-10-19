/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.apiHelpers;

import io.qio.qa.lib.apiHelpers.APIRequestHelper;
import io.qio.qa.lib.common.MBaseAPIHelper;
import io.qio.qa.lib.connection.ConnectionResponse;

public class MTenantAPIHelper extends MBaseAPIHelper {
	//FOR MVP3
	//private final String createOrUpdateTenantEndpointAbstract = "/organizations/{organizationId}/tenants";
	private final String createOrUpdateTenantEndpoint = "/tenants";
	private final String getOrDeleteSingleTenantEndpointAbstract = "/tenants/{tenantId}";
	private final String getAllTenantsEndpoint = "/tenants";
	
	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders){
		//For MVP3, the REST API for tenant creation got modified - for now I hard coded the organization to unblock all the tests that need tenant
		//String createOrUpdateTenantEndpoint = createOrUpdateTenantEndpointAbstract.replace("{organizationId}", "57a254994b4a500096510892");
		return super.create(microservice, environment, createOrUpdateTenantEndpoint, payload, apiRequestHeaders);
	}
	
	public void delete(String microservice, String environment, String tenantId, APIRequestHelper apiRequestHeaders) {
		super.delete(microservice, environment, replaceTenantIdInSingleTenantEndpoint(tenantId), apiRequestHeaders);
	}

	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, getAllTenantsEndpoint, apiRequestHeaders);
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, String tenantId, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, replaceTenantIdInSingleTenantEndpoint(tenantId), apiRequestHeaders);
	}
	
	private String replaceTenantIdInSingleTenantEndpoint(String tenantId) {
		String singleTenantEndpoint = getOrDeleteSingleTenantEndpointAbstract.replace("{tenantId}", tenantId);
		return singleTenantEndpoint;
	}
}
