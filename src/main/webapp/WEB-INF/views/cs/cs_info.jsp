<%@page import="java.util.Arrays"%>
<%@page import="faq.DtoFaq"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String url = request.getContextPath();
	ArrayList<faq.DtoFaq> al = (ArrayList<faq.DtoFaq>)request.getAttribute("al");
	String[] menu = {"배송안내","반품/교환안내","상품안내","쿠폰안내","마일리지안내","자주묻는질문"};
%>
<meta charset="utf-8">
<div id="boardlayout" >
    <div class="subpage_wrap">
        <div id="subpageLNB" class="subpage_lnb">
<div id="boardLnbCommon">
    <h2 class="title1"><a href= "<%=url %>/cs.do" designElement="text" >CS CENTER</a></h3>
    <ul class="lnb_sub">
        <li ><a href="#" designElement="text">공지사항</a></li>
        <li ><a href="#" designElement="text">자주 묻는 질문</a></li>
        <li ><a href="#" designElement="text">상품문의</a></li>
        <li ><a href="#" designElement="text"><b>상품후기</b></a></li>
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
        <!-- +++++ cscenter contents ++++ -->
        <div class="subpage_container">
            <!-- 전체 메뉴 -->
            <a id="subAllButton" class="btn_sub_all" href="#" designElement="text">MENU</a>

            <!-- -->
            <div class="cs_top2 mycs_fcont_margin">
                <a class="menu2" href="<%=url %>/cs.do?cate=1" designElement="text"><span class="area"><span class="text2">배송문의</span></span></a>
                <a class="menu3" href="<%=url %>/cs.do?cate=2" designElement="text"><span class="area"><span class="text2">반품/교환문의</span></span></a>
                <a class="menu1" href="<%=url %>/cs.do?cate=3" designElement="text"><span class="area"><span class="text2">상품문의</span></span></a>
                <a class="menu9" href="<%=url %>/cs.do?cate=4" designElement="text"><span class="area"><span class="text2">쿠폰내역</span></span></a>
                <a class="menu10" href="<%=url %>/cs.do?cate=5" designElement="text"><span class="area"><span class="text2">마일리지내역</span></span></a>
                <a class="menu5" href="<%=url %>/cs.do?cate=6" designElement="text"><span class="area"><span class="text2">자주묻는질문</span></span></a>
            </div>

            <!-- 타이틀 -->
            <div class="title_container2">
                <h3 class="title_sub6"><span designElement="text" textIndex="8" >자주 묻는 질문</span> <span class="top5" designElement="text" textIndex="9" >TOP5</span></h3>
                <a class="btn_thebogi" href="#" designElement="text" textIndex="10" >더보기</a>
            </div>
            
            <ul class="faq_new v2">
                <li>
                    <%for(int i=0; i<al.size();i++){ %>
                    <div class="question">
                        <p class="subject pointer boad_faqview_btn" board_seq="<%=i+1%>"> <span class="cat">[<%=menu[(Integer.parseInt(al.get(i).getFcategory())-1)] %>]</span> <%=al.get(i).getFquestion() %>    </p>
                        <p class="add_info">
                            <span class="hide">번호:  <%=al.get(i).getFidx() %></span>
                        </p>
                    </div>
                    
                    <div id="faqcontent_<%=i+1 %>" class="answer hide">								
                        <p style="box-sizing: inherit;"><%=al.get(i).getFanswer() %></p>
                    </div>
                    <%} %>
                </li>
            </ul>
            <script type="text/javascript">
            // FAQ 게시글 보기
            $('.boad_faqview_btn').on('click', function() { 
                var board_seq = $(this).attr('board_seq');
                $("#faqcontent_"+board_seq).toggle();
            }); 
            </script>
        </div>
        
    </div>
    <script type="text/javascript" src="./js/cscenter_ui.js"></script><!-- 고객센터 ui 공통 -->

</div>
        
        </div>
</div>
