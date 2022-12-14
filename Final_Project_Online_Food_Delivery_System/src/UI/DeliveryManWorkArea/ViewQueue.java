/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.DeliveryManWorkArea;

import Model.DeliveryMan.DeliveryMan;
import Model.WorkQueue.WorkQueue;
import Model.WorkQueue.WorkRequest;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SRADDHA
 */
public class ViewQueue extends javax.swing.JPanel {

    /**
     * Creates new form ViewQueue
     */
    JPanel panelBackWorkArea;
    WorkQueue workQueue;
    DeliveryMan delManDetails;
    int flag;

    public ViewQueue(JPanel panelBackWorkArea, WorkQueue workQueue, DeliveryMan delManDetails, int flag) {
        initComponents();

        this.panelBackWorkArea = panelBackWorkArea;
        this.workQueue = workQueue;
        this.delManDetails = delManDetails;
        this.flag = 0;

        populateTable();
//        for(WorkRequest workRequest: this.workQueue.getWorkRequestList()) {
//           System.out.println(workRequest.getMessage());
//        }
    }

    public void populateTable() {

        DefaultTableModel ordersTable = (DefaultTableModel) tblOrders.getModel();

        ordersTable.setRowCount(0);

        for (WorkRequest workReq : workQueue.getWorkRequestList()) {
            Object row[] = new Object[7];

            row[0] = workReq.getOrderRequest().getOrder_id();
            row[1] = workReq;
            row[2] = workReq.getOrderRequest().getResDetails().getRestaurantName();
            row[3] = workReq.getOrderRequest().getResDetails().getRes_street_add();
            row[4] = workReq.getOrderRequest().getCusDetails().getCustName();
            row[5] = workReq.getOrderRequest().getCusDetails().getCustPhoneNumber();
            row[6] = workReq.getOrderRequest().getCusDetails().getHome_streetAddress();

            ordersTable.addRow(row);

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

        lbltitleorderqueue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnacceptorder = new javax.swing.JButton();
        btnBack = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(650, 650));
        setMinimumSize(new java.awt.Dimension(650, 650));
        setPreferredSize(new java.awt.Dimension(650, 650));

        lbltitleorderqueue.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        lbltitleorderqueue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitleorderqueue.setText("View Order Queue");

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Created At", "Restaurant Name", "Restaurant Street Address", "Customer Name", "Customer Phone Number", "Customer Street Address"
            }
        ));
        jScrollPane1.setViewportView(tblOrders);
        if (tblOrders.getColumnModel().getColumnCount() > 0) {
            tblOrders.getColumnModel().getColumn(0).setResizable(false);
            tblOrders.getColumnModel().getColumn(1).setResizable(false);
            tblOrders.getColumnModel().getColumn(2).setResizable(false);
            tblOrders.getColumnModel().getColumn(3).setResizable(false);
            tblOrders.getColumnModel().getColumn(4).setResizable(false);
            tblOrders.getColumnModel().getColumn(6).setResizable(false);
        }

        btnacceptorder.setBackground(new java.awt.Color(204, 255, 204));
        btnacceptorder.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        btnacceptorder.setText("Accept this Order");
        btnacceptorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnacceptorderActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnBack))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1)
                                .addGap(135, 135, 135)
                                .addComponent(btnacceptorder)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitleorderqueue, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbltitleorderqueue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnBack)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(btnacceptorder)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnacceptorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnacceptorderActionPerformed
        // TODO add your handling code here:
        int selectedWorkInd = tblOrders.getSelectedRow();

        if (selectedWorkInd < 0) {
            JOptionPane.showMessageDialog(this, "Select a Request");
            return;
        }

        DefaultTableModel selectedWork = (DefaultTableModel) tblOrders.getModel();

        WorkRequest acceptedWork = (WorkRequest) selectedWork.getValueAt(selectedWorkInd, 1);

        if (acceptedWork.getStatus().equals("negative") && flag == 0) {
            acceptedWork.setDeliveryMan(delManDetails.getUserAccount());
            acceptedWork.setMessage("Deliveryman Accepted");
            acceptedWork.setStatus("positive");
            acceptedWork.getOrderRequest().setDeliverManDetails(delManDetails);
//            flag = 1;
        }

        JOptionPane.showMessageDialog(this, "Successfully Accepted this Order");
    }//GEN-LAST:event_btnacceptorderActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        panelBackWorkArea.remove(this);
        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).show(panelBackWorkArea, "DeliveryManWorkArea");
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
        btnBack.setForeground(Color.blue);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
        btnBack.setForeground(Color.red);
    }//GEN-LAST:event_btnBackMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnacceptorder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltitleorderqueue;
    private javax.swing.JTable tblOrders;
    // End of variables declaration//GEN-END:variables
}
