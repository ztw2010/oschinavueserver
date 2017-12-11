package com.vueoschina.cn.bean.mock;

import java.io.Serializable;

public class MineCustomBean implements Serializable{
	
	private String customName;
	
	private String contactsPhoneNum;
	
	private double longitude;
	
	private double latitude;
	
	private String customAddress;
	
	private String picUrl = "https://www.ebestglobal.com/wp-content/uploads/2017/05/ebest_mobile_home-e1502217272264.png";

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getContactsPhoneNum() {
		return contactsPhoneNum;
	}

	public void setContactsPhoneNum(String contactsPhoneNum) {
		this.contactsPhoneNum = contactsPhoneNum;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getCustomAddress() {
		return customAddress;
	}

	public void setCustomAddress(String customAddress) {
		this.customAddress = customAddress;
	}

}
