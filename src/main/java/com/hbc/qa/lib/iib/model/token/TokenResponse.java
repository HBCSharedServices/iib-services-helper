/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.token;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
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

		/* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenResponse)) return false;
        TokenResponse that = (TokenResponse) o;
        return Objects.equals(responseMessage, that.responseMessage) &&
                Objects.equals(responseCode, that.responseCode) &&
                Objects.equals(token, that.token) &&
                Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(banner, that.banner);
    } */

	@Override
	public boolean equals(Object responseObj) {
		Logger logger = Logger.getRootLogger();
		Boolean equalityCheckFlag = true;
		try {

			if (!(responseObj instanceof TokenResponse) || responseObj == null)
				return false;

			Field[] fields = TokenResponse.class.getDeclaredFields();
			for (Field field : fields) {
				Object requestVal = field.get(this);
				Object responseVal = field.get(responseObj);
				logger.info("Class Name: " + this.getClass().getName() + " --> Match failed on property: "
						+ field.getName() + ", BillToInRequest Value: " + requestVal + ", Response Value: "
						+ responseVal);
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

    @Override
	public int hashCode() {
		return Objects.hash(responseMessage, responseCode, token, cardNumber, banner);
	}
}
