/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */

package com.thecompany.qa.lib.iib.common;

import com.thecompany.qa.lib.iib.apiHelpers.token.MTokenRequestAPIHelper;
import com.thecompany.qa.lib.iib.model.token.TokenRequest;
import com.thecompany.qa.lib.iib.model.token.helper.TokenHelper;
import com.thecompany.qa.lib.common.MAbstractAPIHelper;

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