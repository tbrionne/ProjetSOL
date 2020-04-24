<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/utilisateur.css">
<%@include file="/WEB-INF/inc/header.jsp"%>

	<div class=container_accueil>
		<table style="width:100%">
			<tr>
				<td><a href="catalog?critere=1"><div class="container_image_accueil">
							<img src="img/frigo.jpg" alt="frigo" class="image_accueil">
							<div class="overlay">
								<div class="text_overlay">Réfrigérateur</div>
							</div>
						</div></a></td>
				<td><a href="catalog?critere=2"><div class="container_image_accueil">
							<img src="img/lavevaisselle.jpg" alt="lave_vaisselle"
								class="image_accueil">
							<div class="overlay">
								<div class="text_overlay">Lave-vaisselle</div>
							</div>
						</div></a></td>
				<td><a href="catalog?critere=3"><div class="container_image_accueil">
							<img src="img/four.jpg" alt="lave_vaisselle"
								class="image_accueil">
							<div class="overlay">
								<div class="text_overlay">Four</div>
							</div>
						</div></a></td>
				<td><a href="catalog?critere=4"><div class="container_image_accueil">
							<img src="img/plaquescuisson.jpg" alt="lave_vaisselle"
								class="image_accueil">
							<div class="overlay">
								<div class="text_overlay">Plaques de cuisson</div>
							</div>
						</div></a></td>
			</tr>

		</table>
	</div>

<div class="text_basdepage">Bienvenue
	sur notre site ElectroSolutec, la branche électroménager de Solutec.
	Vous trouverez votre bonheur à travers les nombreux articles présentés
	dans ces pages. Vous pourrez filtrer nos produits en fonction de leur
	catégories, leur prix ou encore leur classe énergétique.</div>
</body>
<%@include file="/WEB-INF/inc/footer.jsp"%>
</html>