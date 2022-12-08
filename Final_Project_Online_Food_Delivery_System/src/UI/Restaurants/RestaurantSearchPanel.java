/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Restaurants;

import Model.Customer.Customer;
import Model.Menu.Menu;
import Model.Restaurant.Restaurant;
import Model.Restaurant.RestaurantDirectory;
import UI.MenuWorkArea.ViewMenuPanel;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author amretasrerengarajan
 */
public class RestaurantSearchPanel extends javax.swing.JPanel {

    /**
     * Creates new form RestaurantSearchPanel
     */
    RestaurantDirectory resList;
    javax.swing.JPanel panelBackWorkArea;
    Customer cusAccount;

    public RestaurantSearchPanel(RestaurantDirectory resList, javax.swing.JPanel panelBackWorkArea, Customer cusAccount) {
        initComponents();
        this.resList = resList;
        this.cusAccount = cusAccount;
        lblWarType.setVisible(false);
        lblWarText.setVisible(false);
        this.panelBackWorkArea = panelBackWorkArea;
    }

    public void populateTable(ArrayList<Restaurant> restaurantList) {

        DefaultTableModel resTable = (DefaultTableModel) tblRestaurantList.getModel();
        resTable.setRowCount(0);
        for (Restaurant res : restaurantList) {
            Object[] row = new Object[6];
            row[0] = res;
            row[1] = res.getRes_type();
            row[2] = res.getPhoneNumber();
            row[3] = res.getRes_street_add();
            row[4] = res.getRes_city();
            row[5] = res.getRes_pincode();
            resTable.addRow(row);
        }
    }

    public void populateMenuList(Restaurant selectedRestaurant) {
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Delivery_system",
                    "root", "amre1999");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("SELECT * FROM Menu_Directory WHERE restaurant_id =?;");

