/**
 * 
 */
package com.jrsoft.salesOrder;

/**
 * 销售订单状态枚举类型
 * 
 * <p>
 * </p>
 * <dl>
 * <dt>ENTERED</dt>
 * <dd>新录入的销售订单行状态</dd>
 * <dt>PLANNING</dt>
 * <dd>计划员排产中</dd>
 * <dt>LACK_MATERIAL</dt>
 * <dd>缺少原材料，无法下达生产工单</dd>
 * <dt>OPEN_PRODUCTION</dt>
 * <dd>已开工单，正在生产中</dd>
 * <dt>AWAITING_SHIPPING</dt>
 * <dd>等待发货，此状态下还需要财务部放行才可真正发货</dd>
 * <dt>CANCELED</dt>
 * <dd>此订单行已被取消</dd>
 * <dt>SHIPPED</dt>
 * <dd>此订单行已完成发货</dd>
 * </dl>
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public enum SalesOrderStateEnum {

	/**
	 * 新订单
	 */
	ENTERED(1, "新订单"),

	/**
	 * 计划中
	 */
	PLANNING(2, "计划中"),

	/**
	 * 缺料中
	 */
	LACK_MATERIAL(3, "缺料中"),

	/**
	 * 生产中
	 */
	OPEN_PRODUCTION(4, "生产中"),

	/**
	 * 财务放行
	 */
	AWAITING_SHIPPING(5, "等待发货"),

	/**
	 * 已发货
	 */
	SHIPPED(6, "已发货"),

	/**
	 * 已取消
	 */
	CANCELED(0, "取消");

	private int stateId;

	private String stateText;

	SalesOrderStateEnum(int stateId, String stateText) {
		this.stateId = stateId;
		this.stateText = stateText;
	}

	/**
	 * @return the code
	 */
	public int getStateId() {
		return stateId;
	}

	/**
	 * @return the message
	 */
	public String getStateText() {
		return stateText;
	}

}
