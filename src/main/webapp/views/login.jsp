<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
  $(function () {
    login_form.init();
  })
</script>

<section class="signin-page account">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
          <a class="logo" href="/">
            <img src="images/logo.png" alt="" width="110px">
          </a>
          <h2 class="text-center">Welcome</h2>

          <form id="login_form" class="text-left clearfix" ><%-- Main Controller --%>
          <%-- form : button type="button" --%>
            <div class="form-group">
              <input type="text" class="form-control"  placeholder="ID" name="user_id" id="user_id" placeholder="ID를 입력해 주세요"/>
            </div>
            <div class="form-group">
              <input type="password" class="form-control" name="user_pwd"  id="user_pwd" placeholder="Password를 입력해 주세요"/>
            </div>
            <div class="text-center">
              <button type="button" id="login_btn" class="btn btn-main text-center" >Login</button>
            </div>
          </form>
          <p class="mt-20">제품을 구매하시겠어요 ?<a href="/register">  회원가입하기</a></p>
        </div>
      </div>
    </div>
  </div>
</section>

