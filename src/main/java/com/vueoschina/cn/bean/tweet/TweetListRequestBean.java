package com.vueoschina.cn.bean.tweet;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TweetListRequestBean implements Serializable{
	
	private static final long serialVersionUID = 8322471831477138518L;

	private int pageIndex;
	
	private int pageSize;
	
	private String dataType;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	
	/**
	 *  0：最新动弹
	 *  -1：热门动弹
	 *  其它：我的动弹
	 */
	private Long user;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
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

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "TweetListRequestBean [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", dataType=" + dataType
				+ ", accessToken=" + accessToken + ", user=" + user + "]";
	}
}
