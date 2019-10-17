/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */

package com.thecompany.qa.lib.iib.apiHelpers.dictionary;

import com.thecompany.qa.lib.apiHelpers.APIRequestHelper;
import com.thecompany.qa.lib.common.MBaseAPIHelper;
import com.thecompany.qa.lib.connection.ConnectionResponse;
import org.apache.log4j.Logger;

public class MDictionaryAPIHelper extends MBaseAPIHelper {
	private final String createDictionary = "/tenant/{tenantId}/tag";
	private final String getOrUpdateOrDeleteSingleDictionary = "/tenant/{tenantId}/tag/{tag}";
	private final String getOrDeleteTenantDictionary = "/tenant/{tenantId}/tag";
	private final String getAllDictionaries = "/dictionary";

    final static Logger logger = Logger.getRootLogger();
	
	public ConnectionResponse create(String microservice, String environment, String tenantId, String payload, APIRequestHelper apiRequestHeaders){
        String createTenantEndpointN = createDictionary.replace("{tenantId}", tenantId);
		return super.create(microservice, environment, createTenantEndpointN, payload, apiRequestHeaders);
	}
	
	public void delete(String microservice, String environment, String tenantId, String tag, APIRequestHelper apiRequestHeaders) {
		super.delete(microservice, environment, replaceTagAndTenantIdInSingleDictionary(tenantId, tag), apiRequestHeaders);
	}

	public void delete(String microservice, String environment, String tenantId, APIRequestHelper apiRequestHeaders) {
		super.delete(microservice, environment, replaceTenantIdIdInSingleTenantDictionary(tenantId), apiRequestHeaders);
	}

	public ConnectionResponse update(String microservice, String environment, String tenantId, String tag, String payload, APIRequestHelper apiRequestHeaders) {
		return super.update(microservice, environment, replaceTagAndTenantIdInSingleDictionary(tenantId, tag), payload, apiRequestHeaders);
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, String tenantId, String tag, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, replaceTagAndTenantIdInSingleDictionary(tenantId, tag), apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, String tenantId, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, replaceTenantIdIdInSingleTenantDictionary(tenantId), apiRequestHeaders);
	}

	public ConnectionResponse retrieve(String microservice, String environment, APIRequestHelper apiRequestHeaders) {
		return super.retrieve(microservice, environment, getAllDictionaries, apiRequestHeaders);
	}

	private String replaceTagAndTenantIdInSingleDictionary(String tenantId, String tag) {
		return getOrUpdateOrDeleteSingleDictionary.replace("{tenantId}", tenantId).replace("{tag}", tag);
	}

	private String replaceTenantIdIdInSingleTenantDictionary(String tenantId) {
		return getOrDeleteTenantDictionary.replace("{tenantId}", tenantId);
	}
}