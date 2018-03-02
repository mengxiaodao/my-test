package org.andy.shop.model.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengchuang on 2018/2/26.
 */
public class BuyerCart implements Serializable {
    /**
     * 购物车
     */
    private static final long serialVersionUID = 1L;

    //购物项结果集
    private List<BuyerItem> items = new ArrayList<>();

    //添加购物项到购物车
    public void addItem(BuyerItem item){
        //判断是否包含同款
        if (items.contains(item)) {
            //追加数量
            for (BuyerItem buyerItem : items) {
                if (buyerItem.equals(item)) {
                    buyerItem.setAmount(item.getAmount() + buyerItem.getAmount());
                }
            }
        }else {
            items.add(item);
        }

    }

    public List<BuyerItem> getItems() {
        return items;
    }

    public void setItems(List<BuyerItem> items) {
        this.items = items;
    }


    //小计
    //商品数量
    @JsonIgnore
    public Integer getProductAmount(){
        Integer result = 0;
        //计算
        for (BuyerItem buyerItem : items) {
            result += buyerItem.getAmount();
        }
        return result;
    }

    //商品金额
    @JsonIgnore
    public BigDecimal getProductPrice(){
        BigDecimal result = new BigDecimal(0);
        //计算
        for (BuyerItem buyerItem : items) {
            BigDecimal nowData = buyerItem.getProdStockVo().getPmPrice().multiply(new BigDecimal(buyerItem.getAmount()));
            result = result.add(nowData) ;
        }
        return result;
    }

    //运费
    @JsonIgnore
    public BigDecimal getFee(){
        BigDecimal result = new BigDecimal(0);
        //计算
        if (this.getProductPrice() != null && this.getProductPrice().compareTo(new BigDecimal(79)) == -1) {
            result = new BigDecimal(5);
        }

        return result;
    }

    //总价
    @JsonIgnore
    public BigDecimal getTotalPrice(){
        return this.getProductPrice().add(this.getFee());
    }
}
