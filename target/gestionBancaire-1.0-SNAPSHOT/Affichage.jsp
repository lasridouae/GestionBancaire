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
            <li><a href="<a href="<%=request.getContextPath()%>/list" class="nav-link">Personne</a></li>
            <li><a href="<a href="<%=request.getContextPath()%>/entrepriseAffich.jsp" class="nav-link">Entreprise</a></li>
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
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                New User</a>
        </div>
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
            <c:forEach var="personne" items="${requestScope.listClient}">
            <tr>
                   <td><c:out value="${requestScope.personne.id_user}"/></td>
                    <td><c:out value="${requestScope.personne.nom}"/></td>
                    <td><c:out value="${requestScope.personne.prenom}"/></td>
                    <td><c:out value="${requestScope.personne.n_compte}"/></td>
                    <td><c:out value="${requestScope.personne.solde}"/></td>
                    <td><a class="btn btn-warning" href="edit?id=<c:out value='${requestScope.personne.id_user}'/>">Modifier</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger" href="supprimer?id=<c:out value='${requestScope.personne.id_user}'/>">Supprimer</a>
                    </td>
                </tr>
        </c:forEach>

            </tbody>

        </table>


    </div>

  </div>

</body>
</html>
