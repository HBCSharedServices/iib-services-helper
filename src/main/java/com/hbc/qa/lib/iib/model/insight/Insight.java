/**
 * © HBC Shared Services QA 2018. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF HBC.
 */
package com.hbc.qa.lib.iib.model.insight;

import com.hbc.qa.lib.common.Links;
import com.hbc.qa.lib.common.BaseHelper;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonProperty;
import java.lang.reflect.Field;

public abstract class Insight {
	protected String title;
	protected String description;
	protected String status;
	protected String severity;
	protected String tenantId;
	protected String insightTypeId;
	
	protected String createdDate;
	protected String lastModifiedDate;
	protected String eventDate;
	protected String referenceId;
	protected String insightId;
	
	@JsonProperty("_links")
	protected Links _links;

	public Insight() {
	}

	@SuppressWarnings("serial")
	public Insight(String timeStamp, String tenantId, String insightTypeId) {
		this.title = "I" + timeStamp + "Title";
		this.description = "I" + timeStamp + "Desc";
		this.tenantId = tenantId;
		this.insightTypeId = insightTypeId;
		this.severity = InsightSeverity.INFORMATIONAL.toString();
		this.eventDate = null;
	}

	public Insight(String title, String description, String tenantId, String insightTypeId) {
		this.title = title;
		this.description = description;
		this.tenantId = tenantId;
		this.insightTypeId = insightTypeId;
		this.severity = InsightSeverity.INFORMATIONAL.toString();
		this.eventDate = null;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getInsightTypeId() {
		return insightTypeId;
	}

	public void setInsightTypeId(String insightTypeId) {
		this.insightTypeId = insightTypeId;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public String getInsightId() {
		return insightId;
	}

	public Boolean validateDateFormats() {
		Logger logger = Logger.getRootLogger();
		Field[] fields = Insight.class.getDeclaredFields();
		for (Field field : fields) {
			Object responseVal = null;
			try {
				responseVal = field.get(this);
				String fieldName = field.getName();

				// Checking for the format of the Date Field.
				if (fieldName.equals("createdDate") || fieldName.equals("eventDate") || fieldName.equals("lastModifiedDate")) {
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
			if (!(responseObj instanceof Insight) || responseObj == null)
				return false;

			Field[] fields = Insight.class.getDeclaredFields();
			for (Field field : fields) {
				Object requestVal = field.get(this);
				Object responseVal = field.get(responseObj);
				String fieldName = field.getName();

				// This is separated out as a different method so not all tests will fail if the date format is not right
//				// Checking for the format of the Date Field.
//				if (fieldName.equals("createdDate") || fieldName.equals("eventDate") || fieldName.equals("lastModifiedDate")) {
//					logger.info("Checking validity of date format for "+fieldName);
//					if (!(BaseHelper.isDateCorrectlyFormattedForISO8601NoMS((String) responseVal, fieldName)))
//						return false;
//					if (requestVal != null) {
//						if (!(BaseHelper.isDateCorrectlyFormattedForISO8601NoMS((String) requestVal, fieldName)))
//							return false;
//					}
//				}

				if (requestVal != null && fieldName != "insightTypeId") {
					logger.info("Checking value of field " + fieldName);
					if (!requestVal.equals(responseVal)) {
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

