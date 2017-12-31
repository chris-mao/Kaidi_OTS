/**
 * 
 */
package com.jrsoft.customer.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jrsoft.common.EasyDataGrid;
import com.jrsoft.customer.dao.CustomerDAO;
import com.jrsoft.customer.entity.Customer;
import com.jrsoft.customer.entity.CustomerSite;
import com.jrsoft.customer.service.CustomerService;

/**
 * 客户服务接口实现类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> findAll() {
		return this.customerDAO.findAll(false);
	}

	@Override
	public List<Customer> findAll(boolean onlyAvailable) {
		return this.customerDAO.findAll(onlyAvailable);
	}

	@Override
	public PageInfo<Customer> findAll(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Customer>(customerDAO.findAll(false));
	}

	@Override
	public EasyDataGrid<Customer> findAll(int pageIndex, int pageSize, String searchStr) {
		PageInfo<Customer> pageInfo;
		if (StringUtils.isEmpty(searchStr)) {
			pageInfo = this.findAll(pageIndex, pageSize);
		} else {
			Customer customer = new Customer();
			customer.setCustomerCode("%" + searchStr + "%");
			customer.setShortName("%" + searchStr + "%");
			PageHelper.startPage(pageIndex, pageSize);
			pageInfo = new PageInfo<Customer>(customerDAO.fuzzyQuery(customer));
		}

		EasyDataGrid<Customer> dg = new EasyDataGrid<Customer>();
		dg.setTotal(pageInfo.getTotal());
		dg.setRows(pageInfo.getList());
		return dg;
	}

	@Override
	public Customer findOne(Customer customer) {
		if (customer.getCustomerId() != 0) {
			return this.customerDAO.findById(customer.getCustomerId());
		}
		else if (!StringUtils.isEmpty(customer.getCustomerCode())) {
			return this.customerDAO.findByCode(customer.getCustomerCode());
		}
		else if (!StringUtils.isEmpty(customer.getShortName())) {
			return this.customerDAO.findByShortName(customer.getShortName());
		}
		else if (!StringUtils.isEmpty(customer.getShortName())) {
			return this.customerDAO.findByName(customer.getCustomerName());
		}
		return null;
	}

	@Override
	public boolean insert(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Customer> findAllByEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerSite> findAllSiteByCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EasyDataGrid<CustomerSite> findAll(int pageIndex, int pageSize, int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int newSite(CustomerSite site) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateSite(CustomerSite site) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSite(int siteId) {
		// TODO Auto-generated method stub
		return false;
	}

}
