/**
 * 
 */
package com.jrsoft.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jrsoft.model.dao.sqlprovider.ModelDynaSqlProvider;
import com.jrsoft.model.entity.Model;

/**
 * 产品型号数据访问接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface ModelDAO {

	/**
	 * 查询所有产品型号
	 * 
	 * @since 1.0
	 * @param onlyAvailable
	 *            布尔值，为treu显查询available=1的产品型号，否则查询所有产品型号
	 * @return
	 */
	@SelectProvider(method = "findAllSql", type = ModelDynaSqlProvider.class)
	@Results({ @Result(property = "modelId", column = "model_id", id = true),
			@Result(property = "modelNum", column = "model_num"),
			@Result(property = "modelName", column = "model_name"),
			@Result(property = "specification", column = "specification"),
			@Result(property = "categoryId", column = "category_id"),
			@Result(property = "categoryName", column = "category_name"),
			@Result(property = "hasTechDoc", column = "has_tech_doc"),
			@Result(property = "techDocETA", column = "tech_doc_eta"),
			@Result(property = "techDocATA", column = "tech_doc_ata"), @Result(property = "hasBom", column = "has_bom"),
			@Result(property = "bomETA", column = "bom_eta"), @Result(property = "bomATA", column = "bom_eta"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<Model> findAll(@Param(value = "available") boolean onlyAvailable);

	/**
	 * 按编号查询产品型号
	 * 
	 * @since 1.0
	 * @param id
	 *            产品型号编号
	 * @return
	 */
	@Select("SELECT model_id, model_num, model_name, specification, category_id, category_Name, has_tech_doc, tech_doc_eta, tech_doc_ata, has_bom, bom_eta, bom_ata, available, created_time, update_time FROM vw_model WHERE model_id = #{id}")
	@Results({ @Result(property = "modelId", column = "model_id", id = true),
			@Result(property = "modelNum", column = "model_num"),
			@Result(property = "modelName", column = "model_name"),
			@Result(property = "specification", column = "specification"),
			@Result(property = "categoryId", column = "category_id"),
			@Result(property = "categoryName", column = "category_name"),
			@Result(property = "hasTechDoc", column = "has_tech_doc"),
			@Result(property = "techDocETA", column = "tech_doc_eta"),
			@Result(property = "techDocATA", column = "tech_doc_ata"), @Result(property = "hasBom", column = "has_bom"),
			@Result(property = "bomETA", column = "bom_eta"), @Result(property = "bomATA", column = "bom_eta"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Model findById(@Param(value = "id") int id);

	/**
	 * 按型号查询产品型号
	 * 
	 * @since 1.0
	 * @param modelNum
	 *            产品型号
	 * @return
	 */
	@Select("SELECT model_id, model_num, model_name, specification, category_id, category_Name, has_tech_doc, tech_doc_eta, tech_doc_ata, has_bom, bom_eta, bom_ata, available, created_time, update_time FROM vw_model WHERE model_num = #{modelNum}")
	@Results({ @Result(property = "modelId", column = "model_id", id = true),
			@Result(property = "modelNum", column = "model_num"),
			@Result(property = "modelName", column = "model_name"),
			@Result(property = "specification", column = "specification"),
			@Result(property = "categoryId", column = "category_id"),
			@Result(property = "categoryName", column = "category_name"),
			@Result(property = "hasTechDoc", column = "has_tech_doc"),
			@Result(property = "techDocETA", column = "tech_doc_eta"),
			@Result(property = "techDocATA", column = "tech_doc_ata"), @Result(property = "hasBom", column = "has_bom"),
			@Result(property = "bomETA", column = "bom_eta"), @Result(property = "bomATA", column = "bom_eta"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Model findByNum(@Param(value = "modelNum") String modelNum);

	/**
	 * 按名称查询产品型号
	 * 
	 * @since 1.0
	 * @param modelName
	 *            产品名称
	 * @return
	 */
	@Select("SELECT model_id, model_num, model_name, specification, category_id, category_Name, has_tech_doc, tech_doc_eta, tech_doc_ata, has_bom, bom_eta, bom_ata, available, created_time, update_time FROM vw_model WHERE model_name = #{name}")
	@Results({ @Result(property = "modelId", column = "model_id", id = true),
			@Result(property = "modelNum", column = "model_num"),
			@Result(property = "modelName", column = "model_name"),
			@Result(property = "specification", column = "specification"),
			@Result(property = "categoryId", column = "category_id"),
			@Result(property = "categoryName", column = "category_name"),
			@Result(property = "hasTechDoc", column = "has_tech_doc"),
			@Result(property = "techDocETA", column = "tech_doc_eta"),
			@Result(property = "techDocATA", column = "tech_doc_ata"), @Result(property = "hasBom", column = "has_bom"),
			@Result(property = "bomETA", column = "bom_eta"), @Result(property = "bomATA", column = "bom_eta"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public Model findByName(@Param(value = "name") String modelName);

	/**
	 * 按产品型号或是产品名称模糊查询产品
	 * 
	 * @since 1.0
	 * @param model
	 * @return
	 */
	@Select("SELECT model_id, model_num, model_name, specification, category_id, category_Name, has_tech_doc, tech_doc_eta, tech_doc_ata, has_bom, bom_eta, bom_ata, available, created_time, update_time FROM vw_model WHERE model_num LIKE #{modelNum} OR model_name LIKE #{modelName}")
	@Results({ @Result(property = "modelId", column = "model_id", id = true),
			@Result(property = "modelNum", column = "model_num"),
			@Result(property = "modelName", column = "model_name"),
			@Result(property = "specification", column = "specification"),
			@Result(property = "categoryId", column = "category_id"),
			@Result(property = "categoryName", column = "category_name"),
			@Result(property = "hasTechDoc", column = "has_tech_doc"),
			@Result(property = "techDocETA", column = "tech_doc_eta"),
			@Result(property = "techDocATA", column = "tech_doc_ata"), @Result(property = "hasBom", column = "has_bom"),
			@Result(property = "bomETA", column = "bom_eta"), @Result(property = "bomATA", column = "bom_eta"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<Model> fuzzyQuery(Model model);

	/**
	 * 按类别查询产品型号
	 * 
	 * @since 1.0
	 * @param categoryId
	 * @return
	 */
	@Select("SELECT model_id, model_num, model_name, specification, category_id, category_Name, has_tech_doc, tech_doc_eta, tech_doc_ata, has_bom, bom_eta, bom_ata, available, created_time, update_time FROM vw_model WHERE category_id = #{categoryId}")
	@Results({ @Result(property = "modelId", column = "model_id", id = true),
			@Result(property = "modelNum", column = "model_num"),
			@Result(property = "modelName", column = "model_name"),
			@Result(property = "specification", column = "specification"),
			@Result(property = "categoryId", column = "category_id"),
			@Result(property = "categoryName", column = "category_name"),
			@Result(property = "hasTechDoc", column = "has_tech_doc"),
			@Result(property = "techDocETA", column = "tech_doc_eta"),
			@Result(property = "techDocATA", column = "tech_doc_ata"), @Result(property = "hasBom", column = "has_bom"),
			@Result(property = "bomETA", column = "bom_eta"), @Result(property = "bomATA", column = "bom_eta"),
			@Result(property = "available", column = "available"),
			@Result(property = "createdTime", column = "created_time"),
			@Result(property = "updateTime", column = "update_time") })
	public List<Model> findAllByCategory(@Param(value = "categoryId") int categoryId);

	/**
	 * 创建新产品型号
	 * 
	 * @since 1.0
	 * @param department
	 * @return 受影响的行数
	 */
	@Insert("INSERT INTO model(model_num, model_name, specification, category_id, has_tech_doc, tech_doc_eta, tech_doc_ata, has_bom, bom_eta, bom_ata, available, created_time) VALUES(#{modelNum}, #{modelName}, #{specification}, #{categoryId}, #{hasTechDoc}, #{techDocETA}, #{techDocATA}, #{hasBom}, #{bomETA}, #{bomATA}, #{available}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "modelId")
	public int insert(Model model);

	/**
	 * 更新产品型号
	 * 
	 * @since 1.0
	 * @param department
	 * @return 受影响的行数
	 */
	@Update("UPDATE model SET model_num = #{modelNum}, model_name = #{modelName}, specification = #{specification}, category_id = #{categoryId}, has_tech_doc = #{hasTechDoc}, tech_doc_eta = #{techDocETA}, tech_doc_ata = #{techDocATA}, has_bom = #{haasBom}, bom_eta = #{bomETA}, bom_ata = #{bomATA},  available = #{available} WHERE model_id = #{modelId}")
	public int udpate(Model model);

	/**
	 * 删除产品型号
	 * 
	 * @since 1.0
	 * @param id
	 * @return 受影响的行数
	 */
	@Delete("DELETE FROM model WHERE model_id = #{id}")
	public int delete(@Param(value = "id") int id);

}
