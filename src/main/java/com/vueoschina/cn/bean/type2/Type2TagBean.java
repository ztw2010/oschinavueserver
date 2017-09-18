package com.vueoschina.cn.bean.type2;

import java.io.Serializable;

public class Type2TagBean implements Serializable{

	private static final long serialVersionUID = -2911654358496338032L;
	
	private String tagImgUrl;
	
	private String tagName;

	public String getTagImgUrl() {
		return tagImgUrl;
	}

	public void setTagImgUrl(String tagImgUrl) {
		this.tagImgUrl = tagImgUrl;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "Type2TagBean [tagImgUrl=" + tagImgUrl + ", tagName=" + tagName + "]";
	}
}
