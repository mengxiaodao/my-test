package org.andy.shop.model.cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mengchuang on 2018/2/26.
 * 商品对象
 */
public class Prod implements Serializable{
    /**
     * 商品主键id
     */
    private Long id;
    /**
     * 商品编码
     */
    private String productCode;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品保质期，保质期（天） 0表示无保质期要求
     */
    private Integer qualityPeriod;
    /**
     * 是否删除 0:未删除 1:已删除
     */
    private Integer isDeleted;
    private Date createTime;
    private Date updateTime;
    /**
     * 商品单价
     */
    private BigDecimal pmPrice;

    public BigDecimal getPmPrice() {
        return pmPrice;
    }

    public void setPmPrice(BigDecimal pmPrice) {
        this.pmPrice = pmPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQualityPeriod() {
        return qualityPeriod;
    }

    public void setQualityPeriod(Integer qualityPeriod) {
        this.qualityPeriod = qualityPeriod;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
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
