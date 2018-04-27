/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.insight;

public enum InsightStatus {
	OPEN("Open"),
	CLOSED("Closed");
	
	private String realValue;

	private InsightStatus(String realValue) {
		this.realValue = realValue;
	}

	@Override
	public String toString() {
		return realValue;
	}
}
