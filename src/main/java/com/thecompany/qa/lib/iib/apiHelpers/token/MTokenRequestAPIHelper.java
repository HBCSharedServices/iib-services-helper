/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */
package com.thecompany.qa.lib.iib.apiHelpers.token;

import com.thecompany.qa.lib.apiHelpers.APIRequestHelper;
import com.thecompany.qa.lib.common.MBaseAPIHelper;
import com.thecompany.qa.lib.connection.ConnectionResponse;

public class MTokenRequestAPIHelper extends MBaseAPIHelper {
	private final String createTokenEndpoint = "/tokenization/tokenex/create/token";

	public ConnectionResponse create(String microservice, String environment, String payload, APIRequestHelper apiRequestHeaders){
		return super.create(microservice, environment, createTokenEndpoint, payload, apiRequestHeaders);
	}
}
