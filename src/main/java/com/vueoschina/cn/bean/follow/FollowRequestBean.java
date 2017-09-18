package com.vueoschina.cn.bean.follow;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FollowRequestBean implements Serializable{

	private static final long serialVersionUID = 3989191706374781668L;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	/**
	 * 0-粉丝|1-关注的人
	 */
	private int relation;
	
	private int page;
	
	private int pageSize;
	
	private String dataType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getRelation() {
		return relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
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
		return "FollowRequestBean [accessToken=" + accessToken + ", relation=" + relation + ", page=" + page
				+ ", pageSize=" + pageSize + ", dataType=" + dataType + "]";
	}
}
