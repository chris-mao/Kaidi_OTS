/**
 * 
 */
package com.jrsoft.customer.service;

import java.util.List;
import java.util.Set;

import com.jrsoft.app.service.AbstractDbService;
import com.jrsoft.common.EasyDataGrid;
import com.jrsoft.customer.entity.Customer;
import com.jrsoft.customer.entity.CustomerSite;

/**
 * 客户业务接口
 * 
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface CustomerService extends AbstractDbService<Customer> {

	/**
	 * 根据业务员查询分配到其名下的客户清单
	 * 
	 * @since 1.0
	 * @param employee
	 * @return Set
	 */
	public Set<Customer> findAllByEmployee(int employeeId);
	
	public List<CustomerSite> findAllSiteByCustomer(int customerId);
	
//	public PageInfo<CustomerSite> findAll(int pageNum, int pageSize, int customerId);
	
	public EasyDataGrid<CustomerSite> findAll(int pageIndex, int pageSize, int customerId);
	
	public int newSite(CustomerSite site);
	
	public boolean updateSite(CustomerSite site);
	
	public boolean deleteSite(int siteId);
}
