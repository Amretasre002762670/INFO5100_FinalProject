/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.CustomerWorkArea;

import Model.Customer.Customer;
import Model.Email.SendEmail;
import Model.Menu.Menu;
import Model.Order.Order;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.WorkQueue;
import Model.WorkQueue.WorkRequest;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.*;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author amretasrerengarajan
 */
public class CheckoutPanel extends javax.swing.JPanel {

    /**
     * Creates new form CheckoutPanel
     */
    JPanel panelBackWorkArea;
    Order order;
    WorkQueue workQueue;
    
    private static final String emailMsgTxt = "Your order is successfully placed";
    private static final String emailSubjectTxt = "Order placed";
    private static final String emailFromAddress = "amretasre6@gmail.com";

    // Add List of Email address to who email needs to be sent to
    private static final String[] emailList = {"amretasrert@gmail.com"};

    public CheckoutPanel(JPanel panelBackWorkArea, Order order, WorkQueue workQueue) {
        initComponents();
        this.panelBackWorkArea = panelBackWorkArea;
        this.order = order;
        this.workQueue = workQueue;

        lblWarCVVEmpty.setVisible(false);
        lblWarCvv.setVisible(false);
        lblWarCardNo.setVisible(false);
        lblWarCardNumEmpty.setVisible(false);
        lblWarDate.setVisible(false);
        lblWarName.setVisible(false);
        lblWarNameEmpty.setVisible(false);
        lblWarValidTillEmpty.setVisible(false);

    }

    public void populateWorkQueue() {

        WorkRequest workRequest = new WorkRequest();
        workRequest.setOrderRequest(order);
        workRequest.setMessage("Order Placed");
        workRequest.setCusAcct(order.getCusDetails().getUserAccount());
        workRequest.setRequestDate(order.getDatePlaced());
        workRequest.setRequestTime(order.getOrderCreatedAt());
        workRequest.setStatus("negative");
        workRequest.setResAdmin(order.getResDetails().getRestaurantAdmin().getAccountDetails());

        workQueue.addWorkRequest(workRequest);
    }

    public void sendOrderToDB() {
        String queryOrderTable = "INSERT INTO Order_Directory (datePlaced, orderCratedAt, customer_id, restaurant_id, order_id_generated) VALUES (?, ?, ?, ?, ?)";
        String queryMenuOrderTable = "INSERT INTO Menu_Order_Relation (food_id, order_id_generated) VALUES (?, ?);";
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Delivery_system",
                    "root", "amre1999");

            PreparedStatement st_OrderTable = (PreparedStatement) connection
                    .prepareStatement(queryOrderTable);

            st_OrderTable.setString(1, order.getDatePlaced());
            st_OrderTable.setString(2, order.getOrderCreatedAt());
            st_OrderTable.setInt(3, order.getCusDetails().getCustId());
            st_OrderTable.setInt(4, order.getResDetails().getRestaurantId());
            st_OrderTable.setLong(5, order.getOrder_id());

            st_OrderTable.execute();

//            PreparedStatement st_getOrderId = (PreparedStatement) connection
//                    .prepareStatement(queryGetOrderId);
//            st_getOrderId.setLong(1, order.getOrder_id());
//            ResultSet rs_generatedOrderId = st_getOrderId.executeQuery();
//            while (rs_generatedOrderId.next()) {
            PreparedStatement st_MenuOrderTable = (PreparedStatement) connection
                    .prepareStatement(queryMenuOrderTable);

