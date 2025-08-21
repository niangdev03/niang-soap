package com.soap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soap.Utils.DBUtil;
import com.soap.entity.Classe;
import com.soap.entity.Sector;

public class ClasseDAO {

    public void createClasse(Classe classe) {
        String sql = "INSERT INTO classes (name, description, sector_id) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, classe.getName());
            stmt.setString(2, classe.getDescription());
            stmt.setInt(3, classe.getSector().getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Classe> getAllClasses() {
        List<Classe> list = new ArrayList<>();
        String sql = "SELECT c.id AS classe_id, c.name AS classe_name, c.description, " +
                    "s.id AS sector_id, s.name AS sector_name " +
                    "FROM classes c JOIN sectors s ON c.sector_id = s.id";
        try (Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Sector sector = new Sector(
                    rs.getInt("sector_id"),
                    rs.getString("sector_name")
                );

                Classe classe = new Classe(
                    rs.getInt("classe_id"),
                    rs.getString("classe_name"),
                    rs.getString("description"),
                    sector
                );

                list.add(classe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateClasse(Classe classe) {
        String sql = "UPDATE classes SET name = ?, description = ?, sector_id = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, classe.getName());
            stmt.setString(2, classe.getDescription());
            stmt.setInt(3, classe.getSector().getId());
            stmt.setInt(4, classe.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteClasse(int id) {
        String sql = "DELETE FROM classes WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

