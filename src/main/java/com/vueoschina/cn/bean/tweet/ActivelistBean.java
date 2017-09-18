package com.vueoschina.cn.bean.tweet;

import java.io.Serializable;

public class ActivelistBean implements Serializable {

	private static final long serialVersionUID = 1195270436870638054L;

	private String author;
	private int catalog;
	private String objectTitle;
	private String tweetImage;
	private int objectCatalog;
	private ObjectReplyBean objectReply;
	private String portrait;
	private long authorid;
	private String message;
	private String pubDate;
	private String url;
	private int objectType;
	private int appClient;
	private int commentCount;
	private long id;
	private long objectId;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCatalog() {
		return catalog;
	}

	public void setCatalog(int catalog) {
		this.catalog = catalog;
	}

	public String getObjectTitle() {
		return objectTitle;
	}

	public void setObjectTitle(String objectTitle) {
		this.objectTitle = objectTitle;
	}

	public String getTweetImage() {
		return tweetImage;
	}

	public void setTweetImage(String tweetImage) {
		this.tweetImage = tweetImage;
	}

	public int getObjectCatalog() {
		return objectCatalog;
	}

	public void setObjectCatalog(int objectCatalog) {
		this.objectCatalog = objectCatalog;
	}

	public ObjectReplyBean getObjectReply() {
		return objectReply;
	}

	public void setObjectReply(ObjectReplyBean objectReply) {
		this.objectReply = objectReply;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(long authorid) {
		this.authorid = authorid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getObjectType() {
		return objectType;
	}

	public void setObjectType(int objectType) {
		this.objectType = objectType;
	}

	public int getAppClient() {
		return appClient;
	}

	public void setAppClient(int appClient) {
		this.appClient = appClient;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	@Override
	public String toString() {
		return "ActivelistBean [author=" + author + ", catalog=" + catalog + ", objectTitle=" + objectTitle
				+ ", tweetImage=" + tweetImage + ", objectCatalog=" + objectCatalog + ", objectReply=" + objectReply
				+ ", portrait=" + portrait + ", authorid=" + authorid + ", message=" + message + ", pubDate=" + pubDate
				+ ", url=" + url + ", objectType=" + objectType + ", appClient=" + appClient + ", commentCount="
				+ commentCount + ", id=" + id + ", objectId=" + objectId + "]";
	}
}
