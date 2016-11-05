/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.asset;

import io.qio.qa.lib.common.BaseHelper;
import io.qio.qa.lib.ehm.model.common.Links;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonProperty;

import java.lang.reflect.Field;

public abstract class Asset {
	protected String abbreviation;
	protected String name;
	protected String description;
	protected String status;
	protected String tenant;

	// returned in the response of a POST request
	protected String createdDate;
	protected String assetId;
	
	@JsonProperty("_links")
	protected Links _links;

	public Asset() {
	}

	@SuppressWarnings("serial")
	public Asset(String timeStamp, String tenant) {
		this.abbreviation = "A" + timeStamp;
		this.name = "A" + timeStamp + "Name";
		this.description = "A" + timeStamp + "Desc";
		this.status = AssetStatus.CREATED.toString();
		this.tenant = tenant;
	}

	public Asset(String abbreviation, String name, String description, String tenant, String status) {
		this.abbreviation = abbreviation;
		this.name = name;
		this.description = description;
		this.tenant = tenant;
		this.status = status;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Links get_links() {
		return _links;
	}

	public void set_links(Links _links) {
		this._links = _links;
	}

    public String getCreatedDate() {
        return createdDate;
    }

    public String getAssetId() {
        return assetId;
    }

    public Boolean validateDateFormats() {
        Logger logger = Logger.getRootLogger();
        Field[] fields = Asset.class.getDeclaredFields();
        for (Field field : fields) {
            Object responseVal = null;
            try {
                responseVal = field.get(this);
                String fieldName = field.getName();

                // Checking for the format of the Date Field.
                if (field.getName().equals("createdDate")) {
                    //logger.info("Checking validity of date format for "+fieldName);
                    if (!(BaseHelper.isDateCorrectlyFormattedForISO8601NoMS((String) responseVal, fieldName)))
                        return false;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

	@Override
	public boolean equals(Object responseObj) {
		Logger logger = Logger.getRootLogger();
		Boolean equalityCheckFlag = true;
		try {
			if (!(responseObj instanceof Asset) || responseObj == null)
				return false;

			Field[] fields = Asset.class.getDeclaredFields();
			for (Field field : fields) {
				Object requestVal = field.get(this);
				Object responseVal = field.get(responseObj);
				String fieldName = field.getName();

//                // This is separated out as a different method so not all tests will fail if the date format is not right
//                // Checking for the format of the Date Field.
//                if (field.getName().equals("createdDate")) {
//                    //logger.info("Checking validity of date format for "+fieldName);
//                    if (!(BaseHelper.isDateCorrectlyFormattedForISO8601NoMS((String) responseVal, fieldName)))
//                        return false;
//                    if (requestVal != null) {
//                        if (!(BaseHelper.isDateCorrectlyFormattedForISO8601NoMS((String) requestVal, fieldName)))
//                            return false;
//                    }
//                }

				if (requestVal != null) {
					if (!requestVal.equals(responseVal)) {
						logger.info("Checking value of field " + fieldName);
						equalityCheckFlag = false;
						logger.error("Class Name: " + this.getClass().getName() + " --> Match failed on property: " + fieldName + ", Request Value: " + requestVal + ", Response Value: " + responseVal);
						break;
					}
				}
			}
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
		}
		return equalityCheckFlag;
	}
}