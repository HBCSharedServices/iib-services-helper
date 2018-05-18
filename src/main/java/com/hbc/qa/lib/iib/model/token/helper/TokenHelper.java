/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.token.helper;

import com.hbc.qa.lib.iib.model.token.TokenRequest;

public class TokenHelper {
	TokenRequest token = null;

	private void initDefaultTokeRequest() {
		token = new TokenRequest();
		token.setBanner("LT");
		token.setCardNumber("1234567890");
	}

	public TokenRequest getTokenRequest() {
		initDefaultTokeRequest();
		return token;
	}
}