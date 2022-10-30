<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.bootpay.co.kr/js/bootpay-3.3.3.min.js" type="application/javascript"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
  $(function (){  //약관동의 전체 체크
    $("#all_agree").click(function (){
     var ck = $(this).is(":checked");
     var allck;
     if(ck==true){
       allck = true;
     }
     else{
       allck = false;
     }
     $(".agree_chk").prop("checked",allck);

    });

    /*$("#search_post").postcodifyPopUp({
      insertPostcode5 : "#person_post",
      insertAddress : "#person_addr",
      hideOldAddresses : false
    });*/

    document.getElementById("search_post").addEventListener("click", function(){

      new daum.Postcode({
        oncomplete: function(data) { //선택시 입력값 세팅
          document.getElementById("person_post").value=data.zonecode;
          document.getElementById("person_addr").value = data.address;
          document.getElementById("person_addrtc").focus();

        }
      }).open();
    });


  $("#payinfo").click(function (){ //주문자 정보와 동일
    $("#person_nm").val($("#cname").val());
    $("#person_hp1").val($("#chp1").val());
    $("#person_hp2").val($("#chp2").val());
    $("#person_hp3").val($("#chp3").val());
    $("#person_phone1").val($("#ctel1").val());
    $("#person_phone2").val($("#ctel2").val());
    $("#person_phone3").val($("#ctel3").val());

  });
  });
</script>


