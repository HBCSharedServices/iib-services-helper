/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package com.hbc.qa.lib.iib.model.activityType.helper;

import com.hbc.qa.lib.iib.model.activityType.ActivityType;

import static com.hbc.qa.lib.common.BaseHelper.getCurrentTimeStamp;

public class ActivityTypeHelper {
	ActivityType activityType = null;

	/*
	 * This method is invoked from each of the following methods to make sure every time a new TaxServiceResponse is created with a unique timestamp.
	 */
	private void initDefaultActivityType() {
		activityType = new ActivityType(getCurrentTimeStamp());
	}

	public ActivityType getActivityType() {
		initDefaultActivityType();
		return activityType;
	}

}