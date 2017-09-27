package com.vueoschina.cn.bean.mine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserBlogListRequestBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int page;

	private int pageSize;

	private String dataType;

	@JsonProperty(value = "access_token")
	private String accessToken;
	
	@JsonProperty(value = "authoruid")
	private String authoruId;

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

	public String getAuthoruId() {
		return authoruId;
	}

	public void setAuthoruId(String authoruId) {
		this.authoruId = authoruId;
	}

	@Override
	public String toString() {
		return "UserBlogListRequestBean [page=" + page + ", pageSize=" + pageSize + ", dataType=" + dataType
				+ ", accessToken=" + accessToken + ", authoruId=" + authoruId + "]";
	}
}
