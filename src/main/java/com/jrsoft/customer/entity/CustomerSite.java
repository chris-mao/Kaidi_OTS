/**
 * 
 */
package com.jrsoft.customer.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 客户地址实体类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class CustomerSite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public static final String BILL_TO = "BILL_TO";

	/**
	 * 
	 */
	public static final String SHIP_TO = "SHIP_TO";

	/**
	 * 地址编号
	 */
	private int siteId;

	/**
	 * 客户编号
	 */
	private int customerId;

	/**
	 * 地址用途
	 */
	@NotEmpty(message = "地址用途不能为空")
	@Length(max = 8, message = "邮政编码长度不能超过8个字符")
	private String sitePurpose;

	/**
	 * 国家
	 */
	@Length(max = 32, message = "国家长度不能超过32个字符")
	private String country;

	/**
	 * 省份
	 */
	@NotEmpty(message = "省份不能为空")
	@Length(max = 32, message = "省份长度不能超过32个字符")
	private String province;

	/**
	 * 城市
	 */
	@NotEmpty(message = "城市不能为空")
	@Length(max = 32, message = "城市长度不能超过32个字符")
	private String city;

	/**
	 * 地区
	 */
	@NotEmpty(message = "地区不能为空")
	@Length(max = 32, message = "地区长度不能超过32个字符")
	private String district;

	/**
	 * 地址
	 */
	@NotEmpty(message = "街道地址不能为空")
	@Length(max = 256, message = "街道地址长度不能超过256个字符")
	private String address;
	
	/**
	 * 国家／
	 */
	private String addressText;
	
	/**
	 * 邮政编码
	 */
	@Length(max = 16, message = "邮政编码长度不能超过16个字符")
	private String zipCode;

	/**
	 * 联系人
	 */
	@Length(max = 64, message = "联系人长度不能超过64个字符")
	private String contact;

	/**
	 * 联系电话
	 */
	@Length(max = 64, message = "联系电话长度不能超过64个字符")
	private String phone;

	/**
	 * 电子邮件
	 */
	@Length(max = 100, message = "邮件长度不能超过100个字符")
	private String email;

	/**
	 * 其他联系方式
	 */
	@Length(max = 100, message = "其他联系方式长度不能超过100个字符")
	private String others;

	/**
	 * 是否有效
	 */
	private boolean available = true;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getSitePurpose() {
		return sitePurpose;
	}

	public void setSitePurpose(String sitePurpose) {
		this.sitePurpose = sitePurpose;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "CustomerSite [siteId=" + siteId + ", customerId=" + customerId + ", sitePurpose=" + sitePurpose
				+ ", country=" + country + ", province=" + province + ", city=" + city + ", district=" + district
				+ ", address=" + address + ", zipCode=" + zipCode + ", contact=" + contact + ", phone=" + phone
				+ ", email=" + email + ", others=" + others + ", available=" + available + ", createdTime="
				+ createdTime + ", updateTime=" + updateTime + "]";
	}

	public String getAddressText() {
		return addressText;
	}

	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}

}
