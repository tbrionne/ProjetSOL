<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="css/utilisateur.css">
	<%@include file="/WEB-INF/inc/header.jsp" %>
	
	
		<div style="display:grid">
		<table border="1">
			<tr>
				<td style=" width:25%; background-color:#e90649; text-align:center"><a href="#frigo"><img src="img/frigoR.jpg" alt="Réfrigérateur" class="img_accueil"></a></td>
				<td style=" width:25%; background-color:#e90649; text-align:center"><a href="#lavaiss"><img src="img/lavevaisselleR.jpg" alt="Lave-vaisselle" class="img_accueil"></a></td>
				<td style=" width:25%; background-color:#e90649; text-align:center"><a href="#four"><img src="img/four.jpg" alt="Four" class="img_accueil"></a></td>
				<td style=" width:25%; background-color:#e90649; text-align:center"><a href="#plaques"><img src="img/plaquescuissonR.jpg" alt="Plaques de cuisson" class="img_accueil"></a></td>
			</tr>
		</table>
		</div>
		
		<div style="text-align: center; width:100%;
	background-color: gray; color:black; font-size:25pt; font-family: "Comic Sans MS", cursive, sans-serif;">Bienvenue sur notre site ElectroSolutec, la branche électroménager de Solutec. 
		Vous trouverez votre bonheur à travers les nombreux articles présentés dans ces pages. 
		Vous pourrez filtrer nos produits en fonction de leur catégories, leur prix ou encore leur classe énergétique.
		</div>
	</body>
	<%@include file="/WEB-INF/inc/footer.jsp" %>
</html>