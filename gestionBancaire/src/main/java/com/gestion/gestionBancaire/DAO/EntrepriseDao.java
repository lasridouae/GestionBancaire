package com.gestion.gestionBancaire.DAO;

import com.gestion.gestionBancaire.Model.Entreprise;
import com.gestion.gestionBancaire.Model.Personne;

import java.sql.SQLException;
import java.util.List;

public interface EntrepriseDao {


    void insert(Entreprise entreprise) throws SQLException;

    List<Entreprise> listAllCompanies() throws SQLException;

    boolean update(Entreprise entreprise) throws SQLException;

    String chercher(Entreprise entreprise) throws SQLException;

    boolean delete(Entreprise entreprise) throws SQLException;


    Entreprise getClient(int id_user);

}
