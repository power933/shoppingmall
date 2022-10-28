<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>localstorage 저장</title>
</head>
<body>


</body>
</html>
<script>
    console.log(typeof(Storage));
    if(typeof(Storage)!="undefined"){   //
        //localStorage : 비휘발성
        //sessionStorage : 1회성
        var datas=["hong@nate.com","010-1234-5678"];
        localStorage.setItem("data",JSON.stringify(datas)); //json을 string으로 바꿔서 저장
        localStorage.setItem("mid","hong_gil");
        localStorage.setItem("mpw","1234");
        sessionStorage.setItem("mname","HHGild");

    }else{
        alert("해당 브라우저는 접근이 되지 않습니다");
    }
</script>