package controller;

import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "GetStaffServlet")
public class GetStaffServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);

        try {
            QueryModel q = new QueryModel();
            Cookie[] c = request.getCookies();
            String id = "";
            if(c!=null){
                for(int i = 0 ;i<c.length;i++){
                    if(c[i].getName().equals("staffID")){
                        id = c[i].getValue();
                    }
                }
            }
            System.out.println("staffid="+id);
            ResultSet result = q.getStaffFromName(id);
            String json = "{";
            String name = "";
            String lastname = "";
            String email = "";
            while(result.next()){
                name =result.getString("name");
                lastname =result.getString("lastname");
            }
            json +="\"name\":"+"\""+name+"\",";
            json +="\"lastname\":"+"\""+lastname+"\",";
            json +="\"email\":"+"\""+email+"\",";
            json += "\"id\":"+"\""+id+"\"}";
            PrintWriter out = response.getWriter();
//            System.out.println(json);
//            System.out.print(json);
            out.print(json);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }private void setAccessControlHeaders(HttpServletResponse resp) {
//            resp.setHeader("Access-Control-Allow-Origin", "http://192.168.0.102:8081");
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", "*");
    }
}
