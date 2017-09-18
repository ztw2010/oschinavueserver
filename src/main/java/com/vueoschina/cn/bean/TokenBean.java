package com.vueoschina.cn.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenBean implements Serializable{

	private static final long serialVersionUID = -3757812938018317916L;
	
	@JsonProperty(value = "access_token")
	private String accessToken;
	
	@JsonProperty(value = "refresh_token")
	private String refreshToken;
	
	@JsonProperty(value = "token_type")
	private String tokenType;
	
	@JsonProperty(value = "expires_in")
	private int expiresIn;
	
	@JsonProperty(value = "uid")
	private String uId;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	@Override
	public String toString() {
		return "TokenBean [accessToken=" + accessToken + ", refreshToken=" + refreshToken + ", tokenType=" + tokenType
				+ ", expiresIn=" + expiresIn + ", uId=" + uId + "]";
	}
}
