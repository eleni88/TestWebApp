/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Student;
import dao.StudentDAO;
import java.util.List;


public class StudentService {

    StudentDAO stuDao = new StudentDAO();


    public String getStudents() {

        StudentDAO s = new StudentDAO();
        List<Student> students = s.getStudents();
        StringBuilder stbld = new StringBuilder();
        stbld.append(stbld)
                .append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("</head>")
                .append("<body>");
        for (Student st : students) {
            String delete = "<a href='DeleteStudentServlet?delete=" + st.getId() + "'>Delete</a>";
            String update = "<a href='UpdateStudentServlet?update=" + st.getId() + "'>Update</a>";
            
            stbld.append("<p>").append(st).append(delete).append(update).append("</p>");
        }
        String input = "<a href='InputStudentServlet" + "'>Input</a>";
        stbld.append("<p>").append(input).append("</p>");
        stbld.append("</body>").append("</html>");
        

        String str = stbld.toString();

        return str;
    }

    public boolean InsertStudent(Student st) {

        if (stuDao.InsertStudentJPA(st)) 
            return true;
        return false;
    }
    
    

    public boolean DeleteStudent(int id) {

        if (stuDao.DeleteStudent(id)) 
            return true;
       return false;
    }
    
    public Student GetStudentById(int id2){
      return stuDao.GetStudentById(id2);
        
    }
    
    public boolean UpdateStudent(Student st){
    if(stuDao.UpdateStudentJPA(st)) return true;
    return false;
    }

}
