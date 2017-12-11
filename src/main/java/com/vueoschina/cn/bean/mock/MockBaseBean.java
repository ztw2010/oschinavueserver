package com.vueoschina.cn.bean.mock;

import java.io.Serializable;

public class MockBaseBean<T> implements Serializable{
	
	private int ret;
	
	private String msg;
	
	private T data;

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MockBaseBean [ret=" + ret + ", msg=" + msg + ", data=" + data + "]";
	}

}
