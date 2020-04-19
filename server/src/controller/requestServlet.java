package controller;

import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//form_no, staff_id, topic, description, from_date, to_date, send_date, attach_file, return_date, return_date
@WebServlet(name = "requestServlet")
public class requestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        this.setAccessControlHeaders(response);
        try (PrintWriter out = response.getWriter()) {
            String form_no = request.getParameter("form_no");
            String staff_id = request.getParameter("staff_id");
//            String topic = request.getParameter("topic");
            String description = request.getParameter("description");
            String from_date = request.getParameter("from_date");
            String to_date = request.getParameter("to_date");
            String send_date = request.getParameter("send_date");
            String attach_file = request.getParameter("attach_file");
            String return_date = request.getParameter("return_date");
            String comment = request.getParameter("comment");

            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String branch = request.getParameter("branch");
            String department = request.getParameter("department");


            QueryModel queryModel = new QueryModel();
            queryModel.insertRequestFormName(firstname,lastname,email,phone,department.substring(0,2),branch.substring(0,2),comment);
//            System.out.println(firstname);
//            queryModel.insertRequestForm(form_no, description,
//                    from_date, to_date, send_date,
//                    firstname,lastname,email,phone,branch.substring(0,2),
//                    department.substring(0,2));

            out.print("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void setAccessControlHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
//        response.addHeader("Access-Control-Max-Age", "1728000");
    }
}