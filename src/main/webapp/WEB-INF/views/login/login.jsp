<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
<div class="title_container" style="display:none;">
  <h2><span designElement="text" textIndex="3">로그인</span></h2>
</div>

<!-- 탭 -->
<div class="resp_login_wrap">
  <div id="loginTab" class="tab_basic fullsize Pt20">
    <ul>
      <li class="on"><a href="javascript:void(0)" data-tab="member"><span designElement="text" textIndex="4">회원</span></a></li>
      <li ><a href="javascript:void(0)" data-tab="nonmember"><span designElement="text" textIndex="5">비회원</span></a></li>
    </ul>
  </div>
</div>

<!-- +++++++++++ 회원 +++++++++++ -->
<form method="post" action="/loginck" id ="f">
<div id="member" class="loginTabContetns resp_login_wrap Mt0">
  <fieldset>
    <ul class="login_real_area">
      <li class="input_area">
        <input type="text" id="userid" name="mid" class="box_id" value="" placeholder="아이디" required="required">
        <input type="password" id="password" name="mpass" class="box_pw" placeholder="비밀번호" password="password" required="required">
      </li>
      <li>
        <label class="id_save">
          <input type="checkbox" id="idsave" value="checked">
          <span designElement="text" textIndex="6">아이디 저장</span></label>
      </li>
      <li>
        <button type="submit" class="btn_resp size_login1" onclick="nextpg()">
          <span designElement="text" textIndex="7">로그인</span>
        </button>
      </li>
      <li class="find_join">
        <%--<a href="#" designElement="text" textIndex="8">아이디 찾기</a> &nbsp;|&nbsp;
        <a href="#" designElement="text" textIndex="9">비밀번호 찾기</a> &nbsp;|&nbsp;--%>
        <a href="/join" class="Fw500 gray_01" designElement="text" textIndex="10">회원가입</a>
      </li>
    </ul>
    <!-- SNS 가입폼 -->
    <h3 class="title_sub3 v3"><span designElement="text" textIndex="11">또는 SNS 로그인</span></h3>
    <ul class="sns_login_ul">
      <li class="sns-login-button" snstype="kakao"><div class="img"><img src="./images1/sns_icon_kakao.png" onclick="kakaoLogin()" alt="kakao 로그인" title="카카오 로그인"/></div></li>
      <%--<li class="sns-login-button" snstype="naver"><div class="img"><img src="./images1/sns_icon_naver.png" alt="naver 로그인" title="네이버 로그인"/></div></li>--%>
    </ul>
  </fieldset>
</div>
</form>
<!-- +++++++++++ //회원 +++++++++++ -->


<!-- +++++++++++ 비회원 +++++++++++ -->
<div id="nonmember" class="loginTabContetns resp_login_wrap Mt0" style="display:none;">
  <input type="hidden" name="return_url" value=""/>
  <ul class="login_real_area">
    <li class="input_area">
      <input type="text" name="order_seq" value="" class="box_order" placeholder="주문번호" />
      <input type="text" name="order_email" value="" class="box_order" placeholder="주문자 이메일" />
    </li>
    <li class="desc_area">
      <p designElement="text" textIndex="14">비회원은 주문번호와 이메일로 주문을 조회할 수 있습니다.</p>
    </li>
    <li>
      <button type="submit" class="btn_resp size_login1">
        <span designElement="text" textIndex="15">주문조회</span>
      </button>
    </li>
  </ul>
</div>
<script>
  $(document).ready(function() {
    $("form[name='loginForm'] input[name='userid']").focus();
    $('#loginTab a').on('click', function() {
      var tab_name = $(this).data('tab');
      $('.loginTabContetns').hide();
      $('#' + tab_name).show();
      $('#loginTab li').removeClass('on');
      $(this).closest('li').addClass('on');
    });
  });
  var setid = localStorage.getItem("saveid");
  document.getElementById("userid").value= setid;
  var check = document.getElementById("idsave");

  function nextpg(){
    if(check){
      if(check.checked){
        localStorage.setItem("saveid",document.getElementById("userid").value);
      }
      f.submit();
    }
  }
  var storageid = localStorage.getItem("saveid");
  if(storageid == null){
    storageid = "";
  }
  document.getElementById("userid").value = storageid;


  $(document).ready(function(){
    Kakao.init('293a5b17f513198b24992488489133b4');
    Kakao.isInitialized();
  });

  function kakaoLogin() {
    Kakao.Auth.authorize({
      redirectUri: 'http://power933.cafe24.com/klogin'
    }); // 등록한 리다이렉트uri 입력
  }
</script>
<!-- +++++++++++ //비회원 +++++++++++ -->