package com.jrsoft.auth.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>系统角色控制器类，提供系统角色维护页面入口</p>
 * 
 * com.jrsoft.auth.controller AuthRoleController
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/roles")
public class AuthRoleController {

	/**
	 * 系统角色页面访问入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@GetMapping({ "", "/index" })
	@RequiresPermissions("authRole:list")
	public String roleList() {
		return "auth/role";
	}
}
