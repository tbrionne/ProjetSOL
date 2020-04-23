<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="css/utilisateur.css">
	<%@include file="/WEB-INF/inc/header.jsp" %>
	
	
		<div style="display:grid">
		<table border="1" bordercolor="white" bgcolor="white" width="100%">
			<tr>
				<td class="tdCat" border="10" ><a href="catalog?critere=1"><img src="img/frigoR.jpg" alt="Réfrigérateur" class="img_accueil"></a><h2>Frigo</h2></td>
				<td class="tdCat" border="10"><a href="catalog?critere=2"><img src="img/lavevaisselleR.jpg" alt="Lave-vaisselle" class="img_accueil"></a><h2>Lave Vaisselle</h2></td>
				<td class="tdCat" border="10"><a href="catalog?critere=3"><img src="img/four.jpg" alt="Four" class="img_accueil"></a><h2>Four</h2></td>
				<td class="tdCat" border="10"><a href="catalog?critere=4"><img src="img/plaquescuissonR.jpg" alt="Plaques de cuisson" class="img_accueil"></a><h2>Plaque de cuisson</h2></td>
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