package com.vueoschina.cn.bean.mine;

import java.io.Serializable;
import java.util.List;

import com.vueoschina.cn.bean.NoticeBean;


public class MineInfoResponseBean implements Serializable {

	private static final long serialVersionUID = -2336199872072952035L;

	private int gender;
	private String joinTime;
	private String city;
	private int fansCount;
	private String portrait;
	private List<String> expertise;
	private List<String> platforms;
	private int uid;
	private String lastLoginTime;
	private String province;
	private String name;
	private int followersCount;
	private int favoriteCount;
	private NoticeBean notice;
	private int tweetCount;
	
	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getGender() {
		return gender;
	}


	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}


	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setExpertise(List<String> expertise) {
		this.expertise = expertise;
	}

	public List<String> getExpertise() {
		return expertise;
	}

	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}

	public List<String> getPlatforms() {
		return platforms;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUid() {
		return uid;
	}


	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	public int getFansCount() {
		return fansCount;
	}

	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public NoticeBean getNotice() {
		return notice;
	}

	public void setNotice(NoticeBean notice) {
		this.notice = notice;
	}

	public int getTweetCount() {
		return tweetCount;
	}

	public void setTweetCount(int tweetCount) {
		this.tweetCount = tweetCount;
	}

	@Override
	public String toString() {
		return "MineInfoResponseBean [gender=" + gender + ", joinTime=" + joinTime + ", city=" + city + ", fansCount="
				+ fansCount + ", portrait=" + portrait + ", expertise=" + expertise + ", platforms=" + platforms
				+ ", uid=" + uid + ", lastLoginTime=" + lastLoginTime + ", province=" + province + ", name=" + name
				+ ", followersCount=" + followersCount + ", favoriteCount=" + favoriteCount + ", notice=" + notice
				+ ", tweetCount=" + tweetCount + "]";
	}
}
