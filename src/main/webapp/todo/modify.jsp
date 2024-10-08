<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24. 8. 7.
  Time: 오전 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Modify</title>
</head>
<body>
<h1>Todo Modify</h1>
<form id="form1" action="/todo/modify" method="post">
    <div>
        번호: <input type="text" name="tno" value="${dto.tno}" readonly>
    </div>
    <div>
        제목: <input type="text" name="title" value="${dto.title}">
    </div>
    <div>
        날짜: <input type="date" name="dueDate" value="${dto.dueDate}">
    </div>
    <div>
        실행 여부: <input type="checkbox" name="finished" ${dto.finished ? "checked":""}>
    </div>

    <div>
        <button type="submit">수정</button>
    </div>
</form>

<form id="form2" action="/todo/remove" method="post">
    <input type="hidden" name="tno" value="${dto.tno}" readonly>
    <div>
        <button type="submit">삭제</button>
    </div>
</form>
</body>
</html>
