/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.taxService.helper;

import com.hbc.qa.lib.common.BaseHelper;
import com.hbc.qa.lib.iib.model.taxService.TaxService;
import com.hbc.qa.lib.iib.model.taxService.TaxServiceLineItem;
import com.hbc.qa.lib.iib.model.taxService.TaxServiceLineItemShipTo;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class TaxServiceGetPayloadHelper {
	TaxServiceLineItem taxServiceLineItem = null;
	TaxService taxService = null;
	TaxServiceLineItemShipTo taxServiceLineItemShipTo = null;
	final static Logger logger = Logger.getRootLogger();


	public TaxServiceLineItem prepareTaxServiceGetPayloadLineItems(String line_number, String tax_calculation_needed, String item_id, String product_class, String line_total, String extended_price, String discount_price, String tax_exempt_flag, TaxServiceLineItemShipTo line_shipto) {
		taxServiceLineItem.setLine_number(line_number);
		taxServiceLineItem.setTax_calculation_needed(tax_calculation_needed);
		taxServiceLineItem.setItem_id(item_id);
		taxServiceLineItem.setProduct_class(product_class);
		taxServiceLineItem.setLine_total(line_total);
		taxServiceLineItem.setExtended_price(extended_price);
		taxServiceLineItem.setDiscount_price(discount_price);
		taxServiceLineItem.setTax_exempt_flag(tax_exempt_flag);
		taxServiceLineItem.setLine_shipto(line_shipto);

		return taxServiceLineItem;
	}

	public TaxService prepareTaxServiceGetPayloadWithLineItems(String order_number, String banner_code, String country_code, String store_number, String postal_code, String state_province, String city, String tax_exempt_flag, List<TaxServiceLineItem> line_item) {
		taxService = new TaxService();
		taxService.setBanner_code(banner_code);
		taxService.setOrder_number(order_number);
		taxService.setCity(city);
		taxService.setCountry_code(country_code);
		taxService.setPostal_code(postal_code);
		taxService.setStore_number(store_number);
		taxService.setState_province(state_province);
		taxService.setTax_exempt_flag(tax_exempt_flag);
		taxService.setLine_item(line_item);

		return taxService;
	}

	public String prepareTaxServiceGetPayloadAsJSONString(String order_number, String banner_code, String country_code, String store_number, String postal_code, String state_province, String city, String tax_exempt_flag, List<TaxServiceLineItem> line_item) {
		taxService = prepareTaxServiceGetPayloadWithLineItems(order_number, banner_code, country_code, store_number, postal_code, state_province, city, tax_exempt_flag, line_item);

		String payloadJSONString = "";
		try {
			payloadJSONString = BaseHelper.toJSONString(taxService);
		} catch (IOException e) {
			logger.info("Exception while transforming TaxService class instance to JSONString "+e);
		}

		return payloadJSONString;
	}
}