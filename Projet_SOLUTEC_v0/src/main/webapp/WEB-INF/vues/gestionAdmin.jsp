<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>

<!-- 	Header : -->
	<%@include file="/WEB-INF/inc/header.jsp" %>
	
	
<!-- 	Body : -->
<br>
<br>
<br>
<br>
<br>
<br>
<br>

	<h3>Page gestionAdmin</h3>
		
	
<!-- 	Definition des categories : -->
<!-- 	/!\ A enlever une fois qu'on aura résolu le problème de foreign key /!\  -->
			
<label for="pet-select">Choose a pet:</label>

<select name="pets" id="pet-select">
    <option value="">--Please choose an option--</option>
    <option value="dog">Dog</option>
    <option value="cat">Cat</option>
    <option value="hamster">Hamster</option>
    <option value="parrot">Parrot</option>
    <option value="spider">Spider</option>
    <option value="goldfish">Goldfish</option>
</select>
		 
		

<%-- <form:form method="POST" commandName="electromenager" action="gestionAdmin"> --%>
<!-- <table> -->
<!--     <tr> -->
<!--         <td>Catégorie : </td> -->
<%--  		<td><form:select path="idCategorie" items="${categoriesMap}"/></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<!--         <td> -->
<!--             <input type="submit" value="Submit"/> -->
<!--         </td> -->
<!--     </tr> -->
<!-- </table>   -->
<%-- </form:form> --%>


<!-- 	Ajout de produits : -->

<%-- 		<form:form modelAttribute="produit"> --%>
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td>Nom : </td> -->
<%-- 					<td><form:input path="name" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Catégorie : </td> -->
<%-- 					<td><form:input path="idCategorie"/></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Marque : </td> -->
<%-- 					<td><form:input path="marque" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Prix : </td> -->
<%-- 					<td><form:input path="prix" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Nom du fichier de la photo : </td> -->
<%-- 					<td><form:input path="photo" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Classe energetique : </td> -->
<%-- 					<td><form:input path="classeEnergetique" /></td> --%>
<!-- 				</tr> -->
<!-- 				<td><input type="submit" value="Ajout d'un produit" ></td> -->
<!-- 			</table> -->
<%-- 		</form:form> --%>
		
<!-- 	Tableau récapitulatif des produits : -->
<!-- 		<table border="1"> -->
<!-- 			<tr> -->
<!-- 				<th><s:message code="c.nom" /></th> -->
<!-- 				<th><s:message code="c.prenom" /></th> -->
<!-- 				<th><s:message code="c.nomDeCompte" /></th> -->
<!-- 			</tr> -->
<%-- 			<c:forEach items="${utilisateurs}" var="u"> --%>
<!-- 				<tr> -->
<%-- 					<td>${u.nom}</td> --%>
<%-- 					<td>${u.prenom}</td> --%>
<%-- 					<td>${u.nomDeCompte}</td> --%>
<!-- 				</tr> -->
<!-- 			</c:forEach> -->
<!-- 		</table> -->
		
		
<!-- 	Footer -->
	<%@include file="/WEB-INF/inc/footer.jsp" %>
</html>