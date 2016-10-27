/**
 * © Qio Technologies Ltd. 2016. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF QIO TECHNOLOGIES LTD.
 */
package io.qio.qa.lib.ehm.model.asset;


import io.qio.qa.lib.ehm.model.assetType.AssetType;

public class AssetResponse extends Asset {
	private AssetType assetType;

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}
	
	// TODO:
	/*
	 * If two objects do not match, then its simply going to print out their
	 * string representations in the logger message. I need to figure out a
	 * better way for this.
	 */
	@Override
	public boolean equals(Object responseObj) {
		Boolean equalityCheckFlag = false;
		AssetType assetTypeFromResponseObj = ((AssetResponse) responseObj).getAssetType();

		if (super.equals(responseObj) && this.assetType.equals(assetTypeFromResponseObj))
			equalityCheckFlag = true;

		return equalityCheckFlag;
	}
}