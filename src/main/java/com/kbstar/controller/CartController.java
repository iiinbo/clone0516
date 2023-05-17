package com.kbstar.controller;


import com.kbstar.dto.Cart;
import com.kbstar.dto.Product;
import com.kbstar.dto.User;
import com.kbstar.service.CartService;
import com.kbstar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

// 컨트롤러 설명 : Product를 담고, 담은 상품 중 order하기 위한 기능을 담당하는 곳.
// 로그인 한 고객만 이용 가능(미로그인 후 선택 시 로그인유도)
// 로그인 시, 담은 상품 한눈에 보기 - 주문하기 연동 등
@Slf4j
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;

    @Value("${uploadimgdir}") // 이렇게 세팅하면, 애플리케이션 프로퍼티에  정해둔, simg/ 폴더에 집어넣는다.
    String imgdir;
    String dir = "cart/";


    // 1- cart 기본페이지 : 로그인한 고객이 담은 상품 전체조회
    // 127.0.0.1/cart?user_id=${loginuser.user_id} ** session에 로그인정보 담으면, url바꿀 것. **
    @RequestMapping("")
    public String main(Model model, String user_id) throws Exception {
        List<Cart> list = null; // 카트 정보 불러올 바구니 준비.
        try {
            list = cartService.getmycart( user_id ); // 카트 정보를 list에 담기.
        } catch (Exception e) {
            throw new Exception(e);
        }
        model.addAttribute("mycart", list);
        // center에 cart 페이지 표출
        model.addAttribute("center", dir + "center");

        return "index";
    }

    // cart 조회 페이지에서 product_id별 삭제하기.
    // 127.0.0.1/cart/remove?product_id=${obj.product_id}
    @RequestMapping("/remove")
    public String remove(Model model, Integer product_id, HttpSession session) throws Exception {

        try {
            cartService.remove(product_id);
            if(session != null){ // ses 정보 남아있어야 삭제 완료 > 본페이지 이동
                User user = (User) session.getAttribute("loginuser");
                return "redirect:/cart?user_id="+user.getUser_id();
                //회원의 장바구니 페이지로 회귀하기.

            }else{
                return "index"; // ses 정보 사라지면 > 홈으로 이동
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    // cart 페이지로 product 추가하기. -> 본 컨트롤러가 아닌, AjaximplController에서 처리한다.
    // 이유 : 장바구니에 카트 담고, 다른 페이지 이동이 아니라- 본 페이지에 남아있게 하기 위함.
    // 127.0.0.1/cart/addcart


}
