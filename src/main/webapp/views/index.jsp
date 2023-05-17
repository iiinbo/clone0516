<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--JSTL : 통화 날짜를 표현하게 해주는 문법--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>

<!--
/**
* 화면 : index.js
* 내용 : center 나누기 / login 기능 구현 중
* 작성자 : 정인보
* 작성일 : 5.11
*/
-->

<html lang="en">
<head>

    <!-- Basic Page Needs
    ================================================== -->
    <meta charset="utf-8">
    <title>AESPA | simple and Gorgeous</title>

    <!-- Mobile Specific Metas
    ================================================== -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Construction Html5 Template">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0">
    <meta name="author" content="Themefisher">
    <meta name="generator" content="Themefisher Constra HTML Template v1.0">

    <!-- theme meta -->
    <meta name="theme-name" content="aviato" />

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="/images/favicon.png" />

    <!-- Themefisher Icon font -->
    <link rel="stylesheet" href="/plugins/themefisher-font/style.css">
    <!-- bootstrap.min css -->
    <link rel="stylesheet" href="/plugins/bootstrap/css/bootstrap.min.css">

    <!-- Animate css -->
    <link rel="stylesheet" href="/plugins/animate/animate.css">
    <!-- Slick Carousel -->
    <link rel="stylesheet" href="/plugins/slick/slick.css">
    <link rel="stylesheet" href="/plugins/slick/slick-theme.css">

    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 제이쿼리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <%-- 부트스트랩 --%>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body id="body">

<!-- Start Top Header Bar -->
<section class="top-header">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-xs-12 col-sm-4">
                <div class="contact-number">
                    <i class="tf-ion-ios-telephone"></i>
                    <span>02-0201-0707</span>
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-4">
                <!-- Site Logo -->
                <div class="logo text-center">
                    <a href="/">
                        <!-- replace logo here -->
                        <svg width="135px" height="29px" viewBox="0 0 155 29" version="1.1" xmlns="http://www.w3.org/2000/svg"
                             xmlns:xlink="http://www.w3.org/1999/xlink">
                            <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" font-size="40"
                               font-family="AustinBold, Austin" font-weight="bold">
                                <g id="Group" transform="translate(-108.000000, -297.000000)" fill="#000000">
                                    <text id="AVIATO">
                                        <tspan x="108.94" y="325">AESPA</tspan>
                                    </text>
                                </g>
                            </g>
                        </svg>
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-4">
                <!-- Cart -->
                <ul class="top-menu text-right list-inline">
                    <li class="dropdown cart-nav dropdown-slide">
                        <!-- 카트 선택 시 로그인한 고객이라면, 본인의 카트 정보조회 dropdown -->
                        <%--                        <c:if test="${loginuser != null }">--%>
                        <a href="/cart?user_id=${loginuser.user_id}" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
                                class="tf-ion-android-cart"></i> Cart</a>
                        <div class="dropdown-menu cart-dropdown">

                            <!-- 로그인 한 고객의 Cart Item 을 드롭다운 하기 -->
                            <div class="media" >
                                <a class="pull-left" href="#!">
                                    <img class="media-object" src="/img/${obj.product_imgname}" alt="image" />
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading"><a href="#!">${obj.product_name}</a></h4>
                                    <div class="cart-price">
                                        <span>${obj.cart_quantity}</span>
                                        <span>${obj.product_price}</span>
                                    </div>
                                    <h5><strong>${obj.product_price}</strong></h5>
                                    <p>Product ID: ${obj.product_id}</p> <!-- 추가 -->
                                </div>

                                <a href="#!" class="remove"><i class="tf-ion-close"></i></a>
                            </div><!-- / Cart Item -->

                            <div class="cart-summary">
                                <span>Total</span>
                                <span class="total-price">$1799.00</span>
                            </div>
                            <ul class="text-center cart-buttons">
                                <li><a href="/cart?user_id=${loginuser.user_id}" class="btn btn-small">자세히 보기</a></li>
                                <li><a href="#order" class="btn btn-small btn-solid-border">주문하기</a></li>
                            </ul>

                        </div>
                    </li><!-- / Cart -->
                    <!-- Mypage -->
                    <c:choose>
                        <c:when test="${loginuser == null}">
                            <li class="dropdown dropdown-slide">
                                <!-- 미로그인 고객 : 로그인하기 화면 보여주기 | 로그인 고객 : 내정보 수정 & 로그아웃 화면 보여주기 -->
                                        <a href="/login" class="" data-toggle="" data-hover="dropdown" data-delay="350"
                                           role="button" aria-haspopup="true" aria-expanded="false"><span class="tf-ion-android-person"></span> Login</a><!-- Main Controller -->
                            </li>
                        </c:when>
                            <c:otherwise>
                                <li class="dropdown dropdown-slide">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350"
                                   role="button" aria-haspopup="true" aria-expanded="false"><span class="tf-ion-android-person"></span> ${loginuser.user_id} <span
                                        class="tf-ion-ios-arrow-down"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/profile"> 내정보 수정</a></li>
                                    <li><a href="/logout"> Logout</a></li><!-- Main Controller -->
                                </ul>
                                </li>
                            </c:otherwise>
                    </c:choose><!-- / Mypage -->

                    <!-- Search -->
                    <li class="dropdown search dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
                                class="tf-ion-ios-search-strong"></i> Search</a>
                        <ul class="dropdown-menu search-dropdown">
                            <li>
                                <form action="post"><input type="search" class="form-control" placeholder="Search..."></form>
                            </li>
                        </ul>
                    </li><!-- / Search -->


                </ul><!-- / .nav .navbar-nav .navbar-right -->
            </div>
        </div>
    </div>
