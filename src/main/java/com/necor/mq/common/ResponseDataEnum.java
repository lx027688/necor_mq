package com.necor.mq.common;

/**
 * 消息类型Enum
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public enum ResponseDataEnum {
	
	/** 成功 */
	SUCCESS,
	
	/** 警告 */
	WARNING,
	
	/** 失败 */
	FAILURE,

	/** 无权限 */
	UN_AUTH,

	/** 未登陆 */
	UN_LOGIN;
}
