/**
 * 
 */
package com.jrsoft.salesOrder.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrsoft.auth.utils.AuthUtils;

/**
 * <p>
 * 销售订单控制器类，提供销售订单维护页面入口
 * </p>
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/salesorders")
public class SalesOrderController {

	/**
	 * 销售订单列表页面访问入口
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping({ "", "/index" })
	// @RequiresPermissions("so:list")
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute("currentUser", AuthUtils.getCurrentUser());
		return "so/index";
	}
	
	/**
	 * 新建销售订单
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping("/new")
	public String newSalesOrder(HttpServletRequest request, Model model) {
		model.addAttribute("currentUser", AuthUtils.getCurrentUser());
		return "so/new";
	}

}
