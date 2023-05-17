<%--@@include('header.htm')--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!--kakao -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0f0752ec20b8a0352c5794754058b576"></script>
<script>
  let update_form = {
    init: function () {
        $('#update_btn').click(function () {
            update_form.send();
      });
    },
    send: function () {
      $('#update_form').attr({
        'action':'/updateimpl',
        'method':'post'
      });
      $('#update_form').submit();
    }
  };
  $(function () {
      update_form.init();
  });

  var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
          };

  //지도를 미리 생성
  var map = new daum.maps.Map(mapContainer, mapOption);
  //주소-좌표 변환 객체를 생성
  var geocoder = new daum.maps.services.Geocoder();
  //마커를 미리 생성
  var marker = new daum.maps.Marker({
    position: new daum.maps.LatLng(37.537187, 127.005476),
    map: map
  });


  function sample5_execDaumPostcode() {
    new daum.Postcode({
      oncomplete: function(data) {
        var addr = data.address; // 최종 주소 변수

        // 주소 정보를 해당 필드에 넣는다.
        document.getElementById("user_address").value = addr;
        // 주소로 상세 정보를 검색
        geocoder.addressSearch(data.address, function(results, status) {
          // 정상적으로 검색이 완료됐으면
          if (status === daum.maps.services.Status.OK) {

            var result = results[0]; //첫번째 결과의 값을 활용

            // 해당 주소에 대한 좌표를 받아서
            var coords = new daum.maps.LatLng(result.y, result.x);
            // 지도를 보여준다.
            mapContainer.style.display = "block";
            map.relayout();
            // 지도 중심을 변경한다.
            map.setCenter(coords);
            // 마커를 결과값으로 받은 위치로 옮긴다.
            marker.setPosition(coords)
          }
        });
      }
    }).open();

  }

</script>

<div class="container">
  <div class="row">
    <div class="col-sm-6 col-sm-offset-3">
      <form id = "update_form" class="form-horizontal">
        <fieldset>
          <legend>회원가입</legend>
          <div class="form-group">
            <label for="user_id" class="col-lg-2 control-label">아이디</label>
            <div class="col-lg-10">
              <input type="text" class="form-control" id="user_id" name="user_id" value="${loginuser.user_id}" readonly>
            </div>
          </div>
          <div class="form-group">
            <label for="user_pwd" class="col-lg-2 control-label">비밀번호</label>
            <div class="col-lg-10">
              <input type="password" class="form-control" id="user_pwd" name="user_pwd" placeholder="비밀번호를 입력하세요." required>
            </div>
          </div>
          <div class="form-group">
            <label for="user_name" class="col-lg-2 control-label">이름</label>
            <div class="col-lg-10">
              <input type="text" class="form-control" id="user_name" name="user_name" value="${loginuser.user_name}" required>
            </div>
          </div>
          <div class="form-group">
            <label for="user_contact" class="col-lg-2 control-label">전화번호</label>
            <div class="col-lg-10">
              <input type="text" class="form-control" id="user_contact" name="user_contact" placeholder="전화번호를 입력하세요." required>

            </div>

          </div>
          <div class="form-group">
            <label for="user_address" class="col-lg-2 control-label">주소</label>
            <div class="col-lg-10">
<%--              <input type="text" class="form-control" id="user_address" name="user_address" placeholder="주소를 입력하세요." required>--%>
                  <input type="text" id="user_address" name="user_address"  placeholder="주소">
                  <input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
                  <div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
            </div>
          </div>
          <div class="form-group">
            <label for="user_birthday" class="col-lg-2 control-label">생년월일</label>
            <div class="col-lg-10">
              <input type="date" id="user_birthday" name="user_birthday" name="userBirth"/>
            </div>
          </div>
          <div class="form-group">
            <label for="user_gender" class="col-lg-2 control-label">성별</label>
            <div class="col-lg-10">
              <select class="form-control" id="user_gender" name="user_gender" required>
                <option value="" disabled selected>성별을 선택하세요.</option>
                <option value="m">남성</option>
                <option value="f">여성</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <div class="col-lg-10 col-lg-offset-2">
              <button type="button" id="update_btn" class="btn btn-primary">정보변경하기</button>
            </div>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
    <style>
        button {
            background-color: #79c5b5; /* 티파니앤코 민트색 */
            color: #fff;
            border: none; /* 테두리 제거 */
            font-size: 6px;
            border-radius: 5px; /* 버튼 라운드 처리 */
            height: 40px;
            width: 70px;
            cursor: pointer;
        }


    </style>






