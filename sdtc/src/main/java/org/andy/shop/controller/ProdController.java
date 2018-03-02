package org.andy.shop.controller;

import org.andy.shop.model.Message;
import org.andy.shop.model.User;
import org.andy.shop.model.cart.BuyerCart;
import org.andy.shop.model.cart.BuyerItem;
import org.andy.shop.model.cart.ProdStock;
import org.andy.shop.model.cart.dto.ProdDto;
import org.andy.shop.model.cart.vo.ProdStockVo;
import org.andy.shop.model.cart.vo.ProdVo;
import org.andy.shop.service.cart.ProdService;
import org.andy.shop.utils.Pagination;
import org.andy.shop.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by mengchuang on 2018/2/26.
 */
@Controller
@RequestMapping("/buyerCartManage")
public class ProdController {
    @Resource
    private ProdService prodService;

    @RequestMapping("/pageInit.do")
    public ModelAndView pageInit(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/cart/prodList"); //返回的文件名
        return mav;
    }
    /**
     * 分页查询商品列表
     * @param prodDto
     * @return
     */
    @RequestMapping(value="/getProdList.do")
    @ResponseBody
    public Pagination<ProdVo> getProdList(ProdDto prodDto) {
        Pagination<ProdVo> prodVoPagination = prodService.getProdByDto(prodDto);
        return prodVoPagination;
    }

    /**
     * 添加商品到购物车
     * @param skuId  skuid
     * @param amount 购买数量
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/addGoodsToCart.do")
    @ResponseBody
    public Result addGoodsToCart(Long skuId, Integer amount, HttpServletRequest request,
             HttpServletResponse response) {
        Result result = new Result();
        try {
            //初始化购物车
            BuyerCart buyerCart = new BuyerCart();
            //3, 将当前款商品追加到购物车
            if (null != skuId && null != amount) {
                ProdStockVo sku = new ProdStockVo();
                sku.setId(skuId);
                //购物项
                BuyerItem buyerItem = new BuyerItem();
                buyerItem.setProdStockVo(sku);
                //设置数量
                buyerItem.setAmount(amount);
                //添加购物项到购物车
                buyerCart.addItem(buyerItem);
            }
            //登录了
            //4, 将购物车追加到Redis中
            HttpSession session = request.getSession(false); //得到session对象
            //取出会话数据
            User user = (User) session.getAttribute("user");
            String key = "buyerCart"+ String.valueOf(user.getId());

            prodService.insertBuyerCartToRedis(buyerCart,key);
        } catch (Exception e) {
            e.printStackTrace();
            result.set("插入失败", false);
        }
        result.set("插入成功", true);
        return result;
    }

}
