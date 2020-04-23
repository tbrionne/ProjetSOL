<head>
<meta charset="UTF-8">
<title>Gestion des utilisateurs</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<!-- 		En t�te de la page : -->
	<header>
		<a href="${pageContext.request.contextPath}"><img class="logo"
			src="img/logo_SOLUTEC.png" alt="Logo SOLUTEC" /></a>

		<h1 class="titre">Titre provisoire</h1>


		<object style="position: absolute; top: 15px; right: 15px;">
			<a href="${pageContext.request.contextPath}"><img class="drapeau"
				src="img/home.png" /></a> <a
				href="${requestScope['javax.servlet.forward.request_uri']}?lang=fr"><img
				class="drapeau" src="img/fr.png" /></a> <a
				href="${requestScope['javax.servlet.forward.request_uri']}?lang=en"><img
				class="drapeau" src="img/en.png" /></a>
		</object>
	</header>


	<!-- 		Menu de navigation : -->
	<nav>
		<ul>
			<li><a href="catalog">Tous les articles</a></li>
			<li><a href="catalog?critere=1">R�frig�rateur</a></li>
			<li><a href="catalog?critere=2">Lave-vaisselle</a></li>
			<li><a href="catalog?critere=3">Four</a></li>
			<li><a href="catalog?critere=4">Plaques de cuisson</a></li>
		</ul>
	</nav>