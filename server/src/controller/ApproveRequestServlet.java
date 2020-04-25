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

//form_no, staff_id, topic, description, from_date, to_date, send_date, attach_file, return_date, return_date
@WebServlet(name = "ApproveRequestServlet")
public class ApproveRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        this.setAccessControlHeaders(response);
        System.out.println("test");
        try  {
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
            System.out.println("aproving");
            ResultSet result = q.getWaitingRequestFormBySendTo(q.getDepartmentFromId(id));
            String form_no="";
            while(result.next()){
                form_no =result.getString("form_no");

            }

            String comment = request.getParameter("comment");
            String status = request.getParameter("status");
            System.out.println("status="+status);

            PrintWriter out = response.getWriter();
            QueryModel queryModel = new QueryModel();
            queryModel.approveRequestFormByFormNO(comment,status,form_no);
            out.print("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void setAccessControlHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
//        response.addHeader("Access-Control-Max-Age", "1728000");
    }
}