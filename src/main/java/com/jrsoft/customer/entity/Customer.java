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
 * 客户实体类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 客户编号
	 */
	private int customerId;

	/**
	 * 客户代码
	 */
	@NotEmpty(message = "客户代码不允许为空")
	@Length(max = 6, message = "客户代码长度不能超过6位字符")
	private String customerCode;

	/**
	 * 客户名称
	 */
	@NotEmpty(message = "客户名称不允许为空")
	@Length(max = 128, message = "客户名称长度不能超过128位字符")
	private String customerName;

	/**
	 * 客户简称
	 */
	@NotEmpty(message = "客户简称不允许为空")
	@Length(max = 64, message = "客户简称长度不能超过64位字符")
	private String shortName;

	/**
	 * 客户ABC
	 */
	@Length(max = 2, message = "客户ABC分类长度不能超过2位字符")
	private String customerClass;

	/**
	 * 国家
	 */
	@Length(max = 32, message = "国家长度不能超过32位字符")
	private String country;

	/**
	 * 城市
	 */
	@Length(max = 32, message = "城市长度不能超过32位字符")
	private String city;

	/**
	 * 销售人员编号
	 */
	private int salesPerson;

	/**
	 * 销售人员姓名
	 */
	private String salesPersonName;

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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCustomerClass() {
		return customerClass;
	}

	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(int salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getSalesPersonName() {
		return salesPersonName;
	}

	public void setSalesPersonName(String salesPersonName) {
		this.salesPersonName = salesPersonName;
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
		return "Customer [customerId=" + customerId + ", customerCode=" + customerCode + ", customerName="
				+ customerName + ", shortName=" + shortName + ", customerClass=" + customerClass + ", country="
				+ country + ", city=" + city + ", salesPerson=" + salesPerson + ", salesPersonName=" + salesPersonName
				+ ", available=" + available + ", createdTime=" + createdTime + ", updateTime=" + updateTime + "]";
	}
	
}
