package org.andy.shop.model.cart;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mengchuang on 2018/2/26.
 * 库存对象
 */
public class ProdStock implements Serializable{
    //商品库存ID,skuId
    private Long id;
    //商品ID
    private Long pmInfoId;
    //商品颜色，商品颜色，0黑色，1白色，2红色
    private Integer pmColor;
    //商品大小，0代表L，1代表XL，2代表xxl
    private Integer pmSize;
    //商品实际库存
    private Long realStockNum;
    //最后一次更新时间
    private Date updateTime;
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

    public Long getPmInfoId() {
        return pmInfoId;
    }

    public void setPmInfoId(Long pmInfoId) {
        this.pmInfoId = pmInfoId;
    }

    public Integer getPmColor() {
        return pmColor;
    }

    public void setPmColor(Integer pmColor) {
        this.pmColor = pmColor;
    }

    public Integer getPmSize() {
        return pmSize;
    }

    public void setPmSize(Integer pmSize) {
        this.pmSize = pmSize;
    }

    public Long getRealStockNum() {
        return realStockNum;
    }

    public void setRealStockNum(Long realStockNum) {
        this.realStockNum = realStockNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
