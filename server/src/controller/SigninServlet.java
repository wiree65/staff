package controller;

import model.Encrypt;
import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SigninServlet")
@MultipartConfig
public class SigninServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        // Get username and password from req
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String json = "";

        try {
            QueryModel q = new QueryModel();
            boolean auth = q.checkPassword(username,password);
            System.out.println(auth);
            if(auth){
                HttpSession session = request.getSession();
                int staffID = q.getCustomerId(username);
                String sessionID = session.getId();
                response.setStatus(200);
                session.setAttribute("staffID",staffID);
                json="success";
//                json = "{\"error\":\"User not found\"}";
//            }else if(auth ){
//                HttpSession session = request.getSession();
//                String sessionID = session.getId();
//                int staffID = q.getCustomerId(username);
//                if(staffID == -1){
//                    response.setStatus(404);
//                    json = "{\"error\":\"User not found\"}";
//                }else{
//                    response.setStatus(200);
//                    session.setAttribute("staffID",staffID);
//                }
//            }else if(auth == 2){
//                response.setStatus(404);
//                json = "{\"error\":\"Password not matched\"}";
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
