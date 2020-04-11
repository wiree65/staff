package model;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    public static Connection getMSSQLConnection() throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String database = "CSC105_project";
            String host = "dbms.ilab.sit.kmutt.ac.th";
            String user = "csc105";
            String password = "csprogramming";
            String url = String.format("jdbc:sqlserver://%s;databaseName=%s;user=%s;password=%s", host, database, user, password);
            Connection conn = DriverManager.getConnection(url);
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
