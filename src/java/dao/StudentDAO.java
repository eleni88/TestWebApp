/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Student;
import controllers.StudentServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Eleni
 */
public class StudentDAO extends Database {

    String server = "localhost:3306";
    String database = "bootcampdb";
    String username = "root";
    String password = "1234";

    public StudentDAO() {
        super();
    }

    public List<Student> getStudents() {
        Student st;
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM `bootcampdb`.`students`";
        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, query);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        try {
            while (rs.next()) {
                st = new Student(rs.getLong("ID"), rs.getString("SURNAME"),
                        rs.getString("NAME"), rs.getFloat("GRADE"),
                        rs.getString("BIRTHDATE"));
                students.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public boolean InsertStudent(Student st) {
        String query = "INSERT INTO `bootcampdb`.`students`\n" + "(SURNAME,NAME,GRADE,BIRTHDATE)\n"
                + "VALUES(\"" + st.getSurname() + "\",\"" + st.getName() + "\"," + st.getGrade() + "\"," + st.getBirthDate() + "\")";
        int i = Database(server, database, username, password, query, (byte) 1);
        if (i >= 1) 
            return true; else 
            return false;
        }
    
    public boolean InsertStudentJPA(Student st){
        boolean completed = false;
     EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TestWebAppPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(st);
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return completed;
    }

    public boolean DeleteStudent(long id) {
   String query = "delete from `bootcampdb`.`students` where id = " + id +";";
   int i = Database(server, database, username, password, query, (byte) 1);
        if (i >= 1) 
            return true; else 
        return false;
    }
    
    public Student GetStudentById(long id){
    String query = "SELECT * FROM Students where id = " + id +";";
        Student st = null;
        ResultSet rs = Database(server, database, username, password, query);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        try {
            
                st = new Student(rs.getLong("ID"), rs.getString("SURNAME"),
                        rs.getString("NAME"), rs.getFloat("GRADE"),
                        rs.getString("BIRTHDATE"));
                
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return st;
    }
    
    
    
    
//    public boolean UpdateStudent(Student st){
//     
//    String query = "UPDATE `bootcampdb`.`students` \n" +
//                        "SET  SURNAME='"+ st.getSurname() + "',NAME='"+st.getName() 
//                + "',GRADE='"+st.getGrade() +"',BIRTHDATE='"+st.getBirthDate()
//                +"' WHERE ID="+st.getId();
//    
//    int i = Database(server, database, username, password, query, (byte) 1);
//        if (i >= 1) 
//            return true; else 
//    return false;
//    }
    
    public boolean UpdateStudentJPA(Student st) {
        boolean completed = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebApp1PU");
        EntityManager em = emf.createEntityManager();

        Student fromDBStudent = em.find(entities.Student.class, st.getId());
        fromDBStudent.setSurname(st.getSurname());
        fromDBStudent.setGrade(st.getGrade());
        fromDBStudent.setBirthDate(st.getBirthDate());
        em.getTransaction().begin();
        try {
            //transaction
            em.persist(fromDBStudent);
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return completed;

    }

}
