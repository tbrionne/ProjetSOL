<head>
<meta charset="UTF-8">
<title>Gestion des utilisateurs</title>
<link rel="stylesheet" href="css/index.css">
</head>
	<body>
<!-- 		En tête de la page : -->
		<header>
			<a href="${pageContext.request.contextPath}"><img class="logo" src="img/logo_SOLUTEC.png" alt="Logo SOLUTEC"/></a>
			
			<h1 class="titre">Titre provisoire</h1>
		</header> 
		 
		<object style="position: fixed; top: 15px; right: 15px;">
			<a href="${pageContext.request.contextPath}"><img class="drapeau" src="img/home.png" /></a> 
			<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=fr"><img class="drapeau" src="img/fr.png"/></a>
			<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en"><img class="drapeau" src="img/en.png"/></a>
		</object>
			
		
		
<!-- 		Menu de navigation : -->
		<ul>
	  		<li><a href="#allarticles">Tous les articles</a></li>
	  		<li><a href="#frigo">Réfrigirateur</a></li>
	  		<li><a href="#lavaiss">Lave-vaisselle</a></li>
	  		<li><a href="#four">Four</a></li>
	  		<li><a href="#plaques">Plaques de cuisson</a></li>
		</ul>
