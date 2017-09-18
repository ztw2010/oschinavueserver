package com.vueoschina.cn.bean;

import java.io.Serializable;
import java.util.List;

public class NewsDetailResponseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1445523804205161442L;
	
	private String author;
	
	private Long id;
	
	private Long authorid;
	
	private String title;
	
	private String body;
	
	private String pubDate;
	
	private int favorite;
	
	private int commentCount;
	
	private String url;
	
	private List<RelativeResponseBean> relativies;
	
	private NoticeResponseBean notice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public Long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Long authorid) {
		this.authorid = authorid;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<RelativeResponseBean> getRelativies() {
		return relativies;
	}

	public void setRelativies(List<RelativeResponseBean> relativies) {
		this.relativies = relativies;
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

	@Override
	public String toString() {
		return "NewsDetailResponseBean [author=" + author + ", id=" + id + ", authorid=" + authorid + ", title=" + title
				+ ", body=" + body + ", pubDate=" + pubDate + ", favorite=" + favorite + ", commentCount="
				+ commentCount + ", url=" + url + ", relativies=" + relativies + ", notice=" + notice + "]";
	}
}
