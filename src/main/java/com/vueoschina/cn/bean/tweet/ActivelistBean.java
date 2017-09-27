package com.vueoschina.cn.bean.tweet;

import java.io.Serializable;

public class ActivelistBean implements Serializable {

	private static final long serialVersionUID = 1195270436870638054L;
	private long id;
	private String portrait;
	private String author;
	private long authorid;
	private int catalog;
	private int appClient;
	private long objectId;
	private int objectType;
	private int objectCatalog;
	private String objectTitle;
	private String objectName;
	private String objectBody;
	private String url;
	private String message;
	private String tweetImage;
	private int commentCount;
	private String pubDate;
	private ObjectReplyBean objectReply;

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


	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectBody() {
		return objectBody;
	}

	public void setObjectBody(String objectBody) {
		this.objectBody = objectBody;
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

	public ObjectReplyBean getObjectReply() {
		return objectReply;
	}

	public void setObjectReply(ObjectReplyBean objectReply) {
		this.objectReply = objectReply;
	}

	@Override
	public String toString() {
		return "ActivelistBean [id=" + id + ", portrait=" + portrait + ", author=" + author + ", authorid=" + authorid
				+ ", catalog=" + catalog + ", appClient=" + appClient + ", objectId=" + objectId + ", objectType="
				+ objectType + ", objectCatalog=" + objectCatalog + ", objectTitle=" + objectTitle + ", objectName="
				+ objectName + ", objectBody=" + objectBody + ", url=" + url + ", message=" + message + ", tweetImage="
				+ tweetImage + ", commentCount=" + commentCount + ", pubDate=" + pubDate + ", objectReply="
				+ objectReply + "]";
	}
}
