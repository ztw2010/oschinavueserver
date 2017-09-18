package com.vueoschina.cn.bean.tweet;

import java.io.Serializable;
import java.util.List;

import com.vueoschina.cn.bean.NoticeBean;


public class MineTweetResponseBean implements Serializable {

	private static final long serialVersionUID = 5711548869546557956L;

	private List<ActivelistBean> activelist;
	
	private NoticeBean notice;

	public List<ActivelistBean> getActivelist() {
		return activelist;
	}

	public void setActivelist(List<ActivelistBean> activelist) {
		this.activelist = activelist;
	}

	public NoticeBean getNotice() {
		return notice;
	}

	public void setNotice(NoticeBean notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "MineTweetResponseBean [activelist=" + activelist + ", notice=" + notice + "]";
	}
}
