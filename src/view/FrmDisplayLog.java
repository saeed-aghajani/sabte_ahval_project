/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.EventLogDescription;
import common.Utility;
import controller.DocumentsJpaController;
import controller.ResponsibleInformationJpaController;
import java.awt.ComponentOrientation;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Utilities;
import model.Documents;
import model.ResponsibleInformation;

/**
 *
 * @author saeed
 */
public class FrmDisplayLog extends javax.swing.JFrame {

    /**
     * Creates new form FrmRecordStatistics
     */
    FrmMain frmMain;
    DefaultTableModel model;
    DocumentsJpaController documentsJpaController; 
    ResponsibleInformationJpaController rijc;
    
   
    public FrmDisplayLog(FrmMain frmMain) {
        initComponents();
        this.frmMain = frmMain;
        setWindowInMiddle();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setRightToLeft();
        model=(DefaultTableModel)tblRecordStatistics.getModel();
        tblRecordStatistics.setModel(model);
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SabteAhvalPU");
        documentsJpaController = new DocumentsJpaController(emf);
        rijc = new ResponsibleInformationJpaController(emf);
        tblRecordStatistics.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        fillJTable();
    }
     private void setWindowInMiddle(){
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
     
    public void fillJTable(){
        model.setRowCount(0);                
        List<Documents> docs = documentsJpaController.findAllDocuments();
        String discriminator = "";
        for(int i=0; i<docs.size(); i++){
            if(docs.get(i).getDiscriminatorColumn()=='C')
                discriminator = "شناسنامه";
            else if(docs.get(i).getDiscriminatorColumn()=='N')
                discriminator = "کارت ملی";
            else if(docs.get(i).getDiscriminatorColumn()=='R')
                discriminator = "کاربر";
            model.addRow(new Object[]{docs.get(i).getId(), docs.get(i).getResponsibleId().getId(), 
                docs.get(i).getResponsibleId().getUsername(),
                Utility.gregorian2jalali(docs.get(i).getLogDate()), discriminator,
                    docs.get(i).getDiscriminatorColumnId(), EventLogDescription.valueOf(docs.get(i).getDescription()).getPersianMsg()});
        }        
    }
    
    void setRightToLeft(){
        this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecordStatistics = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("نمایش اطلاعات");

        tblRecordStatistics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "شناسه", "شناسه ی کاربری", "نام کاربری", "تاریخ", "جدول مورد تغییر", "شناسه در جدول مورد تغییر", "توضیحات"
            }
        ));
        jScrollPane1.setViewportView(tblRecordStatistics);

        btnBack.setText("بازگشت");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1491, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmDisplayLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDisplayLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDisplayLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDisplayLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new FrmRecordStatistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRecordStatistics;
    // End of variables declaration//GEN-END:variables
}
