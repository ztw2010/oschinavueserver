package com.vueoschina.cn.bean.mine;

import java.io.Serializable;

public class UserBlogBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String author;
	
	private Long id;
	
	private String title;
	
	private String body;
	
	private Long authorid;
	
	private String pubDate;
	
	private int type;
	
	private int commentCount;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Long authorid) {
		this.authorid = authorid;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "UserBlogBean [author=" + author + ", id=" + id + ", title=" + title + ", body=" + body + ", authorid="
				+ authorid + ", pubDate=" + pubDate + ", type=" + type + ", commentCount=" + commentCount + "]";
	}

}
