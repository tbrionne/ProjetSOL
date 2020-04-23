<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<!-- 	Header : -->
	<%@include file="/WEB-INF/inc/header.jsp" %>
	
	
<!-- 	Body : -->

			<form action="admin/ajouter" method="POST">
		<tr>

<!-- 			<td>CATEGORIE<input type="number"  name="categorie_id"/></td> <br> -->
			<td><label for="categorie">Catégories :</label>
				<select name="categorie_id" id="categorie">
				    <option value="">-Choisissez une catégorie-</option>
				    <option value="1">Réfrigérateur</option>
				    <option value="2">Lave-vaisselle</option>
				    <option value="3">Four</option>
				    <option value="4">Plaque de cuisson</option>
				</select></td> <br>
			<td>NOM PRODUIT<input type="text"  name="produit_name"/></td> <br> 
			<td>MARQUE<input type="text"  name="marque"/></td>   <br>
			<td>PRIX<input type="text"  name="prix"/></td> <br>
			<td>PHOTO<input type="text"  name="photo"/></td>  <br> 
<!-- 			<td>CLASSE ENERGETIQUE<input type="text"  name="classe_energetique_id"/></td>  -->
			
			<td><input type="submit" value="AJOUTER CE PRODUIT"/></td>		 
		</tr>
		
	</form>	
	
	
	<!-- 	Tableau récapitulatif des produits : -->
		
		<h3>Produits dans la base :</h3>
		
		<table border="1">
			<tr>
				<th>ID</th>
				<th>NOM</th>
				<th>CATEGORIE</th>
				<th>MARQUE</th>
				<th>PRIX</th>
<!-- 				<th>CLASSE ENERGETIQUE</th> -->
				<th>PHOTO</th>
			</tr>
			<c:forEach items="${gestionAdmin}" var="p">
				<tr>
					<td>${p.produit_id}</td>
					<td><input type="text" value="${p.produit_name}" name="NOM" /></td>
					<td><input type="text" value="${p.categorie_id}" name="CATEGORIE" /></td>
					<td><input type="text" value="${p.marque}" name="MARQUE" /></td>
					<td><input type="text" value="${p.prix}" name="PRIX" /></td>
<%-- 					<td><input type="text" value="${p.classe_energetique_id}" name="CLASSE ENERGETIQUE" /></td> --%>
					<td><input type="text" value="${p.photo}" name="PHOTO" /></td>
					<td><a href="admin/supprimer?produit_id=${p.produit_id}">Supprimer</a></td>
				</tr>
				</form>
			</c:forEach>
		</table>
	
	
	<!-- 	Footer -->
	<%@include file="/WEB-INF/inc/footer.jsp" %>
</html>
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	
<!-- 	Definition des categories : -->
<!-- 	/!\ A enlever une fois qu'on aura résolu le problème de foreign key /!\  -->
			
<!-- <label for="pet-select">Choose a pet:</label> -->

<!-- <select name="pets" id="pet-select"> -->
<!--     <option value="">--Please choose an option--</option> -->
<!--     <option value="dog">Dog</option> -->
<!--     <option value="cat">Cat</option> -->
<!--     <option value="hamster">Hamster</option> -->
<!--     <option value="parrot">Parrot</option> -->
<!--     <option value="spider">Spider</option> -->
<!--     <option value="goldfish">Goldfish</option> -->
<!-- </select> -->
		 

	

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

<%-- 	<form:form modelAttribute="produit"> --%>
<%-- 		<label>Nom : </label><form:input path="name"/><br> --%>
<%-- 		<label>Categorie : </label><form:input path="idCategorie"/><br> --%>
<%-- 		<label>Marque : </label><form:input path="marque"/><br> --%>
<%-- 		<label>Prix : </label><form:input path="prix"/><br> --%>
<%-- 		<label>Nom du fichier de la photo : </label><form:input path="photo"/><br> --%>
<%-- 		<label>Classe energetique : </label><form:input path="classeEnergetique"/><br> --%>
		
<%-- 		<input type="submit" value='<spring:message code="b_ajout_utilisateur"/>'/><br> --%>
<%-- 	</form:form> --%>

<%-- 		<form:form modelAttribute="produit"> --%>
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td>Nom : </td> -->
<%-- 					<td><form:input path="produit_name" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Catégorie : </td> -->
<%-- 					<td><form:input path="categorie_id"/></td> --%>
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
<!--  			<tr>  --> 
<!-- 				<td>Classe energetique : </td>  --> 
<%-- 					<td><form:input path="classe_energetique_id" /></td>  --%> 
<!-- 				</tr> 

				
				
<!-- 			</table> -->
<%-- 		</form:form> --%>
		
<!-- 		<a href="admin/ajouter"> Ajouter un produit</a> -->
		
		

		
		
