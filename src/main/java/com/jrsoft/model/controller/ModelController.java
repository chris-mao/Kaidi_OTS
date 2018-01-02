/**
 * 
 */
package com.jrsoft.model.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>产品型号控制器类，提供产品型号维护页面入口</p>
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/models")
public class ModelController {

	/**
	 * 产品型号管理页面访问入口
	 * 
	 * @return
	 */
	@GetMapping({ "", "/index" })
	@RequiresPermissions("model:list")
	public String index() {
		return "model/index";
	}

}
