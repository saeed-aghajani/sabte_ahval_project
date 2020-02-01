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
import controller.NationalCardJpaController;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Documents;
import model.NationalCard;

/**
 *
 * @author saeed
 */
public class FrmDeliverNid extends javax.swing.JFrame {

    /**
     * Creates new form frmNIdDelivery
     */
    FrmMain frmMain;
    
    NationalCardJpaController nationalCardJpaController;
    DocumentsJpaController documentsJpaController;
     
     
    public FrmDeliverNid(FrmMain frmMain) {
        initComponents();
        this.frmMain = frmMain;
        setWindowInMiddle();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SabteAhvalPU");
        nationalCardJpaController = new NationalCardJpaController(emf);
        documentsJpaController = new DocumentsJpaController(emf);
        String strJalali=Utility.gregorian2jalali(new Date());
        String[] jalaliParts=strJalali.split("-");
        int currentYear = Integer.parseInt(jalaliParts[0]);
        for(int years = 1300; years <= currentYear; years++) {
            cmbDeliveYear.addItem(years + "");
        }
        cmbDeliveYear.setSelectedIndex(currentYear-1300);
        cmbDeliverMonth.setSelectedIndex(Integer.parseInt(jalaliParts[1])-1);
        cmbDeliverDay.setSelectedIndex(Integer.parseInt(jalaliParts[2])-1);    
    
    }
    private void setWindowInMiddle(){
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNid = new javax.swing.JTextField();
        btnDelivery = new javax.swing.JButton();
        btnDeliveryReturn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbDeliverDay = new javax.swing.JComboBox<>();
        cmbDeliverMonth = new javax.swing.JComboBox<>();
        cmbDeliveYear = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("تحویل کارت ملی");

        jLabel1.setText("کد ملی");

        btnDelivery.setText("تحویل");
        btnDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryActionPerformed(evt);
            }
        });

        btnDeliveryReturn.setText("بازگشت");
        btnDeliveryReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryReturnActionPerformed(evt);
            }
        });

        jLabel2.setText("تاریخ");

        jLabel3.setText("/");

        jLabel4.setText("/");

        cmbDeliverDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbDeliverMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(cmbDeliveYear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbDeliverMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDeliverDay, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(19, 19, 19)
                        .addComponent(txtNid, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeliveryReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(btnDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cmbDeliverDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDeliverMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDeliveYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelivery)
                    .addComponent(btnDeliveryReturn))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryActionPerformed
        // TODO add your handling code here:
         try{
             
             if(txtNid.getText().isEmpty()){
                throw new SabteAhvalException(CustomExceptionMessage.EMPTY_PARAMETERS, "FrmIssuanceNid", "");
            }
            if(!Utility.isNumeric(txtNid.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.NOT_NUMBER, "FrmIssuanceNid", "");
            }  
            if(txtNid.getText().length() != 10){
                throw new SabteAhvalException(CustomExceptionMessage.INVALID_LENGTH, "FrmIssuanceNid", "");
            }
            NationalCard nc = nationalCardJpaController.findNationalCardByNid(txtNid.getText());
            
            int reply = JOptionPane.showConfirmDialog(null, "مبلغ چهل هزار تومان بابت کارمزد خدمات دریافت شود", "هزینه کارمزد", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){
            int month = cmbDeliverMonth.getSelectedIndex()+1;
            Date deliverDate = Utility.jalaliString2Date(cmbDeliveYear.getSelectedItem().toString()
                    +"-"+month+"-"+cmbDeliverDay.getSelectedItem().toString());
            nationalCardJpaController.updateNationalCardDelivery(txtNid.getText(), true, deliverDate);
            
            Documents documents = new Documents();
            documents.setDiscriminatorColumn('N');
            documents.setDiscriminatorColumnId(nc.getId());
            documents.setLogDate(new Date());
            documents.setResponsibleId(this.frmMain.getResponsibleInformation());
            documents.setCosts(new BigInteger("40000"));
            documents.setDescription(EventLogDescription.DELIVER_NATIONAL_CARD.name());                        
            documentsJpaController.create(documents);
            JOptionPane.showMessageDialog(this, "عملیات تحویل با موفقیت انجام شد","نتیجه تحویل",JOptionPane.INFORMATION_MESSAGE);
            }
            
            else if(reply == JOptionPane.NO_OPTION) {
               JOptionPane.showMessageDialog(this, "بدون پرداخت وجه تحویل امکان پذیر نیست", "اخطار", JOptionPane.WARNING_MESSAGE);
            }
         }
     catch(SabteAhvalException e){
            JOptionPane.showMessageDialog(this, e.getCustomExceptionMessage().getPersianMsg(), e.getCustomExceptionMessage().getTitle(), JOptionPane.ERROR_MESSAGE);
}

                                              

    }//GEN-LAST:event_btnDeliveryActionPerformed

    private void btnDeliveryReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryReturnActionPerformed
        // TODO add your handling code here:
        frmMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDeliveryReturnActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDeliverNid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDeliverNid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDeliverNid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDeliverNid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FrmDeliverNid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelivery;
    private javax.swing.JButton btnDeliveryReturn;
    private javax.swing.JComboBox<String> cmbDeliveYear;
    private javax.swing.JComboBox<String> cmbDeliverDay;
    private javax.swing.JComboBox<String> cmbDeliverMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNid;
    // End of variables declaration//GEN-END:variables
}
