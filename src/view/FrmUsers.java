/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.CustomExceptionMessage;
import common.EventLogDescription;
import common.SabteAhvalException;
import common.Utility;
import controller.DocumentsJpaController;
import controller.ResponsibleInformationJpaController;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import java.awt.ComponentOrientation;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Documents;
import model.ResponsibleInformation;

/**
 *
 * @author saeed
 */
public class FrmUsers extends javax.swing.JFrame {

    FrmMain frmMain; 
    DefaultTableModel model;
    ResponsibleInformationJpaController responsibleInformationController;
    DocumentsJpaController documentsJpaController;
   
    public FrmUsers(FrmMain frmMain) {
        initComponents();
        this.frmMain = frmMain;
        setWindowInMiddle();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model=(DefaultTableModel)tblUsers.getModel();
        tblUsers.setModel(model);
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SabteAhvalPU");
        responsibleInformationController=new ResponsibleInformationJpaController(emf);
        documentsJpaController = new DocumentsJpaController(emf);
        tblUsers.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        fillJTable();
        
    }
      private void setWindowInMiddle(){
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    public void fillJTable(){
        model.setRowCount(0);                
        List<ResponsibleInformation> responsibleInformation = responsibleInformationController.findAllResponsibleInformation();
        for(int i=0; i<responsibleInformation.size(); i++){
            model.addRow(new Object[]{responsibleInformation.get(i).getId(),responsibleInformation.get(i).getFirstName(),
            responsibleInformation.get(i).getLastName(),responsibleInformation.get(i).getPhone(),
            responsibleInformation.get(i).getUsername(),responsibleInformation.get(i).getAddress()});
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtNid = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtEducation = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("اطلاعات کارمندان");

        jLabel1.setText("نام");

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        jLabel2.setText("نام خانوادگی");

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        jLabel3.setText("نام کاربری");

        jLabel4.setText("رمز عبور");

        jLabel5.setText("تلفن");

        jLabel6.setText("آدرس");

        jLabel7.setText("سمت  اداری");

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "کارمند", "مدیر" }));

