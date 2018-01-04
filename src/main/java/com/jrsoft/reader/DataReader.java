/**
 * 
 */
package com.jrsoft.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

/**
 * 外部文件读取接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface DataReader<T> {

	/**
	 * 读取外部文件，将文件中的每一行数据转为指定的泛型
	 * 
	 * @since 1.0
	 * @param inputFileName
	 *            外部文件名称
	 * @return
	 * @throws IOException
	 *             如果文件不存在，抛出 {@link IOException}异常
	 * @throws DataFormatException
	 *             如果文件格式不正确，抛出 {@link DataFormatException}异常
	 */
	public ArrayList<T> readFile(String inputFileName) throws IOException, DataFormatException;
}
