/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HotelReservationSystem;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnection {

    public static Connection con;

    public static Connection creatConnection() {
        String path = "jdbc:mysql://localhost:3306/hotel_reservation ";
        try {
            con = DriverManager.getConnection(path, "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return con;
    }

    public int searchUser(String user, String pass) {

        int count = 0;
        ResultSet rst;

        try {
            Statement st = DBConnection.creatConnection().createStatement();

            String query = "select * from customer where email ='" + user + "' and password ='" + pass + "'";
            // System.out.println(query);
            rst = st.executeQuery(query);

            if (rst.next()) {
                count = 1;
            } else {
                count = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public ResultSet getUserInformation(String user, String pass) {
        ResultSet rst = null;

        try {
            Statement st = DBConnection.creatConnection().createStatement();

            String query = "select * from customer  where email ='" + user + "' and password ='" + pass + "'";
            //System.out.println(query);
            rst = st.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }

    public ResultSet getReservationData(String guestID) {
        ResultSet rst = null;

        try {
            Statement st = DBConnection.creatConnection().createStatement();

            String query = "select * from room_reservation where guestID = '" + guestID + "' ";
            System.out.println(query);
            rst = st.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }

    public ResultSet getRoomData() {
        ResultSet rst = null;

        try {
            Statement st = DBConnection.creatConnection().createStatement();

            String query = "select * from room_tbl ";
            //System.out.println(query);
            rst = st.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }
    
    public ResultSet getRoomDataFromprice(double price) {
        ResultSet rst = null;

        try {
            Statement st = DBConnection.creatConnection().createStatement();

            String query = "select * from room_tbl where price <= '"+price+"'";
            //System.out.println(query);
            rst = st.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }

    public ResultSet getHallData() {
        ResultSet rst = null;

        try {
            Statement st = DBConnection.creatConnection().createStatement();

            String query = "select * from hall_tbl ";
            System.out.println(query);
            rst = st.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }
    
     public ResultSet getHallDataFromSeatCapacity(int seats) {
        ResultSet rst = null;

        try {
            Statement st = DBConnection.creatConnection().createStatement();

            String query = "select * from hall_tbl where seating_capacity <= '"+seats+"' ";
            System.out.println(query);
            rst = st.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }

    public ResultSet getHallReservationData(String guestID) {
        ResultSet rst = null;

        try {
            Statement st = DBConnection.creatConnection().createStatement();

            String query = "select * from hall_reservation where guestID = '" + guestID + "' ";
            System.out.println(query);
            rst = st.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }
    
    public ResultSet getFeedbackDetails(String guestID) {
        ResultSet rst = null;

        try {
            Statement st = DBConnection.creatConnection().createStatement();

            String query = "SELECT * FROM `feedback` WHERE customerID = '"+guestID+"' ";
            System.out.println(query);
            rst = st.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }

}
