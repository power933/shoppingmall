<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" name="ids" id="ids" value="">
<input type="text" name="ids" id="ids1" value="">
<input type="text" name="ids" id="ids2" value="">
</body>
<script>
    var name = localStorage.getItem("mid");
    document.getElementById("ids").value = localStorage.getItem("mid");
    document.getElementById("ids1").value = localStorage.getItem("mpw");
    document.getElementById("ids2").value = sessionStorage.getItem("mname");
    console.log(localStorage.getItem("data"));
</script>
</html>
