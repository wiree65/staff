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


    public ResultSet getRequestFormBySendTo(String department) {
        try {
            String query = String.format("SELECT DISTINCT staff.id , staff.name, staff.lastname, staff.tel, staff.email, department.name, branch.name,staff_request.form_no, staff_request.topic,staff_request.description, staff_request.from_date,staff_request.to_date, staff_request.send_date,staff_request.attach_file ,staff_request.comment ,staff_request.status,staff_request.return_date,staff_request.send_to from staff Inner Join department on staff.department = department.id Inner Join branch on staff.branch = branch.id INNER JOIN staff_request on staff.id= staff_request.staff_id WHERE staff_request.send_to = '%s'",department);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getApprovedRequestFormBySendTo(String department) {
        try {
            String query = String.format("SELECT DISTINCT staff.id , staff.name, staff.lastname, staff.tel, staff.email, department.name, branch.name,staff_request.form_no, staff_request.topic,staff_request.description, staff_request.from_date,staff_request.to_date, staff_request.send_date,staff_request.attach_file ,staff_request.comment ,staff_request.status,staff_request.return_date,staff_request.send_to from staff Inner Join department on staff.department = department.id Inner Join branch on staff.branch = branch.id INNER JOIN staff_request on staff.id= staff_request.staff_id WHERE staff_request.send_to = '%s' AND status = 'Approved'",department);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public ResultSet getWaitingRequestFormById(String id) {
        try {
            String query = String.format("SELECT DISTINCT staff.id , RSQ.form_no, RSQ.topic,RSQ.description,RSQ.send_date ,RSQ.comment ,RSQ.status,RSQ.return_date,send_to, (select department.name from department  inner join staff_request on department.id  = send_to where staff_request.form_no = RSQ.form_no)AS send_to_name from staff  Inner Join department on staff.department = department.id Inner Join branch on staff.branch = branch.id INNER JOIN staff_request  AS RSQ on staff.id = staff_id  AND status='waiting' where staff_id = '%s' ",id);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getApprovedRequestFormById(String id) {
        try {
            String query = String.format("SELECT DISTINCT staff.id , RSQ.form_no, RSQ.topic,RSQ.description,RSQ.send_date ,RSQ.comment ,RSQ.status,RSQ.return_date,send_to, (select department.name from department  inner join staff_request on department.id  = send_to where staff_request.form_no = RSQ.form_no)AS send_to_name from staff  Inner Join department on staff.department = department.id Inner Join branch on staff.branch = branch.id INNER JOIN staff_request  AS RSQ on staff.id = staff_id  AND status='Approved' where staff_id = '%s' ",id);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getDisapprovedRequestFormById(String id) {
        try {
            String query = String.format("SELECT DISTINCT staff.id , RSQ.form_no, RSQ.topic,RSQ.description,RSQ.send_date ,RSQ.comment ,RSQ.status,RSQ.return_date,send_to, (select department.name from department  inner join staff_request on department.id  = send_to where staff_request.form_no = RSQ.form_no)AS send_to_name from staff  Inner Join department on staff.department = department.id Inner Join branch on staff.branch = branch.id INNER JOIN staff_request  AS RSQ on staff.id = staff_id  AND status='disapproved' where staff_id = '%s' ",id);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getWaitingRequestFormBySendTo(String department) {
        try {
            String query = String.format("SELECT DISTINCT staff.id , staff.name, staff.lastname, staff.tel, staff.email, department.name, branch.name,staff_request.form_no, staff_request.topic,staff_request.description, staff_request.from_date,staff_request.to_date, staff_request.send_date,staff_request.attach_file ,staff_request.comment ,staff_request.status,staff_request.return_date,staff_request.send_to from staff Inner Join department on staff.department = department.id Inner Join branch on staff.branch = branch.id INNER JOIN staff_request on staff.id= staff_request.staff_id WHERE staff_request.send_to = '%s' AND status = 'Waiting'",department);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getDisapprovedRequestFormBySendTo(String department) {
        try {
            String query = String.format("SELECT DISTINCT staff.id , staff.name, staff.lastname, staff.tel, staff.email, department.name, branch.name,staff_request.form_no, staff_request.topic,staff_request.description, staff_request.from_date,staff_request.to_date, staff_request.send_date,staff_request.attach_file ,staff_request.comment ,staff_request.status,staff_request.return_date,staff_request.send_to from staff Inner Join department on staff.department = department.id Inner Join branch on staff.branch = branch.id INNER JOIN staff_request on staff.id= staff_request.staff_id WHERE staff_request.send_to = '%s' AND status = 'Disapproved'",department);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void approveRequestFormByFormNO(String comment,String status,String form_no){
        String query = String.format("UPDATE staff_request SET comment = '%s', status = '%s',return_date = GETDATE() WHERE form_no = '%s'",comment,status,form_no);
        System.out.println(query);
        executeQuery(query);
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


    public void createAccountAndSalary(String username, String password, String salary, String nickname, String name, String lastname, String date_of_birth, String tel, String email, String citizen_id, String sex, String address, String date_of_employed, String department,String branch) throws NoSuchAlgorithmException {
        String newpassword = username + password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashpassword = toHexString(md.digest(newpassword.getBytes(StandardCharsets.UTF_8)));
        String query = String.format("INSERT INTO staff(username,password,salary,nickname,name,lastname,date_of_birth,tel,email,citizen_id,sex,address,date_of_employed,department,branch) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", username, hashpassword, salary, nickname, name, lastname, date_of_birth, tel, email, citizen_id, sex, address, date_of_employed,department, branch);
        System.out.println(query);
        executeQuery(query);

    }

    public boolean isManager(int id) throws SQLException {
        String query = String.format("SELECT manager_id from department where manager_id = '%s'", id);
        ResultSet result = statementQuery(query);
        int managerId=0;
        while (result.next()) {
            managerId = result.getInt("manager_id");
        }
        return managerId==id;
    }


    public int getStaffId(String username) throws Exception {
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



    public void justDepartment(String branch,String department) throws SQLException {
        String query=String.format("INSERT INTO staff(branch,department) VALUES ('%s','%s')",branch,department);
        System.out.println(query);
        executeQuery(query);
    }


    public void insertRequestFormName(String firstname ,String lastname,String email,String phone,String department,String branch,String comment) throws NoSuchAlgorithmException {

        String query = String.format("INSERT INTO staff_request(firstname,lastname,email,phone,department,branch,comment) VALUES('%s','%s','%s','%s','%s','%s','%s')",
                firstname,lastname,email,phone,department,branch,comment);
        System.out.println(query);
        executeQuery(query);

    }
    //GETDATE()
    public void insertRequestForm(String staff_id,String from_date,String topic,String description,String to_date,String send_to){
        String query = String.format("INSERT INTO staff_request(staff_id,from_date,topic,description,to_date,send_to,send_date) VALUES('%s','%s','%s','%s','%s','%s',GETDATE())",
                staff_id,from_date,topic,description,to_date,send_to);
        System.out.println(query);
        executeQuery(query);
    }

    public ResultSet getCalendar() {
        try {
            String query = String.format("SELECT * FROM staff_calendar");
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getRequestFormByid(String id) {
        try {

            String query = String.format("SELECT DISTINCT staff.id , staff.name, staff.lastname, staff.tel, staff.email, department.name, branch.name,staff_request.form_no, staff_request.topic,staff_request.description, staff_request.from_date,staff_request.to_date, staff_request.send_date,staff_request.attach_file ,staff_request.comment ,staff_request.status,staff_request.return_date from staff Inner Join department on staff.department = department.id Inner Join branch on staff.branch = branch.id INNER JOIN staff_request on staff.id= staff_request.staff_id WHERE staff.id = '%s'",id);

            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
    public void InsertCalendar(String start_date,String end_date, String detail, String event_name){
        String query = String.format("INSERT INTO staff_calendar(start_date,end_date,detail,event_name) VALUES('%s','%s','%s','%s')",
                start_date,end_date,detail,event_name);
        System.out.println(query);
        executeQuery(query);
    }


    public String getDepartmentFromId(String id){
        try {
            String query = String.format("select department from staff where id ='%s'",id);

            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            String staffDepartment="";
            while (result.next()) {
                String department = ""+result.getInt("department");
                staffDepartment = department;
            }
            return staffDepartment;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

     public ResultSet getStaffFromId(String id){
        try {
            String query = String.format("SELECT staff.id,staff.username,staff.name,staff.lastname,staff.email,staff.tel,staff.date_of_birth,department.name,branch.name,staff.address,staff.date_of_employed,staff.salary,staff.created_at,staff.update_at,staff.citizen_id,staff.sex,staff.nickname from staff INNER JOIN  department  on staff.department  = department.id INNER JOIN branch on staff.branch = branch.id where staff.id = '%s'",id);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }





}