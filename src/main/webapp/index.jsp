<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestion Bancaire </title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<style>
    body {
        background-image: url("img/banque.png");
    }
        h1{
            margin-left: 7em;
            margin-top: 1em;
            font-size: 4.5rem;
        }
        p{
            margin-left: 23em;
        }

</style>
<header>
<nav class="navbar navbar-expand-md navbar-dark"
     style="background-color: blue">
    <div>
        <a href="" class="navbar-brand"> Gestion Bancaire </a>
    </div>
    <ul class="navbar-nav">

        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Personne</a></li>
        <li><a href="<%=request.getContextPath()%>/EntrepriseServlet" class="nav-link">Entreprise</a></li>
        <li><a href="Entreprise.jsp" class="nav-link">Add Entreprise</a></li>
        <li><a href="Personne.jsp"  class="nav-link">Add Personne</a></li>
    </ul>

</nav>
</header>

<h1> Welcome </h1>
<p>lorem ipsum Neque porro quisquam est qui dolorem ipsum quia dolor sit amet.</p>

</body>
</html>