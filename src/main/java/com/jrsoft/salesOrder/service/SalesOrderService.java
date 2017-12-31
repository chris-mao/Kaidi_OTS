/**
 * 
 */
package com.jrsoft.salesOrder.service;

import java.util.List;
import java.util.Map;

import com.jrsoft.app.service.AbstractDbService;
import com.jrsoft.common.EasyDataGrid;
import com.jrsoft.salesOrder.SalesOrderStateEnum;
import com.jrsoft.salesOrder.entity.SalesOrder;

/**
 * 销售订单头业务接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface SalesOrderService extends AbstractDbService<SalesOrder> {

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
	public EasyDataGrid<SalesOrder> findAll(int pageIndex, int pageSize, Map<String, String> params);

	/**
	 * 取消销售订单
	 * 
	 * @since 1.0
	 * @param salesOrderIds
	 *            销售订单编号，多个编号使用逗号分隔
	 * @return
	 */
	public boolean cancelSalesOrder(List<Integer> salesOrderIds);

	/**
	 * 财务放行销售订单
	 * 
	 * @since 1.0
	 * @param salesOrderIds
	 *            订单编号，多个编号之间使用逗号分隔
	 * @return
	 */
	public boolean financeRelease(List<Integer> salesOrderIds);

	/**
	 * 品质放行销售订单
	 * 
	 * @since 1.0
	 * @param salesOrderIds
	 *            订单行号，多个行号之间使用逗号分隔
	 * @return
	 */
	public boolean qualityRelease(List<Integer> salesOrderIds);

	/**
	 * 更新订单状态
	 * 
	 * @since 1.0
	 * @param salesOrderIds
	 *            订单编号，多个编号之间使用逗号分隔
	 * @param state
	 *            订单行状态 {@link SalesOrderStateEnum}
	 * @return
	 */
	public boolean updateState(List<Integer> salesOrderIds, SalesOrderStateEnum state);

	/**
	 * 更新订单预计交期
	 * 
	 * @since 1.0
	 * @param salesOrderIds
	 *            订单编号，多个编号之间使用逗号分隔
	 * @param etd
	 *            预估交期
	 * @return
	 */
	public boolean updateETD(List<Integer> salesOrderIds, String etd);

	/**
	 * 更新订单行实际交期，同时把订单行状态变更为Shipped状态
	 * 
	 * @since 1.0
	 * @param salesOrderIds
	 *            订单编号，多个编号之间使用逗号分隔
	 * @param atd
	 *            实际交期
	 * @return
	 */
	public boolean updateATD(List<Integer> salesOrderIds, String atd);
	
	public int splitSaleOrder();

}
