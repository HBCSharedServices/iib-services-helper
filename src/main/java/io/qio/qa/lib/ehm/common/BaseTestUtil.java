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

	protected String mongoDbServer;
	protected String mongoDbServerPort;
	protected String mongoDb;
	protected String mongoUsername;
	protected String mongoPassword;

	protected Config mongoDbConfig;
	
	final static Logger logger = Logger.getRootLogger();

	public void initSetup(String userType) {
		userConfig = ConfigFactory.load("user_creds.conf");
		envConfig = ConfigFactory.load("environments.conf");
		microserviceConfig = ConfigFactory.load("microservices.conf");
		envRuntimeConfig = ConfigFactory.load("environment_runtime.conf");

		userName = userConfig.getString("user." + userType + ".username");
		password = userConfig.getString("user." + userType + ".password");

		envRuntime = envRuntimeConfig.getString("env.runtime");
		environment = envConfig.getString("env.name" + "." + envRuntime);
		
		String oauthMicroservice = microserviceConfig.getString(oauthMicroserviceName + "." + envRuntime);
		apiRequestHelper = new APIRequestHelper(userName, password, oauthMicroservice);
	}

	public void baseInitLoadConfigurationFiles() {
		userConfig = ConfigFactory.load("user_creds.conf");
		envConfig = ConfigFactory.load("environments.conf");
		envRuntimeConfig = ConfigFactory.load("environment_runtime.conf");
		microserviceConfig = ConfigFactory.load("microservices.conf");
		mongoDbConfig = ConfigFactory.load("mongodbs.conf");

		envRuntime = envRuntimeConfig.getString("env.runtime");
	}

	public void baseInitMongoSetupBeforeAllTests(String mongoName) {
		logger.info("sdsdfsdfds"+ mongoName);
		mongoUsername = mongoDbConfig.getString(mongoName+".db.user."+envRuntime);
		logger.info("xxxx");
		mongoPassword = mongoDbConfig.getString(mongoName+".db.password."+envRuntime);
		mongoDbServer = mongoDbConfig.getString(mongoName+".db.server."+envRuntime);
		mongoDbServerPort = mongoDbConfig.getString(mongoName+".db.serverPort."+envRuntime);
		logger.info("sdsdfsdfds");
		mongoDb = mongoDbConfig.getString(mongoName+".db."+envRuntime);
	}
}
