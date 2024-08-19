<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- heafer.jsp -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<div class="container p-5">
    <h1>게시판</h1>
    <div id="writeForm">
        <h2>글쓰기</h2>
        <form id="writePost" action="/todo/save" method="POST">
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" required><br>
            
            <label for="content">내용:</label>
            <textarea id="content" name="content" required></textarea><br>
            
            <label for="username">닉네임:</label>
            <input type="text" id="username" name="username" required><br>
            
            
            <label for="password">비밀번호:</label>
            <input type="number" id="password" name="password" required><br>
            
            <button type="submit">작성</button>
        </form>
    </div>
    
   
    
    <!-- foofer.jsp -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>