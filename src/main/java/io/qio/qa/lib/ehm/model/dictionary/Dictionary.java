/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.dictionary;

import io.qio.qa.lib.common.Links;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonProperty;
import java.lang.reflect.Field;

public class Dictionary {
	private String tenant;
	private String asset;
	private String tag;
	private String parameter;
	private String type;
	private String timezone;
	private String sourceUint;
	private String destinationUnit;
	private String conversionFormula;

	// returned in the response of a POST request
	@JsonProperty("_links")
	private Links _links;

	public Dictionary() {
	}

	@SuppressWarnings("serial")
	public Dictionary(String timeStamp) {
		this.tag = timeStamp;
		this.destinationUnit = "DDU" + timeStamp;
		this.sourceUint = "DSU" + timeStamp;
		this.type = "String";
		this.timezone = "UTC";
		this.conversionFormula = "val";
	}

	public Dictionary(String tenant, String asset, String tag, String parameter, String type, String timezone, String sourceUint, String destinationUnit, String conversionFormula) {
		this.tenant = tenant;
		this.asset = asset;
		this.tag = tag;
		this.parameter = parameter;
		this.type = type;
		this.timezone = timezone;
		this.sourceUint = sourceUint;
		this.destinationUnit = destinationUnit;
		this.conversionFormula = conversionFormula;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getSourceUint() {
		return sourceUint;
	}

	public void setSourceUint(String sourceUint) {
		this.sourceUint = sourceUint;
	}

	public String getDestinationUnit() {
		return destinationUnit;
	}

	public void setDestinationUnit(String destinationUnit) {
		this.destinationUnit = destinationUnit;
	}

	public String getConversionFormula() {
		return conversionFormula;
	}

	public void setConversionFormula(String conversionFormula) {
		this.conversionFormula = conversionFormula;
	}

	public Links get_links() {
		return _links;
	}

	public void set_links(Links _links) {
		this._links = _links;
	}

	public String toCassandraInsert() {
		//CREATE an Cassandra INSERT statement
		final Logger logger = Logger.getRootLogger();

		String insertSpaceAndTable = "INSERT INTO " + "ingestion_output.dictionary ";
		String fieldList = "(tenant_id, asset_id, parameter_id, tag, source_unit, destination_unit, parameter_type, source_timezone, conversion_formula) VALUES ('";
		String fieldValues = this.tenant + "', '" + this.asset + "', '" + this.parameter + "', '" + this.tag + "', '" + this.sourceUint + "', '" + this.destinationUnit + "', '" + this.type + "', '" + this.timezone + "', '" + this.conversionFormula+"')";

		return insertSpaceAndTable + fieldList + fieldValues;
	}

	public String toCassandraDelete() {
		//CREATE an Cassandra DELETE statement
		final Logger logger = Logger.getRootLogger();

		String deleteCommand = "DELETE FROM " + "ingestion_output.dictionary WHERE tenant_id='" + this.tenant + "' AND asset_id='" + this.asset + "' AND tag='" + tag +"'";
		return deleteCommand;
	}

	@Override
	public boolean equals(Object responseObj) {
		Logger logger = Logger.getRootLogger();
		Boolean equalityCheckFlag = true;
		try {

			if (!(responseObj instanceof Dictionary) || responseObj == null)
				return false;

			Field[] fields = Dictionary.class.getDeclaredFields();
			for (Field field : fields) {
				Object requestVal = field.get(this);
				Object responseVal = field.get(responseObj);
				if (requestVal != null && !field.getName().equals("conversionFormula"))
					if (!requestVal.equals(responseVal)) {
						equalityCheckFlag = false;
						logger.error("Class Name: " + this.getClass().getName() + " --> Match failed on property: "
								+ field.getName() + ", Request Value: " + requestVal + ", Response Value: "
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
}
