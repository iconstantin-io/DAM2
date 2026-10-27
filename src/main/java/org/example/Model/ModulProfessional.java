
package org.example.Model;

public class ModulProfessional {

    private int id;
    private String nom;
    private Integer idProfessor;
    private String nomProfessor;

    public ModulProfessional() {
    }

    public ModulProfessional(int id, String nom,
                             Integer idProfessor, String nomProfessor) {
        this.id = id;
        this.nom = nom;
        this.idProfessor = idProfessor;
        this.nomProfessor = nomProfessor;
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

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomProfessor() {
        return nomProfessor;
    }

    public void setNomProfessor(String nomProfessor) {
        this.nomProfessor = nomProfessor;
    }
}
