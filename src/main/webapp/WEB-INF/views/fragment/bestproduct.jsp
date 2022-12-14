<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="title_group1">
    <h3 class="title1"><span designElement="text" textIndex="4"  textTemplatePath="cmVzcG9uc2l2ZV93cmlzdHdhdGNoX2NsYXNzaWNfZ2wvbWFpbi9pbmRleC5odG1s" >Best Collection</span></h3>
</div>
<div class="show_display_col4">
<style>
.designDisplay_633b83b7791e9 .goods_list ol.gli_contents { text-align:center;}
.designDisplay_633b83b7791e9 .swiper-slide>li.gl_item { width:300px;  }
</style>

<div id='designDisplay_633b83b7791e9' class='designDisplay' designElement='display' perpage='' category='' displayStyle='sizeswipe'>
<div class="designDisplay_633b83b7791e9 display_slide_class displaySwipeTabContentsContainer" tabIdx="0">
<div class="goods_display_slide_wrap">
<div class="swiper-wrapper">

<!--BEST Collection 상품 반복코드 -->
    <c:forEach var="best" items="${best}">
<ul class="goods_list swiper-slide">	
<li class="gl_item">
<div class="gl_inner_item_wrap">

    <!--상품이미지-->
    <div class="gli_image goodsDisplayImageWrap">
        <a href="/item?pcode=${best.pcode}" class="respItemImageArea">
            <img src="${best.pimg1}" data-src="https://fdumb.com/data/goods/32/2021/09/27921_temp_16329010671170list1.jpg" class="goodsDisplayImage lazyload item1cut" onerror="this.src='./images1/noimage.gif';" alt="[아쿠아릭] 헤네시 4인소파" />
            <img src="${best.pimg2}" data-src="https://fdumb.com/data/goods/32/2021/09/27921_temp_16329010674579list1.jpg" class="goodsDisplayImage lazyload item2cut" onerror="this.src='./images1/noimage.gif';" alt="[아쿠아릭] 헤네시 4인소파"  />
        </a>
        <!-- 반응형 시작 -->
        <div class="respGoodsZzim">
            <a class="zzimArea">
                <img src="${best.pimg1}" class="zzimImage normal " alt="찜하기" title="찜하기" />
                <img src="${best.pimg2}" class="zzimImage active hide" alt="찜한 상품" title="찜한 상품" />
            </a>
        </div>
        <!-- 반응형 끝 -->
    </div>
<div class="resp_display_goods_info infO_style_4">
    <!-- 상품명-->
    <div class="goodS_info displaY_goods_name">
        <span class="areA"><a href="/item?pcode=${best.pcode}">${best.pname}</a></span>
    </div>
    <!-- 비회원 대체문구 -->
    <div class="infO_group">
        <!-- (할인혜택)판매가 -->
        <div class="goodS_info displaY_sales_price">
            <span class="areA">					
                <span class="nuM"><fmt:formatNumber value="${best.psale}" pattern="#,###"/></span>&#x20a9;
            </span>
        </div>
    </div>
    <!-- 짧은 설명 -->
    <div class="goodS_info displaY_goods_short_desc">
        <span class="areA">${best.psub_ex}</span>
    </div>
</div>
</div>
</li>
</ul>
<!--BEST Collection 상품 반복코드 끝 -->
    </c:forEach>

</div>
<!-- scrollbar -->
<div class="display-scrollbar swiper-scrollbardesignDisplay_633b83b7791e9"></div>
</div>
<!-- left, right button -->
<div class="swiper-button-next"></div>
<div class="swiper-button-prev"></div>
</div>

<script>
var t = new Date();
var uniquekey_dsp = 'designDisplay_633b83b7791e9'+t.getTime();
var display_swiper = [];

$(function(){
    /* 상품디스플레이 스와이프형 탭 스크립트 */
    $("#designDisplay_633b83b7791e9 .displaySwipeTabContainer").each(function(){
        var tabContainerObj = $(this);
        tabContainerObj.children('li').css('width',(100/tabContainerObj.children('li').length)+'%');
        tabContainerObj.children('li').bind('mouseover click',function(){
            tabContainerObj.children('li.current').removeClass('current');
            $(this).addClass('current');
            var tabIdx = tabContainerObj.children('li').index(this);
            tabContainerObj.closest('.designDisplay, .designCategoryRecommendDisplay').find('.displayTabContentsContainer').hide().eq(tabIdx).show();
        }).eq(0).trigger('mouseover');
    });


    $('.display_slide_class').each(function(){
        if(!$(this).hasClass('set_slide_clear')){
            display_swiper[uniquekey_dsp] = new Swiper($(this).find('.goods_display_slide_wrap'), {
                    slidesPerView: 'auto',
                grabCursor: true,
                autoplay: 3000,
                nextButton: $(this).find('.swiper-button-next'),
                prevButton: $(this).find('.swiper-button-prev')
            });
            $(this).addClass('set_slide_clear').bind('mousedown touchstart touchmove',function(){
                $('.active_swipe_slide').removeClass('active_swipe_slide');
                $(this).addClass('active_swipe_slide');
            });
        }
    });
});
</script>
</div>
</div>