package com.jrsoft.salesOrder.service;

import java.util.List;

import com.jrsoft.app.service.AbstractDbService;
import com.jrsoft.salesOrder.SalesOrderLineStateEnum;
import com.jrsoft.salesOrder.entity.SalesOrderLine;

/**
 * 
 * 销售订单行业务接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface SalesOrderLineService extends AbstractDbService<SalesOrderLine> {

	/**
	 * 获取订单明细
	 * 
	 * @since 1.0
	 * @param salesOrderId
	 *            销售订单编号
	 * @return
	 */
	public List<SalesOrderLine> findAllBySalesOrder(int salesOrderId);

	/**
	 * 取消销售订单行
	 * 
	 * @since 1.0
	 * @param salesOrderId
	 *            销售订单编号
	 * @param lineId
	 *            订单行号，多个行号之间使用逗号分隔
	 * @return
	 */
	public boolean cancelSalesOrderLines(int salesOrderId, List<Integer> salesOrderIds);

	/**
	 * 放行销售计单行
	 * 
	 * @since 1.0
	 * @param salesOrderId
	 *            销售订单编号
	 * @param lineIndexs
	 *            订单行号，多个行号之间使用逗号分隔
	 * @return
	 */
	public boolean releaseSalesOrderLines(int salesOrderId, List<Integer> salesOrderIds);

	/**
	 * 更新订单行状态
	 * 
	 * @since 1.0
	 * @param salesOrderId
	 *            销售订单编号
	 * @param lineIndexs
	 *            订单行号，多个行号之间使用逗号分隔
	 * @param state
	 *            订单行状态 {@link SalesOrderLineStateEnum}
	 * @return
	 */
	public boolean updateLineState(int salesOrderId, List<Integer> lineIndexs, SalesOrderLineStateEnum state);

	/**
	 * 更新订单行预估交期
	 * 
	 * @since 1.0
	 * @param lineIds
	 *            订单行编号，多个编号之间使用逗号分隔
	 * @param etd
	 *            预估交期
	 * @return
	 */
	public boolean updateETD(List<Integer> lineIds, String etd);

	/**
	 * 更新订单行预估交期
	 * 
	 * @since 1.0
	 * @param salesOrderId
	 *            销售订单编号
	 * @param lineIndexs
	 *            订单行号，多个行号之间使用逗号分隔
	 * @param etd
	 *            预估交期
	 * @return
	 */
	public boolean updateETD(int salesOrderId, List<Integer> lineIndexs, String etd);

	/**
	 * 更新订单行实际交期，同时把订单行状态变更为Shipped状态
	 * 
	 * @since 1.0
	 * @param lineIds
	 *            订单行编号，多个编号之间使用逗号分隔
	 * @param atd
	 *            实际交期
	 * @return
	 */
	public boolean updateATD(List<Integer> lineIds, String atd);

	/**
	 * 更新订单行实际交期，同时把订单行状态变更为Shipped状态
	 * 
	 * @since 1.0
	 * @param salesOrderId
	 *            销售订单编号
	 * @param lineIndexs
	 *            订单行号，多个行号之间使用逗号分隔
	 * @param atd
	 *            实际交期
	 * @return
	 */
	public boolean updateATD(int salesOrderId, List<Integer> lineIndexs, String atd);

}
