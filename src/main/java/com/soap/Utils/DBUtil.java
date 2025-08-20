package com.soap.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // Configuration PostgreSQL
    private static String url = "jdbc:postgresql://localhost:5432/niang-devoir-soap";
    private static String username = "postgres"; 
    private static String password = "root";

    static {
        try {
            // Driver PostgreSQL
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

// public class DBUtil {
//     private static String url;
//     private static String user;
//     private static String password;

//     static {
//         try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
//             Properties prop = new Properties();
//             prop.load(input);

//             url = prop.getProperty("db.url");
//             user = prop.getProperty("db.username");
//             password = prop.getProperty("db.password");

//             Class.forName(prop.getProperty("db.driver"));
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public static Connection getConnection() throws Exception {
//         return DriverManager.getConnection(url, user, password);
//     }
// }
