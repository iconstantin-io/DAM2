
package org.example.View;

import org.example.Controller.ProfessorController;
import org.example.Model.Professor;

import java.util.List;
import java.util.Scanner;

public class ProfessorView {

    private ProfessorController controller = new ProfessorController();

    public void demanaProfessor(Scanner sc) {
        System.out.println("Nom: ");
        String nom = sc.nextLine();

        System.out.println("Cognoms: ");
        String cognom = sc.nextLine();

        Professor professor = new Professor();
        professor.setNom(nom);
        professor.setCognom(cognom);

        controller.altaProfesso(professor);
    }

    public void llistarProfessors() {
        List<Professor> professors = controller.readDam2();

        if (professors.isEmpty()) {
            System.out.println("No hi ha professors registrats.");
            return;
        }

        for (Professor professor : professors) {
            System.out.println(
                    "ID: " + professor.getId()
                            + " | Nom: " + professor.getNom()
                            + " | Cognoms: " + professor.getCognom()
            );
        }
    }

    public void actualitzarProfessor(Scanner sc) {
        System.out.print("Introdueix l'ID del professor que vols actualitzar: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nou nom: ");
        String nom = sc.nextLine();

        System.out.print("Nous cognoms: ");
        String cognom = sc.nextLine();

        Professor professor = new Professor();
        professor.setId(id);
        professor.setNom(nom);
        professor.setCognom(cognom);

        controller.updateDam2(professor);
    }

    public void eliminarProfessor(Scanner sc) {
        System.out.print("Introdueix l'ID del professor que vols eliminar: ");
        int id = Integer.parseInt(sc.nextLine());

        controller.deleteDam2(id);
    }
}
