package org.example.View;

import org.example.Controller.ModulProfessionalController;
import org.example.Model.ModulProfessional;

import java.util.List;
import java.util.Scanner;

public class ModulProfessionalView {

    private ModulProfessionalController controller = new ModulProfessionalController();

    // Demana les dades d'un mòdul i el guarda
    public void demanaModul(Scanner sc) {
        System.out.print("Nom del mòdul: ");
        String nom = sc.nextLine();

        System.out.print("Id del professor: ");
        int idProfessor = Integer.parseInt(sc.nextLine());

        ModulProfessional modul = new ModulProfessional();
        modul.setNom(nom);
        modul.setIdProfessor(idProfessor);

        controller.altaModul(modul);
    }

    // Mostra tots els mòduls
    public void llistarModuls() {
        List<ModulProfessional> moduls = controller.llistarModuls();

        if (moduls.isEmpty()) {
            System.out.println("No hi ha cap mòdul.");
        } else {
            for (ModulProfessional m : moduls) {
                System.out.println(m.getId() + " - " + m.getNom() + " - Professor: " + m.getNomProfessor());
            }
        }
    }

    // Demana l'id del mòdul i les noves dades
    public void actualitzarModul(Scanner sc) {
        System.out.print("Id del mòdul a actualitzar: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nou nom: ");
        String nom = sc.nextLine();

        System.out.print("Nou id del professor: ");
        int idProfessor = Integer.parseInt(sc.nextLine());

        ModulProfessional modul = new ModulProfessional();
        modul.setId(id);
        modul.setNom(nom);
        modul.setIdProfessor(idProfessor);

        controller.actualitzarModul(modul);
    }

    // Demana l'id del mòdul i l'elimina
    public void eliminarModul(Scanner sc) {
        System.out.print("Id del mòdul a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());

        controller.eliminarModul(id);
    }
}