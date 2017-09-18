package com.vueoschina.cn.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenRequestBean implements Serializable{
	
	private static final long serialVersionUID = 7023510781083997337L;
	
	@JsonProperty(value = "client_id")
	private String clientId;
	
	@JsonProperty(value = "client_secret")
	private String clientSecret;
	
	@JsonProperty(value = "grant_type")
	private String grantType;
	
	@JsonProperty(value = "redirect_uri")
	private String redirectUri;
	
	@JsonProperty(value = "code")
	private String code;

	
	@JsonProperty(value = "refresh_token")
	private String refreshToken;
	
	@JsonProperty(value = "dataType")
	private String dataType;
	
	@JsonProperty(value = "callback")
	private String callback;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	@Override
	public String toString() {
		return "TokenRequestBean [clientId=" + clientId + ", clientSecret=" + clientSecret + ", grantType=" + grantType
				+ ", redirectUri=" + redirectUri + ", code=" + code + ", refreshToken=" + refreshToken + ", dataType="
				+ dataType + ", callback=" + callback + "]";
	}
}
