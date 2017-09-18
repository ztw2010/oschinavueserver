package com.vueoschina.cn.bean;

import java.io.Serializable;
import java.util.List;

public class NewsType3ResponseBean implements Serializable{

	private static final long serialVersionUID = -2846337199505358504L;
	
	private String imageUrl;
	
	private String title;
	
	private int commentCount;
	
	private String pubDate;
	
	/**
	 * 是否关注
	 * 1:关注
	 * 0:未关注
	 */
	private int isWatched;
	
	/**
	 * 是否原创
	 * 1:原创
	 * 0:非原创
	 */
	private int isOriginal;
	
	/**
	 * 是否推荐
	 * 1:推荐
	 * 0:非推荐
	 */
	private int isRecommend;
	
	/**
	 * 是否是官方人员
	 * 1:官方人员
	 * 0:非官方人员
	 */
	private int isOfficial;
	
	/**
	 * 是否收藏
	 */
	private int favorite;
	
	private String blogTitle;
	
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

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getIsWatched() {
		return isWatched;
	}

	public void setIsWatched(int isWatched) {
		this.isWatched = isWatched;
	}

	public int getIsOriginal() {
		return isOriginal;
	}

	public void setIsOriginal(int isOriginal) {
		this.isOriginal = isOriginal;
	}

	public int getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}

	public int getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(int isOfficial) {
		this.isOfficial = isOfficial;
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

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	@Override
	public String toString() {
		return "NewsType3ResponseBean [imageUrl=" + imageUrl + ", title=" + title + ", commentCount=" + commentCount
				+ ", pubDate=" + pubDate + ", isWatched=" + isWatched + ", isOriginal=" + isOriginal + ", isRecommend="
				+ isRecommend + ", isOfficial=" + isOfficial + ", favorite=" + favorite + ", blogTitle=" + blogTitle
				+ ", body=" + body + ", rerelativies=" + rerelativies + ", notice=" + notice + "]";
	}
}