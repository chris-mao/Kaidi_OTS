/**
 * 
 */
package com.jrsoft.lackMaterial.service;

import java.util.List;
import java.util.Map;

import com.jrsoft.app.service.AbstractDbService;
import com.jrsoft.common.EasyDataGrid;
import com.jrsoft.lackMaterial.entity.LackMaterial;

/**
 * 缺料单业务接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface LackMaterialService extends AbstractDbService<LackMaterial> {
	
	/**
	 * 按给定的查询条件查询缺料单
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
	public EasyDataGrid<LackMaterial> findAll(int pageIndex, int pageSize, Map<String, String> params);

	/**
	 * 获取销售订单行对应的缺料单
	 * 
	 * @since 1.0
	 * @param lineId
	 *            销售订单行编号
	 * @return
	 */
	public List<LackMaterial> findAllBySalesOrderLine(int lineId);

	/**
	 * 获取销售订单对应的所有缺料单
	 * 
	 * @since 1.0
	 * @param saleOrderId
	 *            销售订单编号
	 * @return
	 */
	public List<LackMaterial> findAllBySalesOrder(int saleOrderId);

	/**
	 * 取消缺料单
	 * 
	 * @since 1.0
	 * @param lackIds
	 *            缺料单编号，多个编号之间使用逗号分隔
	 * @return
	 */
	public boolean cancelWorkOrder(List<Integer> lackIds);

	/**
	 * 更新缺料单的预估到达日期和采购单号
	 * 
	 * @since 1.0
	 * @param lackIds
	 *            缺料单编号，多个编号之间使用逗号分隔
	 * @param purchaseNumber
	 *            采购单号
	 * @param eta
	 *            预估到达日期
	 * @return
	 */
	public boolean updateETA(List<Integer> lackIds, String purchaseNumber, String eta);

	/**
	 * 更新缺料单的预估到达日期
	 * 
	 * @since 1.0
	 * @param lackIds
	 *            缺料单编号，多个编号之间使用逗号分隔
	 * @param eta
	 *            预估到达日期
	 * @return
	 */
	public boolean updateETA(List<Integer> lackIds, String eta);

	/**
	 * 更新缺料单的实际到达日期
	 * 
	 * @since 1.0
	 * @param lackIds
	 *            缺料单编号，多个编号之间使用逗号分隔
	 * @param ata
	 *            实际到达日期
	 * @return
	 */
	public boolean updateATA(List<Integer> lackIds, String ata);

}
