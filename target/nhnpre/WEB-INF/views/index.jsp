<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <style>
        #textemail{
            font-size: 15px;
            color : darkgray;
            line-height: 2;
            text-align: left;
        }
        #textbody{
            font-size: 20px;
            color: black;
            font-weight: bold;
            line-height: 2;
            text-align: center;
        }
        #textback{
            background: whitesmoke;
            left:50%;
            margin: 10px 10px 10px 10px;
            padding: 40px 40px 40px 40px;
        }
    </style>
</head>
<body>
<form>
    Email : &nbsp;&nbsp;&nbsp;<input type="text" id="email" name="email" required="true"><br/>
    Password : <input type="password" id="password" name="password" required="true"><br/>
    내용<br/>
    <textarea id="text" name="text" cols="50" rows="4" required="true"></textarea>
    <button class="btn btn-primary" id="addBtn">등록</button>
    <!--
    <div id="addBtn">
        <input type="submit" name="add" value="등록" >&nbsp;&nbsp;
    </div>
    -->
</form>
<c:forEach var="article" items="${articles}">
    <div id="textback">
        <div class="row">
            <p id="textemail">${article.email}</p>
            <button class="btn btn-default">삭제</button>
        </div>
        <div class="row">
            <p id="textbody">${article.text}</p>
        </div>
        <div style="text-align: right">
            <fmt:formatDate value="${article.add_time}" pattern="MM-dd hh:mm"/>
        </div>
    </div>
</c:forEach>
<!--
    <table class="table table-bordered table-hover">
        <tbody>
        <c:forEach var="article" items="${articles}">
            <tr align="center">
                <td>${article.email}</td>
                <td><fmt:formatDate value="${article.add_time}" pattern="MM-dd hh:mm"/></td>
            </tr>
            <tr align="center">
                <td>${article.text}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    -->
</body>
<script src="../resources/jquery/jquery-3.1.1.min.js"></script>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script>
    $('#addBtn').click(function () {
        var form = $('form').serialize();
        var email = document.form.email.value;
        var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

        alert(email);
        if(regex.test(email) === false) {
            alert("잘못된 이메일 형식입니다.");
            return false;
        } else {
            $.ajax({
                url: '/add',
                type: 'POST',
                data: form,
                success: function () {
                    $.bigBox({
                        title: "",
                        content: "등록되었습니다.",
                        color: "#296191",
                        timeout: 3000,
                        icon: "fa fa-bell swing animated"
                    });
                }
            })
        }
    })
</script>
</html>
