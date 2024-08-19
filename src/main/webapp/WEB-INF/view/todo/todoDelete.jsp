<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- heafer.jsp -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<div class="container p-5">
    <h1>게시판</h1>
    <div id="writeForm">
        <h2>삭세</h2>
        <form id="writePost" action="/todo/delete?id=${id}" method="POST">
            <label for="password">비빌번호를 입력 해주세요</label>
            
            <input type="number" id="password" name="password" required><br>
            
            <button type="submit">삭제</button>
        </form>
    </div>
    
   
    
    <!-- foofer.jsp -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>