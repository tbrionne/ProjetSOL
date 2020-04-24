<head>
<meta charset="UTF-8">
<title>Gestion des utilisateurs</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<!-- 		En tête de la page : -->
	<header>
		<table style=" width:100% ;text-align:center;height:100%">
			<tr>
				<td><a href="${pageContext.request.contextPath}"><img
						class="logo" src="img/logo_SOLUTEC.png" alt="Logo SOLUTEC" /></a></td>
				<td class="titre">ElectroSolutec</td>
				<td>
					<div class="encadrement_drapeau">
						<a href="${pageContext.request.contextPath}"><img
							class="drapeau" src="img/home.png" /></a> <a
							href="${requestScope['javax.servlet.forward.request_uri']}?lang=fr"><img
							class="drapeau" src="img/fr.png" /></a> <a
							href="${requestScope['javax.servlet.forward.request_uri']}?lang=en"><img
							class="drapeau" src="img/en.png" /></a>
					</div>
				</td>
			</tr>
		</table>
	</header>


	<!-- 		Menu de navigation : -->
	<nav>
		<ul>
			<li><a href="catalog"><spring:message code="m_tous"/></a></li>
			<li><a href="catalog?critere=1"><spring:message code="m_frigo"/></a></li>
			<li><a href="catalog?critere=2"><spring:message code="m_LaveVaisselle"/></a></li>
			<li><a href="catalog?critere=3"><spring:message code="m_Four"/></a></li>
			<li><a href="catalog?critere=4"><spring:message code="m_PlaqueCuisson"/></a></li>
		</ul>
	</nav>