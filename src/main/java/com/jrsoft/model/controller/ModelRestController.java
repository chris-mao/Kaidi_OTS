/**
 * 
 */
package com.jrsoft.model.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 产品型号控制器类，提供产品型号维护API方法接口
 * <dl>
 * <dt>GET: models/api/list?page=1&rows=20&searchValue=</dt>
 * <dd>按页码返回（符合查询条件或是全部）产品数据列表，需要拥有<code>model:list</code>权限</dd>
 * <dt>GET: models/api/json</dt>
 * <dd>返回全部有效的（available=1）产品数据列表，需要拥有<code>model:list</code>权限</dd>
 * <dt>POST: models/api/new</dt>
 * <dd>新建产品数据，需要拥有<code>model:new</code>权限</dd>
 * <dt>GET: models/api/{id}</dt>
 * <dd>获取产品数据，需要拥有<code>model:list</code>权限</dd>
 * <dt>POST: models/api/{id}</dt>
 * <dd>更新产品数据，需要拥有<code>model:edit</code>权限</dd>
 * <dt>DELETE: models/api/{id}</dt>
 * <dd>删除产品数据，需要拥有<code>model:delete</code>权限</dd>
 * </dl>
 * </p>
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/models/api")
public class ModelRestController {

}
