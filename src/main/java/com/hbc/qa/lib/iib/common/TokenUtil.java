/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.common;

import com.hbc.qa.lib.iib.apiHelpers.token.MTokenRequestAPIHelper;
import com.hbc.qa.lib.iib.model.token.TokenRequest;
import com.hbc.qa.lib.iib.model.token.helper.TokenHelper;
import com.hbc.qa.lib.common.MAbstractAPIHelper;

public class TokenUtil extends BaseTestUtil {

	private MTokenRequestAPIHelper insightTypeAPI = new MTokenRequestAPIHelper();
	private TokenHelper tokenHelper;
	private TokenRequest tokenRequest;
	private final String MICROSERVICE_NAME = "tokenization";
	private String userType = "superuser";

	/**
	 * 
	 * @param tokenFlavor
	 *
	 */
	public TokenRequest createInsightType(String tokenFlavor) {
		initSetup(userType);
		String tokenizationMicroservice = microserviceConfig.getString(MICROSERVICE_NAME + "." + envRuntime);
		tokenHelper = new TokenHelper();

		switch (tokenFlavor) {
		case "ANY":
			tokenRequest = tokenHelper.getTokenRequest();
			break;
		default:
			tokenRequest = tokenHelper.getTokenRequest();
		}
		return MAbstractAPIHelper.getResponseObjForCreate(tokenRequest, tokenizationMicroservice, environment, apiRequestHelper, insightTypeAPI, TokenRequest.class);
	}
}