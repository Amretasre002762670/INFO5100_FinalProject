/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.CustomerWorkArea;

import Model.Menu.Menu;
import Model.Order.Order;
import Model.WorkQueue.WorkQueue;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amretasrerengarajan
 */
public class OrderSummaryPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderSummaryPanel
     */
    JPanel panelBackWorkArea;
    Order order;
    WorkQueue workQueue;

    public OrderSummaryPanel(JPanel panelBackWorkArea, Order order, WorkQueue workQueue) {
        initComponents();
        this.panelBackWorkArea = panelBackWorkArea;
        this.order = order;
        this.workQueue = workQueue;

        txtTotal.setEditable(false);
        txtDatePlaced.setEditable(false);
        txtResName.setEditable(false);
        txtTimePlaced.setEditable(false);
        txtOrderId.setEditable(false);

        txtTotal.setText(String.valueOf(order.getTotal()));
        txtOrderId.setText(String.valueOf(this.order.getOrder_id()));
        txtResName.setText(this.order.getResDetails().getRestaurantName());
        txtDatePlaced.setText(this.order.getDatePlaced());
        txtTimePlaced.setText(this.order.getOrderCreatedAt());

        populateTable(this.order);
    }

    public void populateTable(Order order) {
        
        DefaultTableModel summaryTable = (DefaultTableModel) tblMenu.getModel();
        summaryTable.setRowCount(0);
        
        ArrayList<Menu> newList = new ArrayList<Menu>();
  
        // Traverse through the first list
        for (Menu element : order.getMenu()) {
  
            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {
  
                newList.add(element);
            }
        }
        
        for (Menu menuItem : newList) {

            Object[] row = new Object[3];
            row[0] = menuItem;
            row[1] = menuItem.getFood_price();
            summaryTable.addRow(row);
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
        lblOrderId = new javax.swing.JLabel();
        lblDatePlaced = new javax.swing.JLabel();
        lblTimePlaced = new javax.swing.JLabel();
        lblResName = new javax.swing.JLabel();
        txtOrderId = new javax.swing.JTextField();
        txtDatePlaced = new javax.swing.JTextField();
        txtTimePlaced = new javax.swing.JTextField();
        txtResName = new javax.swing.JTextField();
        btnBack = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(675, 675));
        setMinimumSize(new java.awt.Dimension(675, 675));
        setPreferredSize(new java.awt.Dimension(675, 675));

        lblHeading.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Order Summary");

        lblOrderId.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        lblOrderId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderId.setText("Order ID:");

        lblDatePlaced.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        lblDatePlaced.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatePlaced.setText("Date Placed:");

        lblTimePlaced.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        lblTimePlaced.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimePlaced.setText("Time Placed:");

        lblResName.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        lblResName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResName.setText("Restaurant Name:");

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
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

        tblMenu.setBackground(new java.awt.Color(204, 255, 204));
        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Price Per"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMenu);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("List Of Selected Dishes");

        btnCheckout.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnCheckout.setForeground(new java.awt.Color(255, 0, 0));
        btnCheckout.setText("Checkout >>");
        btnCheckout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseExited(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal.setText("Total:");

        txtTotal.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblOrderId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDatePlaced, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTimePlaced, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblResName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtOrderId)
                                    .addComponent(txtDatePlaced)
                                    .addComponent(txtTimePlaced)
                                    .addComponent(txtResName, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnBack)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(btnCheckout)
                .addGap(99, 99, 99))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblDatePlaced, lblOrderId, lblResName, lblTimePlaced});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderId)
                    .addComponent(txtOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatePlaced)
                    .addComponent(txtDatePlaced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimePlaced)
                    .addComponent(txtTimePlaced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResName)
                    .addComponent(txtResName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckout))
                .addContainerGap(207, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseEntered
        // TODO add your handling code here:
        btnCheckout.setForeground(Color.blue);
    }//GEN-LAST:event_btnCheckoutMouseEntered

    private void btnCheckoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseExited
        // TODO add your handling code here:
        btnCheckout.setForeground(Color.red);
    }//GEN-LAST:event_btnCheckoutMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
        btnBack.setForeground(Color.blue);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
        btnBack.setForeground(Color.red);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnCheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseClicked
        // TODO add your handling code here:
        CheckoutPanel checkOut = new CheckoutPanel(panelBackWorkArea, order, workQueue);
        panelBackWorkArea.remove(this);
        panelBackWorkArea.add("CheckoutPanel", checkOut);
        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
    }//GEN-LAST:event_btnCheckoutMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        panelBackWorkArea.remove(this);
        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
    }//GEN-LAST:event_btnBackMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnCheckout;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatePlaced;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblOrderId;
    private javax.swing.JLabel lblResName;
    private javax.swing.JLabel lblTimePlaced;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblMenu;
    private javax.swing.JTextField txtDatePlaced;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtResName;
    private javax.swing.JTextField txtTimePlaced;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
