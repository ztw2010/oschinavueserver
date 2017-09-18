package com.vueoschina.cn.bean.favorite;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FavoriteRequestBean implements Serializable{

	private static final long serialVersionUID = 933220173526580781L;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	/**
	 * 0-全部|1-软件|2-话题|3-博客|4-新闻|5代码|7-翻译
	 */
	private int type;
	
	private int page;
	
	private int pageSize;
	
	private String dataType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
		return "FavoriteRequestBean [accessToken=" + accessToken + ", type=" + type + ", page=" + page + ", pageSize="
				+ pageSize + ", dataType=" + dataType + "]";
	}

}
