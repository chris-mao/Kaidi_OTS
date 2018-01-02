/**
 * 
 */
package com.jrsoft.model.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * com.jrsoft.model.dao.sqlprovider ModelDynaSqlProvider
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class ModelDynaSqlProvider {
	
	/**
	 * 根据参数动态生成查询员工的SQL语句
	 * 
	 * @param onlyAvailable
	 * @return
	 */
	public String findAllSql(boolean onlyAvailable) {
		return new SQL(){{
			SELECT("model_id, model_num, model_name, specification, category_id, category_Name, has_tech_doc, tech_doc_eta, tech_doc_ata, has_bom, bom_eta, bom_ata, available, created_time, update_time");
			FROM("vw_model");
			if (onlyAvailable) {
				WHERE("available = 1");
			}
			ORDER_BY("model_num");
		}}.toString();
	}

}
