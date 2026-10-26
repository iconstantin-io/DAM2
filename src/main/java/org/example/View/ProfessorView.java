package org.example.View;

import org.example.Controller.ProfessorController;
import org.example.Model.Professor;

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
}
