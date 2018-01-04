/**
 * 
 */
package com.jrsoft.reader.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

import com.jrsoft.reader.DataReader;
import com.jrsoft.workOrder.entity.WorkOrder;

/**
 * 生产工单读取类
 * 
 * <p>
 * 从外部文件中的读取生产工单数据并转为生产工单实体类
 * </p>
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public class WorkOrderReader implements DataReader<WorkOrder> {

	@Override
	public ArrayList<WorkOrder> readFile(String inputFileName) throws IOException, DataFormatException {
		// TODO Auto-generated method stub
		return null;
	}

}
