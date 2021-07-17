/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class JdbcHelper {

    private static String driver ;//= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl ;//= "jdbc:sqlserver://localhost;database=qltv";
    private static String username ;//= "poly";
    private static String password ;//= "123";

    static {
        try {
            BufferedReader out = new BufferedReader(new FileReader("config.txt"));
            driver = out.readLine();
            dburl = out.readLine();
            username = out.readLine();
            password = out.readLine();
            Class.forName(driver);
        } catch (Exception e) {
        }
    }

    ;

    public static PreparedStatement getStatement(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, username, password);
        PreparedStatement pstm;
        if (sql.trim().startsWith("{")) {
            pstm = conn.prepareCall(sql); // PROC
        } else {
            pstm = conn.prepareStatement(sql); // SQL
        }
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i + 1, args[i]);
        }
        return pstm;
    }

    public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement pstm = getStatement(sql, args);
            try {
                pstm.executeUpdate();
            } finally {
                pstm.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement pstm = getStatement(sql, args);
            System.out.println("true");
            return pstm.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}