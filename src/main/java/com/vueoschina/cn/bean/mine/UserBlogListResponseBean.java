package com.vueoschina.cn.bean.mine;

import java.io.Serializable;
import java.util.List;

public class UserBlogListResponseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<UserBlogBean> projectlist;
	
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<UserBlogBean> getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(List<UserBlogBean> projectlist) {
		this.projectlist = projectlist;
	}

	@Override
	public String toString() {
		return "UserBlogListResponseBean [projectlist=" + projectlist + ", count=" + count + "]";
	}
}
