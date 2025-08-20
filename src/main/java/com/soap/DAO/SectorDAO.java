package com.soap.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.soap.Utils.DBUtil;
import com.soap.entity.Sector;

public class SectorDAO {

    public void createSector(Sector sector) {
        String sql = "INSERT INTO sectors (name) VALUES (?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sector.getName());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Sector> getAllSectors() {
        List<Sector> list = new ArrayList<>();
        String sql = "SELECT id, name FROM sectors";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Sector(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

