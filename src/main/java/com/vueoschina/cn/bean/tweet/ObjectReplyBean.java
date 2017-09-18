package com.vueoschina.cn.bean.tweet;

import java.io.Serializable;

public class ObjectReplyBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String objectName;
	
	private String objectBody;

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectBody() {
		return objectBody;
	}

	public void setObjectBody(String objectBody) {
		this.objectBody = objectBody;
	}

	@Override
	public String toString() {
		return "ObjectReplyBean [objectName=" + objectName + ", objectBody=" + objectBody + "]";
	}
}
