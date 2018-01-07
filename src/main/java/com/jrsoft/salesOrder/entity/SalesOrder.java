/**
 * 
 */
package com.jrsoft.salesOrder.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 销售订单头实体类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 */
public class SalesOrder implements Serializable {

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
	 * 预付款百分比
	 */
	private int imprest;

	/**
	 * 季度，1表示第一季度，2表示第二度度，以此类推
	 */
	private int quarter;

	/**
	 * 产品编号
	 */
	@NotEmpty(message = "产品不允许为空")
	private int modelId;

	/**
	 * 产品名称
	 */
	private String modelName;

	/**
	 * 规格型号
	 */
	private String specific;

	/**
	 * 数量
	 */
	@Min(value = 1)
	private int qty;
	
	/**
	 * 销售单价
	 */
	private double unitPrice;

	/**
	 * 特殊要求
	 */
	private String specialMemo;

	/**
	 * 生产车间编号
	 */
	private int workshop;

	/**
	 * 生产车间名称
	 */
	private String workshopName;

	/**
	 * 机组编号
	 */
	private String serialNumber;

	/**
	 * 要求交期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rtd;

	/**
	 * 实际交期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date atd;

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

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getSpecific() {
		return specific;
	}

	public void setSpecific(String specific) {
		this.specific = specific;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getSpecialMemo() {
		return specialMemo;
	}

	public void setSpecialMemo(String specialMemo) {
		this.specialMemo = specialMemo;
	}

	public int getWorkshop() {
		return workshop;
	}

	public void setWorkshop(int workshop) {
		this.workshop = workshop;
	}

	public String getWorkshopName() {
		return workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getRtd() {
		return rtd;
	}

	public void setRtd(Date rtd) {
		this.rtd = rtd;
	}

	public Date getAtd() {
		return atd;
	}

	public void setAtd(Date atd) {
		this.atd = atd;
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

	public int getImprest() {
		return imprest;
	}

	public void setImprest(int imprest) {
		this.imprest = imprest;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getAmount() {
		return qty * unitPrice;
	}

	@Override
	public String toString() {
		return "SalesOrder [orderId=" + orderId + ", orderNumber=" + orderNumber + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", billToId=" + billToId + ", billTo=" + billTo + ", shipToId="
				+ shipToId + ", shipTo=" + shipTo + ", imprest=" + imprest + ", quarter=" + quarter + ", modelId="
				+ modelId + ", modelName=" + modelName + ", specific=" + specific + ", qty=" + qty + ", unitPrice="
				+ unitPrice + ", specialMemo=" + specialMemo + ", workshop=" + workshop + ", workshopName="
				+ workshopName + ", serialNumber=" + serialNumber + ", rtd=" + rtd + ", atd=" + atd + ", creator="
				+ creator + ", creatorName=" + creatorName + ", available=" + available + ", createdTime=" + createdTime
				+ ", updateTime=" + updateTime + "]";
	}

}
