/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.common;

import org.apache.log4j.Logger;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.qio.qa.lib.apiHelpers.APIRequestHelper;

public class BaseTestUtil {
	protected String userName;
	protected String password;
	protected String environment;
	protected final String oauthMicroserviceName = "idm";
	protected String envRuntime;
	protected APIRequestHelper apiRequestHelper;
	protected Config userConfig;
	protected Config envConfig;
	protected Config microserviceConfig;
	protected Config envRuntimeConfig;
	
	final static Logger logger = Logger.getRootLogger();

	public void initSetup(String userType) {
		userConfig = ConfigFactory.load("user_creds.conf");
		envConfig = ConfigFactory.load("environments.conf");
		microserviceConfig = ConfigFactory.load("microservices.conf");
		envRuntimeConfig = ConfigFactory.load("environment_runtime.conf");

		userName = userConfig.getString("user." + userType + ".username");
		password = userConfig.getString("user." + userType + ".password");
		
		environment = envConfig.getString("env.name");
		envRuntime = envRuntimeConfig.getString("env.runtime");
		
		String oauthMicroservice = microserviceConfig.getString(oauthMicroserviceName + "." + envRuntime);
		apiRequestHelper = new APIRequestHelper(userName, password, oauthMicroservice);
	}

}