</section><!-- End Top Header Bar -->


<!-- Main Menu Section -->
<section class="menu">
    <nav class="navbar navigation">
        <div class="container">
            <div class="navbar-header">
                <h2 class="menu-title">Main Menu</h2>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

            </div><!-- / .navbar-header -->

            <!-- Navbar Links -->
            <div id="navbar" class="navbar-collapse collapse text-center">
                <ul class="nav navbar-nav">

                    <!-- Home -->
                    <li class="dropdown ">
                        <a href="/">Home</a>
                    </li><!-- / Home -->


                    <!-- Elements -->
                    <li class="dropdown dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350"
                           role="button" aria-haspopup="true" aria-expanded="false">Shop <span
                                class="tf-ion-ios-arrow-down"></span></a>
                        <div class="dropdown-menu">
                            <div class="row">

                                <!-- Basic -->
                                <div class="col-lg-6 col-md-6 mb-sm-3">
                                    <ul>
                                        <li class="dropdown-header">주얼리</li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="/shop">한눈에보기</a></li>
                                        <li><a href="/shop/earring">귀걸이</a></li>
                                        <li><a href="/shop/ring">반지</a></li>
                                        <li><a href="/shop/bracelet">팔찌</a></li>
                                        <li><a href="/shop/necklace">목걸이</a></li>
                                        <li><a href="/shop/watch">워치</a></li>

                                    </ul>
                                </div>
                                <!-- Basic -->
                                <div class="col-lg-6 col-md-6 mb-sm-3">
                                    <ul>
                                        <li class="dropdown-header">모던 액세서리</li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="/shop/modern">한눈에보기</a></li>

                                    </ul>
                                </div>
                                <!-- Layout -->
                                <div class="col-lg-6 col-md-6 mb-sm-3">
                                    <ul>
                                        <li class="dropdown-header">카테고리</li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="/shop/gift">기프트</a></li>
                                        <li><a href="/shop/casual">캐쥬얼</a></li>
                                        <li><a href="/shop/wedding">웨딩</a></li>

                                    </ul>
                                </div>

                            </div><!-- / .row -->
                        </div><!-- / .dropdown-menu -->
                    </li><!-- / Elements -->








                    <!-- Shop -->
                    <li class="dropdown dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350"
                           role="button" aria-haspopup="true" aria-expanded="false">Service <span
                                class="tf-ion-ios-arrow-down"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="typography.html">매장찾기</a></li>
                            <li><a href="buttons.html">수리문의</a></li>
                            <li><a href="alerts.html">Contect</a></li>
                        </ul>
                    </li><!-- / Blog -->
                </ul><!-- / .nav .navbar-nav -->

            </div>
            <!--/.navbar-collapse -->
        </div><!-- / .container -->
    </nav>
</section>
<!-- center 시작 -->
<c:choose>
    <c:when test="${center == null}">
        <jsp:include page="center.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="${center}.jsp"/>
    </c:otherwise>
</c:choose>
<%-- center 끝. --%>



<footer class="footer section text-center">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="social-media">
                    <li>
                        <a href="https://www.facebook.com/themefisher">
                            <i class="tf-ion-social-facebook"></i>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.instagram.com/themefisher">
                            <i class="tf-ion-social-instagram"></i>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.twitter.com/themefisher">
                            <i class="tf-ion-social-twitter"></i>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.pinterest.com/themefisher/">
                            <i class="tf-ion-social-pinterest"></i>
                        </a>
                    </li>
                </ul>
                <ul class="footer-menu text-uppercase">
                    <li>
                        <a href="contact.html">CONTACT</a>
                    </li>
                    <li>
                        <a href="shop.html">SHOP</a>
                    </li>
                    <li>
                        <a href="pricing.html">Pricing</a>
                    </li>
                    <li>
                        <a href="contact.html">PRIVACY POLICY</a>
                    </li>
                </ul>
                <p class="copyright-text">Copyright &copy;2021, Designed &amp; Developed by <a href="https://themefisher.com/">Themefisher</a></p>
            </div>
        </div>
    </div>
</footer>

<!--
Essential Scripts
=====================================-->

<!-- Main jQuery -->
<script src="/plugins/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.1 -->
<script src="/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- Bootstrap Touchpin -->
<script src="/plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
<!-- Instagram Feed Js -->
<script src="/plugins/instafeed/instafeed.min.js"></script>
<!-- Video Lightbox Plugin -->
<script src="/plugins/ekko-lightbox/dist/ekko-lightbox.min.js"></script>
<!-- Count Down Js -->
<script src="/plugins/syo-timer/build/jquery.syotimer.min.js"></script>

<!-- slick Carousel -->
<script src="/plugins/slick/slick.min.js"></script>
<script src="/plugins/slick/slick-animation.min.js"></script>

<!-- Google Mapl -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
<script type="text/javascript" src="/plugins/google-map/gmap.js"></script>

<!-- Main Js File -->
<script src="/js/script.js"></script>



</body>
</html>