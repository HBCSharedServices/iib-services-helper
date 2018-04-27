/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package com.hbc.qa.lib.iib.model.asset.helper;

import com.hbc.qa.lib.iib.common.AssetTypeUtil;
import com.hbc.qa.lib.iib.model.asset.AssetRequest;
import com.hbc.qa.lib.iib.model.assetType.AssetType;
import com.hbc.qa.lib.iib.model.assetType.helper.ParameterDataType;
import com.hbc.qa.lib.iib.common.TenantUtil;
import com.hbc.qa.lib.iib.model.assetType.helper.AttributeDataType;
import com.hbc.qa.lib.iib.model.tenant.Tenant;
import static com.hbc.qa.lib.common.BaseHelper.getCurrentTimeStamp;

public class AssetRequestHelper {
	AssetRequest asset = null;
	AssetTypeUtil assetTypeUtil = null;
	TenantUtil tenantUtil = null;

	private void initDefaultAsset() {
		asset = new AssetRequest(getCurrentTimeStamp(), "", "");
	}

	public AssetRequest getAssetWithPredefinedAssetTypeAndTenant(String assetTypeId, String tenantId) {
		initDefaultAsset();
		asset.setAssetType(assetTypeId);
		asset.setTenant(tenantId);
		return asset;
	}

	public AssetRequest getAssetWithCreatingAssetTypeAndTenant(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType) {
		assetTypeUtil = new AssetTypeUtil();
		tenantUtil = new TenantUtil();

		AssetType assetType = assetTypeUtil.createAssetType(assetTypeFlavor, attributeDataType, parameterDataType);
		String assetTypeId = assetType.getAssetTypeId();

		Tenant tenant = tenantUtil.createTenant();
		String tenantId = tenant.getTenantId();

		return getAssetWithPredefinedAssetTypeAndTenant(assetTypeId, tenantId);
	}

	public AssetRequest getAssetWithPredefinedTenantAndWithCreatingAssetType(String assetTypeFlavor, AttributeDataType attributeDataType, ParameterDataType parameterDataType, String tenantId) {
		assetTypeUtil = new AssetTypeUtil();

		AssetType assetType = assetTypeUtil.createAssetType(assetTypeFlavor, attributeDataType, parameterDataType);
		String assetTypeId = assetType.getAssetTypeId();

		return getAssetWithPredefinedAssetTypeAndTenant(assetTypeId, tenantId);
	}

	public AssetRequest getAssetWithPredefinedAssetTypeAndWithCreatingTenant(String assetTypeId) {
		tenantUtil = new TenantUtil();

		Tenant tenant = tenantUtil.createTenant();
		String tenantId = tenant.getTenantId();

		return getAssetWithPredefinedAssetTypeAndTenant(assetTypeId, tenantId);
	}
}