package com.gestion.gestionBancaire.Controller;

import com.gestion.gestionBancaire.DAO.EntrepriseDao;
import com.gestion.gestionBancaire.DAOImp.EntrepriseDaoImp;
import com.gestion.gestionBancaire.Model.Entreprise;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="EntrepriseServlet",value ="/EntrepriseServlet")
public class EntrepriseServlet extends HttpServlet {
    private final EntrepriseDao entrepriseDaoImp = new EntrepriseDaoImp();


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

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id_user = Integer.parseInt(request.getParameter("id"));
        Entreprise entreprise = new Entreprise(id_user);
        entrepriseDaoImp.delete(entreprise);
       request.getRequestDispatcher("entrepriseAffich.jsp").forward(request,response);
       // response.sendRedirect("entrepriseAffich.jsp");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id_user = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        long n_compte = Long.parseLong(request.getParameter("n_compte"));
        double solde = Double.parseDouble(request.getParameter("solde"));
        Entreprise entreprise = new Entreprise(id_user,nom,solde,n_compte);
        entrepriseDaoImp.update(entreprise) ;
        response.sendRedirect("entrepriseAffich.jsp");
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nom = request.getParameter("nom");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long n_compte = Long.parseLong(request.getParameter("n_compte"));
        System.out.println(nom);
        Entreprise entreprise = new Entreprise(nom,solde,n_compte);
        entrepriseDaoImp.insert(entreprise);
        response.sendRedirect("EntrepriseServlet");
    }

    private void listCompanies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Entreprise> listCompanies = entrepriseDaoImp.listAllCompanies();
        request.setAttribute("listCompanies", listCompanies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("entrepriseAffich.jsp");
        dispatcher.forward(request, response);
    }



    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_user = Integer.parseInt(request.getParameter("id"));
        Entreprise existingClients = entrepriseDaoImp.getClient(id_user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Entreprise.jsp");
        request.setAttribute("entreprise", existingClients);
        dispatcher.forward(request, response);
    }


}

