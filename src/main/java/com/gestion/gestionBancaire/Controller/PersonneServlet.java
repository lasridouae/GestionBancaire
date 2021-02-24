package com.gestion.gestionBancaire.Controller;

import com.gestion.gestionBancaire.DAO.PersonneDao;
import com.gestion.gestionBancaire.DAOImp.PersonneDaoImp;
import com.gestion.gestionBancaire.Model.Personne;
import com.gestion.gestionBancaire.Model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class PersonneServlet extends HttpServlet {
    private PersonneDao personneDaoImp = new PersonneDaoImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/ajouter":
                    ajouter(request, response);
                    break;
                case "/supprimer":
                    supprimer(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/modifier":
                    modifier(request, response);
                    break;
                default:
                    listClients(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }


    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id_user = Integer.parseInt(request.getParameter("id"));
        Personne existingClients = personneDaoImp.getClient(id_user);
        System.out.println("the client is not null:");
        System.out.println(existingClients != null);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Personne.jsp");
        request.setAttribute("personne", existingClients);
        dispatcher.forward(request, response);
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Personne> listClient = personneDaoImp.listAllClients();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Affichage.jsp");
        dispatcher.forward(request, response);
        //response.sendRedirect("Affichage.jsp");
    }


    private void modifier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id_user = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        long n_compte = Long.parseLong(request.getParameter("n_compte"));
        double solde = Double.parseDouble(request.getParameter("solde"));
        Personne personne = new Personne(id_user,nom,prenom,solde,n_compte);
        personneDaoImp.modifier(personne);
        System.out.println("nom personne"+personne.getNom());
        response.sendRedirect("list");


    }

    private void supprimer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id_user = Integer.parseInt(request.getParameter("id"));
        Personne personne = new Personne(id_user);
        personneDaoImp.supprimer(personne);
        response.sendRedirect("list");
    }



    private void ajouter(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long n_compte = Long.parseLong(request.getParameter("n_compte"));
        System.out.println("prenom is");
        System.out.println(prenom);
        Personne personne = new Personne(nom,prenom,solde,n_compte);
        personneDaoImp.ajouter(personne);
        response.sendRedirect("list");

    }

}
