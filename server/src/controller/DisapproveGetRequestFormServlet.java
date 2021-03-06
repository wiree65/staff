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
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "DisapproveGetRequestFormServlet")
public class DisapproveGetRequestFormServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

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
            System.out.println("id=" + id);
            System.out.println("Waiting");
            ResultSet result = q.getDisapprovedRequestFormById(id);
            System.out.println(result.toString());
            ArrayList<RequestForm> b = new ArrayList<RequestForm>();
            while (result.next()) {

                int form_no = result.getInt("form_no");
                String topic = result.getString("topic");
                String description = result.getString("description");

                String comment = result.getString("comment");
                String status = result.getString("status");
                String return_date = result.getString("return_date");
                String send_to = result.getString("send_to_name");

                RequestForm requestform = new RequestForm( form_no, topic, description,  comment, status, return_date, send_to);
                b.add(requestform);
            }
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            int index = 0;
            out.print("[\n");
            for (RequestForm temp : b) {
                String jsonData = gson.toJson(temp);
                out.println(jsonData);
                index++;
                if (index < b.size()) {
                    out.print(",");
                }
                out.println("\n");
                System.out.println(jsonData);
            }
            out.print("]\n");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", "*");
    }
}
