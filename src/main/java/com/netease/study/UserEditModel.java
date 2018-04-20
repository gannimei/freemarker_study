package com.netease.study;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@CustomValidator
public class UserEditModel {

	private int id;
	
	@NotEmpty(message = "不能为空")
	@Size(min = 6, max = 15, message = "请输入长度在{min}到{max}之间的字符串")
	@Remote(verifyClass = UserNameValid.class, verifyMethod = "isValid", additionalField = "id")
	private String userName;

	@NotEmpty(message = "不能为空")
	@Length(min = 6, message = "最少输入{min}个字符")
	private String password;

	@NotEmpty(message = "不能为空")
	@Length(min = 6, message = "最少输入{min}个字符")
	@Compare(verifyField = "password", message = "密码不一致")
	private String confirmPassword;

	@NotEmpty(message = "不能为空")
	@Email(message = "不符合邮箱规则")
	private String Email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
