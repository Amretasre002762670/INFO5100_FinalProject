/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.MainJframe;

import Model.Customer.Customer;
import Model.Customer.CustomerDirectory;
import Model.DeliveryMan.DeliveryMan;
import Model.Restaurant.Restaurant;
import Model.Restaurant.RestaurantDirectory;
import Model.RestaurantAdmin.RestaurantAdmin;
import Model.System.Ecosystem;
import Model.UserAccount.UserAccount;
import Model.UserAccount.UserAccountDirectory;
import Model.DeliveryMan.DeliveryManDirectory;
import Model.Menu.Menu;
import Model.Order.Order;
import Model.Order.OrderList;
import Model.WorkQueue.WorkQueue;
import UI.CustomerWorkArea.CustomerWorkArea;
import UI.DeliveryManWorkArea.DeliveryManWorkArea;
import UI.RestaurantAdminWorkArea.RestaurantAdminWorkAreaJPanel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import UI.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author amretasrerengarajan
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    CustomerDirectory customerList;
    UserAccountDirectory userAccountDir;
    RestaurantDirectory resList;
    OrderList orderHis;
    Ecosystem ecosystem;
    WorkQueue workQueue;
    DeliveryManDirectory deliveryManList;

    public MainJFrame() {
        initComponents();
        lblWarningUserType.setVisible(false);

//        this.customerList = new CustomerDirectory();
//        this.userAccountDir = new UserAccountDirectory();
//        this.resList = new RestaurantDirectory();
        this.ecosystem = new Ecosystem();
        this.customerList = this.ecosystem.getCustomerDirectory();
        this.userAccountDir = this.ecosystem.getUserAccountDir();
        this.resList = this.ecosystem.getRestaurantDirectory();
        this.workQueue = new WorkQueue();
        this.deliveryManList = new DeliveryManDirectory();
        
        orderHis = new OrderList();

        // Methods to populate the respective lists from DB
        populateCustomerList();
        populateRestaurantList();
        populateDeliveryManList();
    }

    public void checkUserType(String selectedRole) {
        if (selectedRole.equals("Choose a User!")) {
            lblWarningUserType.setVisible(true);
        } else {
            lblWarningUserType.setVisible(false);
        }
    }

    public void populateCustomerList() {
        Customer addCustomer;
        UserAccount addUser;
        try {

            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/online_delivery_system",
                    "root", "amre1999");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("SELECT * FROM Customer_Directory");

            PreparedStatement st_userAcct = (PreparedStatement) connection
                    .prepareStatement("SELECT * FROM User_Account_Directory u, Customer_Directory c WHERE u.user_id = c.user_id");

            ResultSet rs = st.executeQuery();
            ResultSet rs_userAcct = st_userAcct.executeQuery();

            while (rs_userAcct.next()) {
                while (rs.next()) {
                    int custId = Integer.parseInt(rs.getString("customer_id"));
                    String custName = rs.getString("customer_name");
                    String custEmailID = rs.getString("customer_emailid");
                    int custPhoneNum = Integer.parseInt(rs.getString("customer_phoneNum"));
                    String cusStreetAdd = rs.getString("customer_street_address");
                    String cusCity = rs.getString("customer_city");
                    int cusPincode = Integer.parseInt(rs.getString("customer_pincode"));

                    String accountName = rs_userAcct.getString("user_name");
                    String accountPassword = rs_userAcct.getString("user_password");
                    String accountRole = rs_userAcct.getString("user_role");

                    addUser = new UserAccount();
                    addUser.setUsername(accountName);
                    addUser.setPassword(accountPassword);
                    addUser.setRole(accountRole);

                    addCustomer = new Customer(addUser);
                    addCustomer.setCus_emailid(custEmailID);
                    addCustomer.setCustName(custName);
                    addCustomer.setCustId(custId);
                    addCustomer.setCustPhoneNumber(custPhoneNum);
                    addCustomer.setHome_City(cusCity);
                    addCustomer.setHome_pincode(cusPincode);
                    addCustomer.setHome_streetAddress(cusStreetAdd);

                    customerList.createCustomer(addCustomer);
                    userAccountDir.addUserAccounts(addUser);
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void populateRestaurantList() {
        Restaurant addRes;
        RestaurantAdmin resAdmin;
        UserAccount resAdminAcct;
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Delivery_system",
                    "root", "amre1999");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("SELECT * FROM Restaurant_Directory;");

            PreparedStatement st_res_admin = (PreparedStatement) connection
                    .prepareStatement("SELECT * FROM User_Account_Directory u, Restaurant_Admin_Directory r WHERE u.user_id = r.user_id");

            ResultSet rs = st.executeQuery();
            ResultSet rs_admin_dir = st_res_admin.executeQuery();

            while (rs_admin_dir.next()) {
                while (rs.next()) {
                    int resId = Integer.parseInt(rs.getString("restaurant_id"));
                    String restName = rs.getString("restaurant_name");
                    int resPhoneNum = Integer.parseInt(rs.getString("restaurant_phoneNum"));
                    String resStreetAdd = rs.getString("restaurant_street_address");
                    String resCity = rs.getString("restaurant_city");
                    int resPincode = Integer.parseInt(rs.getString("restaurant_pincode"));
                    String resType = rs.getString("restaurant_type");

                    resAdminAcct = new UserAccount();
                    resAdminAcct.setUsername(rs_admin_dir.getString("user_name"));
                    resAdminAcct.setPassword(rs_admin_dir.getString("user_password"));
                    resAdminAcct.setRole(rs_admin_dir.getString("user_role"));
                    userAccountDir.addUserAccounts(resAdminAcct);
                    
                    resAdmin = new RestaurantAdmin();
                    resAdmin.setAccountDetails(resAdminAcct);
                    resAdmin.setResAdminId(Integer.parseInt(rs_admin_dir.getString("res_admin_id")));
                    resAdmin.setResName(restName);
                    
                    addRes = new Restaurant();

                    addRes.setRestaurantName(restName);
                    addRes.setRestaurantId(resId);
                    addRes.setRestaurantAdmin(resAdmin);
                    addRes.setRes_street_add(resStreetAdd);
                    addRes.setRes_pincode(resPincode);
                    addRes.setRes_city(resCity);
                    addRes.setPhoneNumber(resPhoneNum);
                    addRes.setRes_type(resType);

                    try {
                        PreparedStatement st_menu = (PreparedStatement) connection
                                .prepareStatement("SELECT * FROM Menu_Directory WHERE restaurant_id =?");

                        st_menu.setInt(1, resId);

                        ResultSet rs_menu = st_menu.executeQuery();
                        while (rs_menu.next()) {
                            String fd_name = rs_menu.getString("food_name");
                            float fd_price = rs_menu.getFloat("food_price");
                            String fd_preference = rs_menu.getString("food_preference");
                            String fd_size = rs_menu.getString("food_size");
                            int res_id = rs_menu.getInt("restaurant_id");
                            String fd_category = rs_menu.getString("food_cateogory");
                            int fd_id = rs_menu.getInt("food_id");

                            Menu newMenu = new Menu();

                            newMenu.setFood_category(fd_category);
                            newMenu.setFood_name(fd_name);
                            newMenu.setFood_preference(fd_preference);
                            newMenu.setFood_price(fd_price);
                            newMenu.setFood_Qty(fd_size);
                            newMenu.setRestaurant_id(res_id);
                            newMenu.setFood_id(fd_id);

                            addRes.addMenu(newMenu);
                        }
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }

                    resList.addRestaurant(addRes);
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void populateOrderHistory(Customer currentCus) {
        int cusId = currentCus.getCustId();
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Delivery_system",
                    "root", "amre1999");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("SELECT * FROM Order_Directory WHERE customer_id=?");

            st.setInt(1, cusId);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Order orderItem = new Order();
                for (Restaurant res : resList.getRestaurantList()) {
                    if (res.getRestaurantId() == rs.getInt("restaurant_id")) {
                        orderItem.setResDetails(res);
                    }
                }
                orderItem.setCusDetails(currentCus);
                orderItem.setDatePlaced(rs.getString("datePlaced"));
                orderItem.setOrderCreatedAt(rs.getString("orderCratedAt"));
                orderItem.setOrder_id(rs.getInt("order_id_generated"));
                orderHis.addOrder(orderItem);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void populateDeliveryManList() {
        DeliveryMan addDeliveryMan;
        UserAccount addUserAccount;
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/online_delivery_system",
                    "root", "amre1999");

//            PreparedStatement st = (PreparedStatement) connection
//                    .prepareStatement("SELECT * FROM DeliveryMan_Directory");
            PreparedStatement st_userAcct = (PreparedStatement) connection
                    .prepareStatement("SELECT * FROM User_Account_Directory u, DeliveryMan_Directory c WHERE u.user_id = c.user_id");

            ResultSet rs = st_userAcct.executeQuery();

            while (rs.next()) {
                
                addUserAccount = new UserAccount();
                
                addUserAccount.setUsername(rs.getString("user_name"));
                addUserAccount.setPassword(rs.getString("user_password"));
                addUserAccount.setRole(rs.getString("user_role"));
                userAccountDir.addUserAccounts(addUserAccount);
                
                addDeliveryMan = deliveryManList.addDeliveryManWithUserAcct(addUserAccount);;

                addDeliveryMan.setDeliveryManId(rs.getInt("deliveryman_id"));
                addDeliveryMan.setDeliveryManName(rs.getString("deliveryman_name"));
                addDeliveryMan.setDeliveryManNumber(rs.getLong("deliveryman_phoneNumber"));
                addDeliveryMan.setZipcodeCovered(rs.getLong("zipcode_covered"));
                addDeliveryMan.setCommunity(rs.getString("area_covered"));

//                deliveryManList.addDeliveryMan(addDeliveryMan);

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

        lblFrameTitle = new javax.swing.JLabel();
        panelBackWorkArea = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblUserType = new javax.swing.JLabel();
        btnUserType = new javax.swing.JComboBox<>();
        btnLogin = new javax.swing.JButton();
        chckBoxShowPassword = new javax.swing.JCheckBox();
        lblWarningUserType = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setMinimumSize(new java.awt.Dimension(1000, 1000));
        setPreferredSize(new java.awt.Dimension(1000, 1000));
        setSize(new java.awt.Dimension(600, 600));

        lblFrameTitle.setBackground(new java.awt.Color(204, 255, 204));
        lblFrameTitle.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        lblFrameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrameTitle.setText("Online Delivery System");

        panelBackWorkArea.setBackground(new java.awt.Color(204, 255, 204));
        panelBackWorkArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBackWorkArea.setMaximumSize(new java.awt.Dimension(900, 900));
        panelBackWorkArea.setMinimumSize(new java.awt.Dimension(900, 900));
        panelBackWorkArea.setPreferredSize(new java.awt.Dimension(900, 900));
        panelBackWorkArea.setLayout(new java.awt.CardLayout());

        panelLogin.setBackground(new java.awt.Color(204, 204, 255));
        panelLogin.setMaximumSize(new java.awt.Dimension(675, 675));
        panelLogin.setMinimumSize(new java.awt.Dimension(675, 675));
        panelLogin.setPreferredSize(new java.awt.Dimension(675, 675));

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Login Page");

        lblUserName.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblUserName.setText("User Name:");

        lblPassword.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblPassword.setText("Password:");

        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        lblUserType.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblUserType.setText("User Login Type:");

        btnUserType.setBackground(new java.awt.Color(242, 242, 242));
        btnUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a User!", "Customer", "Delivery Man", "Restaurant Admin", "System Admin" }));
        btnUserType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnUserTypeFocusLost(evt);
            }
        });
        btnUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserTypeActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(204, 255, 204));
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        chckBoxShowPassword.setText("Show Password");
        chckBoxShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckBoxShowPasswordActionPerformed(evt);
            }
        });

        lblWarningUserType.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblWarningUserType.setForeground(new java.awt.Color(255, 0, 51));
        lblWarningUserType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblWarningUserType.setText("Choose a valid Role!");

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserName)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(lblUserType)
                        .addGap(18, 18, 18)
                        .addComponent(btnUserType, 0, 213, Short.MAX_VALUE)))
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(chckBoxShowPassword))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWarningUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 184, Short.MAX_VALUE))
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelLoginLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblPassword, lblUserName, lblUserType});

        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitle)
                .addGap(70, 70, 70)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chckBoxShowPassword))
                .addGap(50, 50, 50)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserType)
                    .addComponent(btnUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWarningUserType))
                .addGap(50, 50, 50)
                .addComponent(btnLogin)
                .addContainerGap(543, Short.MAX_VALUE))
        );

        panelBackWorkArea.add(panelLogin, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFrameTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBackWorkArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblFrameTitle)
                .addGap(18, 18, 18)
                .addComponent(panelBackWorkArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void chckBoxShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckBoxShowPasswordActionPerformed
        // TODO add your handling code here:
        if (chckBoxShowPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_chckBoxShowPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String userType = String.valueOf(btnUserType.getSelectedItem());
        Customer resultCustomer = null;
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String userRole = (String) btnUserType.getSelectedItem();
        checkUserType(userRole);
        CustomerWorkArea cusWorkArea;
        DeliveryManWorkArea delworkarea;
        SystemAdminWorkAreaJPanel sysadminWorkArea;
        RestaurantAdminWorkAreaJPanel resadminWorkArea;

        if (userName.equals("") || password.equals("") || userRole.equals("Choose a User!")) {
            lblWarningUserType.setVisible(false);
            JOptionPane.showMessageDialog(this, "All fields are Mandatory");
        } else {
            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Delivery_system",
                        "root", "amre1999");

                PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select user_name, user_password, user_role from User_Account_Directory where user_name=? and user_password=? and user_role=?");

                st.setString(1, userName);
                st.setString(2, password);
                st.setString(3, userRole);

                ResultSet rs = st.executeQuery(); // authenticating users using user name and password

                if (rs.next()) {

                    UserAccount user = new UserAccount();

                    user.setUsername(rs.getString("user_name"));
                    user.setPassword(rs.getString("user_password"));
                    user.setRole(rs.getString("user_role"));

                    if (rs.getString("user_role").equals("Customer")) {
                        Customer searchCustomer = customerList.searchCustomerWithUserAccount(user);

                        if (searchCustomer != null) {

                            populateOrderHistory(searchCustomer);

                            cusWorkArea = new CustomerWorkArea(searchCustomer, panelBackWorkArea, panelLogin, ecosystem.getRestaurantDirectory(), orderHis, workQueue);
                            panelBackWorkArea.removeAll();
                            panelBackWorkArea.add("Customer work area", cusWorkArea);
                            ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);

                            txtUserName.setText("");
                            txtPassword.setText("");
                            btnUserType.setSelectedIndex(0);

                            JOptionPane.showMessageDialog(this, "You have successfully logged in");
                        } else {
                            JOptionPane.showMessageDialog(this, "Customer not available!");
                        }

                    } else if (rs.getString("user_role").equals("Delivery Man")) {

                        DeliveryMan delMan = deliveryManList.findDeliveryManDetails(user);
                        System.out.println(delMan.getUserAccount().getUsername());

                        if (delMan != null) {
                            delworkarea = new DeliveryManWorkArea(panelBackWorkArea, workQueue, delMan, panelLogin);
                            panelBackWorkArea.add("DeliveryManWorkArea", delworkarea);
                            ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
                        } else {
                            JOptionPane.showMessageDialog(this, "Create a new Delivery Man Profile");
                        }
                        
                    } else if (rs.getString("user_role").equals("System Admin")) {
                        // add your code here
                        sysadminWorkArea = new SystemAdminWorkAreaJPanel(panelBackWorkArea, ecosystem, customerList, userAccountDir, user, deliveryManList, resList, panelLogin);
                        panelBackWorkArea.removeAll();
                        panelBackWorkArea.add("SystemAdmin", sysadminWorkArea);
                        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
                        txtUserName.setText("");
                        txtPassword.setText("");
                        btnUserType.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(this, "You have successfully logged in");
                    } else if (rs.getString("user_role").equals("Restaurant Admin")) {
                        // add your code here
                        Restaurant resDetails = resList.searchRestaurantWithUserAccount(user);
//                        selectedResWorkQueue = workQueue.findResWorkQueue(resDetails);
                        
                        resadminWorkArea = new RestaurantAdminWorkAreaJPanel(panelBackWorkArea, ecosystem, resDetails, workQueue, panelLogin);
                        
                        panelBackWorkArea.removeAll();
                        panelBackWorkArea.add("RestaurantAdmin", resadminWorkArea);
                        ((java.awt.CardLayout) panelBackWorkArea.getLayout()).next(panelBackWorkArea);
                        
                        txtUserName.setText("");
                        txtPassword.setText("");
                        btnUserType.setSelectedIndex(0);
                        
                        JOptionPane.showMessageDialog(this, "You have successfully logged in");
                    }

                } else if (userName.equals("") || password.equals("") || userRole.equals("Choose a User!")) {
                    JOptionPane.showMessageDialog(this, "All fields are Mandatory!");
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Username & Password");
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnUserTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnUserTypeFocusLost
        // TODO add your handling code here:
        if (btnUserType.getSelectedItem().equals("Choose a User!")) {
            lblWarningUserType.setVisible(true);
        } else {
            lblWarningUserType.setVisible(false);
        }
    }//GEN-LAST:event_btnUserTypeFocusLost

    private void btnUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserTypeActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        // TODO add your handling code here:
        btnLogin.setBackground(new Color(255, 255, 204));
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        // TODO add your handling code here:
        btnLogin.setBackground(new Color(255, 255, 204));

    }//GEN-LAST:event_btnLoginMouseExited

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> btnUserType;
    private javax.swing.JCheckBox chckBoxShowPassword;
    private javax.swing.JLabel lblFrameTitle;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserType;
    private javax.swing.JLabel lblWarningUserType;
    private javax.swing.JPanel panelBackWorkArea;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
