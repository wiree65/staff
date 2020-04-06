import Model.Employee;
import Model.EmployeeInfo;
import Model.QueryModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        QueryModel q = new QueryModel();
        ArrayList<EmployeeInfo> list = q.getAllEmployee();

        for (EmployeeInfo a:  list) {
            System.out.println(a.toString()+"\n");
        }
    }
}
