/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to create database entries
 * @author Team Charlie
 */
public class Insert {
 
    /**
     * Connect to the test.db database
     * 
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String schoolurl = "jdbc:sqlite:H:/Software Engineering/Project/imp4/Implem3/Implem2 with database/sqlite-tools-win32-x86-3200100/pd.db";
        String homeurl = "jdbc:sqlite:C:/Users/jtayl/Documents/Documents/CSU/Software Engineering/Project/Implem3/Implem2 with database/sqlite-tools-win32-x86-3200100/pd.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(schoolurl);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Insert a new row into the user table
     *
     * @param userName String of user's name
     * @param userPass String of user's password
     * @param userAddress String of user's address
     * @param userBalance Float amount of user's balance
     * 
     */
    public void insertUser(String userName, String userPass, String userAddress, float userBalance) {
        boolean uniq = true;
        String sq2 = "SELECT userName, userPass, userAddress, userBalance " + "FROM user WHERE userName = ?";
        
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sq2)) {
            pstmt.setString(1, userName);
           
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                uniq = false;
            } else {
                String sql = "INSERT INTO user(userName,userPass,userAddress, userBalance) VALUES(?,?,?,?)";
 
                try (Connection conn2 = this.connect();
                        PreparedStatement pstmt2 = conn2.prepareStatement(sql)) {
                    pstmt2.setString(1, userName);
                    pstmt2.setString(2, userPass);
                    pstmt2.setString(3, userAddress);
                    pstmt2.setFloat(4, userBalance);
                    pstmt2.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
                    System.out.println(e.getMessage());
        }
    }
    
    /**
     * Insert a new row into the order table
     * @param orderId Int id of the order
     * @param status String status of the order
     * @param cost Float cost of the order
     * @param uuid String uuid of the order used for unique storage in the database
     * 
     */
    public void insertOrder(int orderId, String status, float cost, String uuid) {
        boolean uniq = true;
        String sq2 = "SELECT orderID, status, cost, uuid " + "FROM orders WHERE uuid = ?";
        
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sq2)) {
            pstmt.setString(1, uuid);
           
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                uniq = false;
                //System.out.println(rs.getInt("orderId"));
                //System.out.println(orderId);
                //System.out.println("duplicate order");
            } else {
                String sql = "INSERT INTO orders(orderID,status,cost,uuid) VALUES(?,?,?,?)";
 
                try (Connection conn2 = this.connect();
                        PreparedStatement pstmt2 = conn2.prepareStatement(sql)) {
                    pstmt2.setInt(1, orderId);
                    pstmt2.setString(2, status);           
                    pstmt2.setFloat(3, cost);
                    pstmt2.setString(4, uuid);
                    pstmt2.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    /**
     * Insert a new row into the transaction table
     * @param transId int id number for the transaction
     * @param userName String name of the user who made the purchase
     * @param orderId int id number of the referenced order
     * @param uuid String uuid of the transaction to be stored in the database
     * 
     */
    public void insertTransaction(int transId, String userName, int orderId, String uuid) {
        boolean uniq = true;
        String sq2 = "SELECT transID, userName, orderID " + "FROM transactions WHERE uuid = ?";
        
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sq2)) {
            pstmt.setString(1, uuid);
           
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                uniq = false;
                //System.out.println("duplicate transaction");
            } else {
                String sql = "INSERT INTO transactions(transID,userName,orderID,uuid) VALUES(?,?,?,?)";

                try (Connection conn2 = this.connect();
                    PreparedStatement pstmt2 = conn2.prepareStatement(sql)) {
                    pstmt2.setInt(1, transId);
                    pstmt2.setString(2, userName);           
                    pstmt2.setInt(3, orderId);
                    pstmt2.setString(4, uuid);
                    pstmt2.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
//        
        
        
    }
    /**
     * @param args the command line arguments
     */
    
 
}
