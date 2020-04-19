package controller;

import model.Encrypt;
import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SigninServlet")
@MultipartConfig
public class SigninServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String json = "";

        try {
            QueryModel q = new QueryModel();
            boolean auth = q.checkPassword(username,password);
//            System.out.println(auth);
            if(auth){
                int staffID =q.getCustomerId(username);
                System.out.println("StaffID"+staffID);
                response.setStatus(200);
                if(q.isManager(staffID)){
                json="{\"role\":\"manager\"}";}
                else{
                    json="{\"role\":\"staff\"}";

                }


                Cookie userCookie = new Cookie("staffID",""+staffID);
                        userCookie.setMaxAge(7200);
                response.addCookie(userCookie);


            }else{
                response.setStatus(400);
            }

            PrintWriter out = response.getWriter();

            out.print(json);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
//            resp.setHeader("Access-Control-Allow-Origin", "http://192.168.0.102:8081");
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", "*");
    }
}
