//package controller;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import com.google.gson.Gson;
//import model.QueryModel;
//import model.Staff;
//
//@WebServlet(name = "Staffs")
//public class Staffs extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");
//        setAccessControlHeaders(response);
//
//        try{
//            QueryModel q = new QueryModel();
//            Cookie[] cookies = request.getCookies();
//            String cookieName = "staffID";
//            String id ="";
//            if (cookies != null)
//            {
//                for(int i=0; i<cookies.length; i++)
//                {
//                    Cookie cookie = cookies[i];
//                    System.out.println(cookies[i].getName());
//                    if (cookieName.equals(cookie.getName()))
//                    {
//                        System.out.print(cookie.getValue());
//                        id = cookie.getValue();
//                    }
//                }
//            }else{
//                System.out.println("ha");
//
//            }
//
//           ResultSet result = q.getStaffFromName(id);
//
////            }
//            Gson gson = new Gson ArrayList<Staff> b = new ArrayList<Staff>();
//            while(result.next()) {
//                int id = result.getInt("id");
//                String username = result.getString("username");
//                String password = result.getString("password");
//                String name = result.getString("name");
//                String lastname = result.getString("lastname");
//                String email = result.getString("email");
//                String tel = result.getString("tel");
//                String date_of_birth = result.getString("date_of_birth");
//                int department = result.getInt("department");
//                String address = result.getString("address");
//                String date_of_employed = result.getString("date_of_employed");
//                String date_of_fired = result.getString("date_of_fired");
//                String salary = result.getString("salary");
//                String branch = result.getString("branch");
//                String nickname = result.getString("nickname");
//                String citizen_id = result.getString("citizen_id");
//                String sex = result.getString("sex");
//                Staff staff = new Staff(id, username, password, name, lastname, email, tel, date_of_birth, department, address,
//                        date_of_employed, date_of_fired, salary, branch, nickname, citizen_id, sex);
//
//                b.add(staff);
//                PrintWriter out = response.getWriter();
//                int index = 0;
//                out.print("{\n");
//                for (Staff temp : b) {
//                    String jsonData = gson.toJson(temp);
//                    out.println(jsonData);
//                    index++;
//                    if (index < b.size()) {
//                        out.print(",");
//                    }
//                    out.println("\n");
//
//                }
//
//                out.print("}\n");
//            }
//    } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        private void setAccessControlHeaders(HttpServletResponse resp) {
//        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
//        resp.setHeader("Access-Control-Allow-Methods", "GET");
//    }
//}
