package com.vueoschina.cn.bean.type2;

import java.io.Serializable;
import java.util.List;

import com.vueoschina.cn.bean.NoticeResponseBean;
import com.vueoschina.cn.bean.RelativeResponseBean;


public class NewsType2ResponseBean implements Serializable{

	private static final long serialVersionUID = 3942524281175068077L;
	
	private String title;
	
	private List<Type2TagBean> tagBeans;
	
	private int commentCount;
	
	private String pubDate;
	
	/**
	 * 是否收藏
	 */
	private int favorite;
	
	private String body;
	
	private List<RelativeResponseBean> rerelativies;
	
	private NoticeResponseBean notice;
	
	private String author;
	
	/**
	 * 回答列表
	 */
	private List<Type2ReplyBean> replyBeans;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Type2TagBean> getTagBeans() {
		return tagBeans;
	}

	public void setTagBeans(List<Type2TagBean> tagBeans) {
		this.tagBeans = tagBeans;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<RelativeResponseBean> getRerelativies() {
		return rerelativies;
	}

	public void setRerelativies(List<RelativeResponseBean> rerelativies) {
		this.rerelativies = rerelativies;
	}

	public NoticeResponseBean getNotice() {
		return notice;
	}

	public void setNotice(NoticeResponseBean notice) {
		this.notice = notice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Type2ReplyBean> getReplyBeans() {
		return replyBeans;
	}

	public void setReplyBeans(List<Type2ReplyBean> replyBeans) {
		this.replyBeans = replyBeans;
	}

	@Override
	public String toString() {
		return "NewsType2ResponseBean [title=" + title + ", tagBeans=" + tagBeans + ", commentCount=" + commentCount
				+ ", pubDate=" + pubDate + ", favorite=" + favorite + ", body=" + body + ", rerelativies="
				+ rerelativies + ", notice=" + notice + ", author=" + author + ", replyBeans=" + replyBeans + "]";
	}
}
