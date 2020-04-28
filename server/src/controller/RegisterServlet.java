package controller;

import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        this.setAccessControlHeaders(response);
        try(PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String tel = request.getParameter("tel");
            String date_of_birth = request.getParameter("date_of_birth");
            String department = request.getParameter("department");
            String address = request.getParameter("address");
            String date_of_employed = request.getParameter("date_of_employed");
            String salary = request.getParameter("salary");
            String branch = request.getParameter("branch");
            String citizen_id = request.getParameter("citizen_id");
            String sex = request.getParameter("sex");
            String nickname=request.getParameter("nickname");
            QueryModel queryModel = new QueryModel();
//            queryModel.createAccountAndbirth(username,password,date_of_birth);
//            queryModel.createAccount(username,password);
            queryModel.createAccountAndSalary(username,password,salary,
                    nickname,name,lastname,date_of_birth,tel,email,citizen_id,
                    sex,address,date_of_employed,department.substring(0,2),branch.substring(0,2));
//            queryModel.createFullAccount( username, password, name,
//                    lastname, email, tel, date_of_birth, department.substring(0,2),
//                    address, date_of_employed, date_of_fired, salary,
//                    branch.substring(0,2),citizen_id,sex,nickname);
            System.out.println(department);
            System.out.println(branch.substring(0,2));
//           queryModel.justDepartment(branch,department.substring(0,2));
            out.print("success");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void setAccessControlHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
//        response.addHeader("Access-Control-Max-Age", "1728000");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

