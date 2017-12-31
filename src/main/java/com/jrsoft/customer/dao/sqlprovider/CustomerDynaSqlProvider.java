package com.jrsoft.customer.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * 
 * com.jrsoft.customer.dao.sqlprovider CustomerDynaSqlProvider
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class CustomerDynaSqlProvider {

	/**
	 * 根据参数动态生成查询客户的SQL语句
	 * 
	 * @param onlyAvailable
	 * @return
	 */
	public String findAllSql(boolean onlyAvailable) {
		return new SQL() {
			{
				SELECT("customer_id, customer_code, short_name, customer_name, customer_class, country, city, sales_person, sales_person_name, available, created_time, update_time");
				FROM("vw_customer");
				if (onlyAvailable) {
					WHERE("available = 1");
				}
				ORDER_BY("customer_code");
			}
		}.toString();
	}

}
