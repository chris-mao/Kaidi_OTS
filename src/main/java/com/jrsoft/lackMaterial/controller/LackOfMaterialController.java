/**
 * 
 */
package com.jrsoft.lackMaterial.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 缺料单控制器类，提供缺料单维护页面入口
 * 
 * LOM: Lack of Material
 * 
 * </p>
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/loms")
public class LackOfMaterialController {
	
	/**
	 * 缺料单列表页面访问入口
	 * 
	 * @return
	 */
	@GetMapping({ "", "/index" })
	@RequiresPermissions("lom:list")
	public String index() {
		return "lom/index";
	}

}
