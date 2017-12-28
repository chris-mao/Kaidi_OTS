/**
 * 
 */
package com.jrsoft.salesOrder.service;

import java.util.List;
import java.util.Map;

import com.jrsoft.app.service.AbstractDbService;
import com.jrsoft.common.EasyDataGrid;
import com.jrsoft.salesOrder.entity.SalesOrderHeader;

/**
 * 销售订单头业务接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface SalesOrderService extends AbstractDbService<SalesOrderHeader> {

	/**
	 * 按给定的查询条件查询销售订单
	 * 
	 * @since 1.0
	 * @param pageIndex
	 *            页码
	 * @param pageSize
	 *            分页大小
	 * @param params
	 *            查询条件键值对
	 * @return
	 */
	public EasyDataGrid<SalesOrderHeader> findAll(int pageIndex, int pageSize, Map<String, String> params);

	/**
	 * 取消销售订单
	 * 
	 * @since 1.0
	 * @param salesOrderIds
	 *            销售订单编号，多个编号使用逗号分隔
	 * @return
	 */
	public boolean cancelSalesOrder(List<Integer> salesOrderIds);

}
