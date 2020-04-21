package controller;

import com.google.gson.Gson;
import model.QueryModel;
import model.StaffInfo;
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

@WebServlet(name = "PersonalInfoServlet ")
public class PersonalInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);

        try{
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
            System.out.println(id);
            ResultSet result = q.getStaffFromId(id);
            ArrayList<StaffInfo> b = new ArrayList<StaffInfo>();
            while(result.next()){
                int id1=result.getInt("id");
                String username = result.getString("username");
                String name= result.getString("name");
                String lastname= result.getString("lastname");
                String email= result.getString("email");
                String tel= result.getString("tel");
                String date_of_birth= result.getString("date_of_birth");
                String department= result.getString("name");
                String branch= result.getString("name");
                String address= result.getString("address");
                String date_of_employed= result.getString("date_of_employed");
                String salary= result.getString("salary");
                String created_at= result.getString("created_at");
                String update_at= result.getString("update_at");
                String citizen_id= result.getString("citizen_id");
                String sex= result.getString("sex");
                String nickname= result.getString("nickname");
                StaffInfo staff = new StaffInfo(id1,username, name,lastname,email,tel,date_of_birth,department,branch, address, date_of_employed,salary,created_at,update_at,citizen_id,sex,nickname);
                b.add(staff);
            }
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            int index = 0;
            out.print("[\n");
            for(StaffInfo temp:b){
                String jsonData = gson.toJson(temp);
                out.println(jsonData);
                index++;
                if(index < b.size()){
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
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", "*");
    }
}
