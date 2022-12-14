<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="title_container">
    <h2><span designElement="text" textIndex="1">장바구니</span></h2>
</div>
<input type="hidden" id="mname" value="${member[0].mname}">
<input type="hidden" id="memail" value="${member[0].memail}">
<input type="hidden" id="mtel" value="${member[0].mtel}">
<input type="hidden" id="maddr" value="${member[0].addr}">
<form name="buy">
<ul class="resp_cart_wrap">
    <!-- ++++++++++++ cart left area +++++++++++ -->
    <li class="cart_left">
        <div class="cart_contents">

            <!-- 전체 선택 -->
            <ul class="cart_contents_top clearbox">
                <li class="aa">
                    <label class="checkbox_allselect"><input type="checkbox" class="btn_select_all" id="select_all" /> <span class="txt">전체선택</span></label>
                </li>
                <li class="bb hide">
                    <input type="button" class="btn_resp size_b btn_shipping_modify" value="배송변경" />
                </li>
            </ul>

            <div class="cart_list">
                <ul class="shipping_group_list">
                    <li class="goods_delivery_info clearbox" id="sippingInfo1">
                        <ul class="detail">
                            <li class="th">배송 :</li>
                            <li class="silmul">
                                <span>직접배송</span>
                                <input type="hidden" class="size" value="${size}">
                                <span id="price_">무료</span>

                                <div class="hope">
                                </div>
                            </li>
                        </ul>
                    </li>


                    <c:set var="totalPrice" value="0"/>
                    <c:set var="totalSale" value="0"/>
                    <c:set var="resultPrice" value="0"/>
                    <c:forEach var="list" items="${list}" varStatus="status">
                        <c:set var="totalPrice" value="${totalPrice+list.pprice*list.product_count}"/>
                        <c:set var="resultPrice" value="${resultPrice+list.psale*list.product_count}"/>
                    <input type="hidden" name="pcode" value="${list.pcode}">
                    <li class="cart_goods" id="cart_goods_987">
                        <div class="cart_goods_detail">
                            <div class="cgd_top">
                                <label>
                                    <input type="hidden" name="" value="Y"/>
                                    <input type="checkbox" class="checkSelect" data="${list.pprice*list.product_count}" data1="${list.pprice*list.product_count-list.psale*list.product_count}" data2="${list.psale*list.product_count}"  name="cart_option_seq[]" id="select${status.count}" value="${list.cartId}" stat="Y" rel="775" />
                                    <span class="goods_name">${list.pname}</span>
                                    <input type="hidden" id="pname${list.cartId}" value="${list.pname}">
                                </label>
                            </div>

                            <div class="cgd_contents">
                                <div class="block block1">
                                    <ul>
                                        <li class="img_area">
                                            <a href=""><img src="${list.pimg1}" class="goods_thumb"></a>
                                        </li>
                                        <li class="option_area">

                                            <ul class="cart_option">
                                                <li><span class="xtle">구성</span> ${list.psub_ex}</li>
                                            </ul>
                                            <div class="cart_quantity"><span class="xtle">수량</span> ${list.product_count}개 <span class="add_txt">(<fmt:formatNumber value="${list.pprice*list.product_count}" pattern="#,###"/>&#x20a9;)</span></div>
                                        </li>
                                    </ul>
                                </div>

                                <ul class="block block2" id="mobile_cart_sale_tr_987">
                                    <li class="price_a" name="viewPrice">
                                        <span class="ptitle">상품금액</span>
                                        <fmt:formatNumber value="${list.pprice*list.product_count}" pattern="#,###"/>&#x20a9;
                                        <input type="hidden" class="hiddenPrice" value="${list.pprice*list.product_count}">
                                    </li>
                                    <li class="price_b">
                                        <span class="ptitle" name="viewPrice">
                                            할인금액
                                        </span>
                                        (-) <span id="mobile_cart_sale_987"><fmt:formatNumber value="${(list.pprice-list.psale)*list.product_count}" pattern="#,###"/>&#x20a9;</span>
                                        <input type="hidden" class="hiddenSale" value="${(list.pprice-list.psale)*list.product_count}">
                                    </li>
                                    <li class="price_c" name="viewPrice">
                                        <span class="ptitle">할인적용금액</span>
                                        <span class="total_p" id="option_suboption_price_sum_987"><span class="num"><fmt:formatNumber value="${list.psale*list.product_count}" pattern="#,###"/></span>&#x20a9;</span>
                                        <input type="hidden" class="hiddenResult" id="price${list.cartId}" value="${list.psale*list.product_count}">
                                    </li>
                                    <input type="hidden" name="cartId" value="${list.cartId}">
                                </ul>
                                <input type="hidden" id="cartId${list.cartId}" value="${list.cartId}">
                                <ul class="block block3">
                                    <%--<li><button type="button" class="btn_option_modify btn_resp">옵션/수량변경</button></li>--%>
                                    <li><button type="button" class="btn_direct_buy btn_resp color2" onclick="onebtn('${list.cartId}');">바로구매</button></li>
                                </ul>

                            </div>
                        </div>
                    </li>

                        <input type="hidden" id="lcate${list.cartId}" value="${list.plarge_cate}">
                        <input type="hidden" id="scate${list.cartId}" value="${list.psmall_cate}">
                        <input type="hidden" id="count${list.cartId}" name="product_ea" value="${list.product_count}">
                        <input type="hidden" id="pcode${list.cartId}" value="${list.pcode}">
                    </c:forEach>

                </ul>
            </div>
        </div>

        <!-- 버튼 그룹 -->
        <div class="selected_btn_groups">
            <label class="checkbox_allselect"><input type="checkbox" class="btn_select_all" /> <span class="txt">전체선택</span></label>

            <div class="btns">
                <%--<button type="button" class="btn_resp size_b color2 btn_selected_order">선택상품 주문하기</button>--%>
                <button type="button" class="btn_resp size_b gray_05 btn_select_del" id="deletebtn">선택상품 삭제</button>
            </div>
        </div>
    </li>
    <!-- ++++++++++++ //cart left area +++++++++++ -->

    <!-- ++++++++++++ cart right area +++++++++++ -->
    <li class="cart_right">
        <h3 class="title_x">전체 주문시 금액</h3>

        <!-- 총합계 Start -->
        <div class="total_sum_price">
            <ul class="list list1">
                <li class="th">총 상품금액</li>
                <li class="td"><span class="sum_price" ><span class="num" id = "totalprice">&#x20a9;</span></span></li>
                <input type="hidden" id="sumprice" value="0">
                <input type="hidden" id="totalprice1" value="${totalPrice}">
            </ul>
            <ul class="list list2">
                <li class="th">총 배송비</li>
                <li class="td"><span class="sum_price"><span>0&#x20a9;</span></span></li>
            </ul>
            <ul class="list list3">
                <li class="th">총 할인</li>
                <li class="td"><span class="sum_price" >(-) <span id = "totalsale">0&#x20a9;</span></span></li>
                <input type="hidden" id="sumsale" value="0">
                 <input type="hidden" id="saleprice1" value="${totalPrice-resultPrice}">
            </ul>
            <ul class="list list4 total">
                <li class="th">총 결제금액</li>
                <li class="td"><span class="sum_price settle_price">
                    <span class="num"><span id="totalmoney">0&#x20a9;</span></span>
                    <input type="hidden" id="sumtotal" value="0">
                    <input type="hidden" id="resultprice1" value="${resultPrice}">
                </li>
            </ul>
        </div>

        <ul class="cart_order_btn_area">
            <li>
                <input type="button" class="btn_resp size_c color2 btn_all_order" id="allbtn"  value="전체 주문하기"  />
            </li>
        </ul>
        <div class="pdb10 center"></div>
        <div class="pdb10 center"></div>
    </li>

    <!-- ++++++++++++ //cart right area +++++++++++ -->
</ul>
<div class="total_price_n_btns">
</div>
</form>


<script>
    function onebtn(cartid){
        var pcode=document.getElementById("pcode"+cartid).value;
        var count=document.getElementById("count"+cartid).value;
        location.href="order?pcode="+pcode+"&product_ea="+count;
    }

    $(document).ready(function() {

        $("#allbtn").click(function (){
            buy.action = "/order";
            buy.submit();
        })
    var size = $(".size").val();
        $(".btn_select_all").click(function() {
            var total = $("#totalprice1").val();
            var result1 = $("#resultprice1").val();
            var sale1 = $("#saleprice1").val();
            if($(".btn_select_all").is(":checked")){
                $(".checkSelect").prop("checked", true);
                $("#totalmoney").html(Number(total).toLocaleString()+"&#x20a9;");
                $("#totalsale").html(Number(sale1).toLocaleString()+"&#x20a9;");
                $("#totalprice").html(Number(result1).toLocaleString()+"&#x20a9;");

            } else {
                $(".checkSelect").prop("checked", false);
                $("#totalmoney").html(0+"&#x20a9;");
                $("#totalsale").html(0+"&#x20a9;");
                $("#totalprice").html(0+"&#x20a9;");
            };

        });

        $(".checkSelect").click(function() {
            var total = $(".checkSelect").length;
            var checked = $(".checkSelect:checked").length;

            var money = $(this).attr("data2");
            var sumtotal = $("#sumtotal").val();
            var plusmoney = Number(sumtotal) + Number(money);
            var minusmony = Number(sumtotal) - Number(money);

            var price = $(this).attr("data");
            var sumprice = $("#sumprice").val();
            var plusmoney1 = Number(sumprice) + Number(price);
            var minusmony1 = Number(sumprice) - Number(price);

            var sale = $(this).attr("data1");
            var sumsale = $("#sumsale").val();
            var plusmoney2 = Number(sumsale) + Number(sale);
            var minusmony2 = Number(sumsale) - Number(sale);

            if($(".checkSelect").is(":checked")){
                $("#sumtotal").val(plusmoney);
                $("#totalmoney").html(plusmoney.toLocaleString()+"&#x20a9;");

                $("#sumprice").val(plusmoney1);
                $("#totalprice").html(plusmoney1.toLocaleString()+"&#x20a9;");

                $("#sumsale").val(plusmoney2);
                $("#totalsale").html(plusmoney2.toLocaleString()+"&#x20a9;");
            }

            if(!$(".checkSelect").is(":checked")){
                $("#sumtotal").val(minusmony);
                $("#totalmoney").html(minusmony.toLocaleString()+"&#x20a9;");

                $("#sumprice").val(minusmony1);
                $("#totalprice").html(minusmony1.toLocaleString()+"&#x20a9;");

                $("#sumsale").val(minusmony2);
                $("#totalsale").html(minusmony2.toLocaleString()+"&#x20a9;");
            }

            if(total != checked){
                $(".btn_select_all").prop("checked", false);

            }
            else{
                $(".btn_select_all").prop("checked", true);
            }
        });
    });
    document.getElementById("deletebtn").addEventListener("click", ev => {
        buy.action = "cartdelete";
        buy.method="post"
        buy.submit();
    });

</script>

