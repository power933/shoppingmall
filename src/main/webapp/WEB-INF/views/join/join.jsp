<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<div class="title_container">
    <h2><span designElement="text" textIndex="1">회원정보 입력</span></h2>
</div>
<div class="mypage_greeting Pb30">
    <span class="pilsu_icon"></span> <span designElement="text" textIndex="2">항목은 <span class="pointcolor">필수 입력</span> 항목입니다.</span>
</div>


<div class="resp_member_join_wrap">
    <div id="formMemberArea" class="resp_member_join">
        <input type="hidden" name="kid_agree" value=""/>
        <div class="resp_join_table">
            <ul class="required">
                <li class="th "><p designElement="text" textIndex="8" >아이디</p></li>
                <li class="td">
                    <input type="text" id="userid" autocapitalize="off" value="" id="mid" name="mid" class="eng_only" placeholder="공백 없는 영문/숫자 포함 6~20자" />
                    <p id="id_info" class="guide_text"></p>
                </li>
            </ul>
            <ul class="required">
                <li class="th "><p designElement="text" textIndex="11" >비밀번호</p></li>
                <li class="td">
                    <input type="password" value="" id="mpass" name="mpass" class="eng_only class_check_password_validation" />
                </li>
            </ul>
            <ul class="required">
                <li class="th "><p designElement="text" textIndex="12" >비밀번호 확인</p></li>
                <li class="td">
                    <input type="password" value="" id="mpassck" class="eng_only" />
                </li>
            </ul>
            <ul class="required">
                <li class="th"><p designElement="text" textIndex="13" >이름</p></li>
                <li class="td">
                    <input type="text" value="" name="mname"  />
                </li>
            </ul>
            <ul class="required">
                <li class="th "><p designElement="text" textIndex="14" >이메일</p></li>
                <li class="td">
                    <input type="email" value="" id="memail0" name="memail0" class="size_mail1" /> @
                    <input type="email" value="" id="memail1" name="memail1" class="size_mail2" />
                    <select id="find_email" onchange="emailselect()">
                        <option value="">직접입력</option>
                        <option value="naver.com">naver.com</option>
                        <option value="nate.com">nate.com</option>
                        <option value="dreamwiz.com">dreamwiz.com</option>
                        <option value="yahoo.co.kr">yahoo.co.kr</option>
                        <option value="empal.com">empal.com</option>
                        <option value="unitel.co.kr">unitel.co.kr</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="korea.com">korea.com</option>
                        <option value="chol.com">chol.com</option>
                        <option value="paran.com">paran.com</option>
                        <option value="freechal.com">freechal.com</option>
                        <option value="hanmail.net">hanmail.net</option>
                        <option value="hotmail.com">hotmail.com</option>
                    </select>
                </li>
            </ul>
            <ul class="required">
                <li class="th "><p designElement="text" textIndex="16" >휴대폰번호</p></li>
                <li class="td">
                    <input type="tel" value="" class="size_phone" maxlength="4" id="mtel0" name="mtel0"  /> -
                    <input type="tel" value="" class="size_phone" maxlength="4" id="mtel1" name="mtel1"   /> -
                    <input type="tel" value="" class="size_phone" maxlength="4" id="mtel2" name="mtel2"  />
                </li>
            </ul>
            <ul >
                <li class="th "><p designElement="text" textIndex="22" >주소</p></li>
                <li class="td">
                    <input type="hidden" value=""/>
                    <input type="tel" value="" class="size_zip_all" id="addr0" name="addr0" readonly />
                    <button type="button" class="btn_resp size_b color4"><span designElement="text" textIndex="23" id="findaddr" >주소찾기</span></button>
                    <div class="address_area">
                        <input type="text" value="" id="addr1" name="addr1"  class="address size_full " readonly />
                        <input type="text" value=""  class="address_street size_full hide" readonly />
                    </div>
                    <div class="address_area">
                        <input type="text" value="" id="addr2" name="addr2" class="size_full" />
                    </div>
                    <p id="address_view" style="padding-top:5px; display:none;"></p>
                </li>
            </ul>

        </div>
    </div>
    <script type="text/javascript">
        $(function(){
            $(".selectLabelSet").each(function(){
                var selectLabelSetObj = $(this);
                $("select.selectLabelDepth1",selectLabelSetObj).bind('change',function(){
                    var childs = $("option:selected",this).attr('childs').split(';');
                    var joinform_seq = $(this).attr('joinform_seq');
                    var select2 = $("input.hiddenLabelDepth[type='hidden'][joinform_seq='"+joinform_seq+"']").val();
                    if(childs[0]){
                        $(".selectsubDepth",selectLabelSetObj).show();
                        $("select.selectLabelDepth2[joinform_seq='"+joinform_seq+"']").empty();
                        for(var i=0; i< childs.length ; i++){
                            $("select.selectLabelDepth2[joinform_seq='"+joinform_seq+"']")
                                .append("<option value='"+childs[i]+"'>"+childs[i]+"</option>");
                        }
                    }else{
                        $(".selectsubDepth",selectLabelSetObj).hide();
                    }
                    $("select.selectLabelDepth2 option[value='"+select2+"']").attr('selected',true);
                }).trigger('change');
            });


            /* ========== 반응형 프론트엔드 추가 ========= */
            // designed radio UI
            $('.designed_radio_checkbox input[type=radio]').closest('.designed_radio_checkbox').addClass('type_radio');
            $('.designed_radio_checkbox input[checked]').parent('label').addClass('on');

            $('.designed_radio_checkbox input[type=radio]').on('change', function() {
                $(this).parent().parent().find('label').removeClass('on');
                $(this).parent('label').addClass('on');
            });
            // designed checkbox UI
            $('.designed_radio_checkbox input[type=checkbox]').on('change', function() {
                if ( $(this).prop('checked') ) {
                    $(this).parent('label').addClass('on');
                } else {
                    $(this).parent('label').removeClass('on');
                }
            });
            /* ========== //반응형 프론트엔드 추가 ========= */
        });

        window.onload = function(){
            document.getElementById("findaddr").addEventListener("click", function(){

                new daum.Postcode({
                    oncomplete: function(data) { //선택시 입력값 세팅
                        document.getElementById("addr0").value=data.zonecode;
                        document.getElementById("addr1").value = data.address;
                        document.querySelector("input[name=addr2]").focus();
                    }
                }).open();
            });
        }

        function emailselect(){
            document.getElementById("memail1").value = document.getElementById("find_email").value;
        }



    </script>
    <!-- ------- //회원가입 입력폼 ------- -->

    <div id="btn_register" class="btn_area_c">
        <button type="submit" class="btn_resp size_c color2 Wmax">
            <span designElement="text">입력 완료</span>
        </button>
    </div>
</div>