package org.andy.shop.model.cart;

import org.andy.shop.model.cart.vo.ProdStockVo;

import java.io.Serializable;

/**
 * Created by mengchuang on 2018/2/26.
 * 购物项
 */
public class BuyerItem implements Serializable{
    private static final long serialVersionUID = 1L;

    //SKu对象
    private ProdStockVo prodStockVo;

    //是否有货
    private Boolean isHave = true;

    //购买的数量
    private Integer amount = 1;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ProdStockVo getProdStockVo() {
        return prodStockVo;
    }

    public void setProdStockVo(ProdStockVo prodStockVo) {
        this.prodStockVo = prodStockVo;
    }

    public Boolean getHave() {
        return isHave;
    }

    public void setHave(Boolean have) {
        isHave = have;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prodStockVo == null) ? 0 : prodStockVo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) //比较地址
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyerItem other = (BuyerItem) obj;
        if (prodStockVo == null) {
            if (other.prodStockVo != null)
                return false;
        } else if (!prodStockVo.getId().equals(other.prodStockVo.getId()))
            return false;
        return true;
    }
}
