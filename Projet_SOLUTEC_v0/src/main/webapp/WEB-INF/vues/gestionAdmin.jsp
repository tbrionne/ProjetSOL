<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>

<html>

<!-- 	Header : -->
<%@include file="/WEB-INF/inc/headerAdmin.jsp"%>


<!-- 	Body : -->
${session["connecte"]}

<br>
<br>
<h3>Ajout d'un produit à la base de données :</h3>

	<c:if test="${!empty msg_erreur}">
			<h4 class="msg_erreur">Erreur : Tous les champs doivent être remplis</h4>
		</c:if>
		
		<c:if test="${!empty msg_erreur_photo}">
			<h4 class="msg_erreur">Erreur : Aucune photo n'a été sélectionnée</h4>
		</c:if>

<c:if test="${!empty ajout}">
	<h5 class="succes">Ajout effectué avec succès</h5>
</c:if>

<form action="adminAjouter" method="POST" enctype="multipart/form-data">
	<center>
		<table>
			<tr>
				<td width=33%>Nom : <input type="text" class="textImput"
					name="produit_name" /></td>
				<td width=33%><label for="categorie">Catégories :</label> <select
					class="textImput" name="categorie_id" id="categorie">
						<option value="">-Choisissez une catégorie-</option>
						<option value="1">Réfrigérateur</option>
						<option value="2">Lave-vaisselle</option>
						<option value="3">Four</option>
						<option value="4">Plaque de cuisson</option>
				</select></td>
				<td width=34%>Marque : <input type="text" class="textImput" name="marque" /></td>
			</tr>
			<tr>
				<td><label for="classeEnergetique">Classe énergétique :</label>
					<select class="textImput" name="classe_energetique_id"
					id="classeEnergetique">
						<option value="">-Choisissez une classe-</option>
						<option value="1">A</option>
						<option value="2">B</option>
						<option value="3">C</option>
						<option value="4">D</option>
						<option value="5">E</option>
						<option value="6">F</option>
				</select></td>
				<td>Prix : <input type="number" class="textImput" name="prix" /></td>
				<td>Photo : <input type="file" class="fileImput"
					name="fichierUpload" /></td>
			</tr>
			<tr>
				<td colspan=3 align=center><input type="submit" class="bouton_ajout" value="Ajouter" /></td>
			</tr>
		</table>
	</center>
</form>


<!-- 	Tableau récapitulatif des produits : -->
<br>
<br>
<h3>Produits dans la base :</h3>

<c:if test="${!empty modification}">
	<h5 class="succes">Modification effectuée avec succès</h5>
</c:if>

<c:if test="${!empty suppression}">
	<h5 class="succes">Suppression effectuée avec succès</h5>
</c:if>

<table class="tableau_global">
	<tr>
		<th>
<!-- ID -->
		<table class="tableau_header">
			<tr>
				<td>
				<table class="tableau_bouton">
					<tr>
						<td><a href="adminTri?critere=produit_idDesc">
			<img style="width: 15px;" src="img/Fleche_haut.png" alt="Tri decroissant" /></a></td>
					</tr>
					<tr>
						<td><a href="adminTri?critere=produit_idAsc">
						<img style="width: 15px;" src="img/Fleche_bas.png" alt="Tri croissant" /></a></td>
					</tr>
				</table>
				</td>
				<td>ID</td>
			</tr>
		</table>
		</th>
		<th>
<!-- NOM -->
		<table class="tableau_header">
			<tr>
				<td>
				<table class="tableau_bouton">
					<tr>
						<td><a href="adminTri?critere=produit_nameDesc">
			<img style="width: 15px;" src="img/Fleche_haut.png" alt="Tri decroissant" /></a></td>
					</tr>
					<tr>
						<td><a href="adminTri?critere=produit_nameAsc">
						<img style="width: 15px;" src="img/Fleche_bas.png" alt="Tri croissant" /></a></td>
					</tr>
				</table>
				</td>
				<td>NOM</td>
			</tr>
		</table>
		</th>
		<th>
<!-- CATEGORIE -->
		<table class="tableau_header">
			<tr>
				<td>
				<table class="tableau_bouton">
					<tr>
						<td><a href="adminTri?critere=categorie_idDesc">
			<img style="width: 15px;" src="img/Fleche_haut.png" alt="Tri decroissant" /></a></td>
					</tr>
					<tr>
						<td><a href="adminTri?critere=categorie_idAsc">
						<img style="width: 15px;" src="img/Fleche_bas.png" alt="Tri croissant" /></a></td>
					</tr>
				</table>
				</td>
				<td>CATEGORIE</td>
			</tr>
		</table>
		</th>
		<th>