        btnAdd.setText("ثبت");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("ویراییش");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setText("حذف");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "کد  کاربر", "نام", "نام خانوادگی", "تلفن", "نام کاربری", "آدرس"
            }
        ));
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsers);

        jLabel8.setText("کد ملی");

        btnBack.setText("بازگشت");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel9.setText("میزان تحصیلات");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(txtUsername))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEducation)
                                .addGap(111, 111, 111))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNid, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel1))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnRemove)
                    .addComponent(btnBack))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try{
            if(txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() ||
                txtNid.getText().isEmpty() || txtUsername.getText().isEmpty() ||
                    txtPassword.getText().isEmpty() || txtPhone.getText().isEmpty() || 
                    txtAddress.getText().isEmpty() || txtEducation.getText().isEmpty()){
                throw new SabteAhvalException(CustomExceptionMessage.EMPTY_PARAMETERS, "FrmUsers", "");
            }
            if(!Utility.isNumeric(txtNid.getText()) || !Utility.isNumeric(txtPhone.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.NOT_NUMBER, "FrmUsers", "");
            }
            if(Utility.containsNumber(txtFirstName.getText()) || Utility.containsNumber(txtLastName.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.CONTAIN_NUMBER, "FrmUsers", "");
            }  
            if(txtNid.getText().length() != 10){
                throw new SabteAhvalException(CustomExceptionMessage.INVALID_LENGTH, "FrmUsers", "");
            }
        
            ResponsibleInformation responsibleInformation=new ResponsibleInformation();
            responsibleInformation.setFirstName(txtFirstName.getText());
            responsibleInformation.setLastName(txtLastName.getText());
            responsibleInformation.setPhone(txtPhone.getText());
            responsibleInformation.setIsAdmin(cmbRole.getSelectedIndex()==0?true:false);
            responsibleInformation.setUsername(txtUsername.getText());
            responsibleInformation.setPassword(txtPassword.getText());
            responsibleInformation.setAddress(txtAddress.getText());
            responsibleInformation.setNationalCode(txtNid.getText());
            responsibleInformation.setEducation(txtEducation.getText());
            int id = responsibleInformationController.create(responsibleInformation);
            Documents documents = new Documents();
            documents.setDiscriminatorColumn('R');
            documents.setDiscriminatorColumnId(id);
            documents.setLogDate(new Date());
            documents.setResponsibleId(this.frmMain.getResponsibleInformation());
            documents.setCosts(new BigInteger("0"));
            documents.setDescription(EventLogDescription.ADD_USER.name());
            documentsJpaController.create(documents);
            JOptionPane.showMessageDialog(this, "عملیات ثبت کاربر با موفقیت انجام شد","نتیجه ثبت کاربر",JOptionPane.INFORMATION_MESSAGE);

            fillJTable();
        }catch(SabteAhvalException e){
            JOptionPane.showMessageDialog(this, e.getCustomExceptionMessage().getPersianMsg(), e.getCustomExceptionMessage().getTitle(), JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try{
            if(txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() ||
                txtNid.getText().isEmpty() || txtUsername.getText().isEmpty() ||
                    txtPassword.getText().isEmpty() || txtPhone.getText().isEmpty() || 
                    txtAddress.getText().isEmpty() || txtEducation.getText().isEmpty()){
                throw new SabteAhvalException(CustomExceptionMessage.EMPTY_PARAMETERS, "FrmUsers", "");
            }
            if(!Utility.isNumeric(txtNid.getText()) || !Utility.isNumeric(txtPhone.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.NOT_NUMBER, "FrmUsers", "");
            }
            if(Utility.containsNumber(txtFirstName.getText()) || Utility.containsNumber(txtLastName.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.CONTAIN_NUMBER, "FrmUsers", "");
            }  
            if(txtNid.getText().length() != 10){
                throw new SabteAhvalException(CustomExceptionMessage.INVALID_LENGTH, "FrmUsers", "");
            }
            int selectedRow = tblUsers.getSelectedRow();
            int id = (int) model.getValueAt(selectedRow, 0);
            //ResponsibleInformation responsibleInformation=responsibleInformationController.findResponsibleInformation(id);
            ResponsibleInformation responsibleInformation = new ResponsibleInformation();
            responsibleInformation.setId(id);
            responsibleInformation.setFirstName(txtFirstName.getText());
            responsibleInformation.setLastName(txtLastName.getText());
            responsibleInformation.setPhone(txtPhone.getText());
            responsibleInformation.setIsAdmin(cmbRole.getSelectedIndex()==0?false:true);
            responsibleInformation.setUsername(txtUsername.getText());
            responsibleInformation.setPassword(txtPassword.getText());
            responsibleInformation.setAddress(txtAddress.getText()); 
            responsibleInformation.setNationalCode(txtNid.getText());
            responsibleInformation.setEducation(txtEducation.getText());
            
            responsibleInformationController.edit(responsibleInformation);
            Documents documents = new Documents();
            documents.setDiscriminatorColumn('R');
            documents.setDiscriminatorColumnId(id);
            documents.setLogDate(new Date());
            documents.setResponsibleId(this.frmMain.getResponsibleInformation());
            documents.setCosts(new BigInteger("0"));
            documents.setDescription(EventLogDescription.EDIT_USER.name());
            documentsJpaController.create(documents);
            JOptionPane.showMessageDialog(this, "عملیات ویراییش کاربر با موفقیت انجام شد","نتیجه,ویراییش کاربر",JOptionPane.INFORMATION_MESSAGE);
             
            fillJTable();
        }catch(SabteAhvalException e){
            JOptionPane.showMessageDialog(this, e.getCustomExceptionMessage().getPersianMsg(), e.getCustomExceptionMessage().getTitle(), JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow=tblUsers.getSelectedRow();
        int id=(int)model.getValueAt(selectedRow,0);
         try {
             responsibleInformationController.destroy(id);
             Documents documents = new Documents();
        documents.setDiscriminatorColumn('R');
        documents.setDiscriminatorColumnId(id);
        documents.setLogDate(new Date());
        documents.setResponsibleId(this.frmMain.getResponsibleInformation());
        documents.setCosts(new BigInteger("0"));
        documents.setDescription(EventLogDescription.REMOVE_USER.name());
        documentsJpaController.create(documents);
        JOptionPane.showMessageDialog(this, "عملیات حذف کاربر با موفقیت انجام شد","نتیجه,حذف کاربر",JOptionPane.INFORMATION_MESSAGE);
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(FrmUsers.class.getName()).log(Level.SEVERE, null, ex);
         }
        fillJTable();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
        // TODO add your handling code here:
        int selectedRow=tblUsers.getSelectedRow();
        int id=(int)model.getValueAt(selectedRow,0);
        ResponsibleInformation responsibleInformation=responsibleInformationController.findResponsibleInformation(id);
        
        txtFirstName.setText(responsibleInformation.getFirstName());
        txtLastName.setText(responsibleInformation.getLastName());
        txtPhone.setText(responsibleInformation.getPhone());
        cmbRole.setSelectedIndex(responsibleInformation.getIsAdmin()?1:0);
        txtUsername.setText(responsibleInformation.getUsername());
        txtPassword.setText(responsibleInformation.getPassword());
        txtAddress.setText(responsibleInformation.getAddress());
        txtNid.setText(responsibleInformation.getNationalCode());
        txtEducation.setText(responsibleInformation.getEducation());
        
        responsibleInformation.setIsAdmin(cmbRole.getSelectedIndex()==0?false:true);
      
        
       
        
    }//GEN-LAST:event_tblUsersMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        frmMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(FrmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FrmUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEducation;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNid;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}