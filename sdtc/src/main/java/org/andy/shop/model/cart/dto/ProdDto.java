package org.andy.shop.model.cart.dto;

import org.andy.shop.utils.BaseDto;

/**
 * Created by mengchuang on 2018/2/26.
 */
public class ProdDto extends BaseDto{
    private String productCode;//商品编码

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
