package org.andy.shop.service.cart.impl;

import org.andy.shop.mapping.cart.ProdMapper;
import org.andy.shop.model.cart.BuyerCart;
import org.andy.shop.model.cart.BuyerItem;
import org.andy.shop.model.cart.dto.ProdDto;
import org.andy.shop.model.cart.vo.ProdVo;
import org.andy.shop.service.cart.ProdService;
import org.andy.shop.service.redisUtil.RedisCacheUtil;
import org.andy.shop.utils.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mengchuang on 2018/2/26.
 */
@Service
public class ProdServiceImpl implements ProdService{
    @Resource
    private ProdMapper prodMapper;
    @Resource
    private RedisCacheUtil redisCacheUtil;
    /**
     * 分页查询商品列表
     * @param prodDto
     * @return
     */
    @Override
    public Pagination<ProdVo> getProdByDto(ProdDto prodDto) {
        Pagination<ProdVo> pagination = new Pagination<ProdVo>();
        Integer count = prodMapper.countProdByDto(prodDto);
        if (count == 0) {
            pagination.setTotal(count);
            return pagination;
        }
        List<ProdVo> prodVos = prodMapper.getProdByDto(prodDto);
        pagination.setRows(prodVos); //返回列表
        pagination.setTotal(count);//总条数
        return pagination;
    }

    /**
     * 将购物车加入到Redis缓存
     * @param buyerCart 购物车对象
     * @param key  redis唯一key值
     * @return
     */
    @Override
    public void insertBuyerCartToRedis(BuyerCart buyerCart, String key) {
        List<BuyerItem> items = buyerCart.getItems();
        if (items.size() > 0) {
            //redis中保存的是skuId 为key , amount 为value的Map集合
            Map<String, Object> hash = new HashMap<>();
            for (BuyerItem item : items) {
                Long num = 0l;
                if(item.getAmount() != null){
                    num = item.getAmount().longValue();
                }
                //判断是否有同款
                if (redisCacheUtil.existHashKey(key, String.valueOf(item.getProdStockVo().getId()))) {
                    //有的话直接添加数量
                    redisCacheUtil.incrementHashKey(key, String.valueOf(item.getProdStockVo().getId()),num );
                }else {
                    // TODO: 2018/2/28 num修改为string 
                    hash.put(String.valueOf(item.getProdStockVo().getId()), String.valueOf(num));
                }
            }
            if (hash.size() > 0) {
                redisCacheUtil.addMap(key, hash);
            }
        }
    }
}
