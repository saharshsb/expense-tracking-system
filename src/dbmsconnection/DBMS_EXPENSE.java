/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbmsconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Pranav krishna
 */
public class DBMS_EXPENSE {
    public static int dbms_expense_cal(String Username){
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");  
           Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/ets","root","tiger");
           Statement stmt=con.createStatement();
           LocalDate currentDate= LocalDate.now();
           int month = currentDate.getMonthValue();
           System.out.println(month);
           ResultSet rs= stmt.executeQuery("select sum(Expense_amount) from expense where Username='"+Username+"' and extract(month from Time_stamp)=extract(month from CURDATE())");
           while(rs.next()){
               System.out.println("Entered");
               return rs.getInt("SUM(EXPENSE_AMOUNT)");
           }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Connection not established"+e);
                    
        }
        return 0;
    }
    
    public static int dbms_income_cal(String Username){
        
        try{
           Class.forName("com.mysql.jdbc.Driver");  
           Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/expense_tracking","root","Pranav@3404");
           Statement stmt=con.createStatement();
           LocalDate currentDate= LocalDate.now();
           int month = currentDate.getMonthValue();
           System.out.println(month);
           ResultSet rs= stmt.executeQuery("select sum(income_amount) from income where Username='"+Username+"' and extract(month from Time_stamp)=extract(month from CURDATE())");
           while(rs.next()){
               System.out.println("Entered");
               return rs.getInt("SUM(INCOME_AMOUNT)");
           }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Connection not established"+e);
                    
        }
        return 0;
    }
}
