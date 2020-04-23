<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>

<!-- 	Header : -->
	<%@include file="/WEB-INF/inc/headerAdmin.jsp" %>
	
	
<!-- 	Body : -->

	<h3>Page admin</h3>
		
		<form:form modelAttribute="admin">
			<table>
				<tr> 
					<td>Login: </td>
					<td><form:input path="login" /></td>
				<tr>
				<tr>
					<td>Password: </td>
					<td><form:password path="password" /></td>
				<tr>
				<td><input type="submit" value="Sign in" ></td>
			</table>
		</form:form>
		
		
		<%@include file="/WEB-INF/inc/footer.jsp" %>
		
</html>