/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */


package com.hbc.qa.lib.iib.apiHelpers.taxService;

import com.hbc.qa.lib.apiHelpers.APIRequestHelper;
import com.hbc.qa.lib.common.MBaseAPIHelper;
import com.hbc.qa.lib.connection.ConnectionResponse;

public class MTaxServiceAPIHelper extends MBaseAPIHelper {
	private final String getTaxEndpointAbstract = "/mw/services/tulip/order/tax/taxCalculationService";

	//https://tulip-uat-mbrk.hbc.com/mw/services/tulip/order/tax/taxCalculationService

	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders){
		return super.create(microservice, environment, getTaxEndpointAbstract, payload, apiRequestHeaders);
	}
}