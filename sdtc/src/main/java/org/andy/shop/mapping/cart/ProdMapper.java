package org.andy.shop.mapping.cart;

import org.andy.shop.model.Message;
import org.andy.shop.model.cart.Prod;
import org.andy.shop.model.cart.dto.ProdDto;
import org.andy.shop.model.cart.vo.ProdVo;
import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.vo.MessageVo;

import java.util.List;


public interface ProdMapper {

    /**
     * 分页查询商品列表
     * @param prodDto
     * @return
     */
    List<ProdVo> getProdByDto(ProdDto prodDto);

    /**
     * 统计商品总数
     * @param prodDto
     * @return
     */
    Integer countProdByDto(ProdDto prodDto);

}