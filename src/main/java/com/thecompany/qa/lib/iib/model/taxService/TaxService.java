/**
 * /**
 *  * © TheCompany QA 2019. All rights reserved.
 *  * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 *  */

package com.thecompany.qa.lib.iib.model.taxService;

import org.apache.log4j.Logger;
import java.util.List;
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

public class TaxService {
	private String order_number;
	private String banner_code;
	private String country_code;
	private String store_number;
	private String postal_code;
	private String state_province;
	private String city;
	private String tax_exempt_flag;
	private List<TaxServiceLineItem> line_item;

	public TaxService() {
	}

	public TaxService(String order_number, String banner_code, String country_code, String store_number, String postal_code, String state_province, String city, String tax_exempt_flag, List<TaxServiceLineItem> line_item) {
		this.order_number = order_number;
		this.banner_code = banner_code;
		this.country_code = country_code;
		this.store_number = store_number;
		this.postal_code = postal_code;
		this.state_province = state_province;
		this.city = city;
		this.tax_exempt_flag = tax_exempt_flag;
		this.line_item = line_item;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getBanner_code() {
		return banner_code;
	}

	public void setBanner_code(String banner_code) {
		this.banner_code = banner_code;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getStore_number() {
		return store_number;
	}

	public void setStore_number(String store_number) {
		this.store_number = store_number;
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

	public String getTax_exempt_flag() {
		return tax_exempt_flag;
	}

	public void setTax_exempt_flag(String tax_exempt_flag) {
		this.tax_exempt_flag = tax_exempt_flag;
	}

	public List<TaxServiceLineItem> getLine_item() {
		return line_item;
	}

	public void setLine_item(List<TaxServiceLineItem> line_item) {
		this.line_item = line_item;
	}

	@SuppressWarnings("serial")


	@Override
	public boolean equals(Object responseObj) {
		Logger logger = Logger.getRootLogger();
		Boolean equalityCheckFlag = true;
		try {

			if (!(responseObj instanceof TaxService) || responseObj == null)
				return false;

			Field[] fields = TaxService.class.getDeclaredFields();
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