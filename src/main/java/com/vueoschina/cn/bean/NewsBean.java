package com.vueoschina.cn.bean;

import java.io.Serializable;

public class NewsBean implements Serializable {

	private static final long serialVersionUID = 9117641401642065055L;
	
	private long id;
	
	private String author;
	
	private String pubDate;
	
	private String title;
	
	private long authorid;
	
	private int commentCount;
	
	private long type;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthorid(long authorid) {
		this.authorid = authorid;
	}

	public long getAuthorid() {
		return authorid;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setType(long type) {
		this.type = type;
	}

	public long getType() {
		return type;
	}

	@Override
	public String toString() {
		return "NewsBean [id=" + id + ", author=" + author + ", pubDate=" + pubDate + ", title=" + title + ", authorid="
				+ authorid + ", commentCount=" + commentCount + ", type=" + type + "]";
	}
}
