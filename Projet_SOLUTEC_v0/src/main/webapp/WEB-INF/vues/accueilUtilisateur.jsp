
<!-- Imports -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<!-- Import du css pour recuperer des styles -->
<link rel="stylesheet" href="css/utilisateur.css">

<!-- Implantation du header provenant d'une autre page jsp  -->
<%@include file="/WEB-INF/inc/header.jsp"%>

<!-- Première zone: Cadre avec les images vitrines de notre catalogue -->
<div class=container_accueil>
	<table style="width: 100%">
		<tr>
			<td><a href="catalog?critere=1"><div
						class="container_image_accueil">
						<img src="img/frigo.jpg" alt="frigo" class="image_accueil">
						<div class="overlay">
							<div class="text_overlay">
								<spring:message code="bu_frigo" />
							</div>
						</div>
					</div></a></td>

			<td><a href="catalog?critere=2"><div
						class="container_image_accueil">
						<img src="img/lavevaisselle.jpg" alt="lave_vaisselle"
							class="image_accueil">
						<div class="overlay">
							<div class="text_overlay">
								<spring:message code="bu_LaveVaisselle" />
							</div>
						</div>
					</div></a></td>

			<td><a href="catalog?critere=3"><div
						class="container_image_accueil">
						<img src="img/four.jpg" alt="lave_vaisselle" class="image_accueil">
						<div class="overlay">
							<div class="text_overlay">
								<spring:message code="bu_Four" />
							</div>
						</div>
					</div></a></td>

			<td><a href="catalog?critere=4"><div
						class="container_image_accueil">
						<img src="img/plaquescuisson.jpg" alt="lave_vaisselle"
							class="image_accueil">
						<div class="overlay">
							<div class="text_overlay">
								<spring:message code="bu_PlaqueCuisson" />
							</div>
						</div>
					</div></a></td>
		</tr>

	</table>
</div>

<!-- Deuxieme zone: zone texte de présentation + random -->

<div>
	<Table>
		<td>
			<article class="text_basdepage ">
				<spring:message code="txt" />
			</article>
		</td>
		<td>
			<article style="border-width: 0px 0px 0px 0px">
				<Table>
					<tr>
						<h3 style="text-align: center; color: #004080;"><spring:message code="promo" /></h3>
					</tr>
					<tr>
						<td><img src="img/${PhotoAleatoire}"
							style="display: block; margin-left: auto; margin-right: auto; height: 250px; width: 400px;" />
							<h3 style="text-align: center; font-weight: lighter;">${NomAleatoire}</h3>
							<h2 style="text-align: center;">
								${PrixAleatoire}€</h2></td>
					</tr>

				</Table>
			</article>
		</td>
	</Table>
</div>
</body>


<!-- Implantation du footer provenant d'une autre page jsp  -->
<%@include file="/WEB-INF/inc/footer.jsp"%>

</html>