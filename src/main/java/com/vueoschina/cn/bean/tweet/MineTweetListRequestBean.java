package com.vueoschina.cn.bean.tweet;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MineTweetListRequestBean implements Serializable{
	
	private static final long serialVersionUID = 8322471831477138518L;

	private int page;
	
	private int pageSize;
	
	private String dataType;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	
	private int user;
	
	private int catalog;

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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getCatalog() {
		return catalog;
	}

	public void setCatalog(int catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		return "MineTweetListRequestBean [page=" + page + ", pageSize=" + pageSize + ", dataType=" + dataType
				+ ", accessToken=" + accessToken + ", user=" + user + ", catalog=" + catalog + "]";
	}
}
