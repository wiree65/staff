package Controller;

import Model.Employee;
import Model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            HttpSession session = request.getSession(false);
//            String firstname = request.getParameter("firstname");
//            String lastname = request.getParameter("lastname");
            String username = (String)session.getAttribute("username");
            out.print(username+"\n");

            QueryModel q = new QueryModel();
            Employee em1 = new Employee(q.searchEmployeebyUsername(username));
            request.setAttribute("employee",em1);
            getServletContext().getRequestDispatcher("/searchemployee.jsp").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
