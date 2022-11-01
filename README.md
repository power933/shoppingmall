# shoppingmall
가구 및 디자인 용품 쇼핑몰(사용자 page)

1. 개발환경
언어 : Java(JDK 11) HTML/CSS, JavaScript
서버 : Apache Tomcat9.0
프레임워크 : SpringBoot 2.7.5, Mybatis
DB : MySQL
IDE : IntelliJ
라이브러리 : Jquery(ajax), JSTL, lombok
API : BootPay, 주소찾기api
web-server : cafe24

2. 개발 기간 및 인원
개발기간 : 10/24 ~ 11/01
개말인원 : 2명(퍼블리싱을 제외한 파트 담당)

3. 각 파트별 상세


**
1) 메인페이지(index)
Celebrity Collection : 각 카테고리별로 상품정렬
기본 주소는 / 이며
카테고리 클릭시 /{category} 로 이동되어 view 전환.
Best collection - 인기 상품(판매량 기준) 
New Collection - 최신상품(등록일기준) 정렬하여 상품을 보여줌

2)회원가입
아이디,이메일 - ajax를 통해 onkeyup시 값을 중복체크를 진행

3)로그인
로그인 시 세션에 아이디 및 이름 저장

4)상품page
상품선택시 id값인 상품code를 통해 불러오며
상품의 수량 선택 후 구매페이지나 장바구니페이지로 이동 가능(비회원 장바구니는 아직 미구현입니다)

5)장바구니
js를 통하여 상품클릭시 각 상품별 금액 및 총합금액을 나타내며
바로 구매, 전체 상품 구매시 상품의 코드 및 장바구니의 id값 전달(구매 확정 후 해당 장바구니 id 삭제)

6)구매
구매는 bootpay api를 이용했으며
필수조건을 모두 입력하고 결제하기를 눌렀을 시

해당 상품들의 코드와 수량들을 받아
ajax를 통해 재고수량 여부를 파악하고
재고가 존재할 시 결제를 진행하고 상품구매리스트 DB에 필요한 정보들을 받아 저장한다.

7)공지사항 페이지
기본적인 페이징 기능과 각 파트(일반공지,긴급공지)선택 여부에 따른 검색기능 구현





