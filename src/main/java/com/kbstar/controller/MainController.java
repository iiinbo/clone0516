package com.kbstar.controller;


import ch.qos.logback.classic.Logger;
import com.kbstar.dto.Cart;
import com.kbstar.dto.Product;
import com.kbstar.dto.User;
import com.kbstar.service.CartService;
import com.kbstar.service.ProductService;
import com.kbstar.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@Controller
public class MainController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;
    Logger logger;
    String dir = "shop/";
    // 0- 초기화면 : 127.0.0.1
    @RequestMapping("/")
    public String main(Model model) throws Exception {
        // selectAll 사용
        List<Product> list = null;
            list = productService.get();

        // list에 담은 Product를 브라우저 화면에 보여주기(jsp파일에 입력 시 명칭 allproduct)
        model.addAttribute("allproduct", list);

        return "index";
    }
    // 1-1 로그인화면 : 127.0.0.1/login
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login"); // center에 login페이지 표출
        return "index";
    }
//loginimpl
@RequestMapping("/loginimpl")
public String loginimpl(Model model, String user_id, String user_pwd, HttpSession session) throws Exception {
    String nextPage = "loginfail";
    try {
        User user = userService.get(user_id);
        if (user != null && user.getUser_pwd().equals(user_pwd)) {
            session.setMaxInactiveInterval(100000);
            session.setAttribute("loginuser", user);
            model.addAttribute("center", dir + "center");
            //아이디와 비밀번호가 맞으면, shop center로 랜딩
        } else {
            model.addAttribute("center", nextPage);
            //그 외의 경우 nextpage
        }
    } catch (Exception e) {
        logger.error(e.getMessage());
        nextPage = "loginfail";
    }

    return "index";
}
    //
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register"); // center에 login페이지 표출
        return "index";
    }
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model,
                               @Validated User user, Errors errors, HttpSession session) throws Exception {
        if(errors.hasErrors()){
            List<ObjectError> ex = errors.getAllErrors();
            for(ObjectError e:ex){
                log.info("------------------------");
                log.info(e.getDefaultMessage());
            }
            throw new Exception("형식 오류"+errors.toString());
        }
        try {
            userService.register(user);
            session.setAttribute("loginuser",user);
        } catch (Exception e) {
            throw new Exception("가입 오류");
        }
        model.addAttribute("ruser", user);
        model.addAttribute("center",dir+"center");
        return "index";
    }

    @RequestMapping("/updateimpl")
    public String updateimpl(Model model,
                               @Validated User user, Errors errors, HttpSession session) throws Exception {
        if(errors.hasErrors()){
            List<ObjectError> ex = errors.getAllErrors();
            for(ObjectError e:ex){
                log.info("------------------------");
                log.info(e.getDefaultMessage());
            }
            throw new Exception("형식 오류"+errors.toString());
        }
        try {
            userService.modify(user);
            session.setAttribute("updateuser",user);
        } catch (Exception e) {
            throw new Exception("가입 오류");
        }
        model.addAttribute("ruser", user);
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/profile")
    public String profile(Model model, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("loginuser");
        String userId = user.getUser_id();
        User profileUser = userService.get(userId);
        model.addAttribute("userinfo", profileUser);
        model.addAttribute("center", "profile");
        return "index";
    }
    @RequestMapping("/changeInfo")
    public String changeInfo(Model model, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("loginuser");
        if (user == null) {
            throw new Exception("user is not logged in");
        }
        // 로그인한 사용자의 아이디를 이용해 사용자 정보를 조회
        User userInfo = userService.get(user.getUser_id());
        model.addAttribute("center", "changeInfo");
        return "index";
    }

    @GetMapping("/checkUserId")
    @ResponseBody
    public String checkUserId(@RequestParam String user_id) throws Exception {
        // userId가 이미 DB에 존재하는지 확인하는 로직을 작성합니다.
        // 존재한다면 true, 아니면 false를 반환합니다.
        User user;
        try {
            user = userService.get(user_id);
        } catch (Exception e) {
            throw new Exception("아이디를 확인해주세요");
        }
        if (user != null) {
            return "fail";
        }
        return "success";
    }

    @RequestMapping("/addcart")
    public Object addcart(Model model, Cart cart) throws Exception {
        cartService.register(cart);
        return "redirect:/shop/"; // shop의 한번에보기 페이지로 바로 이동.
    }
}