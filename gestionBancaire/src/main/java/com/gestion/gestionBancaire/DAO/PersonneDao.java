package com.gestion.gestionBancaire.DAO;

import com.gestion.gestionBancaire.Model.Personne;
import com.gestion.gestionBancaire.Model.Users;


import java.sql.SQLException;
import java.util.List;

public interface PersonneDao {

   void ajouter(Personne personne) throws SQLException;

   List<Personne>listAllClients()throws SQLException;

   boolean modifier(Personne personne) throws SQLException;

    public Personne getClient(int id) throws SQLException ;

    String chercher(Personne personne) throws SQLException;

    boolean supprimer(Personne personne) throws SQLException;
}
