package com.player.repository;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by root_pc on 1/14/2017.
 * this is singleton design pattern for get connection
 */
public class DBProvider {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/wallet";
    static final String USER = "postgres";
    static final String PASS = "12345";

    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName(JDBC_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);
    }

    private DBProvider() {
        //
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}



//    public static Connection CreateConnection()
//            throws ClassNotFoundException, SQLException {
//
//        Class.forName("org.postgresql.Driver");
//        if (conn == null) {
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        }
//        return conn;
//    }
//
//    public synchronized static void CloseConnection() throws SQLException {
//        if (conn != null){
//            conn.close();
//            conn = null;
//        }
//    }

