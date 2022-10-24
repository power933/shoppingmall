<%--
  Created by IntelliJ IDEA.
  User: tjoeun
  Date: 2022-10-24
  Time: 오전 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>

<head>

    <title></title>

</head>

<body>

남은 글자수

<h1>150</h1>

<textarea></textarea>



<script type="text/javascript" src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script type="text/javascript">

    $('textarea').keyup(function () {

        var inputLength = $(this).val().length;

        var remain = 150 - inputLength;



        $('h1').html(remain);



        if (remain >= 0) {

            $('h1').css('color','blue');

        } else {

            $('h1').css('color','red');

        }



    });

</script>



</body>

</html>