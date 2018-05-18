/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.token;

import java.util.Objects;

public class TokenRequest {
	private String banner;
	private String cardNumber;

	public String getBanner ()
	{
		return banner;
	}

	public void setBanner (String banner)
	{
		this.banner = banner;
	}

	public String getCardNumber ()
	{
		return cardNumber;
	}

	public void setCardNumber (String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "TokenRequest{" +
				"banner='" + banner + '\'' +
				", cardNumber='" + cardNumber + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TokenRequest)) return false;
		TokenRequest that = (TokenRequest) o;
		return Objects.equals(banner, that.banner) &&
				Objects.equals(cardNumber, that.cardNumber);
	}

	@Override
	public int hashCode() {

		return Objects.hash(banner, cardNumber);
	}
}
