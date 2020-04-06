package Controller;

import Model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            QueryModel q = new QueryModel();
            if(password.equals(q.checkPassword(userName))){
                HttpSession session= request.getSession();
                session.setAttribute("username",userName);
                out.println("Welcome Back User: "+session.getAttribute("username"));
                getServletContext().getRequestDispatcher("/SearchEmployeeServlet").forward(request,response);
            }else{
                out.println("Problem with your password...Please Check it");
                request.getRequestDispatcher("/index.jsp").include(request,response);
            }
        }

    }
}
