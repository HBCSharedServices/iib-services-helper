/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */

package com.thecompany.qa.lib.iib.model.token.helper;

import com.thecompany.qa.lib.iib.model.token.TokenRequest;
import com.thecompany.qa.lib.iib.model.token.TokenResponse;

public class TokenHelper {
	TokenRequest token = null;
    TokenResponse tokenResponse;

	private void initDefaultTokenRequest() {
		token = new TokenRequest();
		token.setBanner("LT");
		token.setCardNumber("1234567890");
	}

    private void initDefaultTokenResponse() {
        tokenResponse = new TokenResponse();
    }

	public TokenRequest getTokenRequest() {
		initDefaultTokenRequest();
		return token;
	}

    public TokenResponse getTokenResponse(String banner, String cardNumber, String token, String msg, String code) {
        initDefaultTokenResponse();
	    tokenResponse.setBanner(banner);
	    tokenResponse.setCardNumber(cardNumber);
	    tokenResponse.setToken(token);
	    tokenResponse.setResponseMessage(msg);
	    tokenResponse.setResponseCode(code);
	    return tokenResponse;
    }
}