/**
 * 
 */
package com.jrsoft.lackMaterial.service;

import java.util.List;

import com.jrsoft.lackMaterial.entity.LackMaterialChangeDetail;

/**
 * 缺料单变更业务接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface DataChangeService {

	/**
	 * 获取缺料单变更详情
	 * 
	 * @since 1.0
	 * @param lackId
	 *            缺料单编号
	 * @return List<{@link LackMaterialChangeDetail}>
	 */
	public List<LackMaterialChangeDetail> findAllChanges(int lackId);

}
