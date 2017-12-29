/**
 * 
 */
package com.jrsoft.workOrder.service;

import java.util.List;
import java.util.Map;

import com.jrsoft.app.service.AbstractDbService;
import com.jrsoft.common.EasyDataGrid;
import com.jrsoft.workOrder.entity.WorkOrder;

/**
 * 生产工单业务接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface WorkOrderService extends AbstractDbService<WorkOrder> {
	
	/**
	 * 按给定的查询条件查询生产工单
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
	public EasyDataGrid<WorkOrder> findAll(int pageIndex, int pageSize, Map<String, String> params);

	/**
	 * 获取销售订单行对应的生产工单
	 * 
	 * @since 1.0
	 * @param lineId
	 *            销售订单行编号
	 * @return
	 */
	public List<WorkOrder> findAllBySalesOrderLine(int lineId);

	/**
	 * 获取销售订单对应的所有生产工单
	 * 
	 * @since 1.0
	 * @param saleOrderId
	 *            销售订单编号
	 * @return
	 */
	public List<WorkOrder> findAllBySalesOrder(int saleOrderId);

	/**
	 * 取消生产工单
	 * 
	 * @since 1.0
	 * @param workOrderIds
	 *            生产工单编号，多个编号之间使用逗号分隔
	 * @return
	 */
	public boolean cancelWorkOrder(List<Integer> workOrderIds);

	/**
	 * 更新生产工单的预估完成日期
	 * 
	 * @since 1.0
	 * @param workOrderIds
	 *            生产工单编号，多个编号之间使用逗号分隔
	 * @param etf
	 *            预估完成日期
	 * @return
	 */
	public boolean updateETF(List<Integer> workOrderIds, String etf);

	/**
	 * 更新生产工单的实际完成日期
	 * 
	 * @since 1.0
	 * @param workOrderIds
	 *            生产工单编号，多个编号之间使用逗号分隔
	 * @param atf
	 *            实际完成日期
	 * @return
	 */
	public boolean updateATF(List<Integer> workOrderIds, String atf);

}
