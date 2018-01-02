/**
 * 
 */
package com.jrsoft.customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrsoft.common.EasyDataGrid;
import com.jrsoft.common.JsonResult;
import com.jrsoft.customer.entity.Customer;
import com.jrsoft.customer.entity.CustomerSite;
import com.jrsoft.customer.service.CustomerService;

/**
 * <p>
 * 客户控制器类，提供客户资料维护方法接口
 * <dl>
 * <dt>GET: customers/api/list?page=1&rows=20&searchValue=</dt>
 * <dd>按页码返回（符合查询条件或是全部）客户数据列表，需要拥有<code>customer:list</code>权限</dd>
 * <dt>GET: customers/api/json</dt>
 * <dd>返回全部有效的（available=1）客户数据列表，需要拥有<code>customer:list</code>权限</dd>
 * <dt>POST: customers/api/new</dt>
 * <dd>新建客户数据，需要拥有<code>customer:new</code>权限</dd>
 * <dt>GET: customers/api/{id}</dt>
 * <dd>获取客户数据，无权限控制</dd>
 * <dt>POST: customers/api/{id}</dt>
 * <dd>更新客户数据，需要拥有<code>customer:edit</code>权限</dd>
 * <dt>DELETE: customers/api/{id}</dt>
 * <dd>删除客户数据，需要拥有<code>customer:delete</code>权限</dd>
 * </dl>
 * <br />
 * <dl>
 * <dt>GET：customers/{id}/sites</dt>
 * <dd>获取客户地址列表，需要有<code>customer:list</code>权限</dd>
 * <dt>GET：customers/{id}/sites/json</dt>
 * <dd>获取客户有效的（available=1）地址列表，需要有<code>customer:list</code>权限</dd>
 * <dt>GET：customers/{id}/sites/{purpose}</dt>
 * <dd>获取客户指定用途的地址列表，需要有<code>customer:list</code>权限，地址用途可以是<code>bill_to</code>
 * 或是 <code>ship_to</code>，如果不在以上值列表中，程序会抛出{@link IllegalArgumentException}异常
 * </dd>
 * <dt>POST: customers/api/{id}/sites/new</dt>
 * <dd>新建客户地址，需要拥有<code>site:new</code>权限</dd>
 * <dt>GET: customers/api/sites/{id}</dt>
 * <dd>获取客户地址，无权限控制</dd>
 * <dt>POST: customers/api/sites/{id}</dt>
 * <dd>更新客户地址，需要拥有<code>site:edit</code>权限</dd>
 * <dt>DELETE: customers/api/sites/{id}</dt>
 * <dd>删除客户地址，需要拥有<code>site:delete</code>权限</dd>
 * </dl>
 * </p>
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/customers/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	/**
	 * 获取客户主数据列表
	 * 
	 * @since 1.0
	 * @param pageIndex
	 *            页码
	 * @param pageSize
	 *            分页大小
	 * @param searchStr
	 *            查询字符串
	 * @return {@link EasyDataGrid}<{@link Customer}>
	 */
	@GetMapping("/list")
	@RequiresPermissions("customer:list")
	public EasyDataGrid<Customer> findAll(@RequestParam(name = "page", defaultValue = "1") int pageIndex,
			@RequestParam(name = "rows", defaultValue = "20") int pageSize,
			@RequestParam(name = "searchValue", defaultValue = "") String searchStr) {
		return this.customerService.findAll(pageIndex, pageSize, searchStr);
	}

	/**
	 * 以JSON格式返回有效的客户清单
	 * 
	 * @since 1.0
	 * @return String
	 */
	@GetMapping("/json")
	@RequiresPermissions("customer:list")
	public List<Customer> jsonData() {
		return this.customerService.findAll(true);
	}

	/**
	 * 新增客户
	 * 
	 * @since 1.0
	 * @param request
	 * @return
	 */
	@PostMapping("/new")
	@RequiresPermissions("customer:new")
	public JsonResult<Customer> insert(HttpServletRequest request) {
		Customer customer = new Customer();
		customer.setCustomerCode(request.getParameter("customerCode"));
		customer.setCustomerName(request.getParameter("customerName"));
		customer.setShortName(request.getParameter("shortName"));
		customer.setCountry(request.getParameter("country"));
		customer.setCity(request.getParameter("city"));
		customer.setCustomerClass(request.getParameter("customerClass"));
		customer.setSalesPerson(Integer.parseInt(request.getParameter("salesPerson")));
		if (this.customerService.findOne(customer) != null) {
			return new JsonResult<Customer>(JsonResult.ERROR, "客户代码【" + customer.getCustomerCode() + "】已被使用，请使用其他客户代码");
		}
		if (true == this.customerService.insert(customer)) {
			return new JsonResult<Customer>(customer);
		} else {
			return new JsonResult<Customer>(JsonResult.ERROR, "新增客户出错！");
		}
	}

	/**
	 * 获取客户
	 * 
	 * @since 1.0
	 * @param customerId
	 *            客户编号
	 * @return
	 */
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") int customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		return this.customerService.findOne(customer);
	}

	/**
	 * 更新客户
	 * 
	 * @since 1.0
	 * @param customerId
	 *            客户编号
	 * @param request
	 * @return
	 */
	@PostMapping("/{id}")
	@RequiresPermissions("customer:edit")
	public JsonResult<Customer> update(@PathVariable("id") int customerId, HttpServletRequest request) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerCode(request.getParameter("customerCode"));
		customer.setCustomerName(request.getParameter("customerName"));
		customer.setShortName(request.getParameter("shortName"));
		customer.setCountry(request.getParameter("country"));
		customer.setCity(request.getParameter("city"));
		customer.setCustomerClass(request.getParameter("customerClass"));
		customer.setSalesPerson(Integer.parseInt(request.getParameter("salesPerson")));
		customer.setAvailable("on".equals(request.getParameter("available")));
		if (true == this.customerService.update(customer)) {
			return new JsonResult<Customer>(customer);
		} else {
			return new JsonResult<Customer>(JsonResult.ERROR, "修改客户出错！");
		}
	}

	/**
	 * 删除客户
	 * 
	 * @since 1.0
	 * @param customerId
	 *            客户编号
	 * @param request
	 * @return
	 */
	@DeleteMapping("/{id}")
	@RequiresPermissions("customer:delete")
	public JsonResult<Customer> delete(@PathVariable("id") int customerId, HttpServletRequest request) {
		if (true == this.customerService.delete(customerId)) {
			return new JsonResult<Customer>();
		} else {
			return new JsonResult<Customer>(JsonResult.ERROR, "删除客户出错！");
		}
	}

	/**
	 * 获取指定客户的地址清单
	 * 
	 * @since 1.0
	 * @param customerId
	 *            客户编号
	 * @return List<{@link CustomerSite}>
	 */
	@GetMapping("/{id}/sites")
	@RequiresPermissions("customer:list")
	public List<CustomerSite> findAllSitesByCustomer(@PathVariable(name = "id") int customerId) {
		if (0 == customerId) {
			return null;
		}
		return this.customerService.findAllSitesByCustomer(customerId);
	}

	/**
	 * 获取指定客户、指定用途的地址清单
	 * 
	 * @since 1.0
	 * @param customerId
	 *            客户编号
	 * @param sitePurpose
	 *            地址用途，可以是<code>bill_to</code>或是 <code>ship_to</code>
	 *            ，如果不在以上值列表中，程序会抛出{@link IllegalArgumentException}异常
	 * @return List<{@link CustomerSite}>
	 */
	@GetMapping("/{id}/sites/{purpose}")
	@RequiresPermissions("customer:list")
	public List<CustomerSite> findAllPurposeSitesByCustomer(@PathVariable(name = "id") int customerId,
			@PathVariable(name = "purpose") String sitePurpose) {
		if (0 == customerId) {
			return null;
		}
		if (!CustomerSite.BILL_TO.equals(sitePurpose.toUpperCase())
				&& !CustomerSite.SHIP_TO.equals(sitePurpose.toUpperCase())) {
			throw new IllegalArgumentException("地址用途【" + sitePurpose + "】未定义。");
		}
		return this.customerService.findAllPurposeSitesByCustomer(customerId, sitePurpose);
	}

	/**
	 * 创建新的客户地址
	 * 
	 * @since 1.0
	 * @param request
	 * @return
	 */
	@PostMapping("/{id}/sites/new")
	@RequiresPermissions("site:new")
	public JsonResult<CustomerSite> insertSite(HttpServletRequest request) {
		CustomerSite site = new CustomerSite();
		site.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		site.setSitePurpose(request.getParameter("sitePurpose"));
		site.setCountry(request.getParameter("country"));
		site.setProvince(request.getParameter("province"));
		site.setCity(request.getParameter("city"));
		site.setDistrict(request.getParameter("district"));
		site.setAddress(request.getParameter("address"));
		site.setZipCode(request.getParameter("zipCode"));
		site.setContact(request.getParameter("contact"));
		site.setPhone(request.getParameter("phone"));
		site.setEmail(request.getParameter("email"));
		site.setOthers(request.getParameter("others"));

		if (true == this.customerService.insertSite(site)) {
			return new JsonResult<CustomerSite>(site);
		} else {
			return new JsonResult<CustomerSite>(JsonResult.ERROR, "新增客户地址出错！");
		}
	}

	/**
	 * 获取客户地址
	 * 
	 * @since 1.0
	 * @param siteId
	 *            地址编号
	 * @return
	 */
	@GetMapping("/sites/{id}")
	public CustomerSite getCustomerSite(@PathVariable("id") int siteId) {
		return this.customerService.findOneSite(siteId);
	}

	/**
	 * 更新客户地址
	 * 
	 * @since 1.0
	 * @param siteId
	 *            地址编号
	 * @param request
	 * @return
	 */
	@PostMapping("/sites/{id}")
	@RequiresPermissions("site:edit")
	public JsonResult<CustomerSite> updateSite(@PathVariable("id") int siteId, HttpServletRequest request) {
		CustomerSite site = this.customerService.findOneSite(siteId);
		if (null == site) {
			return new JsonResult<CustomerSite>(JsonResult.ERROR, "指定的地址编号不存在！");
		}
		site.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		site.setSitePurpose(request.getParameter("sitePurpose"));
		site.setCountry(request.getParameter("country"));
		site.setProvince(request.getParameter("province"));
		site.setCity(request.getParameter("city"));
		site.setDistrict(request.getParameter("district"));
		site.setAddress(request.getParameter("address"));
		site.setZipCode(request.getParameter("zipCode"));
		site.setContact(request.getParameter("contact"));
		site.setPhone(request.getParameter("phone"));
		site.setEmail(request.getParameter("email"));
		site.setOthers(request.getParameter("others"));
		site.setAvailable("on".equals(request.getParameter("available")));

		if (true == this.customerService.updateSite(site)) {
			return new JsonResult<CustomerSite>(site);
		} else {
			return new JsonResult<CustomerSite>(JsonResult.ERROR, "修改客户地址出错！");
		}
	}

	/**
	 * 删除客户地址
	 * 
	 * @since 1.0
	 * @param siteId
	 *            地址编号
	 * @param request
	 * @return
	 */
	@DeleteMapping("/sites/{id}")
	@RequiresPermissions("site:delete")
	public JsonResult<CustomerSite> deleteSite(@PathVariable("id") int siteId, HttpServletRequest request) {
		if (true == this.customerService.deleteSite(siteId)) {
			return new JsonResult<CustomerSite>();
		} else {
			return new JsonResult<CustomerSite>(JsonResult.ERROR, "删除客户地址出错！");
		}
	}

}
