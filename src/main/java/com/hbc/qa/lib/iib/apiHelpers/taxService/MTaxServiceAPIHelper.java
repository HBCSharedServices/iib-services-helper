/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */

package com.hbc.qa.lib.iib.apiHelpers.taxService;

import com.hbc.qa.lib.apiHelpers.APIRequestHelper;
import com.hbc.qa.lib.common.MBaseAPIHelper;
import com.hbc.qa.lib.connection.ConnectionResponse;

public class MTaxServiceAPIHelper extends MBaseAPIHelper {
	private final String getTaxEndpointAbstract = "/order/tax/taxCalculationService";

	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders){
		return super.create(microservice, environment, getTaxEndpointAbstract, payload, apiRequestHeaders);
	}
}