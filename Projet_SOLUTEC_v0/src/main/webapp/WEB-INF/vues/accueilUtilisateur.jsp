<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<%@include file="/WEB-INF/inc/header.jsp" %>
	
	<div>
	<a href="ajouter" class="bouton"><spring:message code="l_creer_utilisateur"/></a><br>
	<a href="utilisateurs" class="bouton"><spring:message code="l_afficher_utilisateurs"/></a>
	</div>
	<%@include file="/WEB-INF/inc/footer.jsp" %>
</html>