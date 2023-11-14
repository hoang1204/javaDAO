/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoproject;
import java.sql.*;
/**
 *
 * @author macbookairm1
 */
public class ConnectionFactory {
    String driverClassname = "com.mysql.jdbc.Driver"; // ket noi driver
    String connectionUrl = "jdbc:mysql://localhost:3306/test3"; //url ket noi csdl
    String dbUser ="root"; 
    String dbPwd = "";
    private static ConnectionFactory connectionFactory = null;
    // khoi tao + ket noi driver
    private ConnectionFactory(){
        try{
            Class.forName(driverClassname);
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    //connect database
    public Connection getConnection(){
        try{
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
        }catch (SQLException e){
        e.printStackTrace();
        }
        return null;
    }
    
    public static ConnectionFactory getInstance(){
        if (connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
