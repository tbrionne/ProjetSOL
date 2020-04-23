<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/utilisateur.css">
<%@include file="/WEB-INF/inc/header.jsp"%>
<div class="container">
	<div class="aside">
		<h1>Filtres</h1>
		<div class="filtre">Marque<br>
			<c:forEach items="${marques}" var="m">
				<input type="checkbox" id="{m}" name="${m}">
				<label for="{m}">${m}</label><br>
			</c:forEach>
		</div>
		<div class="filtre">Classe Energétique<br>
			<c:forEach items="${classesEnergetiques}" var="ce">
				<input type="checkbox" id="{ce}" name="${ce}">
				<label for="{ce}">${ce}</label><br>
			</c:forEach>
		</div>
		<div class="filtre">Prix</div>
	</div>
	<div class="content">

		<!-- 				<tr> -->
		<!-- 					<th>Nom</th> -->
		<!-- 					<th>Catégorie</th> -->
		<!-- 					<th>Marque</th> -->
		<!-- 					<th>Prix</th> -->
		<!-- 					<th>Photo</th> -->
		<!-- 					<th>Classe énergétique</th> -->
		<!-- 				</tr> -->
		<!-- tableau qui va afficher les utilisateurs enregistrés
		dans la base de données grâce à une boucle forEach -->
		<c:forEach items="${catalogueProduits}" var="p">
			<article>
				<Table border="1">
					<tr>
						<td><img src="img/${p.photo}" /></td>
						<td>
							<ul>
								<li>${p.produit_name}</li>
								<li>${p.categorie_id}</li>
								<li>${p.marque}</li>
								<li>${p.prix}</li>
<%-- 								<li>${p.classe_energetique_id}</li> --%>
							</ul>
						</td>

					</tr>
				</Table>
			</article>
		</c:forEach>

		<article>
			<h1>Produit 2</h1>
			<p>Caractéristiques produit</p>
			<p>photo produit</p>
		</article>
		<article>
			<h1>Produit 3</h1>
			<p>Caractéristiques produit</p>
			<p>photo produit</p>
		</article>
		<article>
			<h1>Produit 3</h1>
			<p>Caractéristiques produit</p>
			<p>photo produit</p>
		</article>
		<article>
			<h1>Produit 3</h1>
			<p>Caractéristiques produit</p>
			<p>photo produit</p>
		</article>
		<article>
			<h1>Produit 3</h1>
			<p>Caractéristiques produit</p>
			<p>photo produit</p>
		</article>
		<article>
			<h1>Produit 3</h1>
			<p>Caractéristiques produit</p>
			<p>photo produit</p>
		</article>
		<article>
			<h1>Produit 3</h1>
			<p>Caractéristiques produit</p>
			<p>photo produit</p>
		</article>
	</div>
</div>
<%@include file="/WEB-INF/inc/footer.jsp"%>
</html>