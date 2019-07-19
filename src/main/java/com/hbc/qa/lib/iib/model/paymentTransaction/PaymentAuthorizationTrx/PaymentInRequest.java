package com.hbc.qa.lib.iib.model.paymentTransaction.PaymentAuthorizationTrx;

public class PaymentInRequest {
    private CardInRequest card;
    private String merchant_id;
    private String entry_mode;
    private String type;
    private BillToInRequest bill_to;

    public CardInRequest getCard() {
        return card;
    }

    public void setCard(CardInRequest card) {
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

    public BillToInRequest getBill_to() {
        return bill_to;
    }

    public void setBill_to(BillToInRequest bill_to) {
        this.bill_to = bill_to;
    }
}
