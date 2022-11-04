package com.necor.mq.common;

import org.springframework.util.ObjectUtils;


/**
 * 响应消息
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public final class ResponseData {
	
	/** 消息类型 */
	private Integer code;
	
	/** 消息内容 */
	private String msg;
	
	/** 响应数据 */
	Object data;

	private ResponseData(){
	
	}

	private ResponseData(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private ResponseData(Integer code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		if(!ObjectUtils.isEmpty(data)){
			this.data = data;
		}
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 添加消息
	 * @param type 消息类型
	 * @param msg 消息内容
	 * @return 消息对象
	 */
	public static ResponseData message(ResponseDataEnum type, String msg){
		return new ResponseData(type.ordinal(),msg);
	}

	/**
	 * 添加消息
	 * @param type 消息类型
	 * @param msg 消息内容
	 * @return 消息对象
	 */
	public static ResponseData message(ResponseDataEnum type, String msg, Object data){
		return new ResponseData(type.ordinal(),msg,data);
	}
	
	/**
	 * 添加成功消息
	 * @param msg 消息内容
	 * @return 消息对象
	 */
	public static ResponseData success(String msg, Object data){
		return new ResponseData(ResponseDataEnum.SUCCESS.ordinal(),msg,data);
	}
	
	/**
	 * 添加成功消息
	 * @param msg 消息内容
	 * @return 消息对象
	 */
	public static ResponseData success(String msg){
		return new ResponseData(ResponseDataEnum.SUCCESS.ordinal(),msg,null);
	}
	
	/**
	 * 添加警告消息
	 * @param msg 消息内容
	 * @return 消息对象
	 */
	public static ResponseData warning(String msg, Object data){
		return new ResponseData(ResponseDataEnum.WARNING.ordinal(),msg,data);
	}
	
	/**
	 * 添加警告消息
	 * @param msg 消息内容
	 * @return 消息对象
	 */
	public static ResponseData warning(String msg){
		return new ResponseData(ResponseDataEnum.WARNING.ordinal(),msg,null);
	}
	
	/**
	 * 添加失败消息
	 * @param msg 消息内容
	 * @return 消息对象
	 */
	public static ResponseData failure(String msg, Object data){
		return new ResponseData(ResponseDataEnum.FAILURE.ordinal(),msg,data);
	}
	
	/**
	 * 添加失败消息
	 * @param msg 消息内容
	 * @return 消息对象
	 */
	public static ResponseData failure(String msg){
		return new ResponseData(ResponseDataEnum.FAILURE.ordinal(),msg,null);
	}
	
	/**
	 * 添加响应数据
	 * @param data 响应数据
	 * @return 消息对象
	 */
	public ResponseData data(Object data){
		this.data = data;
		return this;
	}
	
}
