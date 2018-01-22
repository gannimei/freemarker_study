package com.netease.study;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

public class UserEditModel {

	@NotEmpty(message = "不能为空")
	@Size(min = 6, max = 15, message = "请输入长度在 {0} 到 {1} 之间的字符串")
	private String userName;
	@NotEmpty(message = "不能为空")
	@Min(value = 6, message = "最少要输入 {0} 个字符")
	private String password;
	@NotEmpty(message = "不能为空")
	@Min(value = 6, message = "最少要输入 {0} 个字符")
	private String confirmPassword;
	@NotEmpty(message = "不能为空")
	@Email(message = "不符合邮箱规则")
	private String Email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
