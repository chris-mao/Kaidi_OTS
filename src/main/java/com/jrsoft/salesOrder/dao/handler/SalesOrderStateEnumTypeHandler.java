package com.jrsoft.salesOrder.dao.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.jrsoft.salesOrder.SalesOrderStateEnum;

/**
 * 
 * com.jrsoft.salesOrder.dao.handler SalesOrderStateEnumTypeHandler
 * 
 * 订单状态类型转换类，用于将数据表中的数值转为Java中的枚举类型
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class SalesOrderStateEnumTypeHandler extends BaseTypeHandler<SalesOrderStateEnum> {

	private Class<SalesOrderStateEnum> typeClass;

	private SalesOrderStateEnum[] enums;

	public SalesOrderStateEnumTypeHandler(Class<SalesOrderStateEnum> typeClass) {
		if (null == typeClass) {
			throw new IllegalArgumentException("Type argument cannot be null.");
		}
		this.typeClass = typeClass;
		this.enums = typeClass.getEnumConstants();
		if (null == this.enums) {
			throw new IllegalArgumentException(typeClass.getSimpleName() + " does not repserent an enum type.");
		}
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, SalesOrderStateEnum parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.getStateId());
	}

	@Override
	public SalesOrderStateEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int stateId = rs.getInt(columnName);
		return rs.wasNull() ? null : translateToSalesOrderStateEnum(stateId);
	}

	@Override
	public SalesOrderStateEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int stateId = rs.getInt(columnIndex);
		return rs.wasNull() ? null : translateToSalesOrderStateEnum(stateId);
	}

	@Override
	public SalesOrderStateEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int stateId = cs.getInt(columnIndex);
		return cs.wasNull() ? null : translateToSalesOrderStateEnum(stateId);
	}

	private SalesOrderStateEnum translateToSalesOrderStateEnum(int stateId) {
		SalesOrderStateEnum result = null;
		for (SalesOrderStateEnum orderState : this.enums) {
			if (orderState.getStateId() == stateId) {
				result = orderState;
				break;
			}
		}
		if (result == null) {
			throw new IllegalArgumentException("数值" + stateId + ", 未在枚举类型中 " + typeClass.getSimpleName() + "定义，请检查！");
		}
		return result;
	}

}
