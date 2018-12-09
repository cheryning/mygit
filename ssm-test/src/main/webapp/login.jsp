<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

<h1>欢迎${user.username}</h1>
<hr>
<div>
  <h1>用户列表</h1>
  <table border="1" cellpadding="10" cellspacing="0">
  <thead>
  	<tr>
  		<td>ID</td>
  		<td>姓名</td>
  		<td>年龄</td>
  	</tr>
  	</thead>
  	<c:forEach items="${listusers}" var="u">
  	 <tr>
  	 	<th>${u.id}</th>
  	 	<th>${u.username}</th>
  	 	<th>${u.age}</th>
  	 </tr>
  	 </c:forEach>
  </table>
  <a  class='first'>共${sum}页</a>
  </br>
  <c:if test="${indexnum!=1}"> 
 <a href="${pageContext.request.contextPath}/user/test?page=1" class='first'>首页</a> 
  <a href="${pageContext.request.contextPath}/user/test?page=${indexnum-1}" class='first'>上一页</a> 
 </c:if>
 <span>第${indexnum}页</span>
  <c:if test="${indexnum !=sum}">
 <a href="${pageContext.request.contextPath}/user/test?page=${indexnum+1}" class='first'>下一页</a> 
  <a href="${pageContext.request.contextPath}/user/test?page=${sum}" class='first'>尾页</a>
  </c:if>
</div>
</body>

</html>
