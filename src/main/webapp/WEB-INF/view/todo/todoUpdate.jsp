<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- heafer.jsp -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<div class="container p-5">
    <h1>게시판</h1>
    <div id="writeForm">
        <h2>수정하기</h2>
        
        <form action="/todo/update?id=${todo.id}" method="POST">
            
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" required value="${todo.title}"><br>
            
            <label for="content">내용:</label>
            <textarea id="content" name="content" required>${todo.content}</textarea><br>
            
            <label for="password">비밀번호:</label>
            <input type="number" id="password" name="password" required value="${todo.password}"><br>
            
            <button type="submit">수정</button>
        </form>
    </div>

<!-- foofer.jsp -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>