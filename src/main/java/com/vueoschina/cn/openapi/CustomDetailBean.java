package com.vueoschina.cn.openapi;

import java.io.Serializable;
import java.util.List;

public class CustomDetailBean implements Serializable{
	
	private String picUrl = "https://www.ebestglobal.com/wp-content/uploads/2017/05/ebest_mobile_home-e1502217272264.png";
	
	private String customName;
	
	private String customId;
	
	private String contactsName;
	
	private String contactsPhoneNum;
	
	private String distribuite;
	
	private String detailAddress;
	
	private String preVisitTime;
	
	private String countsVisit30;
	
	private List<StorePicBean> storePics;

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

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsPhoneNum() {
		return contactsPhoneNum;
	}

	public void setContactsPhoneNum(String contactsPhoneNum) {
		this.contactsPhoneNum = contactsPhoneNum;
	}

	public String getDistribuite() {
		return distribuite;
	}

	public void setDistribuite(String distribuite) {
		this.distribuite = distribuite;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getPreVisitTime() {
		return preVisitTime;
	}

	public void setPreVisitTime(String preVisitTime) {
		this.preVisitTime = preVisitTime;
	}

	public String getCountsVisit30() {
		return countsVisit30;
	}

	public void setCountsVisit30(String countsVisit30) {
		this.countsVisit30 = countsVisit30;
	}

	public List<StorePicBean> getStorePics() {
		return storePics;
	}

	public void setStorePics(List<StorePicBean> storePics) {
		this.storePics = storePics;
	}

	@Override
	public String toString() {
		return "CustomDetailBean [picUrl=" + picUrl + ", customName=" + customName + ", customId=" + customId
				+ ", contactsName=" + contactsName + ", contactsPhoneNum=" + contactsPhoneNum + ", distribuite="
				+ distribuite + ", detailAddress=" + detailAddress + ", preVisitTime=" + preVisitTime
				+ ", countsVisit30=" + countsVisit30 + ", storePics=" + storePics + "]";
	}
}
