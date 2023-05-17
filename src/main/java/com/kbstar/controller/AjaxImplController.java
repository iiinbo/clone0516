package com.kbstar.controller;


import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // ajax에서 요청이 들어오면 그 요청을 받고 전달하는 곳! @RestController
public class AjaxImplController {
    @Autowired
    CartService cartService;
    String dir = "shop/";
    @Value("${uploadimgdir}") // 이미지 즉시 저장경로
    String imgdir;

    // 카트 추가하면 본 페이지에 남도록 ajaximpl 컨트롤러를 통해 정보 보내보기.
//    @RequestMapping("/addcart")
//    public Object addcart(Model model, Cart cart) throws Exception {
//        cartService.register(cart);
//        model.addAttribute("center", dir + "center");
//        return "index"; // 낫띵.
//    }


}
