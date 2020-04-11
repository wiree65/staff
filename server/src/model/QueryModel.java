package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class QueryModel {
    Connection conn;
    PreparedStatement preparedStatement;
    public QueryModel() throws Exception {
        conn = DBConnection.getMSSQLConnection();
    }

    public ResultSet getStaff(){
        try{
            String query = String.format("SELECT * FROM staff");
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




}