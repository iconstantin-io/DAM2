package org.example.DAO;

import org.example.Model.Professor;
import java.util.List;

public interface ProfessorDAO {
    void addDam2(Professor professor);

    // Elimina un professor pel seu id
    void deleteDam2(int id);

    // Actualitza el nom i els cognoms d'un professor
    void updateDam2(Professor professor);

    // Retorna la llista de tots els professors
    List<Professor> readDam2();
}
