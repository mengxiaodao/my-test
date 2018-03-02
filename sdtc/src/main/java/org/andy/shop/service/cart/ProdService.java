package org.andy.shop.service.cart;

import org.andy.shop.model.cart.BuyerCart;
import org.andy.shop.model.cart.Prod;
import org.andy.shop.model.cart.dto.ProdDto;
import org.andy.shop.model.cart.vo.ProdVo;
import org.andy.shop.utils.Pagination;

/**
 * Created by mengchuang on 2018/2/26.
 */
public interface ProdService {
    /**
     * 分页查询商品列表
     * @param prodDto
     * @return
     */
    Pagination<ProdVo> getProdByDto(ProdDto prodDto);

    /**
     *将购物车加入到Redis缓存
     * @param buyerCart  购物车对象
     * @param key  redis唯一key值
     * @return
     */
    void insertBuyerCartToRedis(BuyerCart buyerCart, String key);

}
