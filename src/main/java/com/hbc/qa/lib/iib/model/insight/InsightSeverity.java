/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.insight;

public enum InsightSeverity {
	CRITICAL("Critical"),
	WARNING("Warning"),
	INFORMATIONAL("Informational");

	private String realValue;

	private InsightSeverity(String realValue) {
		this.realValue = realValue;
	}

	@Override
	public String toString() {
		return realValue;
	}
}
