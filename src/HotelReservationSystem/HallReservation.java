/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package HotelReservationSystem;

import com.mysql.cj.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;

public class HallReservation extends javax.swing.JFrame {

    /**
     * Creates new form HallReservation
     */
    public HallReservation() {
        initComponents();
        getHallID();
        datepicker_event_date.setDate(Date.from(Instant.now()));
    }

    String guestID;

    public void setGuestID(String userID) {
        this.guestID = userID;
        //System.out.println(guestID);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_req = new javax.swing.JTextArea();
        datepicker_event_date = new com.toedter.calendar.JDateChooser();
        txt_guestCount = new javax.swing.JTextField();
        btn_reserve = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        cmb_hallid = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hall ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Guest Count");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Event Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Special Requests");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        txt_req.setColumns(20);
        txt_req.setRows(5);
        jScrollPane1.setViewportView(txt_req);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 280, 160));
        getContentPane().add(datepicker_event_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 280, -1));

        txt_guestCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_guestCountActionPerformed(evt);
            }
        });
        getContentPane().add(txt_guestCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 280, -1));

        btn_reserve.setBackground(new java.awt.Color(246, 230, 134));
        btn_reserve.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btn_reserve.setText("Reserve");
        btn_reserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reserveActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 540, 160, 40));

        btn_back.setBackground(new java.awt.Color(255, 255, 255));
        btn_back.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        getContentPane().add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, 160, 40));

        getContentPane().add(cmb_hallid, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 280, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hall reservarion.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_guestCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_guestCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_guestCountActionPerformed

    String userId = Loginform.reservationObj.guestID;

    private void btn_reserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reserveActionPerformed

        String hallid, gustCount, event_date, request;

        hallid = cmb_hallid.getSelectedItem().toString();
        gustCount = txt_guestCount.getText();

        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
        event_date = sfd.format(datepicker_event_date.getDate());

        request = txt_req.getText();

        if (gustCount.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Guest count cannot be empty ", "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            try {
            Statement st = HotelReservationSystem.DBConnection.creatConnection().createStatement();
            String query = "INSERT INTO `hall_reservation` ( `hall_id`,`guestID`, `guest_count`, `event_date`, `special_requests`) VALUES ( '" + hallid + "', '" + guestID + "','" + gustCount + "', '" + event_date + "', '" + request + "');";
            int count = st.executeUpdate(query);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Reservation successfully completed.", "Success", JOptionPane.INFORMATION_MESSAGE);

            }

            System.out.println(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong ","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        }
        


    }//GEN-LAST:event_btn_reserveActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.hide();
    }//GEN-LAST:event_btn_backActionPerformed

    public void getHallID() {
        try {
            Statement st = HotelReservationSystem.DBConnection.creatConnection().createStatement();
            ResultSet rst = st.executeQuery("Select * from hall_tbl where status = 'true'");
            while (rst.next()) {
                cmb_hallid.addItem(rst.getString("hallID"));
            }
        } catch (SQLException ex) {

        }

    }

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
            java.util.logging.Logger.getLogger(HallReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HallReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HallReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HallReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HallReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_reserve;
    private javax.swing.JComboBox<String> cmb_hallid;
    private com.toedter.calendar.JDateChooser datepicker_event_date;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_guestCount;
    private javax.swing.JTextArea txt_req;
    // End of variables declaration//GEN-END:variables
}
