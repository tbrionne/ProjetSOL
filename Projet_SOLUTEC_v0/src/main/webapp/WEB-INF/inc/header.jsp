<head>
<meta charset="UTF-8">
<title>Gestion des utilisateurs</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
<header>
	<img src="img/logo.jpg" alt="Logo SOLUTEC" />
	<h1>Titre provisoire</h1>
	<a href="${pageContext.request.contextPath}"><img src="img/home.png"/></a> 
	<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=fr"><img src="img/fr.png"/></a>
	<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en"><img src="img/en.png"/></a>
	<ul>
  		<li><a class="active" href="#home">Home</a></li>
  		<li><a href="#allarticles">Tous les articles</a></li>
  		<li><a href="#frigo">Frigo</a></li>
  		<li><a href="#lavaiss">Lave-vaisselles</a></li>
  		<li><a href="#four">Four</a></li>
  		<li><a href="#plaques">Plaques de cuisson</a></li>
	</ul>
</header>