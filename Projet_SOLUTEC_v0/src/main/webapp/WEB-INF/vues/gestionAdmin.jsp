<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<!-- 	Header : -->
	<%@include file="/WEB-INF/inc/headerAdmin.jsp" %>
	
	
<!-- 	Body : -->

	<h3>Ajout d'un produit à la base de données : </h3>
	<form action="adminAjouter" method="POST">
		<table>
			<tr>
				<td>Nom : <input type="text"  name="produit_name"/></td>
<!-- 				<td>Catégorie :<input type="number"  name="categorie_id"/></td> -->
<!-- 				Le menu déroulant renvoie un string à categorie_id au lieu d'un integer. -->
			<td><label for="categorie">Catégories :</label>
				<select name="categorie_id" id="categorie">
				    <option value="">-Choisissez une catégorie-</option>
				    <option value="1">Réfrigérateur</option>
				    <option value="2">Lave-vaisselle</option>
				    <option value="3">Four</option>
				    <option value="4">Plaque de cuisson</option>
				</select></td>	
				<td>Marque : <input type="text"  name="marque"/></td>
			</tr>
			<tr>	
				<td>Prix :<input type="text"  name="prix"/></td>
				<td>Nom de la photo : <input type="text"  name="photo"/></td>
<!-- 			<td>CLASSE ENERGETIQUE<input type="text"  name="classe_energetique_id"/></td>  -->
				<td><input type="submit" value="Ajouter"/></td>
			</tr>
		</table>	
		
		
	</form>	
	
	
	<!-- 	Tableau récapitulatif des produits : -->
		
		<h3>Produits dans la base :</h3>
		
		<table border="1">
			<tr>
				<th><a href="admin?critere=produit_id">ID</a></th>
				<th><a href=admin?critere=produit_name">NOM</a></th>
				<th>CATEGORIE</th>
				<th>MARQUE</th>
				<th>PRIX</th>
<!-- 				<th>CLASSE ENERGETIQUE</th> -->
				<th>PHOTO</th>
			</tr>
			<c:forEach items="${produits}" var="p">
<%-- 				<form action="adminModifier" method="POST"> --%>
				<tr>
					<td>${p.produit_id}</td>
					<td><input type="text" value="${p.produit_name}" name="NOM" /></td>
					<td><input type="text" value="${p.categorie_id}" name="CATEGORIE" /></td>
					<td><input type="text" value="${p.marque}" name="MARQUE" /></td>
					<td><input type="text" value="${p.prix}" name="PRIX" /></td>
<%-- 					<td><input type="text" value="${p.classe_energetique_id}" name="CLASSE ENERGETIQUE" /></td> --%>
					<td><input type="text" value="${p.photo}" name="PHOTO" /></td>
<!-- 					<td><input type="submit" value="Modifier" /></td> -->
					<td><a href="adminSupprimer?produit_id=${p.produit_id}">Supprimer</a></td>
				</tr>
<%-- 				</form> --%>
			</c:forEach>
		</table>
	
	
	<!-- 	Footer -->
	<%@include file="/WEB-INF/inc/footer.jsp" %>
</html>