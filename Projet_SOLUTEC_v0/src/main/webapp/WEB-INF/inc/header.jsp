<head>
<meta charset="UTF-8">
<title>Gestion des utilisateurs</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<!-- 		En tête de la page : -->
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
			<li><a href="catalog">Réfrigérateur</a></li>
			<li><a href="catalog">Lave-vaisselle</a></li>
			<li><a href="catalog">Four</a></li>
			<li><a href="catalog">Plaques de cuisson</a></li>
		</ul>
	</nav>