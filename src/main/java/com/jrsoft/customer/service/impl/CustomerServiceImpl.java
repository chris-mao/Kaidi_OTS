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
	public PageInfo<Customer> findAll(int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
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
		} else if (!StringUtils.isEmpty(customer.getCustomerCode())) {
			return this.customerDAO.findByCode(customer.getCustomerCode());
		} else if (!StringUtils.isEmpty(customer.getShortName())) {
			return this.customerDAO.findByShortName(customer.getShortName());
		} else if (!StringUtils.isEmpty(customer.getCustomerName())) {
			return this.customerDAO.findByName(customer.getCustomerName());
		}
		return null;
	}

	@Override
	public boolean insert(Customer customer) {
		return 1 == this.customerDAO.insert(customer);
	}

	@Override
	public boolean update(Customer customer) {
		return 1 == this.customerDAO.update(customer);
	}

	@Override
	public boolean delete(int id) {
		return 1 == this.customerDAO.delete(id);
	}

	@Override
	public Set<Customer> findAllByEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerSite> findAllSitesByCustomer(int customerId) {
		return this.customerDAO.findAllSitesByCustomer(customerId);
	}

	@Override
	public List<CustomerSite> findAllPurposeSitesByCustomer(int customerId, String sitePurpose) {
		return this.customerDAO.findAllPurposeSitesByCustomer(customerId, sitePurpose);
	}

	@Override
	public EasyDataGrid<CustomerSite> findAllSitesByCustomer(int pageIndex, int pageSize, int customerId) {
		PageInfo<CustomerSite> pageInfo;
		pageInfo = new PageInfo<CustomerSite>(customerDAO.findAllSitesByCustomer(customerId));

		EasyDataGrid<CustomerSite> dg = new EasyDataGrid<CustomerSite>();
		dg.setTotal(pageInfo.getTotal());
		dg.setRows(pageInfo.getList());
		return dg;
	}

	@Override
	public boolean insertSite(CustomerSite site) {
		return 1 == this.customerDAO.insertSite(site);
	}

	@Override
	public boolean updateSite(CustomerSite site) {
		// TODO Auto-generated method stub
		return 1 == this.customerDAO.updateSite(site);
	}

	@Override
	public boolean deleteSite(int siteId) {
		return 1 == this.customerDAO.deleteSite(siteId);
	}

	@Override
	public CustomerSite findOneSite(int siteId) {
		if (0 == siteId) {
			return null;
		}
		return this.customerDAO.findOneSite(siteId);
	}

}
