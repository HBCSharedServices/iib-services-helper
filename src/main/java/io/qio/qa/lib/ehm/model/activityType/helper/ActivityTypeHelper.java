/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.activityType.helper;

import io.qio.qa.lib.ehm.model.activityType.ActivityType;
import static io.qio.qa.lib.common.BaseHelper.getCurrentTimeStamp;

public class ActivityTypeHelper {
	ActivityType activityType = null;

	/*
	 * This method is invoked from each of the following methods to make sure every time a new ActivityType is created with a unique timestamp.
	 */
	private void initDefaultActivityType() {
		activityType = new ActivityType(getCurrentTimeStamp());
	}

	public ActivityType getActivityType() {
		initDefaultActivityType();
		return activityType;
	}

}