            for (Menu menuItem : order.getMenu()) {

                st_MenuOrderTable.setInt(1, menuItem.getFood_id());
                st_MenuOrderTable.setInt(2, order.getOrder_id());
                st_MenuOrderTable.execute();
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public void constructEmail() {
            SendEmail sendMail = new SendEmail();
            String[] emailList = {"amretasrert@gmail.com", order.getCusDetails().getCus_emailid()};
            String emailMsgTxt = "Your order with " + order.getResDetails().getRestaurantName() + " is placed successfully";
            String emailSubjectTxt = "Order: " + order.getOrder_id() + " placed";
            try {
                sendMail.postMail(emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
            } catch (MessagingException ex) {
//                Logger.getLogger(CheckoutPanel.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeading = new javax.swing.JLabel();
        lblNameOnCard = new javax.swing.JLabel();
        lblValidTill = new javax.swing.JLabel();
        lblCvv = new javax.swing.JLabel();
        lblCardNum = new javax.swing.JLabel();
        txtNameOnCard = new javax.swing.JTextField();
        txtValidTill = new javax.swing.JTextField();
        txtCardNum = new javax.swing.JTextField();
        btnBack = new javax.swing.JLabel();
        btnProceed = new javax.swing.JLabel();
        lblWarDate = new javax.swing.JLabel();
        lblWarCvv = new javax.swing.JLabel();
        lblWarCardNo = new javax.swing.JLabel();
        lblWarName = new javax.swing.JLabel();
        lblWarNameEmpty = new javax.swing.JLabel();
        lblWarValidTillEmpty = new javax.swing.JLabel();
        lblWarCVVEmpty = new javax.swing.JLabel();
        lblWarCardNumEmpty = new javax.swing.JLabel();
        txtCvv = new javax.swing.JPasswordField();
        lblMainMenu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(675, 675));
        setMinimumSize(new java.awt.Dimension(675, 675));
        setPreferredSize(new java.awt.Dimension(675, 675));

        lblHeading.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Checkout");

        lblNameOnCard.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblNameOnCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameOnCard.setText("Name on Card:");

        lblValidTill.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblValidTill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValidTill.setText("Valid Thru:");

        lblCvv.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblCvv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCvv.setText("CVV:");

        lblCardNum.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblCardNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCardNum.setText("Card Number:");

        txtNameOnCard.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNameOnCard.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameOnCardFocusLost(evt);
            }
        });

        txtValidTill.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValidTillFocusLost(evt);
            }
        });

        txtCardNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCardNumFocusLost(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 0, 0));
        btnBack.setText("<< Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });

        btnProceed.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnProceed.setForeground(new java.awt.Color(0, 153, 51));
        btnProceed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProceed.setText("Proceed");
        btnProceed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProceed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProceedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProceedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProceedMouseExited(evt);
            }
        });

        lblWarDate.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblWarDate.setForeground(new java.awt.Color(255, 51, 0));
        lblWarDate.setText("Invalid Date Format");

        lblWarCvv.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblWarCvv.setForeground(new java.awt.Color(255, 51, 0));
        lblWarCvv.setText("Invalid");

        lblWarCardNo.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblWarCardNo.setForeground(new java.awt.Color(255, 51, 0));
        lblWarCardNo.setText("Invalid Card Number");

        lblWarName.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblWarName.setForeground(new java.awt.Color(255, 51, 0));
        lblWarName.setText("Invalid");

        lblWarNameEmpty.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblWarNameEmpty.setForeground(new java.awt.Color(255, 51, 0));
        lblWarNameEmpty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarNameEmpty.setText("Cannot Be Empty");

        lblWarValidTillEmpty.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblWarValidTillEmpty.setForeground(new java.awt.Color(255, 51, 0));
        lblWarValidTillEmpty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarValidTillEmpty.setText("Cannot Be Empty");

        lblWarCVVEmpty.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblWarCVVEmpty.setForeground(new java.awt.Color(255, 51, 0));
        lblWarCVVEmpty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarCVVEmpty.setText("Cannot Be Empty");

        lblWarCardNumEmpty.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblWarCardNumEmpty.setForeground(new java.awt.Color(255, 51, 0));
        lblWarCardNumEmpty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarCardNumEmpty.setText("Cannot Be Empty");

        lblMainMenu.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblMainMenu.setForeground(new java.awt.Color(255, 0, 0));
        lblMainMenu.setText("Main Menu");
        lblMainMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMainMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMainMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMainMenuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMainMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNameOnCard)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNameOnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblWarName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblCvv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblCardNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblValidTill, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtValidTill, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblWarValidTillEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtCvv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                                    .addComponent(txtCardNum, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addComponent(lblWarCVVEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblWarCardNumEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblWarDate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblWarCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblWarCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblWarNameEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblWarCVVEmpty, lblWarCardNumEmpty, lblWarNameEmpty, lblWarValidTillEmpty});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblMainMenu))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNameOnCard)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNameOnCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblWarName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarNameEmpty)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValidTill)
                    .addComponent(txtValidTill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWarDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarValidTillEmpty)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCvv)
                    .addComponent(lblWarCvv)
                    .addComponent(txtCvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarCVVEmpty)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCardNum)
                    .addComponent(txtCardNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWarCardNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarCardNumEmpty)
                .addGap(98, 98, 98)
                .addComponent(btnProceed)
                .addGap(89, 89, 89))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        panelBackWorkArea.remove(this);
        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
