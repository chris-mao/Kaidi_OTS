/**
 * 
 */
package com.jrsoft.organization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jrsoft.common.EasyDataGrid;
import com.jrsoft.organization.dao.EmployeeDAO;
import com.jrsoft.organization.entity.Department;
import com.jrsoft.organization.entity.Employee;
import com.jrsoft.organization.service.EmployeeService;

/**
 * 员工服务接口实现类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	/**
	 * 
	 */
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll(false);
	}

	@Override
	public List<Employee> findAll(boolean onlyAvailable) {
		return employeeDAO.findAll(onlyAvailable);
	}

	@Override
	public PageInfo<Employee> findAll(int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		return new PageInfo<Employee>(employeeDAO.findAll(false));
	}

	@Override
	public EasyDataGrid<Employee> findAll(int pageIndex, int pageSize, String searchStr) {
		PageInfo<Employee> pageInfo;
		if (searchStr.isEmpty()) {
			pageInfo = this.findAll(pageIndex, pageSize);
		} else {
			Employee emp = new Employee();
			emp.setEmployeeNum("%" + searchStr + "%");
			emp.setEmployeeName("%" + searchStr + "%");
			PageHelper.startPage(pageIndex, pageSize);
			pageInfo = new PageInfo<Employee>(employeeDAO.fuzzyQuery(emp));
		}

		EasyDataGrid<Employee> dg = new EasyDataGrid<Employee>();
		dg.setTotal(pageInfo.getTotal());
		dg.setRows(pageInfo.getList());
		return dg;
	}

	@Override
	public List<Employee> findAllByDepartment(int deptId) {
		if (deptId == 0) {
			return null;
		}
		return this.employeeDAO.findAllByDepartment(deptId);
	}

	@Override
	public Employee findOne(Employee employee) {
		if (0 != employee.getEmployeeId()) {
			return employeeDAO.findById(employee.getEmployeeId());
		}
		if (null != employee.getEmployeeNum()) {
			return employeeDAO.findByNum(employee.getEmployeeNum());
		}
		if (null != employee.getEmployeeName()) {
			return employeeDAO.findByName(employee.getEmployeeName());
		}
		return null;
	}

	@Override
	public boolean insert(Employee employee) {
		return 1 == employeeDAO.insert(employee);
	}

	@Override
	public boolean update(Employee employee) {
		return 1 == employeeDAO.udpate(employee);
	}

	@Override
	public boolean delete(int id) {
		return 1 == employeeDAO.delete(id);
	}

}
