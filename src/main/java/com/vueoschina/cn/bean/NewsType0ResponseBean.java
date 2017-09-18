package com.vueoschina.cn.bean;

import java.io.Serializable;
import java.util.List;

public class NewsType0ResponseBean implements Serializable{

	private static final long serialVersionUID = -2846337199505358504L;
	
	private String imageUrl;
	
	private String title;
	
	private int commentCount;
	
	private int favorite;
	
	private int favoriteCount;
	
	private String body;
	
	private List<RelativeResponseBean> rerelativies;
	
	private NoticeResponseBean notice;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

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

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
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

	@Override
	public String toString() {
		return "NewsType0ResponseBean [imageUrl=" + imageUrl + ", title=" + title + ", commentCount=" + commentCount
				+ ", favorite=" + favorite + ", favoriteCount=" + favoriteCount + ", body=" + body + ", rerelativies="
				+ rerelativies + ", notice=" + notice + "]";
	}
}
