package com.gestion.gestionBancaire.Model;

public class Personne extends Users{
    private String prenom;

    public Personne(int id_user, String nom, String prenom, double solde, long n_compte) {
        super(id_user,nom,solde,n_compte);
        this.prenom = prenom;

    }

    public Personne(String nom, String prenom, double solde, long n_compte) {
        super(nom,solde,n_compte);
        this.prenom = prenom;
    }
    public Personne(int id_user, String nom, double solde, long n_compte, String prenom) {
         super(id_user, nom, solde, n_compte);
        this.prenom = prenom;
    }

    public Personne(int id_user) {
        super(id_user);
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
