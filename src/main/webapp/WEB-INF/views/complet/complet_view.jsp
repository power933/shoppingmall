<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="layout_body" class="layout_body">
    <div class="subpage_wrap">
        <div class="subpage_container v3 Pb10">
            <!-- 타이틀 -->
            <div class="title_container">
                <h2><span designElement="text">주문완료</span></h2>
            </div>
            <div class="mypage_greeting">
                <span class="username">${list.cname}</span>님의 주문이 정상적으로 처리되었습니다.
            </div>
        </div>
    </div>
    <div class="subpage_wrap order_payment">
        <div class="subpage_container v2 Pt0 Pb40 order_payment_left2">
            <h2 class="title_od1 Pt15"><span>주문상품</span></h2>
            <div class="cart_contents">
                <div class="cart_list">
                    <ul class="shipping_group_list">
                        <li class="goods_delivery_info clearbox">
                            <ul class="detail">
                                <li class="th">배송 :</li>
                                <li class="silmul">
                                    <span>직접배송</span>
                                    <strong>무료</strong>
                                </li>
                            </ul>
                        </li>
                        <c:set value="0" var="price"/>
                        <c:forEach var="price1" items="${list.priceeach}" varStatus="status">
                            <c:set value="${price+list.priceeach[status.index]}" var="price"/>
                        <li class="cart_goods ">
                            <div class="cart_goods_detail">
                                <div class="cgd_contents">
                                    <div class="block block1">
                                        <ul>
                                            <li class="img_area">
                                                <a href="#"><img src="${list.pimg1[status.index]}" class="goods_thumb" alt="상품이미지" /></a>
                                            </li>
                                            <li class="option_area">
                                                <div class="goods_name v2 d2">
                                                    <a href="#">${list.pname[status.index]}</a>
                                                </div>
                                                <ul class="cart_option">
                                                    <li><span class="xtle">색상</span> 블루</li>
                                                </ul>
                                                <div class="cart_quantity">
                                                    <span class="xtle">수량</span> ${list.count[status.index]}개
                                                    <span class="add_txt">(${price1}&#x20a9;)</span>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <div class="goods_delivery_info Pt10 y1">
                <b>기본배송비 : 0&#x20a9;</b>
                </span>
            </div>
            <div class="order_subsection v2">
                <h3 class="title3"><span>주문자</span></h3>
                <ul class="list_01 v2">
                    <li>
                        <span class="name1 pointcolor2 imp">${list.cname}</span>
                    </li>
                    <li>
                        <span class="phone1">${list.ctel1}-${list.ctel2}-${list.ctel3}</span>
                    </li>
                    <li><span class="email1">${list.recipient_email}</span></li>
                    <li class="desc">
                        주문자 정보로 주문 관련 정보가 문자와 이메일로 발송됩니다.<br />
                        비회원은 이메일과 주문번호로 주문조회가 가능합니다.<br />
                    </li>
                </ul>

                <h3 class="title3"><span>배송지</span></h3>
                <ul class="list_01 v2">
                    <li>
                        <span class="name1 pointcolor imp">${list.person_nm}</span>
                        <span class="gray_06">(대한민국)</span>
                    </li>
                    <li>
                        [ ${list.person_post} ]
                        ${list.person_addr}<br/>
                        <span class="desc">
                        ${list.person_addrtc}
                        </span>
                    </li>
                    <li>
                        ${list.person_phone[0]}-${list.person_phone[2]}-${list.person_phone[1]}
                    </li>
                    <li>
                        ${list.msg}
                    </li>
                </ul>
            </div>
        </div>


        <div class="subpage_container v2 Pt0 Pb40 order_payment_right2">
            <div class="order_subsection v2">
                <h3 class="title3 Pt15"><span>결제 금액</span></h3>
                <div class="order_price_total">
                    <ul>
                        <li class="th"><strong><span>상품금액</span></strong></li>
                        <li class="td"><fmt:formatNumber value="${price}" pattern="#,###"/>&#x20a9;</li>
                    </ul>
                    <ul>
                        <li class="th">
                            <span>배송비</span>&nbsp;
                        </li>
                        <li class="td">
                            (+) 0&#x20a9;
                        </li>
                    </ul>
                    <ul class="total">
                        <li class="th"><span>총 결제금액</span></li>
                        <li class="td">
                            <span class="price"><span class="settle_price"><fmt:formatNumber value="${price}" pattern="#,###"/></span>&#x20a9;</span>
                        </li>
                    </ul>
                </div>
                <h3 class="title3"><span>주문결제정보</span>&nbsp;</h3>
                <table class="table_row_a" cellpadding="0" cellspacing="0">
                    <colgroup><col width="100"><col></colgroup>
                    <tbody>
                    <tr>
                        <th scope="row"><p>주문번호</p></th>
                        <td>
                            ${list.ordernum}
                            <span class="Dib desc">(${list.orderdate})</span>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><p>주문상태</p></th>
                        <td>주문접수</td>
                    </tr>
                    <tr>
                        <th scope="row"><p>결제일시</p></th>
                        <td>
                            <fmt:formatDate value=""/>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><p>결제방식</p></th>
                        <td>
                            ${list.payment}
                        </td>
                    </tr>
                    <!--무통장 일 경우-->
                    <tr class="hide">
                        <th scope="row"><p>입금계좌</p></th>
                        <td>신한은행 100-033-123456 예금주:주식회사 더조은</td>
                    </tr>
                    <tr class="hide">
                        <th scope="row"><p>입금기간</p></th>
                        <td>2022년 11월 07일까지 (이후 입금되지 않았을 경우 자동으로 주문무효 처리)</td>
                    </tr>
                    <!--무통장 일 경우-->
                    <tr>
                        <th scope="row"><p>결제금액</p></th>
                        <td><strong>${price}&#x20a9;</strong></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="Pb60 C">
        <a href="/" class="btn_resp size_c color5"><span>확인</span></a>
    </div>
    <style type="text/css">
        @media only screen and (max-width:767px) {
            .subpage_wrap.order_payment { display:block; width:auto; }
            .subpage_wrap.order_payment .subpage_container { display:block; padding:10px 10px 40px; }
            .subpage_wrap.order_payment .subpage_container.v2 { display:block; padding:10px 10px 40px; }
            .subpage_wrap.order_payment .order_payment_left2 { padding-right:0; }
            .subpage_wrap.order_payment .order_payment_right2 { padding-left:0; }
        }
    </style>