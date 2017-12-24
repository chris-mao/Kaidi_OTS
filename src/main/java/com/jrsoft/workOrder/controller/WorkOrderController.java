/**
 * 
 */
package com.jrsoft.workOrder.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>生产工单控制器类，提供生产工单维护页面入口</p>
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/wos")
public class WorkOrderController {
	
	/**
	 * 生产工单列表页面访问入口
	 * 
	 * @return
	 */
	@GetMapping({ "", "/index" })
	@RequiresPermissions("wo:list")
	public String index() {
		return "wo/index";
	}

}
