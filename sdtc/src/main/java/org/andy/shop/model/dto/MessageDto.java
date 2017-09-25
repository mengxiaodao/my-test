package org.andy.shop.model.dto;

import org.andy.shop.utils.BaseDto;

public class MessageDto extends BaseDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msgName;//资源名称
	private Byte msgType;//资源类别，1广告大牌，2电视多媒体，3LED显示屏	
	private String  publishStartTime;//资源发布起始时间
	private String  publishEndTime;//资源发布结束时间
	
	public String getMsgName() {
		return msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public Byte getMsgType() {
		return msgType;
	}
	public void setMsgType(Byte msgType) {
		this.msgType = msgType;
	}
	public String getPublishStartTime() {
		return publishStartTime;
	}
	public void setPublishStartTime(String publishStartTime) {
		this.publishStartTime = publishStartTime;
	}
	public String getPublishEndTime() {
		return publishEndTime;
	}
	public void setPublishEndTime(String publishEndTime) {
		this.publishEndTime = publishEndTime;
	}
	
}
