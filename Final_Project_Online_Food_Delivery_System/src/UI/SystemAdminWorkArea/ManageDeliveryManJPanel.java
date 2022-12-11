/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SystemAdminWorkArea;

import Model.Customer.Customer;
import Model.DeliveryMan.DeliveryMan;
import Model.DeliveryMan.DeliveryManDirectory;
import Model.System.Ecosystem;
import Model.Employee.Employee;
import Model.Role.DeliveryManrole;
import Model.Role.Role;
import static Model.Role.Role.RoleType.DeliveryMan;
import Model.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puppalanagavaishnavi
 */
public class ManageDeliveryManJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Ecosystem ecosystem;
    private DeliveryMan deliveryMan;
    DeliveryManDirectory deliveryManList;

    /**
     * Creates new form ManageDeliveryManJPanel
     */
    public ManageDeliveryManJPanel(JPanel userProcessContainer, UserAccount account, Ecosystem ecosystem, DeliveryManDirectory deliveryManList) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.ecosystem = ecosystem;
        this.deliveryManList = deliveryManList;
        populateTable();
        populateComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        deliveryManJTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        delComboBox = new javax.swing.JComboBox();
        txtDeliveryManID = new javax.swing.JTextField();
        lblDelId = new javax.swing.JLabel();
        lblDelUsername = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        txtDeliveryManPassword = new javax.swing.JPasswordField();
        txtDeliveryManUserName = new javax.swing.JTextField();
        lblDelPassword = new javax.swing.JLabel();
        btnUpdateDeli = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        lblDelCom = new javax.swing.JLabel();
        txtDeliverManCommunity = new javax.swing.JTextField();
        txtDeliverManName = new javax.swing.JTextField();
        lblDelname = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblDelPhoneNum = new javax.swing.JLabel();
        txtDeliveryManPhoneNum = new javax.swing.JTextField();
        btnBack = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setForeground(new java.awt.Color(204, 204, 255));

        deliveryManJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Name", "Community", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(deliveryManJTable);

        jLabel6.setText("Role:");

        lblDelId.setText("Delivery Man ID:");

        lblDelUsername.setText("Username:");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        lblDelPassword.setText("Password:");

        btnUpdateDeli.setText("Update");
        btnUpdateDeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDeliActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblDelCom.setText("Community:");

        lblDelname.setText("Name:");

        lblTitle.setBackground(new java.awt.Color(0, 153, 153));
        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage DeliveryMan ");

        lblDelPhoneNum.setText("Phone Number");

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 0, 0));
        btnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBack.setText("<< Back");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDelUsername)
                            .addComponent(lblDelId)
                            .addComponent(jLabel6)
                            .addComponent(lblDelCom)
                            .addComponent(lblDelPassword)
                            .addComponent(lblDelname)
                            .addComponent(lblDelPhoneNum))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeliveryManID, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeliveryManUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeliveryManPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeliverManCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeliverManName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeliveryManPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnCreate)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateDeli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveBtn)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(81, 81, 81)
                                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(120, 120, 120))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(delComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDelId)
                    .addComponent(txtDeliveryManID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDelname)
                    .addComponent(txtDeliverManName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDelCom)
                    .addComponent(txtDeliverManCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDelUsername)
                    .addComponent(txtDeliveryManUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDelPhoneNum)
                    .addComponent(txtDeliveryManPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDelPassword)
                    .addComponent(txtDeliveryManPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdateDeli)
                    .addComponent(btnDelete)
                    .addComponent(saveBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = deliveryManJTable.getSelectedRow();
        if (selectedRow >= 0) {
            DeliveryMan d = (DeliveryMan) deliveryManJTable.getValueAt(selectedRow, 0);
            ecosystem.getDeliveryManDirectory().deleteDeliveryMan(d);
            JOptionPane.showMessageDialog(null, "Delivery man removed Successfully.");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select any row.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:

        for (DeliveryMan d : deliveryManList.getDeliveryManList()) {
            if (deliveryMan.getDeliveryManName().equals(d.getDeliveryManName())) {
                d.setDeliveryManName(txtDeliverManName.getText());
                d.setDeliveryManId(Integer.parseInt(txtDeliveryManID.getText()));
              // d.setDeliveryManNumber(Integer.parseInt(txtDeliveryManPhoneNum.getText()));
                d.setCommunity(txtDeliverManCommunity.getText());

            }
        }

        JOptionPane.showMessageDialog(null, "Deliveryman Updated Successfully.");
        populateTable();
        txtDeliveryManID.setText("");
        txtDeliverManName.setText("");
        txtDeliverManCommunity.setText("");
      //  txtDeliveryManPhoneNum.setText("");
        txtDeliveryManPassword.setText("");
        txtDeliveryManUserName.setText("");
    }//GEN-LAST:event_saveBtnActionPerformed

    private void btnUpdateDeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDeliActionPerformed
        // TODO add your handling code here:
        int selectedRow = deliveryManJTable.getSelectedRow();

        if (selectedRow >= 0) {
            DeliveryMan d = (DeliveryMan) deliveryManJTable.getValueAt(selectedRow, 1);
            deliveryMan = d;
            txtDeliveryManID.setText(String.valueOf(d.getDeliveryManId()));
            txtDeliverManName.setText(d.getDeliveryManName());
            txtDeliverManCommunity.setText(d.getCommunity());
          //  txtDeliveryManPhoneNum.setText(String.valueOf(d.getDeliveryManNumber()));
            txtDeliveryManUserName.setText(d.getUserAccount().getUsername());
            txtDeliveryManPassword.setText(d.getUserAccount().getPassword());

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        txtDeliveryManID.getText();
        txtDeliverManName.getText();
        txtDeliverManCommunity.getText();
      //   txtDeliveryManPhoneNum.getText();
        txtDeliveryManUserName.getText();
        populateTable();
    }//GEN-LAST:event_btnUpdateDeliActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:

        String username = txtDeliveryManUserName.getText();
        String password = String.valueOf(txtDeliveryManPassword.getPassword());
        String new_role = "DeliveryMan";
        String name = txtDeliverManName.getText();
        //int DelId = Integer.parseInt(txtDeliveryManID.getText());
        //int phonenumber = Integer.parseInt(txtDeliveryManPhoneNum.getText());
        String community = txtDeliverManCommunity.getText();

        // Employee employee = ecosystem.getEmployeeList().createEmployee(name);
        // getEmployeeDirectory().createEmployee(name);
        
        
        if(username.length() <= 0 || String.valueOf(txtDeliveryManPassword.getPassword()).length() <= 0 ||
        txtDeliverManName.getText().length() <= 0 || txtDeliverManCommunity.getText().length() <= 0 ) 
        {
            JOptionPane.showMessageDialog(null, " One or more fields are empty.");            
        }
        
        UserAccount account = ecosystem.getUserAccountDir().AddUserAccount();
        // getUserAccountDirectory().createUserAccount(username, password, employee, new DeliverManRole());
        account.setUsername(username);
        account.setPassword(password);
        account.setRole("DeliveryMan");

        DeliveryMan d = deliveryManList.addDeliveryManWithUserAcct(account);
        d.setCommunity(community);
        d.setDeliveryManName(name);

        txtDeliveryManID.setText("");
        txtDeliverManName.setText("");
        txtDeliverManCommunity.setText("");
     //   txtDeliveryManPhoneNum.setText("");
        txtDeliveryManUserName.setText("");
        txtDeliveryManPassword.setText("");

        populateTable();
        //JOptionPane.showMessageDialog(this, "Delivery Man has been Created");

        txtDeliveryManID.setText("");
        txtDeliverManName.setText("");
        txtDeliverManCommunity.setText("");
        txtDeliveryManUserName.setText("");
        txtDeliveryManPassword.setText("");
        JOptionPane.showMessageDialog(this, "Delivery Man has been Created");

    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        //        CustomerWorkArea cusWorkArea = new CustomerWorkArea(cusDetails, panelBackWorkArea, resList);
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        // sysAdminwjp.populateTree();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        // panelBackWorkArea.remove(this);
        //((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
        btnBack.setForeground(Color.red);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
        btnBack.setForeground(Color.blue);
    }//GEN-LAST:event_btnBackMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdateDeli;
    private javax.swing.JComboBox delComboBox;
    private javax.swing.JTable deliveryManJTable;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDelCom;
    private javax.swing.JLabel lblDelId;
    private javax.swing.JLabel lblDelPassword;
    private javax.swing.JLabel lblDelPhoneNum;
    private javax.swing.JLabel lblDelUsername;
    private javax.swing.JLabel lblDelname;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField txtDeliverManCommunity;
    private javax.swing.JTextField txtDeliverManName;
    private javax.swing.JTextField txtDeliveryManID;
    private javax.swing.JPasswordField txtDeliveryManPassword;
    private javax.swing.JTextField txtDeliveryManPhoneNum;
    private javax.swing.JTextField txtDeliveryManUserName;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) deliveryManJTable.getModel();

        model.setRowCount(0);

        for (DeliveryMan deliveryMan : deliveryManList.getDeliveryManList()) {
            Object[] row = new Object[model.getColumnCount()];
            row[0] = deliveryMan.getDeliveryManId();
            row[1] = deliveryMan;
            row[2] = deliveryMan.getCommunity();
            row[3] = deliveryMan.getUserAccount().getUsername();

            model.addRow(row);
        }
    }

    private void populateComboBox() {
        delComboBox.removeAllItems();
        delComboBox.addItem(Role.RoleType.DeliveryMan.toString());
    }
}