<div id="layout_body" class="layout_body">
  <style type="text/css">
    .resp_layer_pop .btn_view_coupons { position:absolute; right:60px; top:22px; }
    .subpage_wrap.order_payment.flyingMode .order_payment_right .order_subsection { position:fixed; right:0; top:0; z-index:100; width:100%; /*width:calc(40% - 20px);*/ }
    .subpage_wrap.order_payment.flyingMode .order_payment_right .order_subsection .right_flying_wrap1 { max-width:1260px; padding-left:40px; padding-right:40px; margin:0 auto; }
    .subpage_wrap.order_payment.flyingMode .order_payment_right .order_subsection .right_flying_wrap2 { width:100%; position:relative; }
    .subpage_wrap.order_payment.flyingMode .order_payment_right .order_subsection .right_flying_wrap3 { position:absolute; right:0; top:0; width:calc(40% - 20px); background:#fff; box-shadow:0 0 4px rgba(0, 0, 0, 0.2); }
    @media only screen and (max-width:1023px) {
      .subpage_wrap.order_payment.flyingMode .order_payment_right .order_subsection .right_flying_wrap1 { padding-left:10px; padding-right:10px; }
      .subpage_wrap.order_payment.flyingMode .order_payment_right .order_subsection .right_flying_wrap3 { width:290px; }
    }
    @media only screen and (max-width:799px) {
      .subpage_wrap.order_payment { display:block; width:auto; }
      .subpage_wrap.order_payment .subpage_container { display:block; padding:10px 0 40px; }
      .subpage_wrap.order_payment .subpage_container.v2 { display:block; padding:10px 0 40px; }
      .subpage_wrap.order_payment .order_payment_right { width:auto; padding-left:0; }
    }
  </style>

  <script type="text/javascript">
    function onlyNumber(obj) { $(obj).keyup(function(){ $(this).val($(this).val().replace(/[^0-9]/g,"")); }); }
  </script>
  <div id="delivery_address_dialog" style="display:none;"></div><!--주소록-->
  <div id="PromotionDialog" class="hide"></div>
  <div id="couponDownloadDialog" style="display:none"></div>


    <div class="subpage_wrap">
      <div class="subpage_container v3 Pb10">
        <!-- 타이틀 -->
        <div class="title_container Pb0">
          <h2><span designElement="text" textIndex="1"   >주문/결제</span></h2>
        </div>
      </div>
    </div>
  <c:forEach var="cartId" items="${cartId}">
    <input type="hidden" value="${cartId}" name="cartId">
  </c:forEach>

    <div id="orderPaymentLayout" class="subpage_wrap order_payment" data-ezmark="undo">
      <div class="subpage_container v2 Pt0 order_payment_left">
        <!-- 주문상품 :: START -->
        <h2 class="title_od1 Pt15"><span designElement="text" textIndex="2"   >주문상품 정보</span></h2>

        <div id="facebook_mgs"><div style="padding:10px"></div></div>

        <div class="cart_contents">


          <div class="cart_list">
            <ul class="shipping_group_list ">

              <li class="goods_delivery_info clearbox">

                <ul class="detail">
                  <li class="th">배송 :</li>
                  <li class="silmul">
                    <span>직접배송</span>

                    <span class="ship_info">(선불)</span>

                    <span id="price_" class="grp_shipping_price_1_21_direct_delivery">무료</span>

                    <div class="hope">
                    </div>
                  </li>
                  <li class="btn_area">
                    <button type="button" class="btn_resp btn_shipping_modify" cart_seq="949" prepay_info="delivery" nation="korea" goods_seq="767" hop_date="" person_seq="">배송 변경</button>
                  </li>
                </ul>
              </li>
              <c:set var="totalprice" value="0"/>
              <c:set var="totalsale" value="0"/>
              <c:set var="totalresult" value="0"/>

              <c:forEach var="list" items="${list}" varStatus="status">
              <c:set var="totalprice" value="${totalprice+list.pprice*count[status.index]}"/>
              <c:set var="totalsale" value="${totalsale+list.pprice-list.psale*count[status.index]}"/>
              <c:set var="totalresult" value="${totalresult+list.psale*count[status.index]}"/>
              <input type="hidden" name="pcode" value="${list.pcode}">

              <li class="cart_goods">
                <div class="cart_goods_detail">

                  <div class="cgd_contents">
                    <div class="block block1">
                      <ul>
                        <li class="img_area">
                          <a href="#"><img src="${list.pimg1}" title="" alt="상품이미지" /></a>
                          <input type="hidden" name="img1" value="${list.pimg1}">
                        </li>
                        <li class="option_area">


                          <div class="goods_name v2" >
                            <a href="/item?pcode=${list.pcode}" >${list.pname}</a>
                            <input type="hidden" name="pname" value="${list.pname}">
                          </div>


                          <ul class="cart_option">
                            <li><span class="xtle">색상</span> 블루</li>
                          </ul>

                          <div class="cart_quantity">
                            <span class="xtle">수량</span> ${count[status.index]}개
                            <input type="hidden" name="count" value="${count[status.index]}">
                            <span class="add_txt">(<span class="cart_price_num"><fmt:formatNumber pattern="#,###" value="${list.pprice}"/></span>&#x20a9;)</span>
                          </div>


                        </li>
                      </ul>
                    </div>

                    <ul class="block block2 x1" id="mobile_cart_sale_tr_989">
                      <li class="price_a">
                        <span class="ptitle">상품금액</span><fmt:formatNumber pattern="#,###" value="${list.pprice*count[status.index]}"/>&#x20a9;
                        <input type="hidden" name="priceeach" value="${list.pprice*count[status.index]}">
                      </li>
                      <li id="cart_sale_tr_989" class="price_b">
                        <span class="ptitle">할인금액</span>
                        <div id="cart_option_sale_total_989">
                          <fmt:formatNumber pattern="#,###" value="${(list.pprice-list.psale)*count[status.index]}"/>
                        </div>
                      </li>
                      <li class="price_c">
                        <span class="ptitle">할인적용금액</span>
                        <span class="total_p"><span id="option_suboption_price_sum_989"><fmt:formatNumber pattern="#,###" value="${list.psale*count[status.index]}"/></span>&#x20a9;</span>
                      </li>
                    </ul>
                  </div>
                </div>
                </c:forEach>

              </li>

            </ul>

          </div>

        </div>
          <input type="hidden" name="version" value="1.0">
          <input type="hidden" id="price" name="price" value="${totalprice}">
        <input type="hidden" id="mid" name="mid" value="${user.mid}">
        <input type="hidden" name="ordernum" id="ordernum" value="">
        <div class="order_subsection v2">
          <!-- ++++++++++++++++++++ 주문자 :: START ++++++++++++++++++++ -->
          <h3 class="title3"><span designElement="text" textIndex="3"   >주문자</span></h3>

          <div id="order_info_input" class="">
            <div class="order_info_input">
              <ul class="list_01 v2">
                <li><input type="text" name="cname" id="cname" value="" class="pilsu" style="width:170px;" title="주문자 이름" placeholder="주문자 이름" required />
                <li>
                  <input type="tel" name="ctel1" id="ctel1" value="" class="pilsu" style="width:64px;" title="휴대폰" placeholder="휴대폰" required /> -
                  <input type="tel" name="ctel2" id="ctel3" value="" class="pilsu size_phone" placeholder="휴대폰" required /> -
                  <input type="tel" name="ctel3" id="ctel2" value="" class="pilsu size_phone" placeholder="휴대폰" required />
                </li>
                <li>
                  <input type="tel" name="chp1" id="chp1" value="" style="width:64px;" title="연락처2" placeholder="전화" /> -
                  <input type="tel" name="chp2" id="chp2" value="" class="size_phone" placeholder="전화" /> -
                  <input type="tel" name="chp3" id="chp3" value="" class="size_phone" placeholder="전화" />
                  <span class="desc">(선택)</span>
                </li>
                <li><input type="email" name="cemail" id="cemail" value="" class="pilsu size_email_full" title="이메일" placeholder="주문자 이메일" required /></li>
              </ul>
            </div>
          </div>



          <!-- ++++++++++++++++++++ 배송지 :: START ++++++++++++++++++++ -->
          <h3 class="title3"><span designElement="text">배송지</span></h3>
          <!-- 받는분 정보 입력 란 -->
          <div class="delivery_selecter delivery_info_input">
            <div class="settle_tab_contents tab_box2 delivery_input">
              <ul class="list_01 v2">
                <!-- 받는분 -->
                <li>
                  <input type="text" name="person_nm" id="person_nm" class="pilsu" style="width:170px;" value="" title="받는분" required />
                  <button type="button" class="btn_resp size_b color5" id="payinfo">주문자 정보와 동일</button>
                </li>
                <!-- 국내 -->
                <li class="domestic goods_delivery_info ">
                  <input type="text" name="person_post" id="person_post" value="" title="우편번호" class="pilsu size_zip_all" readonly required />
                  <button type="button" class="btn_resp size_b color4" id="search_post">검색</button>
                </li>
                <li class="domestic goods_delivery_info ">
                  <input type="text" name="person_addr" id="person_addr" value="" class="pilsu size_address" title="도로명 주소" readonly />
                </li>
                <li class="domestic goods_delivery_info ">
                  <input type="text" name="person_addrtc" id="person_addrtc" value="" class="pilsu size_address" title="나머지주소" required />
                </li>
                <!-- 연락처 -->
                <li>
                  <input type="tel" name="person_phone" id="person_phone1" value="" class="pilsu" style="width:64px;"  title="휴대폰" placeholder="핸드폰" required /> -
                  <input type="tel" name="person_phone" id="person_phone2" value="" class="pilsu size_phone"  placeholder="핸드폰" required /> -
                  <input type="tel" name="person_phone" id="person_phone3" value="" class="pilsu size_phone"  placeholder="핸드폰" required />
                </li>
                <li>
                  <input type="tel" name="person_hp" id="person_hp1" value="" style="width:64px;"  title="연락처2" placeholder="전화" /> -
                  <input type="tel" name="person_hp" id="person_hp2" value="" class="size_phone"  placeholder="전화" /> -
                  <input type="tel" name="person_hp" id="person_hp3" value="" class="size_phone"  placeholder="전화" />
                  <span class="desc">(선택)</span>
                </li>
                <!-- 이메일 -->
                <li class="hide">
                  <input type="email" name="recipient_email" id="recipient_email" value="" class="size_email_full" title="이메일" />
                </li>
              </ul>
            </div>
          </div>

          <!-- 배송 메세지 -->
          <div id="shipMessage" class="ship_message">
            <input type="text" class="ship_message_txt" name="memo" id="memo" value="" title="배송 메세지 입력" placeholder="배송 메세지 입력" autocomplete="off" />
          </div>
        </div>
      </div>
      <div class="subpage_container v2 Pt0 order_payment_right">
        <div class="order_subsection v2 ">
          <div class="right_flying_wrap1">
            <div class="right_flying_wrap2">
              <div class="right_flying_wrap3">
                <!-- ++++++++++++++++++++ 결제 금액 :: START ++++++++++++++++++++ -->
                <h3 class="title3 Pt15"><span designElement="text" textIndex="6"   >결제 금액</span></h3>
                <div class="order_price_total">
                  <ul>
                    <li class="th"><span class="gray_01 Fs17" designElement="text" textIndex="7"   >상품금액</span></li>
                    <li class="td"><span id="total_goods_price" class="v2 gray_01"><fmt:formatNumber value="${totalprice}" pattern="#,###"/></span>&#x20a9;</li>
                  </ul>
                  <ul>
                    <li class="th">
                      <span designElement="text" textIndex="8"   >배송비</span>&nbsp;
                      <button type="button" class="btn_resp size_a gray_05" onclick="showCenterLayer('#besongDetailList')"><span designElement="text" textIndex="9"   >내역</span></button>
                    </li>
                    <li class="td">
                      (+) <span class="total_delivery_shipping_price">0</span>&#x20a9;
                    </li>
                  </ul>
                  <ul>
                    <li class="th">
                      <span designElement="text" textIndex="10"   >할인금액</span>&nbsp;
                      <button type="button" class="btn_resp size_a gray_05" onclick="showCenterLayer('#saleDetailList')"><span designElement="text" textIndex="11"   >내역</span></button>
                    </li>
                    <li class="td pointcolor3">
                      <span>(-)</span>
                      <span class="total_sales_price"><fmt:formatNumber value="${totalsale}" pattern="#,###"/></span>&#x20a9;
                    </li>
                  </ul>
                  <ul class="total">
                    <li class="th"><span designElement="text" textIndex="14"   >최종 결제금액</span></li>
                    <li class="td">
                      <span class="price"><span class="settle_price"><fmt:formatNumber value="${totalresult}" pattern="#,###"/></span>&#x20a9;</span>
                    </li>
                  </ul>
                </div>


                <!-- ++++++++++++++++++++ 결제 금액 :: END ++++++++++++++++++++ -->


                <!-- ++++++++++++++++++++ 결제 수단 :: START ++++++++++++++++++++ -->
                <h3 class="title3"><span designElement="text" textIndex="17"   >결제 수단</span></h3>
                <ul class="payment_method_select clearbox" id="payment_type">


                  <li>
                    <label><input type="radio" name="payment" value="bank"/>무통장입금</label>
                  </li>


                  <li>
                    <label><input type="radio" name="payment" value="card" checked />신용카드</label>
                  </li>
                  <li>
                    <label><input type="radio" name="payment" value="escrow_virtual" />가상계좌</label>
                  </li>

                </ul>

                <ul class="payment_method_select hide" id="payment_type_zero">
                  <li><strong style="color:#4b4b4b;">전액할인</strong></li>
                </ul>

                <!--무통장입금 - 상세 -->
                <ul class="list_01 v2 bank hide">
                  <li>
                    <input type="text" name="depositor" value="" title="입금자명" />
                  </li>
                  <li>
                    <select name="bank">
                      <option value="">은행 선택</option>
                      <option value="신한은행 100-033-200065 예금주:주식회사 서리">신한은행 100-033-200065 예금주:주식회사 서리</option>
                      <option value="우리은행 211-355-998065 예금주:주식회사 서리">우리은행 211-355-998065 예금주:주식회사 서리</option>
                      <option value="국민은행 910-830-225716 예금주:주식회사 서리">국민은행 910-830-225716 예금주:주식회사 서리</option>
                    </select>
                  </li>
                </ul>
                <ul id="typereceiptlay" class="mt_sp1 hide">
                  <li class="labelgroup_design ">
                    <label for="typereceiptuse1"><input type="radio" name="typereceiptuse" id="typereceiptuse1" value="1" > 발급</label>
                    <label for="typereceiptuse0" class="on"><input type="radio" name="typereceiptuse" id="typereceiptuse0" value="0" checked="checked"> 발급 안 함</label>
                  </li>
                  <li class="hide labelgroup_design" id="typereceiptchoice" >
                    <label class='tax_voucherchk'><input type="radio" name="typereceipt" id="typereceipt1" value="1"> 세금계산서 </label>
                  </li>
                </ul>
                <div id="typereceipttablelay" class="hide">

                  <!-- ~~~~~~~ 현금영수증 신청 부분 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
                  <ul id="cash_container" class="typereceiptlay list_01 v2 Mt5 hide">
                    <li class="labelgroup_design">
                      <label for="cuse0" class="on"><input type="radio" name="cuse" id="cuse0" value="0" checked="checked"> 개인 소득공제</label>
                      <label for="cuse1"><input type="radio" name="cuse" id="cuse1" value="1"> 사업자 지출증빙</label>
                    </li>
                    <li id="personallay">
                      <input type="tel" name="creceipt_number[0]" class="size_email_full" maxlength="13" title="휴대폰번호( '-' 없이 입력 )" />
                    </li>
                    <li id="businesslay" class="hide">
                      <input type="tel" name="creceipt_number[1]" class="size_email_full" maxlength="10" title="사업자번호( '-' 없이 입력 )" />
                    </li>
                    <li id="personallay">
                      <input type="email" name="sales_email" class="size_email_full" title="이메일주소" />
                    </li>
                    <li id="duplicate_message" class="desc">
                      ※ 결제창에서 다시 현금영수증을 신청하지 마세요. 중복발행 됩니다.
                    </li>
                  </ul>
                  <!-- ~~~~~~~ 세금계산서 신청 부분 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
                  <ul id="tax_container" class="typereceiptlay list_01 v2 Mt10 hide">
                    <li>
                      <input type="text" name="co_name" id="co_name" value="" title="상호명" />
                    </li>
                    <li>
                      <input type="tel" name="busi_no" id="busi_no" value="" title="사업자번호" /> <span class="desc">ex) 123-12-12345</span>
                    </li>
                    <li>
                      <input type="text" name="co_ceo" id="co_ceo" value="" title="대표자명" />
                    </li>
                    <li>
                      <input type="text" name="co_status" id="co_status" value="" title="업태" style="width:130px;" /> /
                      <input type="text" name="co_type" id="co_type" value="" title="업종" style="width:130px;" />
                    </li>
                    <li>
                      <input type="text" name="co_new_zipcode" class="size_zip_all" value="" title="우편번호" readonly />
                      <button type="button" class="btn_resp size_b color4" onclick="openDialogZipcode_resp('co_');">검색</button>
                      <input type="hidden" name="co_address_type" id="co_address_type" value="" title="주소" />
                      <input type="text" name="co_address" id="co_address" value="" class="size_address Mt5 " title="주소" readonly />
                      <input type="text" name="co_address_street" id="co_address_street" value="" class="size_address Mt5 hide" title="주소" readonly />
                      <input type="text" name="co_address_detail" id="co_address_detail" value="" class="size_address Mt5" title="상세주소" />
                    </li>
                    <li>
                      <input type="text" name="person" id="person" value="" title="담당자명" />
                    </li>
                    <li>
                      <input type="email" name="email" id="email" value="" title="이메일주소" class="size_email_full" />
                    </li>
                    <li>
                      <input type="tel" name="phone" id="phone" value="" title="연락처 " /> <span class="desc">숫자만 입력</span>
                    </li>
                  </ul>
                </div>
                <!-- ++++++++++++++++++++ 결제 수단 :: END ++++++++++++++++++++ -->

                <!-- ++++++++++++++++++++ 약관 동의 :: START ++++++++++++++++++++ -->
                <h3 class="title3">약관 동의</h3>
                <div class="mem_agree_area">
                  <label class="pilsu_agree_all2"><input type="checkbox" name="all_agree" id="all_agree" value="Y" /> 전체동의</label>
                  <ul id="odAgreeList" class="agree_list2">
                    <li>
                      <a class="agree_view">보기</a>
                      <label><input type="checkbox" class="agree_chk" name="agree1" id="agree1" value="Y" /> <span class="title">쇼핑몰 이용 약관</span> <span class="desc pointcolor imp">(필수)</span></label>
                    </li>
                    <li>
                      <a class="agree_view">보기</a>
                      <label><input type="checkbox" class="agree_chk" name="agree2" id="agree2" value="Y" /> <span class="title">개인정보 수집 및 이용</span> <span class="desc pointcolor imp">(필수)</span></label>
                    </li>
                    <li>
                      <a class="agree_view">보기</a>
                      <label><input type="checkbox" class="agree_chk" name="agree3" id="agree3" value="Y" /> <span class="title">개인정보 제3자 제공 동의</span> <span class="desc pointcolor imp">(필수)</span></label>
                    </li>
                    <li>
                      <a class="agree_view">보기</a>
                      <label><input type="checkbox" class="agree_chk" name="agree4" id="agree4" value="Y" /> <span class="title">개인정보 취급위탁에 대한 동의</span> <span class="desc pointcolor imp">(필수)</span></label>
                    </li>
                  </ul>
                </div>


                <!-- 결제 버튼 -->
                <div class="pay_layer btn_area_c" id="pay_layer1">
                  <input type="button" value="결제하기" name="button_pay" id="pay" class="btn_resp size_extra color2 Wmax" />
                  <input type="button" value="테스트" name="button_pay" id="save" class="btn_resp size_extra color2 Wmax" />
                  <span class="hide"><input type="button" value="장바구니로" class="btn_resp size_extra" onclick="document.location.href='cart';" /></span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>

    <!-- 쿠폰 목록 레이어 -->
    <div id="couponDeatilLayer" class="resp_layer_pop">
      <h4 class="title">보유 쿠폰</h4>
      <div class="y_scroll_auto2">
        <div class="layer_pop_contents v5">
          <div id="coupon_ordersheet_lay">
            <div id="coupon_ordersheet_select"></div>
          </div>
          <div id="coupon_goods_lay"></div>
          <div id="coupon_shipping_lay">
            <div id="coupon_shipping_select"></div>
          </div>
        </div>
      </div>
      <div class="layer_bottom_btn_area2">
        <button type="button" id="coupon_order" class="btn_resp size_c color2 Wmax">적용</button>
      </div>
      <a href="" class="btn_resp btn_view_coupons" target="_blank">보유 쿠폰 전체 보기</a>
      <a href="" class="btn_pop_close"></a>
    </div>
    <!-- //본문내용 끝 -->

  <script type="text/javascript">
    $(function() {
      $( window ).on('resize', function() {
        if ( window.innerWidth != WINDOWWIDTH ) {
          setTimeout(function(){ WINDOWWIDTH = window.innerWidth; }, 10);
        }
      });
    });

    $("#pay").click(function (){
     /* if($(".pilsu").val() == ""){ alert("필수정보를 입력해주세요");}
      else if(!($(".agree_chk").is(":checked"))){alert("필수 동의항목을 모두 체크해 주세요");}
      else{

      }*/

      var mname = document.getElementById("cname").value;
      var mtel = document.getElementById("ctel1").value + document.getElementById("ctel2").value + document.getElementById("ctel3").value;
      var memail = document.getElementById("cemail").value;
      var maddr = document.getElementById("person_post").value+ document.getElementById("person_addr").value + document.getElementById("person_addrtc").value;
      var price2 = ${totalresult};
      var pname = document.getElementsByName("pname")
      if(pname.length>1){
        var len = pname.length-1;
        pname = pname[0].value+" 외 "+ len +"개";
      }else{
        pname = pname[0].value;
      }
      var count = document.getElementsByName("count")[0].value;
      var ordernum = function uuidv4() {
        return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
                (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
        )
      };
      $("#ordernum").val(ordernum());


        BootPay.request({
          price: price2,
          application_id: "635a96d6cf9f6d001d374108",
          name: pname,
          pg: 'inicis',
          method: '',
          show_agree_window: 0,
          items: [
            {
              item_name: pname,
              qty: count,
              unique: '123',
              price: price2,
              cat1: '',
              cat2: '',
            }
          ],
          user_info: {
            username: mname,
            email: memail,
            addr: maddr,
            phone: mtel
          },
          order_id: $("#ordernum").val(),
          params: {callback1: '그대로 콜백받을 변수 1', callback2: '그대로 콜백받을 변수 2', customvar1234: '변수명도 마음대로'},
          account_expire_at: '2020-10-25',
          extra: {
            start_at: '',
            end_at: '',
            vbank_result: 1,
            quota: '0,2,3',
            theme: 'purple',
            custom_background: '#00a086',
            custom_font_color: '#ffffff'
          }
        }).error(function (data) {

          console.log(data);
        }).cancel(function (data) {

          console.log(data);
        }).ready(function (data) {

          console.log(data);
        }).confirm(function (data) {

          var enable;


          var pcode = [];
          var product_ea = [];

          $("input[name=pcode]").each(function(index,item){//체크된 리스트 저장
            pcode.push($(item).val());
          });
          $("input[name=count]").each(function(index,item){//체크된 리스트 저장
            product_ea.push($(item).val());
          });

          //재고 검증 ajax 호출
          $.ajax({
            url         :   "/countstock",
            traditional :   true,
            contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
            type        :   "post",
            async       :   false,
            data        :   { pcode : pcode, product_ea:product_ea },
            success     :   function(data){
              console.log(data.result + " : data")
              if(data.result) {
                enable = true;
              } else {
                enable = false;
              }
            },
            error       :   function(request, status, error){
              console.log("재고확인 ajax 에러");
            }
          });
          console.log(enable +": enable");
          console.log(data);
          if (enable) {
            BootPay.transactionConfirm(data);
            console.log("enable456");
          } else {
            BootPay.removePaymentWindow();
            alert("재고가 떨어졌습니다");
          }
        }).close(function (data) {
          console.log(data);
        }).done(function (data) {
          frm.submit();
          console.log(data);
        });

    })
    function isstock(enable) {
      //배열 선언

    }
  </script>
