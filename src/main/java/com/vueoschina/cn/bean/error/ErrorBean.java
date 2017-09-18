package com.vueoschina.cn.bean.error;

import java.io.Serializable;

public class ErrorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	
	private String errorMsg;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ErrorBean [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
	}
}
