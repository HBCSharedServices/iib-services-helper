/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.insight;

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
