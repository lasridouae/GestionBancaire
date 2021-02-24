<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gestion Bancaire </title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<!-- Load an icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="" class="navbar-brand"> Gestion Bancaire </a>
        </div>

        <ul class="navbar-nav">
            <li><li><a href="<%=request.getContextPath()%>/list" class="nav-link">Personne</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${personne != null}">
            <form action="modifier" method="post">
                </c:if>
                <c:if test="${personne == null}">
                    <!-- changer ajouter au modifier -->
                <form action="ajouter" method="post">
                    </c:if>
                    <caption>
                        <h2>
                            <c:if test="${personne != null}">
                                Edit Client
                            </c:if>
                            <c:if test="${personne == null}">
                                <!-- change to edit client -->
                                Add New Client
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${personne != null}">
                        <input type="hidden" name="id" value="<c:out value='${personne.id_user}' />" />
                    </c:if>
                    <fieldset class="form-group">
                        <label>Nom</label> <input type="text" value="<c:out value='${personne.nom}' />" class="form-control"
                                                  name="nom" required="required">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Prenom</label> <input type="text" value="<c:out value='${personne.prenom}' />" class="form-control" name="prenom">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Numero de compte </label> <input type="text" value="<c:out value='${personne.n_compte}' />" class="form-control" name="n_compte">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Soldes</label> <input type="text" value="<c:out value='${personne.solde}' />" class="form-control" name="solde">
                    </fieldset>
                    <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>