<head>
<meta charset="UTF-8">
<title>Gestion des utilisateurs</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
<header>
	<a href="${pageContext.request.contextPath}"><img src="img/logo_SOLUTEC.png" alt="Logo SOLUTEC" class="logo"/></a>
	<a class="titre">Titre provisoire</a>
	<a href="${pageContext.request.contextPath}"><img class="drapeau" src="img/home.png" /></a> 
	<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=fr"><img class="drapeau" src="img/fr.png"/></a>
	<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en"><img class="drapeau" src="img/en.png"/></a>
	<ul>
  		<li><a class="active" href="#home">Home</a></li>
  		<li><a href="#allarticles">Tous les articles</a></li>
  		<li><a href="#frigo">Frigo</a></li>
  		<li><a href="#lavaiss">Lave-vaisselles</a></li>
  		<li><a href="#four">Four</a></li>
  		<li><a href="#plaques">Plaques de cuisson</a></li>
	</ul>
</header>