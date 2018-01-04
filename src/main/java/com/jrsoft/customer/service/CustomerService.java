/**
 * 
 */
package com.jrsoft.customer.service;

import java.util.List;
import java.util.Set;

import com.jrsoft.app.service.AbstractDbService;
import com.jrsoft.customer.entity.Customer;
import com.jrsoft.customer.entity.CustomerSite;
import com.jrsoft.easyui.EasyDataGrid;

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
	 * @since 1.0
	 * @param customerId
	 *            客户编号
	 * @return
	 */
	public List<CustomerSite> findAllSitesByCustomer(int customerId);

	/**
	 * 查询客户用途地址
	 * 
	 * @since 1.0
	 * @param customerId
	 *            客户编号
	 * @param sitePurpose
	 *            地址用途
	 * @return
	 */
	public List<CustomerSite> findAllPurposeSitesByCustomer(int customerId, String sitePurpose);

	/**
	 * 查询客户地址，具有分页功能
	 * 
	 * @since 1.0
	 * @param pageIndex
	 *            页码
	 * @param pageSize
	 *            分页大小
	 * @param customerId
	 *            客户编号
	 * @return {@link EasyDataGrid}
	 */
	public EasyDataGrid<CustomerSite> findAllSitesByCustomer(int pageIndex, int pageSize, int customerId);

	/**
	 * 按地址编号查询客户地址
	 * 
	 * @since 1.0
	 * @param siteId
	 *            地址编号
	 * @return
	 */
	public CustomerSite findOneSite(int siteId);

	/**
	 * 新增客户地址，新增成功返回<code>true</code>，否则返回<code>false</code>
	 * 
	 * @since 1.0
	 * @param site
	 * @return
	 */
	public boolean insertSite(CustomerSite site);

	/**
	 * 更新客户地址，更新成功返回<code>true</code>，否则返回<code>false</code>
	 * 
	 * @since 1.0
	 * @param site
	 * @return
	 */
	public boolean updateSite(CustomerSite site);

	/**
	 * 删除客户地址，删除成功返回<code>true</code>，否则返回<code>false</code>
	 * 
	 * @since 1.0
	 * @param siteId
	 *            地址编号
	 * @return
	 */
	public boolean deleteSite(int siteId);
}
