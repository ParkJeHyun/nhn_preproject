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
            max-width: 600px;
            left:50%;
            margin: 10px auto 10px auto;
            padding: 40px 40px 40px 40px;
        }
    </style>
</head>
<body>
<div class="container">
    <form style="max-width: 600px; margin: auto; padding: 50px">
        <input type="email" id="email" class="form-control" name="email" placeholder="Email Address" required="true"><br/>
        <input type="password" id="password" class="form-control" name="password" placeholder="Password" required="true"><br/>
        <textarea id="text" name="text" rows="4" required="true" placeholder="내용" style="width:100%;"></textarea><br/>
        <input type="button" class="btn btn-primary" onclick="add_article()" value="등록" style="margin-top: 15px; width: 40%; float: right">
        <!--
        <div id="addBtn">
            <input type="submit" name="add" value="등록" >&nbsp;&nbsp;
        </div>
        -->
    </form>
</div>
<c:forEach var="article" items="${articles}">
    <div class="container">
        <div id="textback">
            <div class="row">
                <div class="col-md-8">
                    <p id="textemail">${article.email}</p>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-danger" style="float: right;">삭제</button>
                    <button class="btn btn-warning" style="float: right; margin-right: 5px">수정</button>
                </div>
            </div>
            <div style="text-align: right">
                <fmt:formatDate value="${article.add_time}" pattern="MM-dd hh:mm"/>
            </div>
            <div class="row">
                <p id="textbody">${article.text}</p>
            </div>
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
    function add_article() {
        var form = $('form').serialize();
        $.ajax({
            url: '/add',
            type: 'POST',
            data: form,
            success: function (responseData) {
                if(responseData == 1){
                    alert("등록되었습니다.");
                    window.location.href = '/';
                }
                else if(responseData == 2){
                    alert("Email 형식이 잘못 되었습니다.");
                }
            },
            error: function (request, status, error) {
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        })
    }
//    $('#addBtn').click(function () {
//        var form = $('form').serialize();
//        $.ajax({
//            url: '/add',
//            type: 'POST',
//            data: form,
//            success: function (responseData) {
//                alert(responseData);
//            },
//            error: function (request, status, error) {
//                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
//            }
//        })
//    })
</script>
</html>
