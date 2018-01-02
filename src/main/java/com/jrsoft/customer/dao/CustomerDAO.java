/**
 * 
 */
package com.jrsoft.customer.dao;

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
	 * @since 1.0
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
	 * @since 1.0
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
	 * @since 1.0
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
	 * @since 1.0
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
	 * @since 1.0
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
	 * @since 1.0
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

	/**
	 * 新增客户
	 * 
	 * @since 1.0
	 * @param customer
	 * @return
	 */
	@Insert("INSERT INTO customer(customer_code, short_name, customer_name, customer_class, country, city, sales_person, available, created_time) VALUES(#{customerCode}, #{shortName}, #{customerName}, #{customerClass}, #{country}, #{city}, #{salesPerson}, #{available}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "customerId")
	public int insert(Customer customer);

	/**
	 * 更新客户
	 * 
	 * @since 1.0
	 * @param customer
	 * @return
	 */
	@Update("UPDATE customer SET customer_code = #{customerCode}, short_name = #{shortName}, customer_name = #{customerName}, customer_class = #{customerClass}, country = #{country}, city = #{city}, sales_person = #{salesPerson}, available = #{available} WHERE customer_id = #{customerId}")
	public int update(Customer customer);

	/**
	 * 删除客户
	 * 
	 * @since 1.0
	 * @param id
	 *            客户编号
	 * @return
	 */
	@Delete("DELETE FROM customer WHERE customer_id = #{id}")
	public int delete(@Param(value = "id") int id);

	/**
	 * 按地址编号查询地址
	 * 
	 * @since 1.0
	 * @param siteId
	 *            地址编号
	 * @return
	 */
	@Select("SELECT site_id, customer_id, site_purpose, country, province, city, district, address, address_text, zip_code, phone, contact, email, others, available, created_time, update_time FROM vw_customer_site WHERE site_id = #{id}")
	@Results({ @Result(property = "siteId", column = "site_id", id = true),
			@Result(property = "customerId", column = "customer_id"),
			@Result(property = "sitePurpose", column = "site_purpose"),
			@Result(property = "country", column = "country"), @Result(property = "province", column = "province"),
			@Result(property = "city", column = "city"), @Result(property = "district", column = "district"),
			@Result(property = "address", column = "address"),
			@Result(property = "addressText", column = "address_text"),
			@Result(property = "zipCode", column = "zip_code"), @Result(property = "phone", column = "phone"),
			@Result(property = "contact", column = "contact"), @Result(property = "email", column = "email"),
			@Result(property = "others", column = "others"), @Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public CustomerSite findOneSite(@Param(value = "id") int siteId);

	/**
	 * 查询客户所有地址
	 * 
	 * @since 1.0
	 * @param customerId
	 *            客户编号
	 * @return
	 */
	@Select("SELECT site_id, customer_id, site_purpose, country, province, city, district, address, address_text, zip_code, phone, contact, email, others, available, created_time, update_time FROM vw_customer_site WHERE customer_id = #{id} ORDER BY site_purpose, address_text")
	@Results({ @Result(property = "siteId", column = "site_id", id = true),
			@Result(property = "customerId", column = "customer_id"),
			@Result(property = "sitePurpose", column = "site_purpose"),
			@Result(property = "country", column = "country"), @Result(property = "province", column = "province"),
			@Result(property = "city", column = "city"), @Result(property = "district", column = "district"),
			@Result(property = "address", column = "address"),
			@Result(property = "addressText", column = "address_text"),
			@Result(property = "zipCode", column = "zip_code"), @Result(property = "phone", column = "phone"),
			@Result(property = "contact", column = "contact"), @Result(property = "email", column = "email"),
			@Result(property = "others", column = "others"), @Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<CustomerSite> findAllSitesByCustomer(@Param(value = "id") int customerId);

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
	@Select("SELECT site_id, customer_id, site_purpose, country, province, city, district, address, address_text, zip_code, phone, contact, email, others, available, created_time, update_time FROM vw_customer_site WHERE customer_id = #{id} AND site_purpose = #{purpose} ORDER BY site_purpose, address_text")
	@Results({ @Result(property = "siteId", column = "site_id", id = true),
			@Result(property = "customerId", column = "customer_id"),
			@Result(property = "sitePurpose", column = "site_purpose"),
			@Result(property = "country", column = "country"), @Result(property = "province", column = "province"),
			@Result(property = "city", column = "city"), @Result(property = "district", column = "district"),
			@Result(property = "address", column = "address"),
			@Result(property = "addressText", column = "address_text"),
			@Result(property = "zipCode", column = "zip_code"), @Result(property = "phone", column = "phone"),
			@Result(property = "contact", column = "contact"), @Result(property = "email", column = "email"),
			@Result(property = "others", column = "others"), @Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<CustomerSite> findAllPurposeSitesByCustomer(@Param(value = "id") int customerId,
			@Param(value = "purpose") String sitePurpose);

	/**
	 * 新增客户地址
	 * 
	 * @since 1.0
	 * @param site
	 * @return
	 */
	@Insert("INSERT INTO customer_site(customer_id, site_purpose, country, province, city, district, address, zip_code, phone, contact, email, others, available, created_time) VALUES(#{customerId}, #{sitePurpose}, #{country}, #{province}, #{city}, #{district}, #{address}, #{zipCode}, #{phone}, #{contact}, #{email}, #{others}, #{available}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "siteId")
	public int insertSite(CustomerSite site);

	/**
	 * 更新客户地址
	 * 
	 * @since 1.0
	 * @param site
	 * @return
	 */
	@Update("UPDATE customer_site SET customer_id = #{customerId}, site_purpose = #{sitePurpose}, country = #{country}, province = #{province}, city = #{city}, district = #{district}, address = #{address}, zip_code = #{zipCode}, phone = #{phone}, contact = #{contact}, email = #{email}, others = #{others}, available = #{available} WHERE site_id = #{siteId}")
	public int updateSite(CustomerSite site);

	/**
	 * 删除客户地址
	 * 
	 * @since 1.0
	 * @param id
	 *            地址编号
	 * @return
	 */
	@Delete("DELETE FROM customer_site WHERE site_id = #{id}")
	public int deleteSite(@Param(value = "id") int id);
}
