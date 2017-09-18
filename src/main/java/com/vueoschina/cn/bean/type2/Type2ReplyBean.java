package com.vueoschina.cn.bean.type2;

import java.io.Serializable;

public class Type2ReplyBean implements Serializable{

	private static final long serialVersionUID = 2145436806737010827L;
	
	private String imageUrl;
	
	private String title;
	
	private String pubDate;
	
	private String body;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Type2ReplyBean [imageUrl=" + imageUrl + ", title=" + title + ", pubDate=" + pubDate + ", body=" + body
				+ "]";
	}
}
