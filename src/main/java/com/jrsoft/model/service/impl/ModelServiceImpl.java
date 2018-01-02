/**
 * 
 */
package com.jrsoft.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jrsoft.common.EasyDataGrid;
import com.jrsoft.model.dao.ModelDAO;
import com.jrsoft.model.entity.Model;
import com.jrsoft.model.service.ModelService;

/**
 * 产品型号服务接口实现类
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@Service
public class ModelServiceImpl implements ModelService {

	/**
	 * 
	 */
	@Autowired
	private ModelDAO modelDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.app.service.AbstractDbService#findAll()
	 */
	@Override
	public List<Model> findAll() {
		return modelDAO.findAll(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.app.service.AbstractDbService#findAll(boolean)
	 */
	@Override
	public List<Model> findAll(boolean onlyAvailable) {
		return modelDAO.findAll(onlyAvailable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.app.service.AbstractDbService#findAll(int, int)
	 */
	@Override
	public PageInfo<Model> findAll(int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		return new PageInfo<Model>(modelDAO.findAll(false));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.app.service.AbstractDbService#findAll(int, int,
	 * java.lang.String)
	 */
	@Override
	public EasyDataGrid<Model> findAll(int pageIndex, int pageSize, String searchStr) {
		PageInfo<Model> pageInfo;
		if (searchStr.isEmpty()) {
			pageInfo = this.findAll(pageIndex, pageSize);
		} else {
			Model m = new Model();
			m.setModelName("%" + searchStr + "%");
			m.setSpecification("%" + searchStr + "%");
			PageHelper.startPage(pageIndex, pageSize);
			pageInfo = new PageInfo<Model>(modelDAO.fuzzyQuery(m));
		}

		EasyDataGrid<Model> dg = new EasyDataGrid<Model>();
		dg.setTotal(pageInfo.getTotal());
		dg.setRows(pageInfo.getList());
		return dg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.app.service.AbstractDbService#findOne(java.lang.Object)
	 */
	@Override
	public Model findOne(Model entity) {
		if (0 != entity.getModelId()) {
			return modelDAO.findById(entity.getModelId());
		}
		if (null != entity.getModelName()) {
			return modelDAO.findByName(entity.getModelName());
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.app.service.AbstractDbService#insert(java.lang.Object)
	 */
	@Override
	public boolean insert(Model entity) {
		return 1 == modelDAO.insert(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.app.service.AbstractDbService#update(java.lang.Object)
	 */
	@Override
	public boolean update(Model entity) {
		return 1 == modelDAO.udpate(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.app.service.AbstractDbService#delete(int)
	 */
	@Override
	public boolean delete(int id) {
		return 1 == modelDAO.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.model.service.ModelService#findAllByCategory(int)
	 */
	@Override
	public List<Model> findAllByCategory(int categoryId) {
		if (categoryId == 0) {
			return null;
		}
		return modelDAO.findAllByCategory(categoryId);
	}

}
