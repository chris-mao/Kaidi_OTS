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
 * @deprecated
 *
 */
public interface SalesOrderLineService extends AbstractDbService<SalesOrderLine> {

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
	 *            订单行状态 {@link SalesOrderLineStateEnum}
	 * @return
	 */
	public boolean updateLinesState(List<Integer> salesOrderIds, SalesOrderLineStateEnum state);

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

}
