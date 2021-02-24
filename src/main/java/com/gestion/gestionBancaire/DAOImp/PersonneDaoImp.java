package com.gestion.gestionBancaire.DAOImp;

import com.gestion.gestionBancaire.DAO.PersonneDao;
import com.gestion.gestionBancaire.DBconn.GetConnection;
import com.gestion.gestionBancaire.Model.Personne;
import com.gestion.gestionBancaire.Model.Users;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonneDaoImp  implements PersonneDao {

    @Override
    public void ajouter(Personne personne) throws SQLException {
        Connection conn = null;
        try {
            String requete = "INSERT INTO public.client(nom, solde, n_compte, prenom) VALUES (?, ?, ?, ?);";
            PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
            stmt.setString(4, personne.getPrenom());
            stmt.setDouble(2, personne.getSolde());
            stmt.setLong(3, personne.getN_compte());
            stmt.setString(1, personne.getNom());
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
    public List<Personne> listAllClients() throws SQLException {
        List<Personne> listClients = new ArrayList<>();
        Connection conn = null;
        try {
            String requete = "SELECT id, nom, solde, n_compte, prenom FROM public.client;";
            PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
            ResultSet rs = stmt.executeQuery();
            Personne personne;
            while (rs.next()) {
                personne = new Personne(rs.getInt("id"), rs.getString("nom"), rs.getDouble("solde"), rs.getLong("n_compte"), rs.getString("prenom"));
                listClients.add(personne);
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
        return listClients;
    }

    @Override
    public boolean modifier(Personne personne) throws SQLException {
        Connection conn = null;
            String requete = "UPDATE public.client SET  nom=?, solde=?, n_compte=?, prenom=? WHERE id=?";
            PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
            stmt.setString(1, personne.getNom());
            stmt.setString(4, personne.getPrenom());
            stmt.setDouble(2, personne.getSolde());
            stmt.setLong(3, personne.getN_compte());
        stmt.setInt(5, personne.getId_user());
            boolean rowUpdated = stmt.executeUpdate() > 0;
            stmt.close();
            return rowUpdated;
    }

    @Override
    public Personne getClient(int id) throws SQLException {
            Connection conn = null;
            try {
                String requete = "SELECT id, nom, solde, n_compte, prenom FROM public.client where id = ?;";
                PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                Personne personne;
                personne = new Personne(rs.getInt("id"), rs.getString("nom"), rs.getDouble("solde"), rs.getLong("n_compte"), rs.getString("prenom"));
                return personne;
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

    @Override
    public String chercher(Personne personne) throws SQLException {
        return null;
    }

    @Override
    public boolean supprimer(Personne personne) throws SQLException {
        Connection conn = null;
            String requete = "DELETE FROM public.client WHERE id = ?;";
            PreparedStatement stmt = Objects.requireNonNull(GetConnection.connect()).prepareStatement(requete);
            stmt.setInt(1, personne.getId_user());
            boolean rowDeleted = stmt.executeUpdate() > 0;
            stmt.close();
            return rowDeleted;
    }
}

