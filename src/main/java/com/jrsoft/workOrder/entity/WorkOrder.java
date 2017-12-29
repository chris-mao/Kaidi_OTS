/**
 * 
 */
package com.jrsoft.workOrder.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 生产工单实体类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class WorkOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 销售订单行编号
	 */
	private int salesOrderLineId;

	/**
	 * 生产工单编号
	 */
	private int Id;

	/**
	 * 生产工单号
	 */
	@NotEmpty(message = "生产工单号不允许为空")
	@Length(min = 1, max = 11, message = "工单号长度不能少于11位")
	private String woNumber;

	/**
	 * 数量
	 */
	@Min(value = 1)
	private int qty;

	/**
	 * 生产车间编号
	 */
	private int workshop;

	/**
	 * 生产车间名称
	 */
	private String workshopName;

	/**
	 * 预估完工日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date etf;

	/**
	 * 实际完工日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date atf;

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
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getWoNumber() {
		return woNumber;
	}

	public void setWoNumber(String woNumber) {
		this.woNumber = woNumber;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
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

	public Date getEtf() {
		return etf;
	}

	public void setEtf(Date etf) {
		this.etf = etf;
	}

	public Date getAtf() {
		return atf;
	}

	public void setAtf(Date atf) {
		this.atf = atf;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
