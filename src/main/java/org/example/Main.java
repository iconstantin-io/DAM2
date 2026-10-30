package org.example;

import java.util.Scanner;
import org.example.View.ProfessorView;
import org.example.View.ModulProfessionalView;

public class Main {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n---------- MENÚ PRINCIPAL ----------");
            System.out.println("1. Submenú de professors");
            System.out.println("2. Submenú de mòduls");
            System.out.println("3. Sortir");
            System.out.print("Tria una opció: ");

            opcio = sc.nextInt();

            switch (opcio) {
                case 1:
                    menuProfessors(sc);
                    break;
                case 2:
                    menuModuls(sc);
                    break;
                case 3:
                    System.out.println("Adéu!");
                    break;
                default:
                    System.out.println("Opció no vàlida. Intenta-ho de nou.");
            }
            System.out.println();

        } while (opcio != 3);

        sc.close();
    }

    public static void menuProfessors(Scanner sc) {

        ProfessorView professorView = new ProfessorView();
        int opcioProfessors;

        do {
            System.out.println("------ SUBMENÚ PROFESSORS ------");
            System.out.println("1. Alta professor");
            System.out.println("2. Llistar professors");
            System.out.println("3. Actualitzar professor");
            System.out.println("4. Eliminar professor");
            System.out.println("5. Tornar al menú principal");
            System.out.print("Tria una opció: ");

            opcioProfessors = sc.nextInt();
            sc.nextLine();

            switch (opcioProfessors) {
                case 1:
                    professorView.demanaProfessor(sc);
                    break;
                case 2:
                    professorView.llistarProfessors();
                    break;
                case 3:
                    professorView.actualitzarProfessor(sc);
                    break;
                case 4:
                    professorView.eliminarProfessor(sc);
                    break;
                case 5:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció no vàlida al submenú de professors.");
            }
            System.out.println();

        } while (opcioProfessors != 5);
    }

    public static void menuModuls(Scanner sc) {

        ModulProfessionalView modulView = new ModulProfessionalView();
        int opcioModuls;

        do {
            System.out.println("\n-------- SUBMENÚ MÒDULS --------");
            System.out.println("1. Alta mòdul");
            System.out.println("2. Llistar mòduls");
            System.out.println("3. Actualitzar mòdul");
            System.out.println("4. Eliminar mòdul");
            System.out.println("5. Tornar al menú principal");
            System.out.print("Tria una opció: ");

            opcioModuls = sc.nextInt();
            sc.nextLine();

            switch (opcioModuls) {
                case 1:
                    modulView.demanaModul(sc);
                    break;
                case 2:
                    modulView.llistarModuls();
                    break;
                case 3:
                    modulView.actualitzarModul(sc);
                    break;
                case 4:
                    modulView.eliminarModul(sc);
                    break;
                case 5:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció no vàlida al submenú de mòduls.");
            }
        } while (opcioModuls != 5);
    }
}
