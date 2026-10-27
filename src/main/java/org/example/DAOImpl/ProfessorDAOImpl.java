package org.example.DAOImpl;

import org.example.DAO.ProfessorDAO;
import org.example.Model.Professor;
import org.example.Utils.Utils;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void deleteDam2(int id) {
        String sql = "DELETE FROM Professors WHERE id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Utils.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            // executeUpdate retorna quantes files s'han esborrat
            int files = ps.executeUpdate();

            if (files > 0) {
                System.out.println("Professor eliminat correctament.");
            } else {
                System.out.println("No existeix cap professor amb aquest id.");
            }
        } catch (SQLException e) {
            System.out.println("Error en eliminar el professor: " + e.getMessage());
        } finally {
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

    @Override
    public void updateDam2(Professor professor) {
        String sql = "UPDATE Professors SET nom = ?, cognoms = ? WHERE id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Utils.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, professor.getNom());
            ps.setString(2, professor.getCognom());
            ps.setInt(3, professor.getId());

            int files = ps.executeUpdate();

            if (files > 0) {
                System.out.println("Professor actualitzat correctament.");
            } else {
                System.out.println("No existeix cap professor amb aquest id.");
            }
        } catch (SQLException e) {
            System.out.println("Error en actualitzar el professor: " + e.getMessage());
        } finally {
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

    @Override
    public List<Professor> readDam2() {
        String sql = "SELECT id, nom, cognoms FROM Professors";

        // Llista on guardarem tots els professors
        List<Professor> professors = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Utils.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Recorrem cada fila del resultat
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String cognom = rs.getString("cognoms");

                Professor professor = new Professor(id, nom, cognom);
                professors.add(professor);
            }
        } catch (SQLException e) {
            System.out.println("Error en llegir els professors: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return professors;
    }
}
