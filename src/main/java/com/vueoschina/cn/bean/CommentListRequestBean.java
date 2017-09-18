package com.vueoschina.cn.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentListRequestBean implements Serializable{
	
	private static final long serialVersionUID = -1766690829393409795L;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	
	private int id;
	
	private int pageIndex;
	
	private int pageSize;
	
	private String dataType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "CommentListRequestBean [accessToken=" + accessToken + ", id=" + id + ", pageIndex=" + pageIndex
				+ ", pageSize=" + pageSize + ", dataType=" + dataType + "]";
	}
}
