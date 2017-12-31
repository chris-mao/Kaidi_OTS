/**
 * 
 */
package com.jrsoft.salesOrder.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 销售订单行实体类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 * @deprecated
 */
public class SalesOrderLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单行编号，唯一
	 */
	private int lineId;

	/**
	 * 销售订单编号
	 */
	private int orderId;
	
	private int lineIndex;

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
	 * 数量
	 */
	@Min(value = 1)
	private int qty;

	/**
	 * 特殊要求
	 */
	private String specialMemo;

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

	public int getLineIndex() {
		return lineIndex;
	}

	public void setLineIndex(int lineIndex) {
		this.lineIndex = lineIndex;
	}

	public int getLineId() {
		return lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
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

	@Override
	public String toString() {
		return "SalesOrderLine [orderId=" + orderId + ", lineIndex=" + lineIndex + ", lineId=" + lineId + ", modelId="
				+ modelId + ", modelName=" + modelName + ", qty=" + qty + ", specialMemo=" + specialMemo + ", rtd="
				+ rtd + ", atd=" + atd + ", creator=" + creator + ", creatorName=" + creatorName + ", available="
				+ available + ", createdTime=" + createdTime + ", updateTime=" + updateTime + "]";
	}

}
