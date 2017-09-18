package com.vueoschina.cn.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsDetailRequestBean implements Serializable{
	
	public static final int TYPE_0 = 0;
	
	public static final int TYPE_1 = 1;
	
	public static final int TYPE_2 = 2;
	
	public static final int TYPE_3 = 3;
	
	public static final int TYPE_4 = 4;
	
	public static final int TYPE_7 = 7;
	
	private static final long serialVersionUID = 3827132884441961740L;
	
	private long id;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	
	private String dataType;
	
	@JsonProperty(value = "newsType")
	private int newsType;
	
	private String newsUrl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getNewsType() {
		return newsType;
	}

	public void setNewsType(int newsType) {
		this.newsType = newsType;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	@Override
	public String toString() {
		return "NewsDetailRequestBean [id=" + id + ", accessToken=" + accessToken + ", dataType=" + dataType
				+ ", newsType=" + newsType + ", newsUrl=" + newsUrl + "]";
	}
}
