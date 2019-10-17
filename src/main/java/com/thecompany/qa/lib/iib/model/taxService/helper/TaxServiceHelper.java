/**
 * /**
 *  * © TheCompany QA 2019. All rights reserved.
 *  * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 *  */

package com.thecompany.qa.lib.iib.model.taxService.helper;

import com.thecompany.qa.lib.iib.model.taxService.TaxServiceRequest;
import com.thecompany.qa.lib.iib.model.taxService.TaxService;
import com.thecompany.qa.lib.iib.model.taxService.TaxServiceLineItem;
import com.thecompany.qa.lib.iib.model.taxService.TaxServiceLineItemShipTo;

import java.util.List;

public class TaxServiceHelper {
	TaxServiceRequest taxServiceRequest = null;
	TaxService taxService = null;
	TaxServiceLineItem taxServiceLineItem = null;
	TaxServiceLineItemShipTo taxServiceLineItemShipTo = null;

	/*
	 * This method is invoked from each of the following methods to make sure every time a new TaxServiceRequest is created.
	 */
	private void initDefaultTaxServiceRequest() {
		taxServiceRequest = new TaxServiceRequest();
		taxService = new TaxService();
	}

	public TaxServiceLineItemShipTo prepareTaxServiceLineItemShipTo(String country_code, String postal_code, String state_province, String city) {
		taxServiceLineItemShipTo.setCity(city);
		taxServiceLineItemShipTo.setCountry_code(country_code);
		taxServiceLineItemShipTo.setState_province(state_province);
		taxServiceLineItemShipTo.setPostal_code(postal_code);

		return taxServiceLineItemShipTo;
	}

	public TaxServiceLineItem prepareTaxServiceRequestLineItem(String line_number, String tax_calculation_needed, String item_id, String product_class, String line_total, String extended_price, String discount_price, String tax_exempt_flag, String country_code, String postal_code, String state_province, String city) {
		taxServiceLineItem = new TaxServiceLineItem();
		taxServiceLineItemShipTo = new TaxServiceLineItemShipTo();

		taxServiceLineItem.setLine_number(line_number);
		taxServiceLineItem.setTax_calculation_needed(tax_calculation_needed);
		taxServiceLineItem.setItem_id(item_id);
		taxServiceLineItem.setProduct_class(product_class);
		taxServiceLineItem.setLine_total(line_total);
		taxServiceLineItem.setDiscount_price(discount_price);
		taxServiceLineItem.setExtended_price(extended_price);
		taxServiceLineItem.setTax_exempt_flag(tax_exempt_flag);
		taxServiceLineItem.setLine_shipto(prepareTaxServiceLineItemShipTo(country_code, postal_code, state_province, city));

		return taxServiceLineItem;
	}

	public TaxServiceRequest prepareTaxServiceRequestForGivenLineItems(String order_number, String banner_code,String country_code, String store_number, String postal_code, String state_province, String city, String tax_exempt_flag, List<TaxServiceLineItem> line_item) {
		initDefaultTaxServiceRequest();
		taxService.setOrder_number(order_number);
		taxService.setBanner_code(banner_code);
		taxService.setCountry_code(country_code);
		taxService.setCity(city);
		taxService.setPostal_code(postal_code);
		taxService.setState_province(state_province);
		taxService.setStore_number(store_number);
		taxService.setTax_exempt_flag(tax_exempt_flag);
		taxService.setLine_item(line_item);
		taxServiceRequest.setRequest(taxService);
		return taxServiceRequest;
	}

}