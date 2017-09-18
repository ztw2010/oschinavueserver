package com.vueoschina.cn.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseRequestBean<T> implements Serializable{

	private static final long serialVersionUID = 961957314470817871L;
	
	/**
	 * 获取accessToken
	 */
	public static final String METHOD_GETTOKEN="getToken";
	
	/**
	 * 获取综合/所有新闻
	 */
	public static final String METHOD_GETGETMULTIPLE="getMultiple";
	
	/**
	 * 获取新闻详情
	 */
	public static final String METHOD_NEWSDETAIL="getNewsDetail";
	
	/**
	 * 发布评论
	 */
	public static final String METHOD_PUBCOMMENT="pubComment";
	
	/**
	 * 获取评论列表
	 */
	public static final String METHOD_GETCOMMENTLIST="getCommentList";
	
	/**
	 * 获取动弹列表
	 */
	public static final String METHOD_GETTWEETLIST="getTweetList";
	
	/**
	 * 获取个人信息
	 */
	public static final String METHOD_GETMINEINFO="getMineInfo";
	
	/**
	 * 获取收藏列表
	 */
	public static final String METHOD_FAVORITE_LIST="getFavoriteList";
	
	/**
	 * 获取关注列表
	 */
	public static final String METHOD_FOLLOW_LIST="getFollowList";
	
	/**
	 * 获取我的动弹列表
	 */
	public static final String METHOD_GET_MINE_TWEET_LIST="getMineTweetList";
	
	@JsonProperty(value = "methodName")
	private String methodName;
	
	@JsonProperty(value = "paramsObj")
	private T t;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "BaseRequestBean [methodName=" + methodName + ", t=" + t + "]";
	}
}
