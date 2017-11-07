package com.vueoschina.cn.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SoftwareCategoryRequestBean implements Serializable{
	
	private static final long serialVersionUID = -1766690829393409795L;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	
	private int tag;
	
	private String dataType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return "SoftwareCategoryRequestBean [accessToken=" + accessToken + ", tag=" + tag + ", dataType=" + dataType
				+ "]";
	}
}
