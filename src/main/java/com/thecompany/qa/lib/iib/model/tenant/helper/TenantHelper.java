/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */
package com.thecompany.qa.lib.iib.model.tenant.helper;

import com.thecompany.qa.lib.iib.model.tenant.Tenant;
import static com.thecompany.qa.lib.common.BaseHelper.getCurrentTimeStamp;

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
