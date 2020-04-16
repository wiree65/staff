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

    public ResultSet getStaff() {
        try {
            String query = String.format("SELECT * FROM staff");
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getStaffFromName(String id) {
        try {
            String query = String.format("SELECT * FROM staff WHERE id='%s'",id);

            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet statementQuery(String query) {
        try {
            preparedStatement = conn.prepareStatement(query);
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeQuery(String query) {
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkPassword(String username, String password) throws NoSuchAlgorithmException, SQLException {
        String newpassword = username + password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashpassword = toHexString(md.digest(newpassword.getBytes(StandardCharsets.UTF_8)));
        String query = String.format("SELECT password from staff where username = '%s'", username);
        ResultSet result = statementQuery(query);
        String correctpassword = "";
        while (result.next()) {
            correctpassword = result.getString("password");
        }
        return correctpassword.equals(hashpassword);
    }

    public void createAccount(String username, String password) throws NoSuchAlgorithmException {
        String newpassword = username + password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashpassword = toHexString(md.digest(newpassword.getBytes(StandardCharsets.UTF_8)));
        String query = String.format("INSERT INTO staff(username,password) VALUES('%s','%s')", username, hashpassword);
        System.out.println(query);
        executeQuery(query);

    }

    public void createAccountAndSalary(String username, String password, String salary, String nickname, String name, String lastname, String date_of_birth, String tel, String email, String citizen_id, String sex, String address, String date_of_employed, String branch) throws NoSuchAlgorithmException {
        String newpassword = username + password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashpassword = toHexString(md.digest(newpassword.getBytes(StandardCharsets.UTF_8)));
        String query = String.format("INSERT INTO staff(username,password,salary,nickname,name,lastname,date_of_birth,tel,email,citizen_id,sex,address,date_of_employed,branch) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", username, hashpassword, salary, nickname, name, lastname, date_of_birth, tel, email, citizen_id, sex, address, date_of_employed, branch);
        System.out.println(query);
        executeQuery(query);

    }

    public int signinUser(String username, String password) throws Exception {
        try {
            String query = String.format("select username,password from staff where username='%s'", username);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            // 0 : User Not Found.
            // 1 : Password Matched.
            // 2 : Password not Matched.
            if (!result.next()) {
                return 0;
            } else {
                return result.getString("password").equals(
                        Encrypt.encrypt(password)) ? 1 : 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getCustomerId(String username) throws Exception {
        try {
            String query = String.format("select id from staff where username='%s'", username);

            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            // 0 : User Not Found.
            if (!result.next()) {
                return -1;
            } else {
                return Integer.parseInt(result.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


//    public void justDepartment(String branch) throws SQLException {
//        String query=String.format("INSERT INTO staff(branch) VALUES ('%s')",branch);
//        System.out.println(query);
//        preparedStatement = conn.prepareStatement(query);
//        ResultSet result = preparedStatement.executeQuery();
//        result.next();
//        String branch = result.getString("")
//
//
//    }
    public void createAccountAndbirth(String username,String password,String date_of_birth) throws NoSuchAlgorithmException {
        String newpassword = username+password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashpassword = toHexString(md.digest(newpassword.getBytes(StandardCharsets.UTF_8)));
        String query = String.format("INSERT INTO staff(username,password,date_of_birth) VALUES('%s','%s','%s')",username,hashpassword,date_of_birth);
        System.out.println(query);
        executeQuery(query);

    }

    public void createFullAccount(String username,String password,String name,String lastname,String email,String tel,String date_of_birth,String department,String address,String date_of_employed,String date_of_fired,String salary,String branch,String citizen_id,String sex,String nickname) throws NoSuchAlgorithmException {
        String newpassword = username+password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashpassword = toHexString(md.digest(newpassword.getBytes(StandardCharsets.UTF_8)));
        String query = String.format("INSERT INTO staff(username, password, name, lastname, email, tel, date_of_birth, department, address, date_of_employed, date_of_fired, salary, branch,citizen_id,sex,nickname) " +
                "VALUES('%s','%s','%s','%s','%s','%s','%s','%d','%s','%s','%s','%s','%d','%s','%s','%s');",username,hashpassword,name,lastname,email,tel,date_of_birth,department,address,date_of_employed,date_of_fired,salary,branch,citizen_id,sex,nickname);
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