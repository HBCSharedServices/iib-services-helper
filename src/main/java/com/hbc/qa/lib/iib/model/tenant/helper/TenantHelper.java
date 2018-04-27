/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.tenant.helper;


import com.hbc.qa.lib.iib.model.tenant.Tenant;
import static com.hbc.qa.lib.common.BaseHelper.getCurrentTimeStamp;

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
