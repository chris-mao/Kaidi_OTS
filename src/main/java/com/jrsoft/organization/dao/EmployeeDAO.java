/**
 * 
 */
package com.jrsoft.organization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jrsoft.organization.dao.sqlprovider.EmployeeDynaSqlProvider;
import com.jrsoft.organization.entity.Employee;

/**
 * 员工数据访问接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface EmployeeDAO {

	/**
	 * 查询所有员工
	 * 
	 * @since 1.0
	 * @param onlyAvailable
	 *            布尔值，为treu显查询available=1的员工，否则查询所有员工
	 * @return
	 */
	@SelectProvider(method = "findAllSql", type = EmployeeDynaSqlProvider.class)
	@Results({ @Result(property = "employeeId", column = "employee_id", id = true),
			@Result(property = "employeeNum", column = "employee_num"),
			@Result(property = "employeeName", column = "employee_name"), @Result(property = "email", column = "email"),
			@Result(property = "phone", column = "phone"), @Result(property = "departmentId", column = "department_id"),
			@Result(property = "departmentName", column = "department_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<Employee> findAll(@Param(value = "available") boolean onlyAvailable);

	/**
	 * 按编号查询员工
	 * 
	 * @since 1.0
	 * @param id
	 *            员工编号
	 * @return
	 */
	@Select("SELECT employee_id, employee_num, employee_name, email, phone, department_id, department_name, available, created_time, update_time FROM vw_employee WHERE employee_id = #{id}")
	@Results({ @Result(property = "employeeId", column = "employee_id", id = true),
			@Result(property = "employeeNum", column = "employee_num"),
			@Result(property = "employeeName", column = "employee_name"), @Result(property = "email", column = "email"),
			@Result(property = "phone", column = "phone"), @Result(property = "departmentId", column = "department_id"),
			@Result(property = "departmentName", column = "department_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Employee findById(@Param(value = "id") int id);

	/**
	 * 按姓名查询员工
	 * 
	 * @since 1.0
	 * @param employeeName
	 *            员工姓名
	 * @return
	 */
	@Select("SELECT employee_id, employee_num, employee_name, email, phone, department_id, department_name, available, created_time, update_time FROM vw_employee WHERE employee_name = #{name}")
	@Results({ @Result(property = "employeeId", column = "employee_id", id = true),
			@Result(property = "employeeNum", column = "employee_num"),
			@Result(property = "employeeName", column = "employee_name"), @Result(property = "email", column = "email"),
			@Result(property = "phone", column = "phone"), @Result(property = "departmentId", column = "department_id"),
			@Result(property = "departmentName", column = "department_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Employee findByName(@Param(value = "name") String employeeName);

	/**
	 * 按工号查询员工
	 * 
	 * @since 1.0
	 * @param employeeNum
	 *            员工工号
	 * @return
	 */
	@Select("SELECT employee_id, employee_num, employee_name, email, phone, department_id, department_name, available, created_time, update_time FROM vw_employee WHERE employee_num = #{num}")
	@Results({ @Result(property = "employeeId", column = "employee_id", id = true),
			@Result(property = "employeeNum", column = "employee_num"),
			@Result(property = "employeeName", column = "employee_name"), @Result(property = "email", column = "email"),
			@Result(property = "phone", column = "phone"), @Result(property = "departmentId", column = "department_id"),
			@Result(property = "departmentName", column = "department_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Employee findByNum(@Param(value = "num") String employeeNum);

	/**
	 * 按员工工号或是姓名模糊查询员工
	 * 
	 * @since 1.0
	 * @param employee
	 * @return
	 */
	@Select("SELECT employee_id, employee_num, employee_name, email, phone, department_id, department_name, available, created_time, update_time FROM vw_employee WHERE employee_num LIKE #{employeeNum} OR employee_name LIKE #{employeeName}")
	@Results({ @Result(property = "employeeId", column = "employee_id", id = true),
			@Result(property = "employeeNum", column = "employee_num"),
			@Result(property = "employeeName", column = "employee_name"), @Result(property = "email", column = "email"),
			@Result(property = "phone", column = "phone"), @Result(property = "departmentId", column = "department_id"),
			@Result(property = "departmentName", column = "department_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<Employee> fuzzyQuery(Employee employee);

	/**
	 * 按部门查询员工
	 * 
	 * @since 1.0
	 * @param departmentId
	 * @return
	 */
	@Select("SELECT employee_id, employee_num, employee_name, email, phone, department_id, department_name, available, created_time, update_time FROM vw_employee WHERE department_id = #{deptId}")
	@Results({ @Result(property = "employeeId", column = "employee_id", id = true),
			@Result(property = "employeeNum", column = "employee_num"),
			@Result(property = "employeeName", column = "employee_name"), @Result(property = "email", column = "email"),
			@Result(property = "phone", column = "phone"), @Result(property = "departmentId", column = "department_id"),
			@Result(property = "departmentName", column = "department_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<Employee> findAllByDepartment(@Param(value = "deptId") int departmentId);

	/**
	 * 创建新员工
	 * 
	 * @since 1.0
	 * @param department
	 * @return 受影响的行数
	 */
	@Insert("INSERT INTO employee(employee_num, employee_name, email, phone, department_id, available, created_time) VALUES(#{employeeNum}, #{employeeName}, #{email}, #{phone}, #{departmentId}, #{available}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "employeeId")
	public int insert(Employee employee);

	/**
	 * 更新员工
	 * 
	 * @since 1.0
	 * @param department
	 * @return 受影响的行数
	 */
	@Update("UPDATE employee SET employee_num = #{employeeNum}, employee_name = #{employeeName}, email = #{email}, phone = #{phone}, department_id = #{departmentId}, available = #{available} WHERE employee_id = #{employeeId}")
	public int udpate(Employee employee);

	/**
	 * 删除员工
	 * 
	 * @since 1.0
	 * @param id
	 * @return 受影响的行数
	 */
	@Delete("DELETE FROM employee WHERE employee_id = #{id}")
	public int delete(@Param(value = "id") int id);
}
