# shoppingmall
가구 및 디자인 용품 쇼핑몰(사용자 page)

Url : http://power933.cafe24.com

1. 개발환경
  언어 : Java(JDK 11), HTML/CSS, JavaScript

  서버 : Apache Tomcat9.0

  프레임워크 : SpringBoot 2.7.5, Mybatis

  DB : MySQL

  IDE : IntelliJ

  라이브러리 : Jquery(ajax), JSTL, lombok

  API : BootPay, 다음(주소찾기), 카카오(지도,로그인)

  web-server : cafe24

2. 개발 기간 및 인원
개발기간 : 10/24 ~ 11/07
개말인원 : 2명(퍼블리싱을 제외한 파트 담당)

3. 각 파트별 상세



**페이지 구성**


1 메인페이지(index)
Celebrity Collection : 각 카테고리별로 DB에서 불러와 상품정렬
기본 주소는 / 이며
카테고리 클릭시 /{category} 로 이동되어 view 전환.
Best collection - 인기 상품(판매량 기준) 
New Collection - 최신상품(등록일기준) 정렬하여 상품을 보여줌

2 회원가입
아이디,이메일 - ajax를 통해 onkeyup시 값을 중복체크를 진행
카톡 로그인 - 비회원일시 회원가입 후 로그인처리

3 로그인
로그인 시 세션에 아이디 및 이름 저장, localstarage로 아이디 저장버튼 체크 시 id저장 가능

4 상품page
상품선택시 id값인 상품code를 통해 불러오며
상품의 수량 선택 후 구매페이지나 장바구니페이지로 이동 가능


5 장바구니
js를 통하여 체크박스클릭시 각 상품별 금액 및 총합금액을 나타내며
바로 구매, 전체 상품 구매시 상품의 코드 및 장바구니의 id값 전달(구매 확정 후 해당 장바구니 id 삭제)
비회원이 장바구니에 추가 시 쿠키가 없을 경우 mid 랜덤변수를 생성하여
db테이블에 추가하고 이를 통해 장바구니 정보를 확인케 함


6 구매
구매 API는 bootpay api를 이용했으며
필수조건을 모두 입력하고 결제하기를 눌렀을 시
해당 상품들의 코드와 수량들을 받아
ajax를 통해 재고수량 여부를 파악하고
재고가 존재할 시 결제를 진행하고 상품구매리스트 DB에 필요한 정보들을 받아 저장한다.


7 공지사항 페이지
기본적인 페이징 기능과 각 파트(일반공지,긴급공지)선택 여부에 따른 검색기능 구현 및 긴급공지의 경우 모든 페이지의 최상단에 위치할 수 있도록 구현.
http://power933.cafe24.com/notice


8 회사 info
관리자 페이지에서 작성한 회사 정보를 불러와 출력 + 카카오 지도API
http://power933.cafe24.com/company

todo..
로그인 시큐리티로 처리
관리자 page 깃허브 url : https://github.com/power933/shoppingmall_admin



