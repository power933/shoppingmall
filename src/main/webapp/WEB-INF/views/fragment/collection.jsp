<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8">
<div class="title_group1">
    <h3 class="title1"><span designElement="text" textIndex="1"  textTemplatePath="cmVzcG9uc2l2ZV93cmlzdHdhdGNoX2NsYXNzaWNfZ2wvbWFpbi9pbmRleC5odG1s" >Celebrity Collection</span></h3>
</div>
<div class="show_display_col4">
<style>
.designDisplay_633b83b7559e9 .goods_list li.gl_item{ width:300px; }
</style>

<div id='designDisplay_633b83b7559e9' class='designDisplay' designElement='display' templatePath='main/index.html' displaySeq='10344' page='' perpage='' category='' displayStyle='responsible'>
<ul class="displayTabContainer displayTabType1">
       <%-- <li class="current" style="width:25%">소파/거실장</li>
        <li style="width:25%">침대/매트리스</li>
        <li style="width:25%">식탁/식탁의자</li>
        <li style="width:25%">쿠션/조명</li>--%>
    <c:forEach var = "list" items="${cate}" varStatus="status" >
        <li style="width:25%" onclick="location.href='/${list.ctotal_cate}'">${list.csmall_name}</li>
    </c:forEach>
</ul>

<div class="designDisplay_633b83b7559e9 display_responsible_class displayTabContentsContainer displayTabContentsContainerBox" style="display: block;">
<style>
    .designDisplay_633b83b7559e9.goods_list li.gl_item{ width:300px; }
</style>
<ul class="goods_list designDisplay_633b83b7559e9 goods_info_style_2">

    
<!--Celebrity Collection 상품출력 반복코드 -->
<c:forEach var = "items" items="${items}">
<li class="gl_item">
<div class="gl_inner_item_wrap">
    <!--상품이미지-->

    <div class="gli_image goodsDisplayImageWrap">
        <a href="javascript:void(0);" class="respItemImageArea" onclick="location.href='/item?pcode=${items.pcode}'">
            <img src="${items.pimg1}" data-src="./product/767_2022051214434020.jpg" class="goodsDisplayImage lazyload" onerror="this.src='./images1/noimage.gif'" alt="[디앤에이] 아우라 천연가죽 4인소파"/>
        </a>
        <div class="respGoodsZzim">
            <a class="zzimArea" href="javascript:void(0)" onclick="display_goods_zzim(this, 767)">
                <img src="./images1/icon_zzim.png" class="zzimImage normal " alt="찜하기" title="찜하기" />
                <img src="./images1/icon_zzim_on.png" class="zzimImage active hide" alt="찜한 상품" title="찜한 상품" />
            </a>
        </div>
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
                <span class="areA"><a href="/item?pcode=${items.pcode}">${items.pname}</a></span>
            </div>
        </div>

        <!-- 짧은 설명 -->
        <div class="goodS_info displaY_goods_short_desc">
            <span class="areA">${items.psub_ex}</span>
        </div>

        <div class="infO_group">
            <!-- (할인혜택)판매가 -->
            <div class="goodS_info displaY_sales_price">
                <span class="areA">
                    <span class="nuM"><fmt:formatNumber value="${items.psale}" pattern="#,###"/></span>&#x20a9;
                </span>
            </div>
        </div>
    </div>
</div>
</li></c:forEach>
<!--Celebrity Collection 상품출력 반복코드 끝 -->

</div>