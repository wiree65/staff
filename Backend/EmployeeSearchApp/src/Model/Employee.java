package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

    private String birth_date;
    private String first_name;
    private String last_name;
    private String gender;
    private String hire_date;
    private String salary;
    private String dept_name;
    private String title;
    public Employee(ResultSet resultSet) throws SQLException {

        this.birth_date = resultSet.getString("birth_date");
        this.first_name = resultSet.getString("first_name");
        this.last_name = resultSet.getString("last_name");
        this.gender = resultSet.getString("gender");
        this.hire_date = resultSet.getString("hire_date");
        this.salary = resultSet.getString("salary");
        this.dept_name = resultSet.getString("dept_name");
        this.title = resultSet.getString("title");
    }


    public String getBirthDate() {
        return birth_date;
    }

    public String getFirstname() {
        return first_name;
    }

    public String getLastname() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public String getHire_date() {
        return hire_date;
    }

    public String getSalary() {
        return salary;
    }

    public String getDept_name() {
        return dept_name;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "birth_date='" + birth_date + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", hire_date='" + hire_date + '\'' +
                ", salary='" + salary + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
