package com.gestion.gestionBancaire.DAOImp;


import com.gestion.gestionBancaire.DAO.EntrepriseDao;
import com.gestion.gestionBancaire.DBconn.GetConnection;
import com.gestion.gestionBancaire.Model.Entreprise;
import com.gestion.gestionBancaire.Model.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EntrepriseDaoImp  implements EntrepriseDao {


    @Override
    public void insert(Entreprise entreprise) throws SQLException {
        System.out.println("this is what you're looking for");
        System.out.println(entreprise.getNom());

        Connection conn = null;
        try {
            String requete = "INSERT INTO public.entreprise( id,nom, solde, n_compte) VALUES (?,?,?,?)";
            PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
            stmt.setInt(1, entreprise.getId_user());
            stmt.setString(2, entreprise.getNom());
            stmt.setDouble(3, entreprise.getSolde());
            stmt.setLong(4, entreprise.getN_compte());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public List<Entreprise> listAllCompanies() throws SQLException {
        List<Entreprise> listCompanies = new ArrayList<>();
        Connection conn = null;
        try {
            String requete = "SELECT id, nom, solde, n_compte FROM public.entreprise;";
            PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
            ResultSet rs = stmt.executeQuery();
            Entreprise entreprise;
            while (rs.next()) {
                entreprise = new Entreprise(rs.getInt("id"), rs.getString("nom"), rs.getDouble("solde"), rs.getLong("n_compte"));
                listCompanies.add(entreprise);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listCompanies;
    }




    @Override
    public boolean update(Entreprise entreprise) throws SQLException {
        Connection conn = null;
        String requete = "UPDATE public.entreprise SET  nom=?, solde=?, n_compte=? WHERE id=?";
        PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
        stmt.setInt(4, entreprise.getId_user());
        stmt.setString(1, entreprise.getNom());
        stmt.setDouble(2, entreprise.getSolde());
        stmt.setLong(3, entreprise.getN_compte());
        boolean rowUpdated = stmt.executeUpdate() > 0;
        stmt.close();
        return rowUpdated;
    }

    @Override
    public String chercher(Entreprise entreprise) throws SQLException {

        return null;
    }

    @Override
    public boolean delete(Entreprise entreprise) throws SQLException {
        Connection conn = null;
        String requete = "DELETE FROM public.entreprise WHERE id = ?;";
        PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
        stmt.setInt(1, entreprise.getId_user());
        boolean rowDeleted = stmt.executeUpdate() > 0;
        stmt.close();
        return rowDeleted;
    }

    @Override
    public Entreprise getClient(int id) {
        Connection conn = null;
        try {
            String requete = "SELECT id, nom, solde, n_compte, prenom FROM public.client where id = ?;";
            PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Entreprise entreprise;
            entreprise = new Entreprise(rs.getInt("id"), rs.getString("nom"), rs.getDouble("solde"), rs.getLong("n_compte"));
            return entreprise;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}