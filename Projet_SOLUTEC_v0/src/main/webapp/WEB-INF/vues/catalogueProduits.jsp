<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/utilisateur.css">
<%@include file="/WEB-INF/inc/header.jsp"%>
<div class="container">

	<%-- Filtre sur les marques --%>
	<div class="aside">
		<form action="" method="post">
			<h2>
				<spring:message code="f_titre" />
			</h2>
			<div class="filtre">
				<h3 class="titre_filtre">
					<spring:message code="f_marque" />
				</h3>
				<c:forEach items="${marques}" var="m">
					<input type="checkbox" id="${m}" name="marque" value="${m}">
					<label for="${m}">${m}</label>
					<br>
				</c:forEach>
			</div>

			<%-- Filtre sur les classes energetique --%>
			<div class="filtre" id="classe_energetique">
				<h3 class="titre_filtre">
					<spring:message code="f_classe" />
				</h3>
				<c:forEach items="${classesEnergetiques}" var="ce">
					<input type="checkbox" name="ce" value="${ce}">
					<label for="${ce}">${nomClasseEnergetique[ce-1]}</label>
				</c:forEach>
			</div>

			<%-- Filtre sur les prix --%>
			<div class="filtre">
				<h3 class="titre_filtre">
					<spring:message code="f_prix" />
				</h3>
				<input type="radio" id="prix1" name="prix" value="300"> <label
					for="prix1"><spring:message code="f_p1" /></label><br> <input
					type="radio" id="prix2" name="prix" value="600"> <label
					for="prix2"><spring:message code="f_p2" /></label><br> <input
					type="radio" id="prix3" name="prix" value="900"> <label
					for="prix3"><spring:message code="f_p3" /></label><br> <input
					type="radio" id="prix4" name="prix" value="1200"> <label
					for="prix4"><spring:message code="f_p4" /></label><br> <input
					type="radio" id="prix5" name="prixMax" value="1200"> <label
					for="prix4"><spring:message code="f_p5" /></label><br>
			</div>

			<button type="submit" class="bouton_filtre">
				<spring:message code="f_recherche" />
			</button>
		</form>
	</div>
	<div class="content">
		<article>
			<c:forEach items="${nomCat}" var="n">
				<h1 style="text-align: center; color: #004080; font-size: 33px;">${n}</h1>
			</c:forEach>
		</article>
		<!-- tableau qui va afficher les utilisateurs enregistrés
		dans la base de données grâce à une boucle forEach -->
		<c:forEach items="${categorie}" var="p">
			<article>
				<Table style="width: 100%">
					<tr>
						<td style="width: 40%"><img src="img/${p.photo}"
							style="display: block; margin-left: auto; margin-right: auto; height: 250px; width: 400px;" /></td>
						<td>
							<h2>${p.produit_name}</h2>
							<ul>
								<li style="font-weight:bold;">${p.prix}€</li>
								<li>${p.marque}</li>
								<li>${nomClasseEnergetique[p.classe_energetique_id-1]}</li>
							</ul>
						</td>

					</tr>
				</Table>
			</article>
		</c:forEach>

		<c:if test="${empty categorie}">
			<p style="text-align: center">
				<spring:message code="msg_vide" />
			</p>
		</c:if>

	</div>
</div>
<%@include file="/WEB-INF/inc/footer.jsp"%>
</html>