/**
 * 
 */
package com.jrsoft.reader.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

import com.jrsoft.reader.DataReader;
import com.jrsoft.salesOrder.entity.SalesOrder;

/**
 * 销售订单读取类
 * 
 * <p>
 * 从外部文件中的读取销售订单数据并转为销售订单实体类
 * </p>
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class SalesOrderReader implements DataReader<SalesOrder> {

	@Override
	public ArrayList<SalesOrder> readFile(String inputFileName) throws IOException, DataFormatException {
		// TODO Auto-generated method stub
		return null;
	}

}
