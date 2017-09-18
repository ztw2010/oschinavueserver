package com.vueoschina.cn.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsListRequestBean implements Serializable{

	private static final long serialVersionUID = 7856270790455487996L;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	
	private int catalog;
	
	private int page;
	
	private int pageSize;
	
	private String dataType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getCatalog() {
		return catalog;
	}

	public void setCatalog(int catalog) {
		this.catalog = catalog;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return "NewsListRequestBean [accessToken=" + accessToken + ", catalog=" + catalog + ", page=" + page
				+ ", pageSize=" + pageSize + ", dataType=" + dataType + "]";
	}
}
