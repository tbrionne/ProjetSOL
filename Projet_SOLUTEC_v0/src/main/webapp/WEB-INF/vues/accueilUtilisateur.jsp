
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
		<table style="width:100%">
			<tr>
				<td><a href="catalog?critere=1"><div class="container_image_accueil">
							<img src="img/frigo.jpg" alt="frigo" class="image_accueil">
							<div class="overlay">
							<div class="text_overlay"><spring:message code="bu_frigo"/></div>
							</div>
						</div></a></td>
						
				<td><a href="catalog?critere=2"><div class="container_image_accueil">
							<img src="img/lavevaisselle.jpg" alt="lave_vaisselle" class="image_accueil">
							<div class="overlay">
							<div class="text_overlay"><spring:message code="bu_LaveVaisselle"/></div>
							</div>
						</div></a></td>
						
				<td><a href="catalog?critere=3"><div class="container_image_accueil">
							<img src="img/four.jpg" alt="lave_vaisselle" class="image_accueil">
							<div class="overlay">
							<div class="text_overlay"><spring:message code="bu_Four"/></div>
							</div>
						</div></a></td>
						
				<td><a href="catalog?critere=4"><div class="container_image_accueil">
							<img src="img/plaquescuisson.jpg" alt="lave_vaisselle" class="image_accueil">
							<div class="overlay">
							<div class="text_overlay"><spring:message code="bu_PlaqueCuisson"/></div>
							</div>
						</div></a></td>
			</tr>

		</table>
	</div>

<!-- Deuxieme zone: zone texte de présentation -->
<div class="text_basdepage"><spring:message code="txt"/></div>

</body>

<!-- Implantation du footer provenant d'une autre page jsp  -->
<%@include file="/WEB-INF/inc/footer.jsp"%>

</html>