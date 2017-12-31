/**
 * 
 */
package com.jrsoft.organization.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 员工实体类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	private int employeeId;

	/**
	 * 员工工号
	 */
	@NotEmpty(message = "员工工号不能为空")
	@Length(min = 3, max = 12, message = "员工工号长度需在3位到12位之间")
	private String employeeNum;

	/**
	 * 员工姓名
	 */
	@NotEmpty(message = "员工姓名不能为空")
	@Length(min = 2, max = 32, message = "员工姓名长度需在3位到32位之间")
	private String employeeName;

	/**
	 * 电子邮件
	 */
	@Length(min = 10, max = 100, message = "电子邮件长度需在10位到100位之间")
	private String email;

	/**
	 * 电话号码
	 */
	@Length(min = 6, max = 32, message = "电话号码长度需要6位到32位之间")
	private String phone;

	/**
	 * 部门编号
	 */
	@NotEmpty(message = "请指定员工隶属部门")
	private int departmentId;

	/**
	 * 部门名称
	 */
	private String departmentName;

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

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeNum=" + employeeNum + ", employeeName=" + employeeName
				+ ", email=" + email + ", phone=" + phone + ", departmentId=" + departmentId + ", available="
				+ available + ", createdTime=" + createdTime + ", updateTime=" + updateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		if (employeeNum == null) {
			if (other.employeeNum != null)
				return false;
		} else if (!employeeNum.equals(other.employeeNum))
			return false;
		return true;
	}
}
