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
					<td><label for="categorie">Catégories :</label>
						<select name="categorie_id" id="categorie">
						    <option value="">-Choisissez une catégorie-</option>
						    <option value="1">Réfrigérateur</option>
						    <option value="2">Lave-vaisselle</option>
						    <option value="3">Four</option>
						    <option value="4">Plaque de cuisson</option>
						</select>
					</td>	
					<td>Marque : <input type="text"  name="marque"/></td>
				</tr>
				<tr>
					<td><label for="classeEnergetique">Classe énergétique :</label>
						<select name="classe_energetique_id" id="classeEnergetique">
						    <option value="">-Choisissez une classe-</option>
						    <option value="1">A</option>
						    <option value="2">B</option>
						    <option value="3">C</option>
						    <option value="4">D</option>
						    <option value="5">E</option>
						    <option value="6">F</option>
						</select>
					</td>	
					<td>Prix : <input type="number"  name="prix"/></td>
					<td>Nom de la photo : <input type="text"  name="photo"/></td>
					<td><input type="submit" value="Ajouter"/></td>
				</tr>
			</table>	
		</form>	

				

	
	
	<!-- 	Tableau récapitulatif des produits : -->
		
		<h3>Produits dans la base :</h3>
		
		<table border="1">
			<tr>
				<th>ID
					<a href="adminTri?critere=produit_idDesc" style="position: relative; right: 0px;">
						<img style="width: 15px;" src="img/Fleche_haut.png" alt="Tri decroissant" />
					</a>
					<br>
					<a href="adminTri?critere=produit_idAsc" style="position: relative; right: 0px;">
						<img style="width: 15px;" src="img/Fleche_bas.png" alt="Tri croissant" />
					</a>
				</th>
				<th>NOM
					<a href="adminTri?critere=produit_nameDesc" style="position: relative; right: 0px;">
						<img style="width: 15px;" src="img/Fleche_haut.png" alt="Tri decroissant" />
					</a>
					<br>
					<a href="adminTri?critere=produit_nameAsc" style="position: relative; right: 0px;">
						<img style="width: 15px;" src="img/Fleche_bas.png" alt="Tri croissant" />
					</a>
				</th>
				<th>CATEGORIE</th>
				<th>MARQUE</th>
				<th>PRIX</th>
				<th>CLASSE ENERGETIQUE</th>
				<th>PHOTO</th>
			</tr>
			<c:forEach items="${produits}" var="p">
 				
				<tr>
				<form action="adminModifier" method="POST">
					<td>${p.produit_id} <input type="hidden" name="ID" value="${p.produit_id}"/></td>
					<td><input type="text" value="${p.produit_name}" name="NOM" /></td>
					<td><input type="text" value="${p.categorie_id}" name="CATEGORIE" /></td>
					<td><input type="text" value="${p.marque}" name="MARQUE" /></td>
					<td><input type="text" value="${p.prix}" name="PRIX" /></td>
					<td><input type="text" value="${p.classe_energetique_id}" name="CLASSE ENERGETIQUE" /></td>
					<td><input type="text" value="${p.photo}" name="PHOTO" /></td>
					<td><input type="submit" value="Modifier" /></td>
					<td><a href="adminSupprimer?produit_id=${p.produit_id}">Supprimer</a></td>
				</form>
				
				</tr>
			 
			</c:forEach>
		</table>
	
	
	<!-- 	Footer -->
	<%@include file="/WEB-INF/inc/footer.jsp" %>
</html>