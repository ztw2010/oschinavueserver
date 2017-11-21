package com.vueoschina.cn.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectListRequestBean implements Serializable{
	
	private static final long serialVersionUID = -1766690829393409795L;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	
	private String type;
	
	private String dataType;
	
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return "ProjectListRequestBean [accessToken=" + accessToken + ", type=" + type + ", dataType=" + dataType
				+ ", page=" + page + "]";
	}
}
