/**
 * 
 */
package com.jrsoft.lackMaterial.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 缺料单实体类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class LackMaterial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 销售订单行编号
	 */
	private int salesOrderLineId;

	/**
	 * 缺料单编号
	 */
	private int id;

	/**
	 * 缺料单号
	 */
	@NotEmpty(message = "缺料单号不允许为空")
	@Length(min = 1, max = 11, message = "缺料单号长度不能少于11位")
	private String lackNumber;

	/**
	 * 原材料名称
	 */
	@NotEmpty(message = "原材料不允许为空")
	private String partsName;

	/**
	 * 数量
	 */
	@Min(value = 1)
	private int qty;

	/**
	 * 采购单号
	 */
	@Length(min = 1, max = 10, message = "采购单号长度应在XXXX位之间")
	private String purchaseNumber;

	/**
	 * 采购员编号
	 */
	private int buyer;

	/**
	 * 采购员名称
	 */
	private String buyerName;

	/**
	 * 要求交期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rtd;

	/**
	 * 预估到达日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eta;

	/**
	 * 实际到达日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ata;

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

	public int getSalesOrderLineId() {
		return salesOrderLineId;
	}

	public void setSalesOrderLineId(int salesOrderLineId) {
		this.salesOrderLineId = salesOrderLineId;
	}

	public int getId() {
		return id;
	}

	public void setId(int lackId) {
		this.id = lackId;
	}

	public String getLackNumber() {
		return lackNumber;
	}

	public void setLackNumber(String lackNumber) {
		this.lackNumber = lackNumber;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public int getBuyer() {
		return buyer;
	}

	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Date getRtd() {
		return rtd;
	}

	public void setRtd(Date rtd) {
		this.rtd = rtd;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public Date getAta() {
		return ata;
	}

	public void setAta(Date ata) {
		this.ata = ata;
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
		return "LackMaterial [salesOrderLineId=" + salesOrderLineId + ", lackId=" + id + ", lackNumber="
				+ lackNumber + ", partsName=" + partsName + ", qty=" + qty + ", purchaseNumber=" + purchaseNumber
				+ ", buyer=" + buyer + ", buyerName=" + buyerName + ", rtd=" + rtd + ", eta=" + eta + ", ata=" + ata
				+ ", creator=" + creator + ", creatorName=" + creatorName + ", available=" + available
				+ ", createdTime=" + createdTime + ", updateTime=" + updateTime + "]";
	}

}
