/**
 * 
 */
package com.jrsoft.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 产品型号实体类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 产品编号
	 */
	private int modelId;

	/**
	 * 
	 */
	@NotEmpty(message = "产品型号不能为空")
	@Length(max = 32, message = "产品型号长度不能超过32个字符")
	private String modelNum;

	/**
	 * 产品名称
	 */
	@NotEmpty(message = "产品名称不能为空")
	@Length(max = 64, message = "产品名称长度不能超过64个字符")
	private String modelName;

	/**
	 * 产品规格
	 */
	@Length(max = 512, message = "产品规格长度不能超过512个字符")
	private String specification;

	/**
	 * 产品类别编号
	 */
	@NotEmpty(message = "产品类别不能为空")
	private int categoryId;

	/**
	 * 产品类别名称
	 */
	private String categoryName;

	/**
	 * 技术文档是否已备好
	 */
	private boolean hasTechDoc;

	/**
	 * 预计备好技术文档的日期
	 */
	@Length(max = 10, message = "日期长度不能超过10个字符")
	private String techDocETA;

	/**
	 * 实际备好技术文档的日期
	 */
	@Length(max = 10, message = "日期长度不能超过10个字符")
	private String techDocATA;

	/**
	 * BOM是否已备好
	 */
	private boolean hasBom;

	/**
	 * 预计备好BOM的日期
	 */
	@Length(max = 10, message = "日期长度不能超过10个字符")
	private String bomETA;

	/**
	 * 实际备好BOM的日期
	 */
	@Length(max = 10, message = "日期长度不能超过10个字符")
	private String bomATA;

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

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public boolean isHasTechDoc() {
		return hasTechDoc;
	}

	public void setHasTechDoc(boolean hasTechDoc) {
		this.hasTechDoc = hasTechDoc;
	}

	public String getTechDocETA() {
		return techDocETA;
	}

	public void setTechDocETA(String techDocEta) {
		this.techDocETA = techDocEta;
	}

	public String getTechDocATA() {
		return techDocATA;
	}

	public void setTechDocATA(String techDocAta) {
		this.techDocATA = techDocAta;
	}

	public boolean isHasBom() {
		return hasBom;
	}

	public void setHasBom(boolean hasBom) {
		this.hasBom = hasBom;
	}

	public String getBomETA() {
		return bomETA;
	}

	public void setBomETA(String bomEta) {
		this.bomETA = bomEta;
	}

	public String getBomATA() {
		return bomATA;
	}

	public void setBomATA(String bomAta) {
		this.bomATA = bomAta;
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

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	@Override
	public String toString() {
		return "Model [modelId=" + modelId + ", modelNum=" + modelNum + ", modelName=" + modelName + ", specification="
				+ specification + ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", hasTechDoc="
				+ hasTechDoc + ", techDocETA=" + techDocETA + ", techDocATA=" + techDocATA + ", hasBom=" + hasBom
				+ ", bomETA=" + bomETA + ", bomATA=" + bomATA + ", available=" + available + ", createdTime="
				+ createdTime + ", updateTime=" + updateTime + "]";
	}

}
