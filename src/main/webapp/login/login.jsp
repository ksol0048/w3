<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>로그인 페이지</h1>
<c:if test="${param.result =='error'}">
    <h1>로그인 에러</h1>
</c:if>
<form action="/login" method="post">
    <div>
        <input type="text" name="id">
    </div>
    <div>
        <input type="password" name="password">
    </div>
    <div>
        <button type="reset">리셋</button>
        <button type="submit">로그인</button>
    </div>
</form>
</body>
</html>
