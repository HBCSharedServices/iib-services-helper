/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */
package com.thecompany.qa.lib.iib.model.insight;

import com.thecompany.qa.lib.iib.model.token.TokenRequest;

public class InsightResponse extends Insight {
	private TokenRequest insightType;

	public TokenRequest getInsightType() {
		return insightType;
	}

	public void setInsightType(TokenRequest insightType) {
		this.insightType = insightType;
	}

	// TODO:
	/*
	 * If two objects do not match, then its simply going to print out their
	 * string representations in the logger message. I need to figure out a
	 * better way for this.
	 */
	@Override
	public boolean equals(Object responseObj) {
		Boolean equalityCheckFlag = false;
		TokenRequest insightTypeFromResponseObj = ((InsightResponse) responseObj).getInsightType();

		if (super.equals(responseObj) && this.insightType.equals(insightTypeFromResponseObj))
			equalityCheckFlag = true;

		return equalityCheckFlag;
	}
}