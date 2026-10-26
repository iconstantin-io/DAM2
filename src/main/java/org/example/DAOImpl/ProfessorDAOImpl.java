package org.example.DAOImpl;

import org.example.DAO.ProfessorDAO;
import org.example.Model.Professor;
import org.example.Utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfessorDAOImpl implements ProfessorDAO {

    @Override
    public void addDam2(Professor professor) {
        String sql = "INSERT INTO Professors (nom, cognoms) VALUES (?, ?)";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Utils.getConnection();
            ps = con.prepareStatement(sql);

            // Posem els valors als ?
            ps.setString(1, professor.getNom());
            ps.setString(2, professor.getCognom());

            // Executem l'insert
            ps.executeUpdate();

            System.out.println("Professor guardat correctament.");
        } catch (SQLException e) {
            System.out.println("Error en guardar el professor: " + e.getMessage());
        } finally {
            // Tanquem el PreparedStatement i la connexió
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en tancar: " + e.getMessage());
            }
        }
    }
}
