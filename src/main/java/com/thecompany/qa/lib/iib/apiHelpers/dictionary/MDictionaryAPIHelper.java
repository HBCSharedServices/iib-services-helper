/**
 * © TheCompany QA 2019. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF TheCompany.
 */

package com.thecompany.qa.lib.iib.apiHelpers.dictionary;

import com.thecompany.qa.lib.apiHelpers.APIHeaderRequestHelper;
import com.thecompany.qa.lib.common.MBaseAPIHelper;
import com.thecompany.qa.lib.connection.ConnectionResponse;
import org.apache.log4j.Logger;

public class MDictionaryAPIHelper extends MBaseAPIHelper {
	private final String createDictionary = "/tenant/{tenantId}/tag";
	private final String getOrUpdateOrDeleteSingleDictionary = "/tenant/{tenantId}/tag/{tag}";
	private final String getOrDeleteTenantDictionary = "/tenant/{tenantId}/tag";
	private final String getAllDictionaries = "/dictionary";

    final static Logger logger = Logger.getRootLogger();
	
	public ConnectionResponse create(String microservice, String environment, String tenantId, String payload, APIHeaderRequestHelper apiHeaderRequestHelper){
        String createTenantEndpointN = createDictionary.replace("{tenantId}", tenantId);
		return super.create(microservice, environment, createTenantEndpointN, payload, apiHeaderRequestHelper);
	}
	
	public void delete(String microservice, String environment, String tenantId, String tag, APIHeaderRequestHelper apiHeaderRequestHelper) {
		super.delete(microservice, environment, replaceTagAndTenantIdInSingleDictionary(tenantId, tag), apiHeaderRequestHelper);
	}

	public void delete(String microservice, String environment, String tenantId, APIHeaderRequestHelper apiHeaderRequestHelper) {
		super.delete(microservice, environment, replaceTenantIdIdInSingleTenantDictionary(tenantId), apiHeaderRequestHelper);
	}

	public ConnectionResponse update(String microservice, String environment, String tenantId, String tag, String payload, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.update(microservice, environment, replaceTagAndTenantIdInSingleDictionary(tenantId, tag), payload, apiHeaderRequestHelper);
	}
	
	public ConnectionResponse retrieve(String microservice, String environment, String tenantId, String tag, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.retrieve(microservice, environment, replaceTagAndTenantIdInSingleDictionary(tenantId, tag), apiHeaderRequestHelper);
	}

	public ConnectionResponse retrieve(String microservice, String environment, String tenantId, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.retrieve(microservice, environment, replaceTenantIdIdInSingleTenantDictionary(tenantId), apiHeaderRequestHelper);
	}

	public ConnectionResponse retrieve(String microservice, String environment, APIHeaderRequestHelper apiHeaderRequestHelper) {
		return super.retrieve(microservice, environment, getAllDictionaries, apiHeaderRequestHelper);
	}

	private String replaceTagAndTenantIdInSingleDictionary(String tenantId, String tag) {
		return getOrUpdateOrDeleteSingleDictionary.replace("{tenantId}", tenantId).replace("{tag}", tag);
	}

	private String replaceTenantIdIdInSingleTenantDictionary(String tenantId) {
		return getOrDeleteTenantDictionary.replace("{tenantId}", tenantId);
	}
}