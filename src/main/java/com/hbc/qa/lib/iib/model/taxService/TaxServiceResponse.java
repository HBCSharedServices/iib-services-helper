/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.taxService;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.List;

public class TaxServiceResponse {
	private TaxService response;

	public TaxServiceResponse() {
	}

	public TaxServiceResponse(TaxService response) {
		this.response = response;
	}

	public TaxService getResponse() {
		return response;
	}

	public void setRequest(TaxService request) {
		this.response = response;
	}

	@SuppressWarnings("serial")


	@Override
	public boolean equals(Object responseObj) {
		Logger logger = Logger.getRootLogger();
		Boolean equalityCheckFlag = true;
		try {

			if (!(responseObj instanceof TaxServiceRequest) || responseObj == null)
				return false;

			Field[] fields = TaxServiceRequest.class.getDeclaredFields();
			for (Field field : fields) {
				Object requestVal = field.get(this);
				Object responseVal = field.get(responseObj);
				if (requestVal != null)
					if (!requestVal.equals(responseVal)) {
						equalityCheckFlag = false;
						logger.error("Class Name: " + this.getClass().getName() + " --> Match failed on property: "
								+ field.getName() + ", BillToInRequest Value: " + requestVal + ", Response Value: "
								+ responseVal);
						break;
					}
			}
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
		}
		return equalityCheckFlag;
	}
}