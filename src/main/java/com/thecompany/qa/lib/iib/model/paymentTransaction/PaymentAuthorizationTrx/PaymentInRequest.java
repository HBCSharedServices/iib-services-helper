/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */

package com.thecompany.qa.lib.iib.model.paymentTransaction.PaymentAuthorizationTrx;

public class PaymentInRequest {
    private CardInResponse card;
    private String merchant_id;
    private String entry_mode;
    private String type;

    public CardInResponse getCard() {
        return card;
    }

    public void setCard(CardInResponse card) {
        this.card = card;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getEntry_mode() {
        return entry_mode;
    }

    public void setEntry_mode(String entry_mode) {
        this.entry_mode = entry_mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
