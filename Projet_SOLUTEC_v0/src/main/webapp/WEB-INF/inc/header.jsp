<head>
<meta charset="UTF-8">
<title>Gestion des utilisateurs</title>
<link rel="stylesheet" href="css/index.css"
</head>
<body>
<header>
	<a href="${pageContext.request.contextPath}"><img src="img/home.png"/></a> 
	<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=fr"><img src="img/fr.png"/></a>
	<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en"><img src="img/en.png"/></a>
	<h1><spring:message code="t_principal"/></h1>
</header>