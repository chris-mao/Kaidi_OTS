/**
 * 
 */
package com.jrsoft.workOrder.service;

import java.util.List;

import com.jrsoft.workOrder.entity.WorkOrderChangeDetail;

/**
 * 生产工单变更业务接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface DataChangeService {

	/**
	 * 获取生产工单变更详情
	 * 
	 * @since 1.0
	 * @param workOrderId
	 *            生产工单编号
	 * @return List<{@link WorkOrderChangeDetail}>
	 */
	public List<WorkOrderChangeDetail> findAllChanges(int workOrderId);
}
