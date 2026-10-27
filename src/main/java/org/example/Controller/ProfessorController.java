package org.example.Controller;

import org.example.DAO.ProfessorDAO;
import org.example.DAOImpl.ProfessorDAOImpl;
import org.example.Model.Professor;

public class ProfessorController {

    private ProfessorDAO professorDAO = new ProfessorDAOImpl();

    //Hola?
    public void altaProfesso(Professor professor) {
        professorDAO.addDam2(professor);
    }

}
