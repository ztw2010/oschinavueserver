package com.vueoschina.cn.bean;

import java.io.Serializable;

public class NoticeBean implements Serializable {

	private static final long serialVersionUID = 4172468188012840575L;

	private int replyCount;
	private int msgCount;
	private int fansCount;
	private int referCount;

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}

	public int getMsgCount() {
		return msgCount;
	}

	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}

	public int getFansCount() {
		return fansCount;
	}

	public void setReferCount(int referCount) {
		this.referCount = referCount;
	}

	public int getReferCount() {
		return referCount;
	}

	@Override
	public String toString() {
		return "NoticeBean [replyCount=" + replyCount + ", msgCount=" + msgCount + ", fansCount=" + fansCount
				+ ", referCount=" + referCount + "]";
	}
}
