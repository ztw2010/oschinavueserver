package com.vueoschina.cn.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PubCommentRequestBean implements Serializable{

	private static final long serialVersionUID = 1481374903239061661L;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	
	private String dataType;
	
	@JsonProperty(value = "blog")
	private long newsId;
	
	private String content;

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

	public long getNewsId() {
		return newsId;
	}

	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PubCommentRequestBean [accessToken=" + accessToken + ", dataType=" + dataType + ", newsId=" + newsId
				+ ", content=" + content + "]";
	}
}
