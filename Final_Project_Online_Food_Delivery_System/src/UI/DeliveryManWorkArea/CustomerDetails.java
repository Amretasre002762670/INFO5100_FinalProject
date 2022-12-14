/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.DeliveryManWorkArea;

import Model.Customer.Customer;
import java.awt.Color;

/**
 *
 * @author SRADDHA
 */
public class CustomerDetails extends javax.swing.JPanel {
  javax.swing.JPanel panelBackWorkArea;
  Customer cusDetails;
    /**
     * Creates new form CustomerDetails
     */
    public CustomerDetails(javax.swing.JPanel panelBackWorkArea, Customer cusDetails) {
        initComponents();
        this.panelBackWorkArea = panelBackWorkArea;
        this.cusDetails = cusDetails;
        
        txtdelcusname.setEditable(false);
        txtdelcusstrtaddress.setEditable(false);
        txtdelcustcity.setEditable(false);
        txtdelcustemail.setEditable(false);
        txtdelcustnumber.setEditable(false);
        txtdelcustpincode.setEditable(false);
        
        txtdelcusname.setText(cusDetails.getCustName());
        txtdelcusstrtaddress.setText(cusDetails.getHome_streetAddress());
        txtdelcustcity.setText(cusDetails.getHome_City());
        txtdelcustemail.setText(cusDetails.getCus_emailid());
        txtdelcustnumber.setText(String.valueOf(cusDetails.getCustPhoneNumber()));
        txtdelcustpincode.setText(String.valueOf(cusDetails.getHome_pincode()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleCustomerdet = new javax.swing.JLabel();
        lbldelcustname = new javax.swing.JLabel();
        lbldelcuststrtaddress = new javax.swing.JLabel();
        lbldelcustcity = new javax.swing.JLabel();
        lbldelcustpincode = new javax.swing.JLabel();
        lbldelcustnumber = new javax.swing.JLabel();
        txtdelcusname = new javax.swing.JTextField();
        txtdelcusstrtaddress = new javax.swing.JTextField();
        txtdelcustcity = new javax.swing.JTextField();
        txtdelcustpincode = new javax.swing.JTextField();
        txtdelcustnumber = new javax.swing.JTextField();
        lbldelcustemail = new javax.swing.JLabel();
        txtdelcustemail = new javax.swing.JTextField();
        lbldelcusback = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        titleCustomerdet.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        titleCustomerdet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleCustomerdet.setText("CUSTOMER DETAILS");

        lbldelcustname.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbldelcustname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldelcustname.setText("Name");

        lbldelcuststrtaddress.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbldelcuststrtaddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldelcuststrtaddress.setText("Street Address");

        lbldelcustcity.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbldelcustcity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldelcustcity.setText("City");

        lbldelcustpincode.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbldelcustpincode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldelcustpincode.setText("Pincode");

        lbldelcustnumber.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbldelcustnumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldelcustnumber.setText("Contact number");

        lbldelcustemail.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbldelcustemail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldelcustemail.setText("Email");

        lbldelcusback.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbldelcusback.setForeground(new java.awt.Color(255, 51, 51));
        lbldelcusback.setText("<<Back");
        lbldelcusback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbldelcusback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldelcusbackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbldelcusbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbldelcusbackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleCustomerdet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbldelcuststrtaddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldelcustemail)
                            .addComponent(lbldelcustnumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldelcustcity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldelcustpincode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldelcustname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdelcustnumber)
                            .addComponent(txtdelcustemail, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtdelcusname)
                            .addComponent(txtdelcusstrtaddress)
                            .addComponent(txtdelcustcity)
                            .addComponent(txtdelcustpincode)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lbldelcusback)))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbldelcustemail, lbldelcustnumber});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleCustomerdet)
                .addGap(31, 31, 31)
                .addComponent(lbldelcusback)
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldelcustname)
                    .addComponent(txtdelcusname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldelcuststrtaddress)
                    .addComponent(txtdelcusstrtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldelcustcity)
                    .addComponent(txtdelcustcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldelcustpincode)
                    .addComponent(txtdelcustpincode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldelcustnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdelcustnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldelcustemail)
                    .addComponent(txtdelcustemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbldelcusbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldelcusbackMouseClicked
        // TODO add your handling code here:
         panelBackWorkArea.remove(this);
        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).show(panelBackWorkArea, "Currentorder");
    }//GEN-LAST:event_lbldelcusbackMouseClicked

    private void lbldelcusbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldelcusbackMouseEntered
        lbldelcusback.setForeground(Color.blue);
        // TODO add your handling code here:
    }//GEN-LAST:event_lbldelcusbackMouseEntered

    private void lbldelcusbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldelcusbackMouseExited
        lbldelcusback.setForeground(Color.red);
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lbldelcusbackMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbldelcusback;
    private javax.swing.JLabel lbldelcustcity;
    private javax.swing.JLabel lbldelcustemail;
    private javax.swing.JLabel lbldelcustname;
    private javax.swing.JLabel lbldelcustnumber;
    private javax.swing.JLabel lbldelcustpincode;
    private javax.swing.JLabel lbldelcuststrtaddress;
    private javax.swing.JLabel titleCustomerdet;
    private javax.swing.JTextField txtdelcusname;
    private javax.swing.JTextField txtdelcusstrtaddress;
    private javax.swing.JTextField txtdelcustcity;
    private javax.swing.JTextField txtdelcustemail;
    private javax.swing.JTextField txtdelcustnumber;
    private javax.swing.JTextField txtdelcustpincode;
    // End of variables declaration//GEN-END:variables
}
