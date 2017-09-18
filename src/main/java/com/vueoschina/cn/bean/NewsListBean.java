package com.vueoschina.cn.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsListBean implements Serializable{

	private static final long serialVersionUID = 6573031535739120451L;
	
	@JsonProperty(value = "newslist")
	private List<NewsBean> newsList;
	
	@JsonProperty(value = "notice")
	private NoticeBean noticeBean;

	public List<NewsBean> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsBean> newsList) {
		this.newsList = newsList;
	}

	public NoticeBean getNoticeBean() {
		return noticeBean;
	}

	public void setNoticeBean(NoticeBean noticeBean) {
		this.noticeBean = noticeBean;
	}

	@Override
	public String toString() {
		return "NewsListBean [newsList=" + newsList + ", noticeBean=" + noticeBean + "]";
	}
}
