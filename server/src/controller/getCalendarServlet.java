package controller;

import com.google.gson.Gson;
import model.QueryModel;
import model.Staff;
import model.calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "getCalendarServlet")
public class getCalendarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);

        try{
            QueryModel q = new QueryModel();
            ResultSet result = q.getCalendar();
            ArrayList<calendar> b = new ArrayList<calendar>();
            while(result.next()){

                String event_name = result.getString("event_name");
                String start_date = result.getString("start_date");
                String end_date = result.getString("end_date");

                calendar calendar = new calendar(event_name,start_date,end_date);
                b.add(calendar);
            }
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            int index = 0;
            out.print("[\n");
            for(calendar temp:b){
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
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }
}
