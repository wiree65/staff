package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    public static Connection getMSSQLConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String host = "202.44.9.117";
            String databaseName = "EXAMPLE";
            String user = "csc105";
            String password = "csprogramming";
            String url = String.format("jdbc:sqlserver://%s;databaseName=%s;user=%s;password=%s",host,databaseName,user,password);
            Connection conn = DriverManager.getConnection(url);
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}