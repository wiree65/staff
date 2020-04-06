package Controller;

import Model.Employee;
import Model.EmployeeInfo;
import Model.QueryModel;
import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class GetEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            HttpSession session = request.getSession(false);
//            String firstname = request.getParameter("firstname");
//            String lastname = request.getParameter("lastname");

            out.println(generateJsonData());


//            getServletContext().getRequestDispatcher("/searchemployee.jsp").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public JsonArray generateJsonData(){
        QueryModel q = new QueryModel();
        ArrayList<EmployeeInfo> list = q.getAllEmployee();
        JsonArrayBuilder array = Json.createArrayBuilder();

        for (EmployeeInfo a:  list) {
            array.add(Json.createObjectBuilder().add("first_name",a.getFirstname()).add("last_name",a.getLastname()).add("gender",a.getGender()).add("hire_date",a.getHire_date()));
        }

        return array.build();
    }
}