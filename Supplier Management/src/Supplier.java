import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class Supplier extends javax.swing.JFrame {

 
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public Supplier() {
        initComponents();
    establishConnection();
       setLocationRelativeTo(null);

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SuppIDField = new javax.swing.JTextField();
        SearchBTN = new javax.swing.JButton();
        ShowBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 0, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supplier ID:");

        SearchBTN.setBackground(new java.awt.Color(153, 153, 153));
        SearchBTN.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        SearchBTN.setForeground(new java.awt.Color(0, 51, 51));
        SearchBTN.setText("Search");
        SearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTNActionPerformed(evt);
            }
        });

        ShowBTN.setBackground(new java.awt.Color(153, 153, 153));
        ShowBTN.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        ShowBTN.setForeground(new java.awt.Color(0, 51, 51));
        ShowBTN.setText("Show");
        ShowBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowBTNActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(SuppIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(ShowBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SuppIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTNActionPerformed
  String suppIDStr = SuppIDField.getText(); // Get the supplier ID from the input field

        // Validate input
        if (suppIDStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Supplier ID must be provided!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int suppID = Integer.parseInt(suppIDStr); // Convert supplier ID to integer

            // Prepare SQL statement to retrieve supplier data
            String sql = "SELECT * FROM suppliermanagement WHERE supplier_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, suppID);

            // Execute the query
            rs = pstmt.executeQuery();

            // Clear previous results
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            // Check if a result was returned
            if (rs.next()) {
                // Add the retrieved data into the table
                model.addRow(new Object[]{
                    rs.getInt("supplier_id"),
                    rs.getString("name"),
                    rs.getString("contact_info"),
                    rs.getString("product"),
                    rs.getBoolean("is_active"),
                    rs.getDate("last_updated")
                });
            } else {
                JOptionPane.showMessageDialog(this, "Supplier ID not found.", "Search Error", JOptionPane.ERROR_MESSAGE);
            }

            // Clean up
            rs.close();
            pstmt.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Supplier ID. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error retrieving data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
 
    }//GEN-LAST:event_SearchBTNActionPerformed

    private void ShowBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowBTNActionPerformed
  this.dispose(); 

    // Create and show the SupplierManagement window
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            SupplierManagement supplierWindow = new SupplierManagement();
            supplierWindow.setVisible(true); // Make the new window visible
        }
    });
    }//GEN-LAST:event_ShowBTNActionPerformed

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
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchBTN;
    private javax.swing.JButton ShowBTN;
    private javax.swing.JTextField SuppIDField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
