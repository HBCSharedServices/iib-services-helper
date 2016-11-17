/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.tenant.helper;


import io.qio.qa.lib.ehm.model.tenant.Tenant;
import static io.qio.qa.lib.common.BaseHelper.getCurrentTimeStamp;

public class TenantHelper {
	Tenant tenant;
	
	// creates a tenant with default values for its properties.
	private void initDefaultTenant() {
		tenant = new Tenant(getCurrentTimeStamp());
	}
	
	/*
	 * Tenant object 
	 */

	public Tenant getTenant(){
		initDefaultTenant();
		return tenant;
	}
}
