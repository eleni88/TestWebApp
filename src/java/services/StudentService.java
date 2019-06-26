/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Student;
import controllers.StudentServlet;
import dao.Database;
import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author George.Pasparakis
 */
public class StudentService {

    
    PrintWriter out;
     
    
     
    
//        public void htmltext( List<Student> s) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Student Servlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<br />");
//            out.println(s);
//            out.println("</body>");
//            out.println("</html>");
//        }
    public String getStudents() {

      
 StudentDAO s = new StudentDAO();
        List<Student> students2 = s.get();
        StringBuilder stbld = new StringBuilder();
        stbld.append(stbld)
                .append("<!DOCTYPE html>")
                .append("<html>") 
                .append("<head>")
                .append("</head>")
                .append("<body>");
                for (Student st: students2){
                stbld.append("<p>").append(s).append("</p>");
                }
                stbld.append("</body>");
                
//        for (int i = students2.size(); i > 0; i++) {
//           
//            stbld.append(htmltext(students2.get(i)));}
         
        

        String str = stbld.toString();

        return str;
    }
    
    

}
