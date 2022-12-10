/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SystemAdminWorkArea;

import Model.Customer.Customer;
import Model.Customer.CustomerDirectory;
import Model.System.Ecosystem;
import Model.Employee.Employee;
import Model.Role.RestaurantAdminrole;
import Model.Role.Role;
import Model.Role.Customerrole;
import java.awt.CardLayout;
import java.awt.Component;
import Model.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author puppalanagavaishnavi
 */
public class ManageCustomersJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Ecosystem ecosystem;
    private Customer customer;
    CustomerDirectory customerList;

    public ManageCustomersJPanel(JPanel userProcessContainer, UserAccount account, Ecosystem ecosystem, CustomerDirectory customerList) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.ecosystem = ecosystem;
        this.customerList = customerList;
        txtCustID.setEditable(false);
        populateComboBox();
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCustUsername = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerJTable = new javax.swing.JTable();
        txtCustUserName = new javax.swing.JTextField();
        lblCustPassword = new javax.swing.JLabel();
        lblCustID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxRole = new javax.swing.JComboBox();
        txtCustID = new javax.swing.JTextField();
        btnUpdateCust = new javax.swing.JButton();
        lblCustStreetAddress = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtCustStreetAddress = new javax.swing.JTextField();
        txtCustPass = new javax.swing.JPasswordField();
        lblCustEmailAddress = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        txtCustEmailAdd = new javax.swing.JTextField();
        lblCustName = new javax.swing.JLabel();
        txtCustName = new javax.swing.JTextField();
        lblCustCity = new javax.swing.JLabel();
        txtCustCity = new javax.swing.JTextField();
        lblCustPincode = new javax.swing.JLabel();
        txtCustPincode = new javax.swing.JTextField();
        lblCustPhoneNumber = new javax.swing.JLabel();
        txtCustPhoneNum = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        lblCustUsername.setText("Username:");

        customerJTable.setBackground(new java.awt.Color(204, 255, 204));
        customerJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Name", "Street Address", "City", "Pincode", "PhoneNumber", "Email ID", "UserName"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerJTable);

        lblCustPassword.setText("Password:");

        lblCustID.setText("Customer ID:");

        jLabel6.setText("Role:");

        cbxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRoleActionPerformed(evt);
            }
        });

        btnUpdateCust.setText("Update");
        btnUpdateCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustActionPerformed(evt);
            }
        });

        lblCustStreetAddress.setText("Street Address");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblCustEmailAddress.setText("Email ID:");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        lblCustName.setText("Name:");

        lblCustCity.setText("City");

        lblCustPincode.setText("Pincode");

        lblCustPhoneNumber.setText("Phone Number:");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(204, 255, 204));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(204, 255, 204));
        btnBack.setText("<- Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(0, 153, 153));
        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 0));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage Customers ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addGap(65, 65, 65)
                .addComponent(btnRefresh)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnCreate)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateCust)
                        .addGap(18, 18, 18)
                        .addComponent(saveBtn)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustStreetAddress)
                            .addComponent(lblCustEmailAddress)
                            .addComponent(lblCustUsername)
                            .addComponent(lblCustPassword)
                            .addComponent(lblCustID)
                            .addComponent(jLabel6)
                            .addComponent(lblCustName)
                            .addComponent(lblCustCity)
                            .addComponent(lblCustPincode)
                            .addComponent(lblCustPhoneNumber))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustPass, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustEmailAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustCity, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustPincode, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnRefresh)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustID)
                            .addComponent(txtCustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustName)
                            .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustStreetAddress)
                            .addComponent(txtCustStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustCity)
                            .addComponent(txtCustCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustPincode)
                            .addComponent(txtCustPincode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustPhoneNumber)
                            .addComponent(txtCustPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustEmailAddress)
                            .addComponent(txtCustEmailAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblCustUsername))
                    .addComponent(txtCustUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustPassword)
                    .addComponent(txtCustPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateCust)
                    .addComponent(btnDelete)
                    .addComponent(saveBtn)
                    .addComponent(btnCreate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void sendUserAccountDetails(UserAccount userAccount) {
        String queryCustomerTable = "INSERT INTO User_Account_Directory (user_name, user_password, user_role) VALUES (?, ?, ?);";

        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Delivery_system",
                    "root", "Qazmaggi123@");

            PreparedStatement st_CustomerTable = (PreparedStatement) connection
                    .prepareStatement(queryCustomerTable);

            st_CustomerTable.setString(1, userAccount.getUsername());
            st_CustomerTable.setString(2, userAccount.getPassword());
            st_CustomerTable.setString(3, userAccount.getRole());

            st_CustomerTable.execute();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }

    public int getUserIdForUserCreated(UserAccount user) {
        String queryCustomerTable = "SELECT user_id FROM User_Account_Directory WHERE user_name=?;";
        int cus_id = 0;
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Delivery_system",
                    "root", "Qazmaggi123@");

            PreparedStatement st_CustomerTable = (PreparedStatement) connection
                    .prepareStatement(queryCustomerTable);

            st_CustomerTable.setString(1, user.getUsername());

            ResultSet rs = st_CustomerTable.executeQuery();

            while (rs.next()) {
                cus_id = rs.getInt("user_id");
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
        return cus_id;
    }

    public void sendCustomerToDB(Customer c) {
        String queryCustomerTable = "INSERT INTO Customer_Directory (customer_name, customer_emailid, customer_phoneNum, customer_street_address, customer_city, customer_pincode, user_id, user_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int cus_id = 0;
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Delivery_system",
                    "root", "Qazmaggi123@");

            PreparedStatement st_CustomerTable = (PreparedStatement) connection
                    .prepareStatement(queryCustomerTable);

            st_CustomerTable.setString(1, c.getCustName());
            st_CustomerTable.setString(2, c.getCus_emailid());
            st_CustomerTable.setInt(3, c.getCustPhoneNumber());
            st_CustomerTable.setString(4, c.getHome_streetAddress());
            st_CustomerTable.setString(5, c.getHome_City());
            st_CustomerTable.setInt(6, c.getHome_pincode());

            UserAccount user = new UserAccount();
            user.setUsername(c.getUserAccount().getUsername());
            user.setPassword(c.getUserAccount().getPassword());

            cus_id = getUserIdForUserCreated(user);
            
            st_CustomerTable.setInt(7, cus_id);
            st_CustomerTable.setString(8, c.getUserAccount().getUsername());

            st_CustomerTable.execute();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void populateRequestTable() {

    }

    public void populateComboBox() {
        cbxRole.removeAllItems();
        cbxRole.addItem(Role.RoleType.Customer.toString());
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) customerJTable.getModel();

        model.setRowCount(0);

        for (Customer customer : customerList.getCustomerList()) {
            Object[] row = new Object[8];
            //    System.out.println("Manage Customer panel");
            //  System.out.println(customer.getCustName());
            row[0] = customer.getCustId();
            row[1] = customer;
            row[2] = customer.getHome_streetAddress();
            row[3] = customer.getHome_City();
            row[4] = customer.getHome_pincode();
            row[5] = customer.getCustPhoneNumber();
            row[6] = customer.getCus_emailid();
            row[7] = customer.getUserAccount().getUsername();
            model.addRow(row);

        }
    }


    private void cbxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRoleActionPerformed
        // TODO add your handling code here:
        populateComboBox();
    }//GEN-LAST:event_cbxRoleActionPerformed

    private void btnUpdateCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustActionPerformed
        // TODO add your handling code here:
        int selectedRow = customerJTable.getSelectedRow();

        if (selectedRow >= 0) {
            Customer c = (Customer) customerJTable.getValueAt(selectedRow, 1);
            customer = c;
            txtCustID.setText(Integer.toString(c.getCustId()));
            txtCustName.setText(c.getCustName());
            txtCustStreetAddress.setText(c.getHome_streetAddress());
            txtCustCity.setText(c.getHome_City());
            txtCustPincode.setText(String.valueOf(c.getHome_pincode()));
            txtCustPhoneNum.setText(Integer.toString(c.getCustPhoneNumber()));
            txtCustEmailAdd.setText(c.getCus_emailid());
            txtCustUserName.setText(c.getUserAccount().getUsername());
            txtCustPass.setText(c.getUserAccount().getPassword());
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        txtCustID.getText();
        txtCustName.getText();
        txtCustStreetAddress.getText();
        txtCustCity.getText();
        txtCustPincode.getText();
        txtCustPhoneNum.getText();
        txtCustEmailAdd.getText();
        txtCustUserName.getText();

        populateTable();
    }//GEN-LAST:event_btnUpdateCustActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = customerJTable.getSelectedRow();
        if (selectedRow >= 0) {
            Customer selectedcustomer = (Customer) customerJTable.getValueAt(selectedRow, 0);
            customerList.deleteCustomer(selectedcustomer);
            // ecosystem.getCustomerDirectory().deleteCustomer(c);
            JOptionPane.showMessageDialog(null, "Customer deleted Successfully.");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select any row.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:

        for (Customer c : customerList.getCustomerList()) {
            if (customer.getCustName().equals(c.getCustName())) {
                c.setCustId(Integer.parseInt(txtCustID.getText()));
                c.setCustName(txtCustName.getText());
                c.setHome_streetAddress(txtCustStreetAddress.getText());
                c.setHome_City(txtCustCity.getText());
                c.setHome_pincode(Integer.parseInt(txtCustPincode.getText()));
                c.setCustPhoneNumber(Integer.parseInt(txtCustStreetAddress.getText()));
                c.setCus_emailid(txtCustEmailAdd.getText());

            }
        }

        JOptionPane.showMessageDialog(null, "Customer Updated Successfully");
        populateTable();
        txtCustID.setText("");
        txtCustName.setText("");
        txtCustStreetAddress.setText("");
        txtCustCity.setText("");
        txtCustPincode.setText("");
        txtCustPhoneNum.setText("");
        txtCustEmailAdd.setText("");
        txtCustUserName.setText("");
        txtCustPass.setText("");
    }//GEN-LAST:event_saveBtnActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        populateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:

        String username = txtCustUserName.getText();
        String password = String.valueOf(txtCustPass.getPassword());
        String new_role = "Customer";
        //int CustId = Integer.parseInt(txtCustID.getText());
        String name = txtCustName.getText();
        String streetaddress = txtCustStreetAddress.getText();
        String City = txtCustCity.getText();
        int Pincode = Integer.parseInt(txtCustPincode.getText());
        int phoneNumber = Integer.parseInt(txtCustPhoneNum.getText());
        String Emailaddress = txtCustEmailAdd.getText();
