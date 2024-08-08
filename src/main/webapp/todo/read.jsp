<jsp:useBean id="dto" scope="request" type="kroryi.w3.todo.dto.TodoDTO"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
<h1>Todo Read</h1>
<div>
    번호: <input type="text" name="tno" value="${dto.tno}" readonly>
</div>
<div>
    제목: <input type="text" name="title" value="${dto.title}" readonly>
</div>
<div>
    날짜: <input type="date" name="dueDate" value="${dto.dueDate}">
</div>
<div>
    실행 여부: <input type="checkbox" name="finished" ${dto.finished ? "checked":""} disabled>
</div>

<a href="/todo/modify?tno=${dto.tno}">수정/삭제</a>
<a href="/todo/list">목록보기</a>
</body>
</html>
