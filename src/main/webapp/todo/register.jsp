<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24. 8. 7.
  Time: 오전 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Register</title>
</head>
<body>
<h1>Todo Register</h1>
<form action="/todo/register" method="post">
    <div>
      제목:  <input type="text" name="title" placeholder="제목 입력">
    </div>
    <div>
      날짜:  <input type="date" name="dueDate">
    </div>
    <div>
        <button type="reset">초기화</button>
        <button type="submit">등록처리</button>
    </div>
</form>
</body>
</html>