//        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).show(panelBackWorkArea, "Customer work area");
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
        btnBack.setForeground(Color.blue);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
        btnBack.setForeground(Color.red);
    }//GEN-LAST:event_btnBackMouseExited

    private void txtNameOnCardFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameOnCardFocusLost
        // TODO add your handling code here:
        String name = txtNameOnCard.getText();
        if (!name.matches("^[a-zA-Z]*$")) {
            lblWarName.setVisible(true);
            lblWarNameEmpty.setVisible(false);
        } else if (name.equals("")) {
            lblWarNameEmpty.setVisible(true);
            lblWarName.setVisible(false);
        }
    }//GEN-LAST:event_txtNameOnCardFocusLost

    private void txtValidTillFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValidTillFocusLost
        // TODO add your handling code here:
        String validThru = txtValidTill.getText();
        if (!validThru.matches("(?:0[1-9]|1[0-2])\\/[0-9]{2}")) {
            lblWarDate.setVisible(true);
            lblWarValidTillEmpty.setVisible(false);
        } else if (validThru.equals("")) {
            lblWarValidTillEmpty.setVisible(true);
            lblWarDate.setVisible(false);
        }
    }//GEN-LAST:event_txtValidTillFocusLost

    private void txtCardNumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCardNumFocusLost
        // TODO add your handling code here:
        String cardNum = txtCardNum.getText();
        if (!cardNum.matches("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|\n"
                + "		(?<mastercard>5[1-5][0-9]{14})|\n"
                + "		(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|\n"
                + "		(?<amex>3[47][0-9]{13})|\n"
                + "		(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|\n"
                + "		(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$")) {
            lblWarCardNo.setVisible(true);
            lblWarCardNumEmpty.setVisible(false);
        } else if (cardNum.equals("")) {
            lblWarCardNo.setVisible(false);
            lblWarCardNumEmpty.setVisible(true);
        }
    }//GEN-LAST:event_txtCardNumFocusLost

    private void btnProceedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProceedMouseClicked
        // TODO add your handling code here:
        if (txtCardNum.getText().equals("") || txtCvv.getText().equals("") || txtNameOnCard.getText().equals("") || txtValidTill.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All fields are Mandatory");
            return;
        } else {

            sendOrderToDB();

            populateWorkQueue();
            
            constructEmail();

            JOptionPane.showMessageDialog(this,
                    "Sucessfully placed order");
        }

        txtCardNum.setText("");
        txtCvv.setText("");
        txtNameOnCard.setText("");
        txtValidTill.setText("");

    }//GEN-LAST:event_btnProceedMouseClicked

    private void btnProceedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProceedMouseEntered
        // TODO add your handling code here:
        btnProceed.setForeground(Color.blue);

    }//GEN-LAST:event_btnProceedMouseEntered

    private void btnProceedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProceedMouseExited
        // TODO add your handling code here:
        btnProceed.setForeground(new Color(0, 153, 51));
    }//GEN-LAST:event_btnProceedMouseExited

    private void lblMainMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMainMenuMouseEntered
        // TODO add your handling code here:
        lblMainMenu.setForeground(Color.blue);
    }//GEN-LAST:event_lblMainMenuMouseEntered

    private void lblMainMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMainMenuMouseExited
        // TODO add your handling code here:
        lblMainMenu.setForeground(Color.red);
    }//GEN-LAST:event_lblMainMenuMouseExited

    private void lblMainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMainMenuMouseClicked
        // TODO add your handling code here:
//        CurrentOrderPanel currentOrderPanel = new CurrentOrderPanel(panelBackWorkArea, workQueue, order.getCusDetails());
//        panelBackWorkArea.add("CurrentOrderPanel", currentOrderPanel);
//        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
        panelBackWorkArea.remove(this);
        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).show(panelBackWorkArea, "Customer work area");
    }//GEN-LAST:event_lblMainMenuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnProceed;
    private javax.swing.JLabel lblCardNum;
    private javax.swing.JLabel lblCvv;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblMainMenu;
    private javax.swing.JLabel lblNameOnCard;
    private javax.swing.JLabel lblValidTill;
    private javax.swing.JLabel lblWarCVVEmpty;
    private javax.swing.JLabel lblWarCardNo;
    private javax.swing.JLabel lblWarCardNumEmpty;
    private javax.swing.JLabel lblWarCvv;
    private javax.swing.JLabel lblWarDate;
    private javax.swing.JLabel lblWarName;
    private javax.swing.JLabel lblWarNameEmpty;
    private javax.swing.JLabel lblWarValidTillEmpty;
    private javax.swing.JTextField txtCardNum;
    private javax.swing.JPasswordField txtCvv;
    private javax.swing.JTextField txtNameOnCard;
    private javax.swing.JTextField txtValidTill;
    // End of variables declaration//GEN-END:variables
}
