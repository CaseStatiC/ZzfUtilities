package com.zzfutilities.javacommon;

public class JavaUtil {
/**
 * 当前方法的名字
 */
	String	methodName	= Thread.currentThread().getStackTrace()[1]
								.getMethodName();

}
