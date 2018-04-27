/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package com.hbc.qa.lib.iib.common;

import org.apache.log4j.Logger;

public class APITestUtil {

	public static String SPECIAL_CHARS = "~^%{&@}$#*()+=!~";
	public static String TWOFIFTYSIX_CHARS = "256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256charactelong256characteRlong";
	public static String TWOFIFTYFIVE_CHARS = "255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong255charactelong";
	public static String FIFTYONE_CHARS = "51charlong51charlong51charlong51charlong51charSlong";
	public static String FIFTY_CHARS = "50charlong50charlong50charlong50charlong50charlong";
//	public static int responseCodeForInputRequest;
//	private static MOauthAPIHelper oauthAPIHelper = null;

	final static Logger logger = Logger.getRootLogger();

	/*
	 * Although this method is called before making any of the get, delete, put and post requests, but the oauth tokens are fetched only once, based on the logic abstracted inside the Connection
	 * Manager class.
	 */
//	private static void initOauthAuthentication(String environment, APIRequestHelper apiRequestHelper) {
//		oauthAPIHelper = oauthAPIHelper == null ? new MOauthAPIHelper() : oauthAPIHelper;
//		oauthAPIHelper.authenticateUsingOauth(apiRequestHelper.getOauthMicroservice(), environment, apiRequestHelper);
//	}

}
