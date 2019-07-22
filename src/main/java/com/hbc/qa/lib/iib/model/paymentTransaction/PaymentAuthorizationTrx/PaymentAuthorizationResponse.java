package com.hbc.qa.lib.iib.model.paymentTransaction.PaymentAuthorizationTrx;

import java.util.List;

public class PaymentAuthorizationResponse {
    private String banner;
    private String country_code;
    private String language_code;
    private String order_number;

    private String sub_channel;
    private String store_number;

    private String terminal_number;
    private String transcation_number;

    private String response_code;
    private String response_message;

    private List<PaymentInResponse> payments;
}
