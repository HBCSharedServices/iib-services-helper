/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.tenant.helper;


import io.qio.qa.lib.ehm.model.tenant.Tenant;

public class TenantHelper {
	Tenant tenant;
	
	// creates a tenant with default values for its properties.
	private void initDefaultTenant() {
		java.util.Date date= new java.util.Date();
		String timestamp = Long.toString(date.getTime());
		tenant = new Tenant(timestamp);
	}
	
	/*
	 * Tenant object 
	 */

	public Tenant getTenant(){
		initDefaultTenant();
		return tenant;
	}
}
