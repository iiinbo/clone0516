<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
  // 장바구니 담기 기능
  // let  product_add = {
  //   init:function (){
  //     $('#cart_addbtn').click(function (){
  //         // 여기서 모달 호출 가능(ex. 장바구니에 성공적으로 상품을 담았습니다.)
  //         $('#myModal').modal();
  //       }
  //     );
  //   }
  // };
  // 화면에 접속 되면 로그인폼 객체에 이닛을 출력해라
  $(function (){
    product_add.init();
  });
</script>
<!-- center 시작 구간 -->
<section class="page-header">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="content">
          <h1 class="page-name">Shop</h1>
          <ol class="breadcrumb">
            <li><a href="/">Home</a></li>
            <li class="active"><a href="/shop">shop</a></li>
          </ol>
        </div>
      </div>
    </div>
  </div>
</section>

<%-- 각각의 Product가 담긴 영역 --%>
<section class="products section">

  <div class="container">

    <div class="row">
      <c:forEach  var="obj" items="${allproduct}" >
      <div class="col-md-4">

        <div class="product-item">
            <div class="product-thumb">
            <img class="img-responsive" src="/img/${obj.product_imgname}" alt="product-img" />
              <%--  버튼 3개  --%>
              <div class="preview-meta">
              <ul>
                <li>
                                    <%--  제품별 상세조회를 위한 모달창 연결 구간.(별도 페이지 아님)  --%>
									<span  data-toggle="modal" data-target="#product-modal${obj.product_id}">
                                      <i class="tf-ion-ios-search-strong" ></i>
									</span>

                </li>
                <li>
                  <a href="#!" ><i class="tf-ion-ios-heart"></i></a>
                </li>
                <li>
                  <a href="/cart?user_id=${loginuser.user_id}"><i class="tf-ion-android-cart"></i></a>
                </li>
              </ul>
            </div>
            </div>
          </div>
          <div class="product-content">
            <h4><a href="product-single.html">${obj.product_name}</a></h4>
            <p class="price"><fmt:formatNumber value="${obj.product_price}" type="number" pattern="₩ ###,###" /></p>
          </div>

        </div>
      </c:forEach>
      </div><%--  각각의 Product가 담긴 영역 끝.   --%>
      <!-- Modal창 팝업을 통한 상품 상세보기 forEach 한번 더! -->
      <c:forEach  var="obj" items="${allproduct}" >

        <div class="modal product-modal fade" id="product-modal${obj.product_id}">
        <%-- 위에서 선언한 #product-modal 와 똑같이 써야 해당 제품의 상세정보  --%>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <i class="tf-ion-close"></i>
        </button>
        <div class="modal-dialog " role="document">
          <div class="modal-content">
            <div class="modal-body">
              <div class="row">
                <form id="cart_form" action="/addcart" method="get">
                <div class="col-md-8 col-sm-6 col-xs-12">
                  <div class="modal-image">
                    <img class="img-responsive" src="/img/${obj.product_imgname}" alt="product-img" />
                  </div>
                </div>
                <div class="col-md-4 col-sm-6 col-xs-12">
                  <div class="product-short-details">
                    <input type="hidden" name="user_id" value="${loginuser.user_id}"/>
                    <input type="hidden" name="product_id" value="${obj.product_id}"/>
                    <h2 class="product-title">${obj.product_name}</h2>
                    <p class="product-price"><fmt:formatNumber value="${obj.product_price}" type="number" pattern="₩ ###,###" /></p>
                    <input type="number" class="form-control" id="cart_quantity" name="cart_quantity" placeholder="수량을 선택하세요" >
                    <p class="product-short-description">
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rem iusto nihil cum. Illo laborum numquam rem aut officia dicta cumque.
                    </p>
                    <%--  페이지 변환됨.(ajax로 데이터 보내는 방식이 아니라서.)  --%>
                    <button type="submit" class="btn btn-main" id="cart_addbtn"> 장바구니에 담기</button>
                    <a href="product-single.html" class="btn btn-transparent">View Product Details</a>
                  </div>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div><!-- /.modal -->

    </c:forEach>
    </div>

</section>

<%-- 장바구니에 item 성공적으로 담으면 모달 호출하기 --%>
<!-- id : myModal -->
<%--<div id="myModal" class="modal fade" role="dialog">--%>
<%--  <div class="modal-dialog">--%>

<%--<!-- Modal content-->--%>
<%--<div class="modal-content">--%>

<%--  <div class="modal-header">--%>
<%--    <button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--    <h4 class="modal-title">장바구니 추가</h4>--%>
<%--  </div>--%>
<%--  <div class="modal-body">--%>
<%--    <p>상품을 성공적으로 장바구니에 담았습니다! </p>--%>
<%--    &lt;%&ndash; 절대 유의! 로그인한 특정고객의  cart 조회 시엔 cid  &ndash;%&gt;--%>
<%--    <a href="/cart?user_id=${loginuser.user_id}" class="btn btn-info" role="button">장바구니로 이동</a>--%>
<%--    <a href="/shop" class="btn btn-info" role="button">쇼핑 계속하기</a>--%>

<%--  </div>--%>
<%--  <div class="modal-footer">--%>
<%--  </div>--%>
<%--</div>--%>

<%--</div>--%>
<%--</div>--%>
