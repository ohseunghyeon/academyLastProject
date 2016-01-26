package com.first.lastproject.dto;

public class MemberDto {
	private String id;
	private String passwd;
	private int mileage;
	private String phone_number;
	private String email;
	private int is_guest;
	private int get_coupon;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIs_guest() {
		return is_guest;
	}
	public void setIs_guest(int is_guest) {
		this.is_guest = is_guest;
	}
	public int getGet_coupon() {
		return get_coupon;
	}
	public void setGet_coupon(int get_coupon) {
		this.get_coupon = get_coupon;
	}
	
}