<!-- MARQUE -->
		<table class="tableau_header">
			<tr>
				<td>
				<table class="tableau_bouton">
					<tr>
						<td><a href="adminTri?critere=marqueDesc">
			<img style="width: 15px;" src="img/Fleche_haut.png" alt="Tri decroissant" /></a></td>
					</tr>
					<tr>
						<td><a href="adminTri?critere=marqueAsc">
						<img style="width: 15px;" src="img/Fleche_bas.png" alt="Tri croissant" /></a></td>
					</tr>
				</table>
				</td>
				<td>MARQUE</td>
			</tr>
		</table>
		</th>
		<th>
<!-- PRIX -->
		<table class="tableau_header">
			<tr>
				<td>
				<table class="tableau_bouton">
					<tr>
						<td><a href="adminTri?critere=prixDesc">
			<img style="width: 15px;" src="img/Fleche_haut.png" alt="Tri decroissant" /></a></td>
					</tr>
					<tr>
						<td><a href="adminTri?critere=prixAsc">
						<img style="width: 15px;" src="img/Fleche_bas.png" alt="Tri croissant" /></a></td>
					</tr>
				</table>
				</td>
				<td>PRIX</td>
			</tr>
		</table>
		</th>
		<th>
<!-- CLASSE ENERGETIQUE -->
		<table class="tableau_header">
			<tr>
				<td>
				<table class="tableau_bouton">
					<tr>
						<td><a href="adminTri?critere=classe_energetique_idDesc">
			<img style="width: 15px;" src="img/Fleche_haut.png" alt="Tri decroissant" /></a></td>
					</tr>
					<tr>
						<td><a href="adminTri?critere=classe_energetique_idAsc">
						<img style="width: 15px;" src="img/Fleche_bas.png" alt="Tri croissant" /></a></td>
					</tr>
				</table>
				</td>
				<td>CLASSE ENERGETIQUE</td>
			</tr>
		</table>
		</th>
		<th>
<!-- PHOTO -->
		<table class="tableau_header">
			<tr>
				<td>
				<table class="tableau_bouton">
					<tr>
						<td><a href="adminTri?critere=photoDesc">
			<img style="width: 15px;" src="img/Fleche_haut.png" alt="Tri decroissant" /></a></td>
					</tr>
					<tr>
						<td><a href="adminTri?critere=photoAsc">
						<img style="width: 15px;" src="img/Fleche_bas.png" alt="Tri croissant" /></a></td>
					</tr>
				</table>
				</td>
				<td>PHOTO</td>
			</tr>
		</table>
		</th>
	</tr>

	<c:forEach items="${produits}" var="p">
		<form action="adminModifier" method="POST">
			<tr>
				<td>${p.produit_id}<input type="hidden" name="id"
					value="${p.produit_id}" /></td>
				<td><input type="text" value="${p.produit_name}"
					name="produit_name" /></td>
				<td><label for="categorie"></label> <select name="categorie_id"
					id="categorie">
						<option value="${p.categorie_id}">${p.categorie_id}</option>
						<option value="1">Réfrigérateur</option>
						<option value="2">Lave-vaisselle</option>
						<option value="3">Four</option>
						<option value="4">Plaque de cuisson</option>
				</select></td>
				<td><input type="text" value="${p.marque}" name="marque" /></td>
				<td><input type="number" value="${p.prix}" name="prix" /></td>
				<td><label for="classeEnergetique"></label> <select
					name="classe_energetique_id" id="classeEnergetique">
						<option value="${p.classe_energetique_id}">${p.classe_energetique_id}</option>
						<option value="1">A</option>
						<option value="2">B</option>
						<option value="3">C</option>
						<option value="4">D</option>
						<option value="5">E</option>
						<option value="6">F</option>
				</select></td>
<!-- 				Une erreur survient lorsqu'on modifie, le controlleur n'arrive pas à retrouver le nom de la photo. -->
<%-- 				<td><img src="img/${p.photo}" name="photo" /></td> --%>
				<td><input type="text" value="${p.photo}" name="photo" /></td>
				<td><input type="submit" class="bouton_modifier" value="Modifier" /></td>
				<td><a class="bouton_supprimer" href="adminSupprimer?produit_id=${p.produit_id}">Supprimer</a></td>
			</tr>
		</form>
	</c:forEach>
</table>


<!-- 	Footer -->
<%@include file="/WEB-INF/inc/footer.jsp"%>
</html>