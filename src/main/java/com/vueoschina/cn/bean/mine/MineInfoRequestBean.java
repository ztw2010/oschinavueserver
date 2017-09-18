package com.vueoschina.cn.bean.mine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MineInfoRequestBean implements Serializable {

	private static final long serialVersionUID = 2515263679004779326L;

	private String dataType;

	@JsonProperty(value = "access_token")
	private String accessToken;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		return "MineRequestBean [dataType=" + dataType + ", accessToken=" + accessToken + "]";
	}
}
