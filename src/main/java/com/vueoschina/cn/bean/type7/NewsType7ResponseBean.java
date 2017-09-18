package com.vueoschina.cn.bean.type7;

import java.io.Serializable;

import com.vueoschina.cn.bean.NoticeResponseBean;


public class NewsType7ResponseBean implements Serializable{
	
	private static final long serialVersionUID = -2974317878714596291L;
	
	private String title;
	
	private int commentCount;
	
	private String pubDate;
	
	private String author;
	
	private String body;
	
	private NoticeResponseBean notice;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public NoticeResponseBean getNotice() {
		return notice;
	}

	public void setNotice(NoticeResponseBean notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "NewsType7ResponseBean [title=" + title + ", commentCount=" + commentCount + ", pubDate=" + pubDate
				+ ", author=" + author + ", body=" + body + ", notice=" + notice + "]";
	}
}
