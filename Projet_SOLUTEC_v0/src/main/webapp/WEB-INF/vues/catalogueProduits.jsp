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
		<div class="filtre">
			Marque<br>
			<c:forEach items="${marques}" var="m">
				<input type="checkbox" id="{m}" name="${m}">
				<label for="{m}">${m}</label><br>
				<br>
			</c:forEach>
		</div>
		<div class="filtre">
			Classe Energétique<br>
			<c:forEach items="${classesEnergetiques}" var="ce">
				<input type="checkbox" id="{ce}" name="${ce}">
				<label for="{ce}">${ce}</label><br>
				<br>
			</c:forEach>
		</div>
		<div class="filtre">
			Prix<br>
			<input type="checkbox" id="prix1" name="orix1">
			<label for="prix1">0 - 100 €</label><br>
			<input type="checkbox" id="prix2" name="prix2">
			<label for="prix2">100 - 500 €</label><br>
			<input type="checkbox" id="prix3" name="prix3">
			<label for="prix3">500 - 1000 €</label><br>
			<input type="checkbox" id="prix4" name="prix4">
			<label for="prix4"> + 1000 €</label><br>
		</div>
		<button type="submit">Rechercher</button>
	</div>
	<div class="content">
	
		<!-- tableau qui va afficher les utilisateurs enregistrés
		dans la base de données grâce à une boucle forEach -->
		<c:forEach items="${categorie}" var="p">
		
			<article>
				<Table border="1">
					<tr>
						<td><img src="img/${p.photo}" /></td>
						<td style="width: 100%">
							<h2>${p.produit_name}</h2>
							<ul>

								<li> ${nomCat[p.categorie_id-1]}</li>
								<li>${p.marque}</li>
								<li>${p.prix}€</li>
								<%-- <li>${p.classe_energetique_id}</li> --%>
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
	</div>
</div>
<%@include file="/WEB-INF/inc/footer.jsp"%>
</html>