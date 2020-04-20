package controller;

import com.google.gson.Gson;
import model.QueryModel;
import model.RequestForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "GetMyRequestFormServlet")
public class GetMyRequestFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);

        try{

            Cookie[] cookies = request.getCookies();
            String cookieName = "staffID";
            String id ="";
            if (cookies != null)
            {
                for(int i=0; i<cookies.length; i++){
                    Cookie cookie = cookies[i];
                    System.out.println(cookies[i].getName());
                    if (cookieName.equals(cookie.getName()))
                    {
                        System.out.print(cookie.getValue());
                        id = cookie.getValue();
                    }
                }
            }else{
                System.out.println("ha");
            }
            QueryModel q = new QueryModel();
            ResultSet result = q.getRequestFormByid(id);
            System.out.println(result.toString());
            ArrayList<RequestForm> b = new ArrayList<RequestForm>();
            while(result.next()){
                int staff_id = result.getInt("id");
                String name = result.getString("staff.name");
                String lastname= result.getString("lastname");
                String tel= result.getString("tel");
                String email= result.getString("email");
                String department= result.getString("department.name");
                String branch= result.getString("branch.name");
                int form_no = result.getInt("form_no");
                String topic= result.getString("topic");
                String description= result.getString("description");
                String from_date= result.getString("form_date");
                String to_date= result.getString("to_date");
                String send_date= result.getString("send_date");
                String attach_file= result.getString("attach_file");
                String comment= result.getString("comment");
                String status= result.getString("status");
                String return_date= result.getString("return_date");

                RequestForm requestform = new RequestForm(staff_id,name,lastname,tel,email,department,branch, form_no,topic,description,from_date, to_date, send_date,attach_file,comment,status, return_date);
                b.add(requestform);
            }
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            int index = 0;
            out.print("[\n");
            for(RequestForm temp:b) {
                String jsonData = gson.toJson(temp);
                out.println(jsonData);
                index++;
                if (index < b.size()) {
                    out.print(",");
                }
                out.println("\n");

            }
            out.print("]\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }
}

