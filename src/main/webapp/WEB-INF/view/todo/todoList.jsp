<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- heafer.jsp -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<div class="container p-5">
	<c:choose>
		<c:when test="${list != null}">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성자</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}">
						<tr>
							<td>${list.id}</td>
							<td>${list.title}</td>
							<td>${list.content}</td>
							<td>${list.username}</td>
							<td>
								<div class="d-flex">

									<form action="/todo/delete" method="GET">
										<input type="hidden" id="id" name="id" value="${list.id}">
										<button class="btn btn-danger">삭제</button>
									</form>

									<form action="/todo/update" method="GET">
										<input type="hidden" id="id" name="id" value="${list.id}">
										<button class="btn btn-warning">수정</button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
					<c:choose>
						<c:when test="${totalPages != null}">
							<ul class="pagination">
								<li class="page-item <c:if test='${currentPage == 1}'>disabled</c:if>"><a class="page-link" href="?type=${type}&page=${currentPage - 1}&size=${size}">이전
										페이지</a></li>
								<c:forEach begin="1" end="${totalPages}" var="page">
									<li class="page-item <c:if test='${page == currentPage}'>active</c:if>"><a class="page-link" href="?type=${type}&page=${page}&size=${size}">${page}</a></li>
								</c:forEach>
								<li class="page-item <c:if test='${currentPage == totalPages}'>disabled</c:if>"><a class="page-link" href="?type=${type}&page=${currentPage + 1}&size=${size}">다음
										페이지</a></li>
							</ul>
						</c:when>
					</c:choose>
					</ul>
				</tbody>
				
			</table>
		</c:when>
		<c:otherwise>
			<div>
				<h5>아직 게시글이 없습니다</h5>
			</div>
		</c:otherwise>
	</c:choose>

</div>

<!-- foofer.jsp -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>