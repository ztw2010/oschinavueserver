package com.vueoschina.cn.openapi;

import java.io.Serializable;

public class StorePicBean implements Serializable{
	
	private String highUrl = "https://www.ebestglobal.com/wp-content/uploads/2017/05/ebest_customer_profile_-e1499283848354.png";
	
	private String thumbnailUrl = "https://www.ebestglobal.com/wp-content/uploads/2017/05/ebest_customer_profile_-e1499283848354.png";

	public String getHighUrl() {
		return highUrl;
	}

	public void setHighUrl(String highUrl) {
		this.highUrl = highUrl;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

}
