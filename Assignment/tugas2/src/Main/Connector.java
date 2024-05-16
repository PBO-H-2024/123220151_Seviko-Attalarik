/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/student_db";
    String DBusername = "root";
    String DBpassword = "";
    
    public Connection conn;
    public Statement statement;
    
    public Connector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Connection Success");
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex.getMessage());
        }
    }
}
