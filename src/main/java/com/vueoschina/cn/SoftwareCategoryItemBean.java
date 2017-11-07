package com.vueoschina.cn;

import java.io.Serializable;

public class SoftwareCategoryItemBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private int tag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "SoftwareCategoryItemBean [name=" + name + ", tag=" + tag + "]";
	}
}
