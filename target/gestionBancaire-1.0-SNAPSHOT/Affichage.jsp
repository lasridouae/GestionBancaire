<%--
  Created by IntelliJ IDEA.
  User: Dlas
  Date: 12/02/2021
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="index.jsp" class="navbar-brand"> Gestion Bancaire</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Clients</a></li>
            <li><a href="Entreprise.jsp" class="nav-link">Add Entreprise</a></li>
            <li><a href="Personne.jsp"  class="nav-link">Add Personne</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Clients</h3>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID User</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Numero de compte</th>
                <th>Solde</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
<!--   for (Todo todo: todos) {  -->
     <c:forEach var="personne" items="${listClient}">
            <tr>
                   <td><c:out value="${personne.getId_user()}"/></td>
                    <td><c:out value="${personne.getNom()}"/></td>
                    <td><c:out value="${personne.getPrenom()}"/></td>
                    <td><c:out value="${personne.getN_compte()}"/></td>
                    <td><c:out value="${personne.getSolde()}"/></td>
                    <td><a class="btn btn-warning" href="edit?id=<c:out value='${personne.id_user}'/>">Modifier</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger" href="supprimer?id=<c:out value='${personne.getId_user()}'/>">Supprimer</a>
                    </td>
                </tr>
        </c:forEach>

            </tbody>

        </table>


    </div>

  </div>

</body>
</html>
