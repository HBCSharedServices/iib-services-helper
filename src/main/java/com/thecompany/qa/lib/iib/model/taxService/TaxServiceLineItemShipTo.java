/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */

package com.thecompany.qa.lib.iib.model.taxService;

import org.apache.log4j.Logger;
import java.lang.reflect.Field;

public class TaxServiceLineItemShipTo {
	private String country_code;
	private String postal_code;
	private String state_province;
	private String city;

	public TaxServiceLineItemShipTo() {
	}

	public TaxServiceLineItemShipTo(String country_code, String postal_code, String state_province, String city) {
		this.country_code = country_code;
		this.postal_code = postal_code;
		this.state_province = state_province;
		this.city = city;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getState_province() {
		return state_province;
	}

	public void setState_province(String state_province) {
		this.state_province = state_province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@SuppressWarnings("serial")


	@Override
	public boolean equals(Object responseObj) {
		Logger logger = Logger.getRootLogger();
		Boolean equalityCheckFlag = true;
		try {

			if (!(responseObj instanceof TaxServiceLineItemShipTo) || responseObj == null)
				return false;

			Field[] fields = TaxServiceLineItemShipTo.class.getDeclaredFields();
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