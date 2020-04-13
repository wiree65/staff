package model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public ResultSet statementQuery(String query){
        try {
            preparedStatement = conn.prepareStatement(query);
            return preparedStatement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void executeQuery(String query){
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkPassword(String username,String password) throws NoSuchAlgorithmException, SQLException {
        String newpassword = username+password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashpassword = toHexString(md.digest(newpassword.getBytes(StandardCharsets.UTF_8)));
        String query = String.format("SELECT password from staff where username = '%s'",username);
        ResultSet result = statementQuery(query);
        String correctpassword="";
        while(result.next()){
            correctpassword =  result.getString("password");
        }
        return correctpassword.equals(hashpassword);
    }
    public void createAccount(String username,String password) throws NoSuchAlgorithmException {
        String newpassword = username+password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashpassword = toHexString(md.digest(newpassword.getBytes(StandardCharsets.UTF_8)));
        String query = String.format("INSERT INTO staff(username,password) VALUES('%s','%s')",username,hashpassword);
        System.out.println(query);
        executeQuery(query);

    }
    public String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }





}