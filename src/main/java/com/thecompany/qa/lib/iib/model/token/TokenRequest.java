/**
 * /**
 *  * © TheCompany QA 2019. All rights reserved.
 *  * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 *  */

package com.thecompany.qa.lib.iib.model.token;

import org.apache.log4j.Logger;
import java.lang.reflect.Field;
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
	public boolean equals(Object responseObj) {
		Logger logger = Logger.getRootLogger();
		Boolean equalityCheckFlag = true;
		try {

			if (!(responseObj instanceof TokenRequest) || responseObj == null)
				return false;

			Field[] fields = TokenRequest.class.getDeclaredFields();
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

	@Override
	public int hashCode() {
		return Objects.hash(banner, cardNumber);
	}
}
