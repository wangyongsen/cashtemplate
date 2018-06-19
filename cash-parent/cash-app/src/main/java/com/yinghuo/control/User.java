package com.yinghuo.control;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class User implements Serializable{
	@NotBlank(message="{username.not.empty}")
	private String username;
   @NotBlank(message="{psw.not.empty}")
	private String psw;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
   
	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
}
