/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package HotelReservationSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class HallReservationDetails extends javax.swing.JFrame {

    /**
     * Creates new form HallRdisplay
     */
    public HallReservationDetails() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_guestCount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        datepicker_eventdate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hallReservation = new javax.swing.JTable();
        btn_delete = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_req = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_guestCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 210, -1));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Guest Count");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 130, 22));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Event Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
        getContentPane().add(datepicker_eventdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 210, -1));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Special Requests");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        btn_update.setBackground(new java.awt.Color(246, 230, 134));
        btn_update.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 590, 160, 40));

        tbl_hallReservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation ID", "Hall ID", "Guest Count", "Event Date", "Special Request"
            }
        ));
        tbl_hallReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hallReservationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hallReservation);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 650, 360));

        btn_delete.setBackground(new java.awt.Color(246, 230, 134));
        btn_delete.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 590, 160, 40));

        btn_back.setBackground(new java.awt.Color(255, 255, 255));
        btn_back.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        getContentPane().add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 590, 160, 40));

        txt_req.setColumns(20);
        txt_req.setRows(5);
        jScrollPane2.setViewportView(txt_req);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 210, 260));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hall reservation details.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed

        try {
            String guestCount, eventDate, requests;
            int no_adult, no_child;

            guestCount = txt_guestCount.getText();
            requests = txt_req.getText();

            SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
            eventDate = sfd.format(datepicker_eventdate.getDate());

            try {
                Statement st = HotelReservationSystem.DBConnection.creatConnection().createStatement();
                String query = "UPDATE `hall_reservation` SET `guest_count` = '" + guestCount + "', `event_date` = '" + eventDate + "', `special_requests` = '" + requests + "' WHERE `hall_reservation`.`reservation_id` = '" + reservID + "';";
                int count = st.executeUpdate(query);
                System.out.println(query);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Reservation update successfull.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    setData();

                }

                tbl_hallReservation.clearSelection();

            } catch (Exception e) {
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some thing went wrong","Error",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_updateActionPerformed

    private void tbl_hallReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hallReservationMouseClicked
        int selectedRow = tbl_hallReservation.getSelectedRow();
        TableModel model = tbl_hallReservation.getModel();

        txt_guestCount.setText(model.getValueAt(selectedRow, 2).toString());
        txt_req.setText(model.getValueAt(selectedRow, 4).toString());
        String rsveID = model.getValueAt(selectedRow, 0).toString();
        setReservationId(rsveID);

        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
        String eventDate = (String) model.getValueAt(selectedRow, 3);

        try {
            Date eventDte = sfd.parse(eventDate);
            datepicker_eventdate.setDate(eventDte);

        } catch (ParseException e) {
            // Handle the parsing exception, e.g., by displaying an error message.
            e.printStackTrace();
        }


    }//GEN-LAST:event_tbl_hallReservationMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            Statement st = HotelReservationSystem.DBConnection.creatConnection().createStatement();
            String query = "DELETE FROM `hall_reservation` WHERE `hall_reservation`.`reservation_id` = '" + reservID + "';";
            int count = st.executeUpdate(query);
            //System.out.println(query);
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Reservation delete successfull.", "Success", JOptionPane.INFORMATION_MESSAGE);
                setData();
                clearFeilds();

            }

            tbl_hallReservation.clearSelection();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed
    public void clearFeilds() {
        txt_guestCount.setText(null);
        txt_req.setText(null);
        datepicker_eventdate.setDate(null);
    }
    String userId;
    String reservID;

    public void setReservationId(String resvId) {
        this.reservID = resvId;
    }

    public void setUserID(String id) {
        this.userId = id;

    }

    public void setData() {
        DBConnection obj = new DBConnection();
        ResultSet rst = obj.getHallReservationData(userId);
        DefaultTableModel s = (DefaultTableModel) tbl_hallReservation.getModel();
        s.setNumRows(0);

        try {
            while (rst.next()) {

                String reservationId = rst.getString("reservation_id");
                String hallId = rst.getString("hall_id");
                String guestCount = rst.getString("guest_count");
                String eventDate = rst.getString("event_date");
                String specialRequest = rst.getString("special_requests");

                String data[] = {reservationId, hallId, guestCount, eventDate, specialRequest};

                s.addRow(data);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Reservationdetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HallReservationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HallReservationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HallReservationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HallReservationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HallReservationDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private com.toedter.calendar.JDateChooser datepicker_eventdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_hallReservation;
    private javax.swing.JTextField txt_guestCount;
    private javax.swing.JTextArea txt_req;
    // End of variables declaration//GEN-END:variables
}
