
package org.example.Controller;

import org.example.DAO.ProfessorDAO;
import org.example.DAOImpl.ProfessorDAOImpl;
import org.example.Model.Professor;

import java.util.List;

public class ProfessorController {

    private ProfessorDAO professorDAO = new ProfessorDAOImpl();

    public void altaProfesso(Professor professor) {
        professorDAO.addDam2(professor);
    }

    public void deleteDam2(int id) {
        professorDAO.deleteDam2(id);
    }

    public void updateDam2(Professor professor) {
        professorDAO.updateDam2(professor);
    }

    public List<Professor> readDam2() {
        return professorDAO.readDam2();
    }
}
