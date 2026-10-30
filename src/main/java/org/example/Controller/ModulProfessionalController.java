package org.example.Controller;

import org.example.DAO.ModulProfessionalDAO;
import org.example.DAOImpl.ModulProfessionalDAOImpl;
import org.example.Model.ModulProfessional;

import java.util.List;

public class ModulProfessionalController {

    private ModulProfessionalDAO modulDAO = new ModulProfessionalDAOImpl();

    // Crida al DAO per guardar el mòdul
    public void altaModul(ModulProfessional modul) {
        modulDAO.addDam2(modul);
    }

    // Crida al DAO per eliminar el mòdul pel seu id
    public void eliminarModul(int id) {
        modulDAO.deleteDam2(id);
    }

    // Crida al DAO per actualitzar el mòdul
    public void actualitzarModul(ModulProfessional modul) {
        modulDAO.updateDam2(modul);
    }

    // Retorna la llista de tots els mòduls
    public List<ModulProfessional> llistarModuls() {
        return modulDAO.readDam2();
    }
}