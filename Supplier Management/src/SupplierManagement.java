import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Date;


public class SupplierManagement extends javax.swing.JFrame {

 
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public SupplierManagement() {
        initComponents();
    establishConnection();
    loadSupplierData(); // Ensure to call the correct method to load supplier data
    setLocationRelativeTo(null);
    
    clearFields();
}
        
    
    private void addActionListener(){
        ExitBTN.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
        ExitBTNActionPerformed(evt);
    }
        });
    }
     private void establishConnection(){
        try{
            //Database connection (replace with your actual credentials)
           conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/supplier_management", "root", "12345");
           if (conn != null){
            stmt = conn.createStatement();
        }else{
                JOptionPane.showMessageDialog(null, "Error updating data: ", "", JOptionPane.ERROR_MESSAGE);
                }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }
     private void clearFields() {
    NameField.setText("");
    ContactInfoField.setText("");
    AddressField.setText("");
    IsActiveField.setText("");
}
private void loadSupplierData() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear existing rows
    
    // Query to fetch the necessary columns from suppliermanagement
    String query = "SELECT supplier_id, name, contact_info, product, is_active, last_updated FROM suppliermanagement";
    
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        // Iterate through the ResultSet and populate the table model
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("supplier_id"),
                rs.getString("name"),
                rs.getString("contact_info"),
                rs.getString("product"), // Corrected to use getString instead of getDate
                rs.getInt("is_active"),
                rs.getDate("last_updated"), // Assuming last_updated is of type Date
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Failed to load supplier data: " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        UpdateBTN = new javax.swing.JButton();
        SaveBTN = new javax.swing.JButton();
        SuppIDField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        ContactInfoField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AddressField = new javax.swing.JTextField();
        IsActiveField = new javax.swing.JTextField();
        DeleteBTN = new javax.swing.JButton();
        ExitBTN = new javax.swing.JButton();
        LstUpdatedField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Name", "Contact Info", "Product", "Is Active", "Last Upldated"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));

        UpdateBTN.setBackground(new java.awt.Color(153, 153, 153));
        UpdateBTN.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        UpdateBTN.setForeground(new java.awt.Color(0, 51, 51));
        UpdateBTN.setText("Update");
        UpdateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBTNActionPerformed(evt);
            }
        });

        SaveBTN.setBackground(new java.awt.Color(153, 153, 153));
        SaveBTN.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        SaveBTN.setForeground(new java.awt.Color(0, 51, 51));
        SaveBTN.setText("Save");
        SaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBTNActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supplier ID:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contact Info:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name:");

        ContactInfoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactInfoFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product:");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Is Active:");

        IsActiveField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsActiveFieldActionPerformed(evt);
            }
        });

        DeleteBTN.setBackground(new java.awt.Color(153, 153, 153));
        DeleteBTN.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        DeleteBTN.setForeground(new java.awt.Color(0, 51, 51));
        DeleteBTN.setText("Delete");
        DeleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBTNActionPerformed(evt);
            }
        });

        ExitBTN.setBackground(new java.awt.Color(153, 153, 153));
        ExitBTN.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        ExitBTN.setForeground(new java.awt.Color(0, 51, 51));
        ExitBTN.setText("Exit");
        ExitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBTNActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Last Updated:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SuppIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                            .addComponent(NameField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(ContactInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(UpdateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(SaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(DeleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(ExitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(378, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IsActiveField, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                                    .addComponent(LstUpdatedField)
                                    .addComponent(AddressField))))
                        .addGap(91, 91, 91))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SuppIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(IsActiveField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LstUpdatedField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ContactInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBTNActionPerformed
   String supplierIdStr = SuppIDField.getText();
    String name = NameField.getText();
    String contactInfo = ContactInfoField.getText();
    String address = AddressField.getText();
    String isActiveStr = IsActiveField.getText();
    String lastUpdatedStr = LstUpdatedField.getText(); // Assuming last_updated is a date string

    // Validate input
    if (supplierIdStr.isEmpty() || name.isEmpty() || contactInfo.isEmpty() || address.isEmpty() || isActiveStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int supplierId = Integer.parseInt(supplierIdStr);
        int isActive = Integer.parseInt(isActiveStr); // Assuming is_active is an integer (0 or 1)
        Date lastUpdated = Date.valueOf(lastUpdatedStr); // Assuming the date is in the format YYYY-MM-DD

        // Prepare SQL statement to update supplier data
        String sql = "UPDATE suppliermanagement SET name = ?, contact_info = ?, product = ?, is_active = ?, last_updated = ? WHERE supplier_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, contactInfo);
        pstmt.setString(3, address);
        pstmt.setInt(4, isActive);
        pstmt.setDate(5, lastUpdated);
        pstmt.setInt(6, supplierId);

        // Execute the statement
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Supplier updated successfully!");
            clearFields();
            loadSupplierData(); // Refresh the table data
        } else {
            JOptionPane.showMessageDialog(this, "No supplier found with the provided ID.", "Update Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid Supplier ID or Is Active value. Please enter numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "Invalid date format for Last Updated. Please use YYYY-MM-DD.", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error updating supplier data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_UpdateBTNActionPerformed

    private void SaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBTNActionPerformed
  String name = NameField.getText();
    String contactInfo = ContactInfoField.getText();
    String address = AddressField.getText();
    String isActiveStr = IsActiveField.getText(); // Assuming is_active is an integer (0 or 1)
    String lastUpdatedStr = LstUpdatedField.getText(); // Assuming last_updated is a date string

    // Validate input (do not check SuppIDField)
    if (name.isEmpty() || contactInfo.isEmpty() || address.isEmpty() || isActiveStr.isEmpty() || lastUpdatedStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int isActive = 0;
    Date lastUpdated = null;

    try {
        // Parse isActiveStr to an integer
        isActive = Integer.parseInt(isActiveStr); // Convert is_active to integer
        if (isActive < 0 || isActive > 1) {
            throw new NumberFormatException("Is Active must be 0 or 1.");
        }

        // Parse lastUpdatedStr to java.sql.Date
        lastUpdated = Date.valueOf(lastUpdatedStr); // Convert last_updated to java.sql.Date
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid Is Active value. Please enter a number (0 or 1).", "Input Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if there's an error
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "Invalid date format for Last Updated. Please use YYYY-MM-DD.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if there's an error
    }

    // Prepare SQL statement to insert new supplier data
    String sql = "INSERT INTO suppliermanagement (name, contact_info, product, is_active, last_updated) VALUES (?, ?, ?, ?, ?)";
    try {
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, contactInfo);
        pstmt.setString(3, address);
        pstmt.setInt(4, isActive);
        pstmt.setDate(5, lastUpdated);

        // Execute the statement
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Supplier added successfully!");
        clearFields(); // Clear the input fields
        loadSupplierData(); // Refresh the table data
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saving supplier data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_SaveBTNActionPerformed

    private void ContactInfoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactInfoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactInfoFieldActionPerformed

    private void DeleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBTNActionPerformed
        String suppIDStr = SuppIDField.getText(); // Assuming SuppIDField contains the supplier ID to delete

    // Validate input
    if (suppIDStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Supplier ID must be provided!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int suppID = Integer.parseInt(suppIDStr); // Convert supplier ID to integer

        // Prepare SQL statement to delete the supplier
        String sql = "DELETE FROM suppliermanagement WHERE supplier_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, suppID);

        // Execute the statement
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Supplier deleted successfully!");
            clearFields(); // Clear the input fields
            loadSupplierData(); // Refresh the table data
        } else {
            JOptionPane.showMessageDialog(this, "Supplier ID not found.", "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid Supplier ID. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error deleting supplier: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_DeleteBTNActionPerformed

    private void ExitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBTNActionPerformed
        this.dispose(); // Close the current window

    // Create and show the SuppManagement window
    Supplier supplierWindow = new Supplier();
    supplierWindow.setVisible(true); // Make the new window visible
    }//GEN-LAST:event_ExitBTNActionPerformed

    private void IsActiveFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsActiveFieldActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_IsActiveFieldActionPerformed

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
            java.util.logging.Logger.getLogger(TrainigManagemnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrainigManagemnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrainigManagemnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrainigManagemnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JTextField ContactInfoField;
    private javax.swing.JButton DeleteBTN;
    private javax.swing.JButton ExitBTN;
    private javax.swing.JTextField IsActiveField;
    private javax.swing.JTextField LstUpdatedField;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton SaveBTN;
    private javax.swing.JTextField SuppIDField;
    private javax.swing.JButton UpdateBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
