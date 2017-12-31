/**
 * 
 */
package com.jrsoft.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.jrsoft.customer.dao.sqlprovider.CustomerDynaSqlProvider;
import com.jrsoft.customer.entity.Customer;
import com.jrsoft.customer.entity.CustomerSite;

/**
 * 客户数据访问接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface CustomerDAO {

	/**
	 * 查询所有客户
	 * 
	 * @param onlyAvailable
	 * @return
	 */
	@SelectProvider(method = "findAllSql", type = CustomerDynaSqlProvider.class)
	@Results({ @Result(property = "customerId", column = "customer_id", id = true),
			@Result(property = "customerCode", column = "customer_code"),
			@Result(property = "customerName", column = "customer_name"),
			@Result(property = "shortName", column = "short_name"),
			@Result(property = "customerClass", column = "customer_class"),
			@Result(property = "country", column = "country"), @Result(property = "city", column = "city"),
			@Result(property = "salesPerson", column = "sales_person"),
			@Result(property = "salesPersonName", column = "sales_person_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<Customer> findAll(@Param(value = "available") boolean onlyAvailable);

	/**
	 * 按客户编号查询
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT customer_id, customer_code, short_name, customer_name, customer_class, country, city, sales_person, sales_person_name, available, created_time, update_time FROM vw_customer WHERE customer_id = #{id}")
	@Results({ @Result(property = "customerId", column = "customer_id", id = true),
			@Result(property = "customerCode", column = "customer_code"),
			@Result(property = "customerName", column = "customer_name"),
			@Result(property = "shortName", column = "short_name"),
			@Result(property = "customerClass", column = "customer_class"),
			@Result(property = "country", column = "country"), @Result(property = "city", column = "city"),
			@Result(property = "salesPerson", column = "sales_person"),
			@Result(property = "salesPersonName", column = "sales_person_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Customer findById(@Param(value = "id") int id);

	/**
	 * 按客户代码查询
	 * 
	 * @param customerCode
	 * @return
	 */
	@Select("SELECT customer_id, customer_code, short_name, customer_name, customer_class, country, city, sales_person, sales_person_name, available, created_time, update_time FROM vw_customer WHERE customer_code = #{code}")
	@Results({ @Result(property = "customerId", column = "customer_id", id = true),
			@Result(property = "customerCode", column = "customer_code"),
			@Result(property = "customerName", column = "customer_name"),
			@Result(property = "shortName", column = "short_name"),
			@Result(property = "customerClass", column = "customer_class"),
			@Result(property = "country", column = "country"), @Result(property = "city", column = "city"),
			@Result(property = "salesPerson", column = "sales_person"),
			@Result(property = "salesPersonName", column = "sales_person_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Customer findByCode(@Param(value = "code") String customerCode);

	/**
	 * 按客户名称查询
	 * 
	 * @param customerName
	 * @return
	 */
	@Select("SELECT customer_id, customer_code, short_name, customer_name, customer_class, country, city, sales_person, sales_person_name, available, created_time, update_time FROM vw_customer WHERE customer_name =#{name}")
	@Results({ @Result(property = "customerId", column = "customer_id", id = true),
			@Result(property = "customerCode", column = "customer_code"),
			@Result(property = "customerName", column = "customer_name"),
			@Result(property = "shortName", column = "short_name"),
			@Result(property = "customerClass", column = "customer_class"),
			@Result(property = "country", column = "country"), @Result(property = "city", column = "city"),
			@Result(property = "salesPerson", column = "sales_person"),
			@Result(property = "salesPersonName", column = "sales_person_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Customer findByName(@Param(value = "name") String customerName);

	/**
	 * 按客户简称查询
	 * 
	 * @param shortName
	 * @return
	 */
	@Select("SELECT customer_id, customer_code, short_name, customer_name, customer_class, country, city, sales_person, sales_person_name, available, created_time, update_time FROM vw_customer WHERE short_name = #{shortName}")
	@Results({ @Result(property = "customerId", column = "customer_id", id = true),
			@Result(property = "customerCode", column = "customer_code"),
			@Result(property = "customerName", column = "customer_name"),
			@Result(property = "shortName", column = "short_name"),
			@Result(property = "customerClass", column = "customer_class"),
			@Result(property = "country", column = "country"), @Result(property = "city", column = "city"),
			@Result(property = "salesPerson", column = "sales_person"),
			@Result(property = "salesPersonName", column = "sales_person_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Customer findByShortName(@Param(value = "shortName") String shortName);

	/**
	 * 按客户代码或是客户简称查询客户
	 * 
	 * @param customer
	 * @return
	 */
	@Select("SELECT customer_id, customer_code, short_name, customer_name, customer_class, country, city, sales_person, sales_person_name, available, created_time, update_time FROM vw_customer WHERE customer_code LIKE #{customerCode} OR short_name LIKE #{shortName}")
	@Results({ @Result(property = "customerId", column = "customer_id", id = true),
			@Result(property = "customerCode", column = "customer_code"),
			@Result(property = "customerName", column = "customer_name"),
			@Result(property = "shortName", column = "short_name"),
			@Result(property = "customerClass", column = "customer_class"),
			@Result(property = "country", column = "country"), @Result(property = "city", column = "city"),
			@Result(property = "salesPerson", column = "sales_person"),
			@Result(property = "salesPersonName", column = "sales_person_name"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<Customer> fuzzyQuery(Customer customer);

	// public List<Customer> findAllByEmployee();

	/**
	 * 新增客户
	 * 
	 * @param customer
	 * @return
	 */
	@Options(useGeneratedKeys = true, keyProperty = "customerId")
	public int insert(Customer customer);

	/**
	 * 更新客户
	 * 
	 * @param customer
	 * @return
	 */
	public int udpate(Customer customer);

	/**
	 * 删除客户
	 * 
	 * @param id
	 *            客户编号
	 * @return
	 */
	@Delete("DELETE FROM customer WHERE customer_id = #{id}")
	public int delete(@Param(value = "id") int id);

	/**
	 * 查询客户所有地址
	 * 
	 * @param customerId
	 *            客户编号
	 * @return
	 */
	public List<CustomerSite> findAllSiteByCustomer(int customerId);

	/**
	 * 查询客户用途地址
	 * 
	 * @param customerId
	 *            客户编号
	 * @param sitePurpose
	 *            地址用途
	 * @return
	 */
	public List<CustomerSite> findAllPurposeSiteByCustomer(int customerId, String sitePurpose);

	/**
	 * 新增客户地址
	 * 
	 * @param site
	 * @return
	 */
	@Options(useGeneratedKeys = true, keyProperty = "siteId")
	public int insertSite(CustomerSite site);

	/**
	 * 更新客户地址
	 * 
	 * @param site
	 * @return
	 */
	public int udpateSite(CustomerSite site);

	/**
	 * 删除客户地址
	 * 
	 * @param id
	 *            地址编号
	 * @return
	 */
	@Delete("DELETE FROM customer_site WHERE customer_id = #{id}")
	public int deleteSite(@Param(value = "id") int id);
}
