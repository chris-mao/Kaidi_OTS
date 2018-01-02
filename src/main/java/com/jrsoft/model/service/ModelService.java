/**
 * 
 */
package com.jrsoft.model.service;

import java.util.List;

import com.jrsoft.app.service.AbstractDbService;
import com.jrsoft.model.entity.Model;

/**
 * com.jrsoft.model.service ModelService
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface ModelService extends AbstractDbService<Model> {
	
	/**
	 * 按类别查询产品型号
	 * 
	 * @since 1.0
	 * @param categoryId
	 *            类别编号
	 * @return
	 */
	public List<Model> findAllByCategory(int categoryId);

}
