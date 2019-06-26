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

/**
 *
 * @author Eleni
 */
public class StudentDAO extends Database {

    public StudentDAO() {
        super();
    }
    
    
    
     public List<Student> get(){
        Student st;
        List<Student> students = new ArrayList<>();
        
        String server = "localhost:3306";
        String database = "bootcampdb";
        String username = "root";
        String password = "1234";
        String query = "SELECT * FROM `bootcampdb`.`students`";
        
        
        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, query);
        if(rs == null) { System.out.println("Error to the database");} 
        try {
            while(rs.next()) {
                st = new Student(rs.getInt("ID"), rs.getString("SURNAME"), 
                                         rs.getString("NAME"), rs.getFloat("GRADE"), 
                                         rs.getString("BIRTHDATE")); 
                students.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
     }
    
    
    
    
    
}
