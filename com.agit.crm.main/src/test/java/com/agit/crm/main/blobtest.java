/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BayuHS
 */
public class blobtest {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/crm-engine";
        String username = "postgres";
        String password = "root";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1 - Load driver
            // Class.forName("org.postgresql.Driver"); // Class.forName() is not needed since JDBC 4.0

            // Step 2 - Open connection
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // Step 3 - Execute statement
            stmt = conn.createStatement();
            rs = stmt.executeQuery("rs = stmt.executeQuery(\"UPDATE agit_storing_fi_card AS v\\n\"\n"
                    + "//                        + \"SET statusresult = CASE\\n\"\n"
                    + "//                        + \"WHEN s.pointcheck1 = '|'\\n\"\n"
                    + "//                        + \"AND s.pointcheck2 = '|'\\n\"\n"
                    + "//                        + \"AND s.pointcheck3 = '|'\\n\"\n"
                    + "//                        + \"AND s.pointcheck4 = '|'\\n\"\n"
                    + "//                        + \"AND s.pointcheck5 = '|' THEN\\n\"\n"
                    + "//                        + \"	'G'\\n\"\n"
                    + "//                        + \"ELSE\\n\"\n"
                    + "//                        + \"	'NG'\\n\"\n"
                    + "//                        + \"END\\n\"\n"
                    + "//                        + \"FROM\\n\"\n"
                    + "//                        + \"	agit_storing_fi_card AS s\\n\"\n"
                    + "//                        + \"WHERE\\n\"\n"
                    + "//                        + \"	v.storingficardid = s.storingficardid\");");

            // Step 4 - Get result
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                // Step 5 Close connection
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
