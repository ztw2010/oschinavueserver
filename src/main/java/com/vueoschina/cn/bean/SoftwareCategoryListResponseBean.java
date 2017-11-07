package com.vueoschina.cn.bean;

import java.io.Serializable;
import java.util.List;

import com.vueoschina.cn.SoftwareCategoryItemBean;

public class SoftwareCategoryListResponseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<SoftwareCategoryItemBean> softwareTypes;
	
	private NoticeResponseBean noticeResponseBean;

	public List<SoftwareCategoryItemBean> getSoftwareTypes() {
		return softwareTypes;
	}

	public void setSoftwareTypes(List<SoftwareCategoryItemBean> softwareTypes) {
		this.softwareTypes = softwareTypes;
	}

	public NoticeResponseBean getNoticeResponseBean() {
		return noticeResponseBean;
	}

	public void setNoticeResponseBean(NoticeResponseBean noticeResponseBean) {
		this.noticeResponseBean = noticeResponseBean;
	}

	@Override
	public String toString() {
		return "SoftwareCategoryListResponseBean [softwareTypes=" + softwareTypes + ", noticeResponseBean="
				+ noticeResponseBean + "]";
	}
}
