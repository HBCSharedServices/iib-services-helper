package com.hbc.qa.lib.iib.model.paymentTransaction.PaymentAuthorizationTrx;

public class AuthorizationInResponse {
    private String authorization_reference;
    private String authorization_code;
    private String authorization_date;
    private String avs_response_code;
    private String cvv_response_code;

    public String getAuthorization_reference() {
        return authorization_reference;
    }

    public void setAuthorization_reference(String authorization_reference) {
        this.authorization_reference = authorization_reference;
    }

    public String getAuthorization_code() {
        return authorization_code;
    }

    public void setAuthorization_code(String authorization_code) {
        this.authorization_code = authorization_code;
    }

    public String getAuthorization_date() {
        return authorization_date;
    }

    public void setAuthorization_date(String authorization_date) {
        this.authorization_date = authorization_date;
    }

    public String getAvs_response_code() {
        return avs_response_code;
    }

    public void setAvs_response_code(String avs_response_code) {
        this.avs_response_code = avs_response_code;
    }

    public String getCvv_response_code() {
        return cvv_response_code;
    }

    public void setCvv_response_code(String cvv_response_code) {
        this.cvv_response_code = cvv_response_code;
    }
}
