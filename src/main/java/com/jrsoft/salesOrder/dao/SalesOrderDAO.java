/**
 * 
 */
package com.jrsoft.salesOrder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.jrsoft.salesOrder.SalesOrderStateEnum;
import com.jrsoft.salesOrder.dao.handler.SalesOrderStateEnumTypeHandler;
import com.jrsoft.salesOrder.entity.SalesOrder;

/**
 * 销售订单数据访问接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface SalesOrderDAO {

	// @SelectProvider(method = "findAllSql", type =
	// AuthUserDynaSqlProvider.class)
	@Results({ @Result(property = "orderId", column = "order_id", id = true),
			@Result(property = "orderType", column = "order_type"),
			@Result(property = "userName", column = "user_name"), @Result(property = "nickName", column = "nick_name"),
			@Result(property = "email", column = "email"), @Result(property = "password", column = "user_psd"),
			@Result(property = "state", column = "state", javaType = SalesOrderStateEnum.class, typeHandler = SalesOrderStateEnumTypeHandler.class),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<SalesOrder> findAll();

}
