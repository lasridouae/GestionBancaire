package com.gestion.gestionBancaire.Model;

public class Entreprise extends Users {

    public Entreprise(String nom, double solde, long n_compte) {
        super(nom, solde, n_compte);
    }

    public Entreprise(int id_user, String nom, double solde, long n_compte) {
        super(id_user, nom, solde, n_compte);
    }

    public Entreprise(int id_user) {
        super(id_user);
    }
}
