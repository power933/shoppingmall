<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>


<meta charset="utf-8">
<div id="boardlayout" >
    <div class="subpage_wrap">
        <div id="subpageLNB" class="subpage_lnb">
<div id="boardLnbCommon">
    <h3 class="title1"><a href="#" designElement="text">CS CENTER</a></h3>
    <ul class="lnb_sub">
        <li ><a href="/notice" designElement="text">공지사항</a></li>
        <li ><a href="/cs" designElement="text">자주 묻는 질문</a></li>
        <%--<li ><a href="#" designElement="text">상품문의</a></li>
        <li ><a href="#" designElement="text"><b>상품후기</b></a></li>--%>
    </ul>
</div>
<script>
$(function() {
    // 고객센터 LNB 텍스트 수정기능으로 삭제시, 클라이언트단에서 삭제 처리
    $('#boardLnbCommon a').each(function(e) {
        if ( $(this).text() == '' ) {
            $(this).parent('li, h2').remove();
        }
    });
});
</script>
        </div>
    <div class="subpage_container">
        <!-- 전체 메뉴 -->
        <a id="subAllButton" class="btn_sub_all" href="javascript:void(0)"><span designElement="text" textIndex="1"  textTemplatePath="cmVzcG9uc2l2ZV93cmlzdHdhdGNoX2NsYXNzaWNfZ2wvYm9hcmQvaW5kZXguaHRtbA==" >MENU</span></a>

        <!-- 타이틀 ( 관리자에서 설정한 "게시판명"이 노출됩니다. ) -->
        <div class="title_container">
            <h2>공지사항</h2>
        </div>

        <div id="bbslist">
<input type="hidden" name="startPage" value="${dto.startPage}">
<ul class="bbs_top_wrap">
    <li class="left">
        <select name="searchType" id="searchcategory">
            <option value="w"  ${dto.searchType eq 'w'?'selected':''}>- 전체 -</option>
            <option value="n" ${dto.searchType eq 'n'?'selected':''} >공지</option>
            <option value="y" ${dto.searchType eq 'y'?'selected':''} >긴급공지</option>
        </select>
    </li>
    <li class="right2">
        <span class="searchform">
            <input type="text" name="searchWord" id="search_text" class="res_bbs_search_input" value="${dto.searchWord}" title="제목, 내용" />
            <button type="submit" class="btn_resp size_b" >검색</button>
            <button type="button" class="btn_resp size_b" onclick="location.href='notice'">초기화</button>
        </span>
    </li>
</ul>
<div class="article_info hide">
총 0개 (현재 0/총 0페이지)
</div>
<c:choose>
    <c:when test="${list==null}">
<!--등록된 글이 없을 경우-->
<div class="no_data_area2">
    등록된 게시글이 없습니다.
</div>
    </c:when>

<c:otherwise>
<!--등록된 글이 있을 경우-->
<div class="res_table">
<ul class="thead">
<li style="width:45px;"><span designElement="text">번호</span></li>
<li><span designElement="text">제목</span></li>
<li style="width:94px;"><span designElement="text">작성자</span></li>
<li style="width:84px;"><span designElement="text">등록일</span></li>
</ul>

<!--반복구간 사항-->
<c:forEach var="list" items="${list}">
<ul class="tbody">
<li class="mo_hide">
<span class="mtitle" designElement="text">번호:</span> ${list.idx}</li>
<li class="subject">
${list.ntitle}
</li>
<li class="subject" style="text-align: center;">
${list.nwriter}
</li>
<li class="subject" style="text-align: center;">
${list.ndate}
</li>
</ul>
</c:forEach>
    </c:otherwise>
    </c:choose>
<!--반복구간 종료-->
</div>
<div id="pagingDisplay" class="paging_navigation">
<p>
<!--페이지 번호 반복구간-->
<c:forEach var="i" begin="1" end="${size}" step="1">
<a class="on red" href="<c:url value="?startPage=${i}&searchWord=${dto.searchWord}&searchType=${dto.searchType}"/>">${i }</a>
</c:forEach>
<!--페이지 번호 반복구간-->
</p>
</div>

     </div>
    </div>
<!--공지사항 끝-->