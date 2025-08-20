package com.soap.Utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            url = prop.getProperty("db.url");
            user = prop.getProperty("db.username");
            password = prop.getProperty("db.password");

            Class.forName(prop.getProperty("db.driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }
}
