/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.token;

import java.util.Objects;

public class TokenResponse {
	private String responseMessage;
	private String responseCode;
	private String token;
	private String cardNumber;
	private String banner;

	public String getResponseMessage ()
    {
			return responseMessage;
    }

		public void setResponseMessage (String responseMessage)
		{
			this.responseMessage = responseMessage;
		}

		public String getResponseCode ()
		{
			return responseCode;
		}

		public void setResponseCode (String responseCode)
		{
			this.responseCode = responseCode;
		}

		public String getToken ()
		{
			return token;
		}

		public void setToken (String token)
		{
			this.token = token;
		}

		public String getCardNumber ()
		{
			return cardNumber;
		}

		public void setCardNumber (String cardNumber)
		{
			this.cardNumber = cardNumber;
		}

		public String getBanner ()
		{
			return banner;
		}

		public void setBanner (String banner)
		{
			this.banner = banner;
		}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenResponse)) return false;
        TokenResponse that = (TokenResponse) o;
        return Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(banner, that.banner);
    }

    @Override
	public int hashCode() {
		return Objects.hash(responseMessage, responseCode, token, cardNumber, banner);
	}
}
