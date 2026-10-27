
package org.example.DAOImpl;

import org.example.DAO.ModulProfessionalDAO;
import org.example.Model.ModulProfessional;
import org.example.Utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ModulProfessionalDAOImpl implements ModulProfessionalDAO {

    @Override
    public void addDam2(ModulProfessional modul) {
        String sql = "INSERT INTO ModulsProfessionals (nom, id_professor) "
                + "VALUES (?, ?)";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, modul.getNom());

            if (modul.getIdProfessor() != null) {
                ps.setInt(2, modul.getIdProfessor());
            } else {
                ps.setNull(2, Types.INTEGER);
            }

            int files = ps.executeUpdate();

            if (files > 0) {
                System.out.println("Mòdul professional afegit correctament.");
            }

        } catch (SQLException e) {
            System.out.println("Error en afegir el mòdul professional.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDam2(int id) {
        String sql = "DELETE FROM ModulsProfessionals WHERE id = ?";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int files = ps.executeUpdate();

            if (files > 0) {
                System.out.println("Mòdul professional eliminat correctament.");
            } else {
                System.out.println("No s'ha trobat cap mòdul amb aquest ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error en eliminar el mòdul professional.");
            e.printStackTrace();
        }
    }

    @Override
    public void updateDam2(ModulProfessional modul) {
        String sql = "UPDATE ModulsProfessionals "
                + "SET nom = ?, id_professor = ? WHERE id = ?";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, modul.getNom());

            if (modul.getIdProfessor() != null) {
                ps.setInt(2, modul.getIdProfessor());
            } else {
                ps.setNull(2, Types.INTEGER);
            }

            ps.setInt(3, modul.getId());

            int files = ps.executeUpdate();

            if (files > 0) {
                System.out.println("Mòdul professional actualitzat correctament.");
            } else {
                System.out.println("No s'ha trobat cap mòdul amb aquest ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error en actualitzar el mòdul professional.");
            e.printStackTrace();
        }
    }

    @Override
    public List<ModulProfessional> readDam2() {
        List<ModulProfessional> moduls = new ArrayList<>();

        String sql = "SELECT m.id, m.nom, m.id_professor, "
                + "CONCAT(p.nom, ' ', p.cognoms) AS nom_professor "
                + "FROM ModulsProfessionals m "
                + "LEFT JOIN Professors p ON m.id_professor = p.id";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");

                int idProfessorValor = rs.getInt("id_professor");
                Integer idProfessor = rs.wasNull() ? null : idProfessorValor;

                String nomProfessor = rs.getString("nom_professor");

                ModulProfessional modul = new ModulProfessional(
                        id, nom, idProfessor, nomProfessor
                );

                moduls.add(modul);
            }

        } catch (SQLException e) {
            System.out.println("Error en llegir els mòduls professionals.");
            e.printStackTrace();
        }

        return moduls;
    }
}
