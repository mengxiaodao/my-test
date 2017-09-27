package org.andy.shop.model;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
public class Message {
    private Long id;	//主键资源id

    private String msgName;//资源名称

    private BigDecimal msgPrice;//资源价格
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishTime;//资源发布时间

    private Byte msgType;//资源类别，1广告大牌，2电视多媒体，3LED显示屏	

    private Integer provinceId;//资源所属省份id

    private Integer cityId;//资源所属城市id

    private Date createTime;//资源创建时间

    private Date updateTime;//资源修改时间
    
    public  Message(){
    	
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName == null ? null : msgName.trim();
    }

    public BigDecimal getMsgPrice() {
		return msgPrice;
	}

	public void setMsgPrice(BigDecimal msgPrice) {
		this.msgPrice = msgPrice;
	}

	public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Byte getMsgType() {
        return msgType;
    }

    public void setMsgType(Byte msgType) {
        this.msgType = msgType;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}