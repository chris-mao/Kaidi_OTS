/**
 * 
 */
package com.jrsoft.salesOrder.service;

import java.util.List;

import com.jrsoft.salesOrder.entity.SalesOrderLineChangeDetail;

/**
 * 销售订单行变更业务接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface DataChangeService {

	/**
	 * 获取销售订单行变更详情
	 * 
	 * @since 1.0
	 * @param lineId
	 *            销售订单行编号
	 * @return List<{@link SalesOrderLineChangeDetail}>
	 */
	public List<SalesOrderLineChangeDetail> findAllChanges(int lineId);

}
