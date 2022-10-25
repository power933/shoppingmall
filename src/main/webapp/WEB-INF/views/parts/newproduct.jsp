<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8">
<div class="title_group1">
    <h3 class="title1"><span designElement="text" textIndex="2"  textTemplatePath="cmVzcG9uc2l2ZV93cmlzdHdhdGNoX2NsYXNzaWNfZ2wvbWFpbi9pbmRleC5odG1s" >New Collection</span></h3>
</div>
<div class="show_display_col4">
<style>
.designDisplay_633b83b76d26d .goods_list li.gl_item{ width:300px; }
</style>

<div id='designDisplay_633b83b76d26d' class='designDisplay' designElement='display' templatePath='main/index.html' displaySeq='10342' page='' perpage='' category='' displayStyle='responsible'>

<div class="designDisplay_633b83b76d26d display_responsible_class ">
<style>
    .designDisplay_633b83b76d26d.goods_list li.gl_item{ width:300px; }
</style>
<ul class="goods_list designDisplay_633b83b76d26d goods_info_style_2">

<!-- NEW PRODUCT  반복코드 -->
    <c:forEach var="recent" items="${recent}">
<li class="gl_item">
<div class="gl_inner_item_wrap">

    <!--상품이미지-->
    <div class="gli_image goodsDisplayImageWrap">
        <a href="#" class="respItemImageArea">
            <img src="${recent.pimg1}" data-src="https://fdumb.com/data/goods/32/2021/09/27921_temp_16329010671170list1.jpg" class="goodsDisplayImage lazyload" onerror="this.src='./images/noimage.gif'" alt="[아쿠아릭] 헤네시 4인소파"/>
        </a>
        <!-- 반응형 모바일 시작 -->
        <div class="respGoodsZzim">
            <a class="zzimArea" href="#">
                <img src="${recent.pimg1}" class="zzimImage normal " alt="찜하기" title="찜하기" />
                <img src="${recent.pimg2}" class="zzimImage active hide" alt="찜한 상품" title="찜한 상품" />
            </a>
        </div>
        <!-- 반응형 모바일 끝 -->
    </div>

    <div class="resp_display_goods_info infO_style_2">
    <!-- +++++++++++++++++++++++++++++++++ NEW 상품 정보 ++++++++++++++++++++++++++++++++ -->
        <!-- 컬러옵션 -->
        <div class="goodS_info displaY_color_option">
        </div>

        <div class="infO_group">

            <!-- 브랜드명 -->
            <div class="goodS_info displaY_brand_name">
                <span class="areA">AQUARIC</span>
            </div>

            <!-- 상품명-->
            <div class="goodS_info displaY_goods_name">
                <span class="areA"><a href="/item?pcode=${recent.pcode}">${recent.pname}</a></span>
            </div>
        </div>

        <!-- 짧은 설명 -->
        <div class="goodS_info displaY_goods_short_desc">
            <span class="areA">${recent.psub_ex}</span>
        </div>

        <div class="infO_group">
            <!-- (할인혜택)판매가 -->
            <div class="goodS_info displaY_sales_price">
                <span class="areA">
                    <span class="nuM"><fmt:formatNumber value="${recent.psale}" pattern="#,###"/></span>&#x20a9;
                </span>
            </div>
        </div>
    </div>
</div>
</li>
<!-- NEW PRODUCT  반복코드 끝 -->
    </c:forEach>


</ul>
</div>


</div>

</div>