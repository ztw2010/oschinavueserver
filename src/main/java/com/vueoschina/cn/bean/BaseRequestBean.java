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
	 * 获取动态列表
	 */
	public static final String METHOD_ACTIVE_LIST="active_list";
	
	/**
	 * 获取私信列表
	 */
	public static final String METHOD_MESSAGE_LIST="message_list";
	
	/**
	 * 用户博客列表
	 */
	public static final String METHOD_USER_BLOG_LIST="user_blog_list";
	
	/**
	 * 获取软件分类列表(只有2级)
	 */
	public static final String METHOD_PROJECT_CATALOG_LIST ="project_catalog_list";
	
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