//        Employee employee = ecosystem.getEmployeeDirectory().createEmployee(name);

        UserAccount account = ecosystem.getUserAccountDir().AddUserAccount();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole("Customer");

        Customer c = customerList.addCustomer(account);
        c.setCus_emailid(Emailaddress);
        c.setCustPhoneNumber(phoneNumber);
        c.setHome_City(City);
        c.setCustName(name);
        c.setHome_pincode(Pincode);
        c.setHome_streetAddress(streetaddress);
        //c.setUserAccount(userAccount);

        // ecosystem.getCustomerDirectory().createCustomer(customer);
        //JOptionPane.showMessageDialog(null, "Customer has been Created");
        populateTable();

//        for(Customer cus: customerList.getCustomerList()) {
//            System.out.println(cus.getCustName());
//        }
        sendUserAccountDetails(account);
//        int cus_id = getUserIdForUserCreated(account);
//        System.out.println(cus_id);
        sendCustomerToDB(c);

        txtCustID.setText("");
        txtCustName.setText("");
        txtCustStreetAddress.setText("");
        txtCustEmailAdd.setText("");
        txtCustUserName.setText("");
        txtCustPass.setText("");
        JOptionPane.showMessageDialog(null, "Customer has been Created");


    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        // sysAdminwjp.populateTree();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdateCust;
    private javax.swing.JComboBox cbxRole;
    private javax.swing.JTable customerJTable;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustCity;
    private javax.swing.JLabel lblCustEmailAddress;
    private javax.swing.JLabel lblCustID;
    private javax.swing.JLabel lblCustName;
    private javax.swing.JLabel lblCustPassword;
    private javax.swing.JLabel lblCustPhoneNumber;
    private javax.swing.JLabel lblCustPincode;
    private javax.swing.JLabel lblCustStreetAddress;
    private javax.swing.JLabel lblCustUsername;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField txtCustCity;
    private javax.swing.JTextField txtCustEmailAdd;
    private javax.swing.JTextField txtCustID;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JPasswordField txtCustPass;
    private javax.swing.JTextField txtCustPhoneNum;
    private javax.swing.JTextField txtCustPincode;
    private javax.swing.JTextField txtCustStreetAddress;
    private javax.swing.JTextField txtCustUserName;
    // End of variables declaration//GEN-END:variables
}
