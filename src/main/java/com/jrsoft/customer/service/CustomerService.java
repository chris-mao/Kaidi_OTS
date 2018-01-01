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
	
	/**
	 * 查询客户所有地址
	 * 
	 * @param customerId
	 *            客户编号
	 * @return
	 */
	public List<CustomerSite> findAllSitesByCustomer(int customerId);
	
	/**
	 * 查询客户用途地址
	 * 
	 * @param customerId
	 *            客户编号
	 * @param sitePurpose
	 *            地址用途
	 * @return
	 */
	public List<CustomerSite> findAllPurposeSitesByCustomer(int customerId, String sitePurpose);
	
	public EasyDataGrid<CustomerSite> findAll(int pageIndex, int pageSize, int customerId);
	
	/**
	 * 
	 * @param siteId
	 * @return
	 */
	public CustomerSite findOneSite(int siteId);
	
	public boolean insertSite(CustomerSite site);
	
	public boolean updateSite(CustomerSite site);
	
	public boolean deleteSite(int siteId);
}
