<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Todo List</title>
</head>
<style>
    .todoList ul {
        list-style-type: none; /* 기본 불릿 포인트 제거 */
        padding: 0; /* 기본 패딩 제거 */
        margin: 0 0 10px 0; /* 하단에 간격 추가 */
    }

    .todoList ul li {
        display: inline; /* li를 인라인 요소로 설정하여 가로로 배치 */
        margin-right: 10px; /* li 요소 사이 간격 */
    }
</style>
<body>
<h1>Todo List</h1>
<h2>${loginInfo}</h2>
<h2>${loginInfo.mname}</h2>

<div class="todoList">
    <ul>
        <c:forEach var="dto" items="${dtoList}">
            <li>${dto.tno}</li>
            <li><a href="/todo/read?tno=${dto.tno}">${dto.title}</a></li>
            <li>${dto.dueDate}</li>
            <li>${dto.finished? "완료":"미완료"}</li>
        </c:forEach>
    </ul>
    <form method="post" action="/logout">
        <button type="submit">로그아웃</button>
    </form>

</div>
</body>
</html>
