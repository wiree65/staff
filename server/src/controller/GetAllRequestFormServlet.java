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

@WebServlet(name = "GetAllRequestFormServlet")
public class GetAllRequestFormServlet extends HttpServlet {

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);

        try{
            QueryModel q = new QueryModel();
            ResultSet result = q.getAllRequestForm();
            ArrayList<RequestForm> b = new ArrayList<RequestForm>();
            while(result.next()){
            int form_no = result.getInt("form_no");
            int staff_id = result.getInt("staff_id");
            String topic = result.getString("topic");
            String description = result.getString("description");
            String from_date = result.getString("from_date");
            String to_date = result.getString("to_date");
            String send_date = result.getString("send_date");
            String attach_file = result.getString("attach_file");
            String return_date = result.getString("return_date");
            String comment = result.getString("comment");
            RequestForm requestform = new requestform(form_no,staff_id,topic,description,from_date,to_date,send_date,attach_file,return_date,comment);

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

