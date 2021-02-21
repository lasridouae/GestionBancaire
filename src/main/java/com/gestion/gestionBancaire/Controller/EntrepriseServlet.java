package com.gestion.gestionBancaire.Controller;

import com.gestion.gestionBancaire.DAO.EntrepriseDao;
import com.gestion.gestionBancaire.DAOImp.EntrepriseDaoImp;
import com.gestion.gestionBancaire.Model.Entreprise;
import com.gestion.gestionBancaire.Model.Personne;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/EntrepriseServlet")
public class EntrepriseServlet extends HttpServlet {
    private EntrepriseDao entrepriseDao = new EntrepriseDaoImp();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insert(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                update(request, response);
                break;
            default:
                listCompanies(request, response);
                break;
        }
    }catch (SQLException ex) {
        throw new ServletException(ex);
    }
}

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id_user = Integer.parseInt(request.getParameter("id"));
        Entreprise entreprise = new Entreprise(id_user);
        entrepriseDao.delete(entreprise) ;
        response.sendRedirect("entrepriseAffich.jsp");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id_user = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        long n_compte = Long.parseLong(request.getParameter("n_compte"));
        double solde = Double.parseDouble(request.getParameter("solde"));
        Entreprise entreprise = new Entreprise(id_user,nom,solde,n_compte);
        entrepriseDao.update(entreprise) ;
        response.sendRedirect("entrepriseAffich.jsp");
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nom = request.getParameter("nom");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long n_compte = Long.parseLong(request.getParameter("n_compte"));
        System.out.println(nom);
        Entreprise entreprise = new Entreprise(nom,solde,n_compte);
        entrepriseDao.insert(entreprise);
        response.sendRedirect("entrepriseAffich.jsp");
    }

    private void listCompanies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Entreprise> listCompanies = entrepriseDao.listAllCompanies();
        request.setAttribute("listCompanies", listCompanies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("entrepriseAffich.jsp");
        dispatcher.forward(request, response);
    }



    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_user = Integer.parseInt(request.getParameter("id"));
        Entreprise existingClients = entrepriseDao.getClient(id_user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Entreprise.jsp");
        request.setAttribute("entreprise", existingClients);
        dispatcher.forward(request, response);
    }



    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Entreprise.jsp");
        dispatcher.forward(request, response);
    }


}