            st.setInt(1, selectedRestaurant.getRestaurantId());

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("food_cateogory"));
                String fd_category = rs.getString("food_cateogory");
                String fd_name = rs.getString("food_name");
                float fd_price = rs.getFloat("food_price");
                String fd_preference = rs.getString("food_preference");
                String fd_size = rs.getString("food_size");
                int res_id = rs.getInt("restaurant_id");

                Menu newMenu = new Menu();

                newMenu.setFood_category(fd_category);
                newMenu.setFood_name(fd_name);
                newMenu.setFood_preference(fd_preference);
                newMenu.setFood_price(fd_price);
                newMenu.setFood_Qty(fd_size);
                newMenu.setRestaurant_id(res_id);
                
                selectedRestaurant.addMenu(newMenu);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
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

        SearchType = new javax.swing.ButtonGroup();
        lblHeading = new javax.swing.JLabel();
        lblSearchType = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblWarType = new javax.swing.JLabel();
        lblWarText = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        cmbBoxSearchType = new javax.swing.JComboBox<>();
        lblSearch = new javax.swing.JLabel();
        TablePanel = new javax.swing.JScrollPane();
        tblRestaurantList = new javax.swing.JTable();
        btnViewMenu = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(950, 950));
        setMinimumSize(new java.awt.Dimension(650, 650));
        setPreferredSize(new java.awt.Dimension(650, 650));

        lblHeading.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Choose A Restaurant");

        lblSearchType.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblSearchType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearchType.setText("Search Type:");

        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblWarType.setForeground(new java.awt.Color(255, 51, 0));
        lblWarType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblWarType.setText("Choose One!");

        lblWarText.setForeground(new java.awt.Color(255, 0, 51));
        lblWarText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblWarText.setText("This Field cannot be Empty!");

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
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

        cmbBoxSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One Search Type", "Restaurant Name", "Restaurant Type", "Restaurant Street Address", "Restaurant City", "Restaurant Pincode", "View All" }));
        cmbBoxSearchType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxSearchTypeActionPerformed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearch.setText("Search:");

        TablePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TablePanel.setMaximumSize(new java.awt.Dimension(450, 450));
        TablePanel.setMinimumSize(new java.awt.Dimension(450, 450));
        TablePanel.setPreferredSize(new java.awt.Dimension(450, 450));

        tblRestaurantList.setBackground(new java.awt.Color(204, 255, 204));
        tblRestaurantList.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        tblRestaurantList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Type", "Phone Number", "Street Address", "City", "Pincode"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRestaurantList.setMaximumSize(new java.awt.Dimension(300, 300));
        tblRestaurantList.setMinimumSize(new java.awt.Dimension(300, 300));
        tblRestaurantList.setPreferredSize(new java.awt.Dimension(300, 300));
        TablePanel.setViewportView(tblRestaurantList);

        btnViewMenu.setText("View Menu");
        btnViewMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnBack))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSearchType)
                                            .addComponent(lblSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbBoxSearchType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblWarType, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblWarText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(155, 155, 155)
                                        .addComponent(btnSearch))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(btnViewMenu)))
                        .addGap(0, 72, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblSearch, lblSearchType});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbBoxSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWarType))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWarText)
                            .addComponent(lblSearch)))
                    .addComponent(lblSearchType))
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(69, 69, 69)
                .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnViewMenu)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String searchType = String.valueOf(cmbBoxSearchType.getSelectedItem());
        String searchText = txtSearch.getText();
        ArrayList<Restaurant> searchResults = null;
        if (searchType.equals("") && !searchType.equals("View All")) {
            lblWarType.setVisible(true);
        } else if (searchType.equals("View All")) {
            populateTable(resList.getRestaurantList());
        } else {
            if (searchText.equals("")) {
                lblWarText.setVisible(true);
            } else {
                if (searchType.equals("Restaurant Name")) {
                    searchResults = resList.searchWithResName(searchText);
                } else if (searchType.equals("Restaurant Type")) {
                    searchResults = resList.searchWithResType(searchText);
                } else if (searchType.equals("Restaurant Street Address")) {
                    searchResults = resList.searchWithResAdd(searchText);
                } else if (searchType.equals("Restaurant City")) {
                    searchResults = resList.searchWithResCity(searchText);
                } else if (searchType.equals("Restaurant Pincode")) {
                    searchResults = resList.searchWithResPincode(Integer.parseInt(searchText));
                } else {
                    JOptionPane.showMessageDialog(this, "Select Search Type and Text");
                }
                populateTable(searchResults);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
        btnBack.setForeground(Color.blue);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
        btnBack.setForeground(Color.red);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        panelBackWorkArea.remove(this);
        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
    }//GEN-LAST:event_btnBackMouseClicked

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        // TODO add your handling code here:
        if (txtSearch.getText().equals("")) {
            lblWarText.setVisible(true);
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void cmbBoxSearchTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxSearchTypeActionPerformed
        // TODO add your handling code here:
        if (cmbBoxSearchType.getSelectedItem().equals("View All")) {
            lblSearch.setVisible(false);
            txtSearch.setVisible(false);
        }
    }//GEN-LAST:event_cmbBoxSearchTypeActionPerformed

    private void btnViewMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMenuActionPerformed
        // TODO add your handling code here:
        int selectedResInd = tblRestaurantList.getSelectedRow();

        if (selectedResInd < 0) {
            JOptionPane.showMessageDialog(this, "Select a Restaurant");
        }

        DefaultTableModel restaurantTable = (DefaultTableModel) tblRestaurantList.getModel();

        Restaurant selectedRestaurant = (Restaurant) restaurantTable.getValueAt(selectedResInd, 0);
        
        
        // ADD MENU PANEL

        ViewMenuPanel menuPanel = new ViewMenuPanel(panelBackWorkArea, selectedRestaurant, cusAccount);
        panelBackWorkArea.removeAll();
        panelBackWorkArea.add("MenuPanel", menuPanel);
        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
    }//GEN-LAST:event_btnViewMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup SearchType;
    private javax.swing.JScrollPane TablePanel;
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewMenu;
    private javax.swing.JComboBox<String> cmbBoxSearchType;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearchType;
    private javax.swing.JLabel lblWarText;
    private javax.swing.JLabel lblWarType;
    private javax.swing.JTable tblRestaurantList;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
