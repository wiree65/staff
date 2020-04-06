package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryModel {
    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    public QueryModel(){
        try {
            conn = DBconnection.getMSSQLConnection();
            System.out.println("Connection:"+conn);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet searchEmployee(String firstname, String lastname){
        try{
            String query = String.format("SELECT * FROM employees.employees WHERE first_name LIKE '%s' AND last_name LIKE '%s' ", firstname, lastname);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet;
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<EmployeeInfo>  getAllEmployee(){
        try{
            String query = String.format("SELECT TOP 200 * FROM employees.employees ");
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            ArrayList<EmployeeInfo>  list = new ArrayList<>();
            while(resultSet.next()){
                 list.add(new EmployeeInfo(resultSet));
            }return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet searchEmployeebyUsername(String username){
        try{
            String query = String.format("SELECT employees.first_name, employees.last_name, employees.birth_date,employees.gender,employees.hire_date, MAX(salaries.salary) AS 'salary', departments.dept_name, titles.title\n" +
                    "FROM employees INNER JOIN salaries on employees.emp_no = salaries.emp_no INNER JOIN dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                    "INNER JOIN departments on dept_emp.dept_no = departments.dept_no INNER JOIN useraccount on useraccount.emp_no = employees.emp_no\n" +
                    "INNER JOIN titles on titles.emp_no = employees.emp_no WHERE useraccount.username='%s'\n" +
                    "GROUP BY employees.first_name, employees.last_name, employees.birth_date,employees.gender,employees.hire_date, departments.dept_name, titles.title", username);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet;
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public String checkPassword (String username){
        try {
            String query = String.format("SELECT * FROM employees.useraccount WHERE username ='%s' ",username);
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString("password");
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
