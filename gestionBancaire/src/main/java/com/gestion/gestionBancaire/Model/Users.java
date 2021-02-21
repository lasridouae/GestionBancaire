package com.gestion.gestionBancaire.Model;

public class Users {
    private int id_user;
    private String nom;
    private double solde;
    private long N_compte;


    public Users(String nom, double solde, long n_compte) {
        this.nom = nom;
        this.solde = solde;
        N_compte = n_compte;
    }

    public Users(int id_user, String nom, double solde, long n_compte) {

        this.id_user = id_user;
        this.nom = nom;
        this.solde = solde;
        N_compte = n_compte;
    }

    public Users( int id_user) {
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public long getN_compte() {
        return N_compte;
    }

    public void setN_compte(long n_compte) {
        N_compte = n_compte;
    }
}
