/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */

package com.thecompany.qa.lib.iib.model.taxService;

import org.apache.log4j.Logger;
import java.lang.reflect.Field;

/*{
		 "request": {
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

public class TaxServiceLineItem {
	private String line_number;
	private String tax_calculation_needed;
	private String item_id;
	private String product_class;
	private String line_total;
	private String extended_price;
	private String discount_price;
	private String tax_exempt_flag;
	private TaxServiceLineItemShipTo line_shipto;

	public TaxServiceLineItem() {
	}

	public TaxServiceLineItem(String line_number, String tax_calculation_needed, String item_id, String product_class, String line_total, String extended_price, String discount_price, String tax_exempt_flag, TaxServiceLineItemShipTo line_shipto) {
		this.line_number = line_number;
		this.tax_calculation_needed = tax_calculation_needed;
		this.item_id = item_id;
		this.product_class = product_class;
		this.line_total = line_total;
		this.extended_price = extended_price;
		this.discount_price = discount_price;
		this.tax_exempt_flag = tax_exempt_flag;
		this.line_shipto = line_shipto;
	}


	public String getLine_number() {
		return line_number;
	}

	public void setLine_number(String line_number) {
		this.line_number = line_number;
	}

	public String getTax_calculation_needed() {
		return tax_calculation_needed;
	}

	public void setTax_calculation_needed(String tax_calculation_needed) {
		this.tax_calculation_needed = tax_calculation_needed;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getProduct_class() {
		return product_class;
	}

	public void setProduct_class(String product_class) {
		this.product_class = product_class;
	}

	public String getLine_total() {
		return line_total;
	}

	public void setLine_total(String line_total) {
		this.line_total = line_total;
	}

	public String getExtended_price() {
		return extended_price;
	}

	public void setExtended_price(String extended_price) {
		this.extended_price = extended_price;
	}

	public String getDiscount_price() {
		return discount_price;
	}

	public void setDiscount_price(String discount_price) {
		this.discount_price = discount_price;
	}

	public String getTax_exempt_flag() {
		return tax_exempt_flag;
	}

	public void setTax_exempt_flag(String tax_exempt_flag) {
		this.tax_exempt_flag = tax_exempt_flag;
	}

	public TaxServiceLineItemShipTo getLine_shipto() {
		return line_shipto;
	}

	public void setLine_shipto(TaxServiceLineItemShipTo line_shipto) {
		this.line_shipto = line_shipto;
	}

	@SuppressWarnings("serial")


	@Override
	public boolean equals(Object responseObj) {
		Logger logger = Logger.getRootLogger();
		Boolean equalityCheckFlag = true;
		try {

			if (!(responseObj instanceof TaxServiceLineItem) || responseObj == null)
				return false;

			Field[] fields = TaxServiceLineItem.class.getDeclaredFields();
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