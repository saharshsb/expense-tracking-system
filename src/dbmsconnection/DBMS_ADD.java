package dbmsconnection;


import ets.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pranav krishna
 */
public class DBMS_ADD {
    public static void dbms_add_transact(String Username,String type,String Category,String Name,String Amount_String,String Date_String){
        try {        
            LocalDate date = LocalDate.parse(Date_String);
            int Amount=Integer.parseInt(Amount_String);
            Class.forName("com.mysql.jdbc.Driver");  
           Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/expense_tracking","root","Pranav@3404");
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery("Select * from transact");
           rs.next();
           int transaction=rs.getInt("TRANSACTION_ID");
           int j=stmt.executeUpdate("Update transact set transaction_id=transaction_id+1");
           int i=stmt.executeUpdate("Insert into transactions values("+transaction+",'"+Username+"','"+type.toUpperCase()+"','"+Category+"','"+Name+"',"+Amount+",'"+date+"')");
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
