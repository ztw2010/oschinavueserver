package com.vueoschina.cn.bean;

import java.io.Serializable;

public class NoticeResponseBean implements Serializable{

	private static final long serialVersionUID = -8294631097966433042L;
	
	private int replyCount;
	
	private int msgCount;
	
	private int fansCount;
	
	private int referCount;

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getMsgCount() {
		return msgCount;
	}

	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}

	public int getFansCount() {
		return fansCount;
	}

	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}

	public int getReferCount() {
		return referCount;
	}

	public void setReferCount(int referCount) {
		this.referCount = referCount;
	}

	@Override
	public String toString() {
		return "NoticeResponseBean [replyCount=" + replyCount + ", msgCount=" + msgCount + ", fansCount=" + fansCount
				+ ", referCount=" + referCount + "]";
	}
}
