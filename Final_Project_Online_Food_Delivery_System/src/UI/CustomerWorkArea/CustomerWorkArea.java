/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.CustomerWorkArea;

/**
 *
 * @author amretasrerengarajan
 */
public class CustomerWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form CustomerWorkArea
     */
    public CustomerWorkArea() {
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

        lblTitle = new javax.swing.JLabel();
        btnSearchRes = new javax.swing.JButton();
        btnViewOrderHistory = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Customer Work Area");
        add(lblTitle, "card2");

        btnSearchRes.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnSearchRes.setText("Search Restaurant");
        add(btnSearchRes, "card3");

        btnViewOrderHistory.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnViewOrderHistory.setText("View Orders History");
        add(btnViewOrderHistory, "card4");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchRes;
    private javax.swing.JButton btnViewOrderHistory;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
