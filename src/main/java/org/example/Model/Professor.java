package org.example.Model;

public class Professor {

    private int id;
    private String nom;
    private String cognom;

    public Professor() {}

    public Professor(String nom, String cognom){
        nom = this.nom;
        cognom = this.cognom;
    }

    public Professor(int id, String nom, String cognom) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
}
