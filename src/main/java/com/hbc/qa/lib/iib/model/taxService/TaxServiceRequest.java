/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */

package com.hbc.qa.lib.iib.model.taxService;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/*{
		 "request": {
		 "order_number": "1089666787",
		 "banner_code": "SAKS",
		 "country_code": "US",
		 "store_number": "624",
		 "postal_code": "33431",
		 "state_province": "FL",
		 "city": "BOCA RATON",
		 "tax_exempt_flag": "N",
		 "line_item": [{
		 "line_number": "1",
		 "tax_calculation_needed": "Y",
		 "item_id": "87606159",
		 "product_class": "018",
		 "line_total": "380.00",
		 "extended_price": "380.00",
		 "discount_price": "0.00",
		 "line_shipto": {
		 "country_code": "US",
		 "postal_code": "39056",
		 "state_province": "FL",
		 "city": "BOCA RATON"
		 },
		 "line_charge": [


		 ]
		 }]
		 }
		 }
*/

public class TaxServiceRequest {
	private TaxService request;

	public TaxServiceRequest() {
	}

	public TaxServiceRequest(TaxService request) {
		this.request = request;
	}

	public TaxService getRequest() {
		return request;
	}

	public void setRequest(TaxService request) {
		this.request = request;
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