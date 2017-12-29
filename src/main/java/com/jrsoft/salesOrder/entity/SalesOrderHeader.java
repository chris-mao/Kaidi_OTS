/**
 * 
 */
package com.jrsoft.salesOrder.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 销售订单头实体类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class SalesOrderHeader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 销售订单编号
	 */
	private int orderId;

	/**
	 * 销售订单号
	 */
	@NotEmpty(message = "销售订单号不允许为空")
	@Length(min = 14, max = 14, message = "销售订单号长度不能少于14位")
	private String orderNumber;
	
	/**
	 * 客户编号
	 */
	@NotEmpty(message = "客户不允许为空")
	private int customerId;
	
	/**
	 * 客户名称
	 */
	private String customerName;
	
	/**
	 * 发票地址编号
	 */
	@NotEmpty(message = "发票地址不允许为空")
	private int billToId;
	
	/**
	 * 发票地址
	 */
	private String billTo;
	
	/**
	 * 收货地址编号
	 */
	@NotEmpty(message = "收货地址不允许为空")
	private int shipToId;
	
	/**
	 * 收货地址
	 */
	private String shipTo;

	/**
	 * 创建者编号
	 */
	private int creator;

	/**
	 * 创建者名称
	 */
	private String creatorName;

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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getBillToId() {
		return billToId;
	}

	public void setBillToId(int billToId) {
		this.billToId = billToId;
	}

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public int getShipToId() {
		return shipToId;
	}

	public void setShipToId(int shipToId) {
		this.shipToId = shipToId;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
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
		return "SalesOrderHeader [orderId=" + orderId + ", orderNumber=" + orderNumber + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", billToId=" + billToId + ", billTo=" + billTo + ", shipToId="
				+ shipToId + ", shipTo=" + shipTo + ", creator=" + creator + ", creatorName=" + creatorName
				+ ", available=" + available + ", createdTime=" + createdTime + ", updateTime=" + updateTime + "]";
	}

}
