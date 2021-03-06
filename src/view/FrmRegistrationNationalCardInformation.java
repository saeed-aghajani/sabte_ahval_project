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
import model.NationalCard;

/**
 *
 * @author saeed
 */
public class FrmRegistrationNationalCardInformation extends javax.swing.JFrame {

    /**
     * Creates new form frmRegistrationNationalCardInformation
     */
    FrmMain frmMain;
    DefaultTableModel model;
    NationalCardJpaController nationalController;
    DocumentsJpaController documentsJpaController;
    
    public FrmRegistrationNationalCardInformation(FrmMain frmMain) {
        initComponents();
        setWindowInMiddle();
        this.frmMain = frmMain;
        model=(DefaultTableModel)tblNationalCard.getModel();
        tblNationalCard.setModel(model);
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SabteAhvalPU");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nationalController=new NationalCardJpaController(emf);
        documentsJpaController = new DocumentsJpaController(emf);
        tblNationalCard.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        fillJTable();
        setCurrentDate();
    }
     private void setWindowInMiddle(){
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void fillJTable(){
        model.setRowCount(0);                
        List<NationalCard> nationalCard = nationalController.findAllNationalCard();
        for(int i=0; i<nationalCard.size(); i++){
        model.addRow(new Object[]{nationalCard.get(i).getId(),nationalCard.get(i).getNid()
                ,nationalCard.get(i).getFirstName(),nationalCard.get(i).getLastName(),
                nationalCard.get(i).getFatherName(),Utility.gregorian2jalali(nationalCard.get(i).getBirthdate())});
        }        
    }
    
     private void setCurrentDate(){
        String strJaalali=Utility.gregorian2jalali(new Date());
        String[] jalaliParts=strJaalali.split("-");
        int currentYear = Integer.parseInt(jalaliParts[0]);
        for(int years = 1300; years <= currentYear; years++) {
            cmbNationalCardBirthdateYear.addItem(years + "");
            cmbNationalCardExpireYear.addItem(years + "");
        }
          
        for(int i=currentYear+1;i<currentYear+6;i++){
            cmbNationalCardExpireYear.addItem(i + "");
        }
        cmbNationalCardBirthdateYear.setSelectedIndex(currentYear - 1300);
        cmbNationalCardExpireYear.setSelectedIndex(currentYear + 5 - 1300);
        cmbNationalCardBirthdateMounth.setSelectedIndex(Integer.parseInt(jalaliParts[1])-1);
        cmbNationalCardBirthdateDay.setSelectedIndex(Integer.parseInt(jalaliParts[2])-1);
        cmbNationalCardExpireMounth.setSelectedIndex(Integer.parseInt(jalaliParts[1])-1);
        cmbNationalCardExpireDay.setSelectedIndex(Integer.parseInt(jalaliParts[2])-1);
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
        txtNId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFathersName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ComboNationalCardReplica = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnNationalCardAdd = new javax.swing.JButton();
        btnNationalCardEdite = new javax.swing.JButton();
        btnNationalCardRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNationalCard = new javax.swing.JTable();
        cmbNationalCardBirthdateYear = new javax.swing.JComboBox<>();
        cmbNationalCardBirthdateMounth = new javax.swing.JComboBox<>();
        cmbNationalCardBirthdateDay = new javax.swing.JComboBox<>();
        cmbNationalCardExpireDay = new javax.swing.JComboBox<>();
        cmbNationalCardExpireMounth = new javax.swing.JComboBox<>();
        cmbNationalCardExpireYear = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ثبت کارت ملی");

        jLabel1.setText("شماره ملی");

        jLabel2.setText("نام");

        jLabel3.setText("نام خانوادگی");

        jLabel4.setText("نام پدر");

        jLabel5.setText("تاریخ تولد");

        jLabel8.setText("پایان اعتبار");

        ComboNationalCardReplica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ندارد", "دارد" }));
        ComboNationalCardReplica.setEnabled(false);
        ComboNationalCardReplica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNationalCardReplicaActionPerformed(evt);
            }
        });

        jLabel11.setText("المثنی");

        btnNationalCardAdd.setText("ثبت");
        btnNationalCardAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNationalCardAddActionPerformed(evt);
            }
        });

        btnNationalCardEdite.setText("ویراییش");
        btnNationalCardEdite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNationalCardEditeActionPerformed(evt);
            }
        });

        btnNationalCardRemove.setText("حذف");
        btnNationalCardRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNationalCardRemoveActionPerformed(evt);
            }
        });

        tblNationalCard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "شناسه", "شماره ملی", "نام ", "نام خانوادگی", "نام پدر", "تاریخ تولد"
            }
        ));
        tblNationalCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNationalCardMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNationalCard);

        cmbNationalCardBirthdateMounth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر ", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));

        cmbNationalCardBirthdateDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbNationalCardExpireDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbNationalCardExpireMounth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر ", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));

        jLabel6.setText("سال");

        jLabel7.setText("سال");

        jLabel9.setText("ماه");

        jLabel10.setText("ماه");

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
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(196, 196, 196)
                        .addComponent(btnNationalCardRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cmbNationalCardExpireYear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel7))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cmbNationalCardBirthdateYear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel6)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cmbNationalCardBirthdateMounth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel9))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cmbNationalCardExpireMounth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel10))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnNationalCardEdite, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)))
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbNationalCardExpireDay, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbNationalCardBirthdateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(ComboNationalCardReplica, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFathersName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(16, 16, 16))))))
                            .addComponent(btnNationalCardAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFathersName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbNationalCardBirthdateDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNationalCardBirthdateMounth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNationalCardBirthdateYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbNationalCardExpireDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNationalCardExpireMounth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNationalCardExpireYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ComboNationalCardReplica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNationalCardAdd)
                    .addComponent(btnNationalCardEdite)
                    .addComponent(btnNationalCardRemove)
                    .addComponent(btnBack))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboNationalCardReplicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNationalCardReplicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNationalCardReplicaActionPerformed

    private void btnNationalCardRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNationalCardRemoveActionPerformed
        // TODO add your handling code here:
        NationalCard nationalCard=new NationalCard();
        int selectedRow = tblNationalCard.getSelectedRow();
        int id = (int) model.getValueAt(selectedRow, 0);
        try {
            nationalController.destroy(id);
            Documents documents = new Documents();
            documents.setDiscriminatorColumn('N');
            documents.setDiscriminatorColumnId(id);
            documents.setLogDate(new Date());
            documents.setResponsibleId(this.frmMain.getResponsibleInformation());
            documents.setCosts(new BigInteger("0"));
            documents.setDescription(EventLogDescription.REMOVE_NATIONAL_CARD.name());
            documentsJpaController.create(documents);
            JOptionPane.showMessageDialog(this, "عملیات حذف با موفقیت انجام شد","نتیجه حذف",JOptionPane.INFORMATION_MESSAGE);

            fillJTable();
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FrmRegistrationNationalCardInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNationalCardRemoveActionPerformed

    private void btnNationalCardAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNationalCardAddActionPerformed
        // TODO add your handling code here:
        try{    
            if(txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() ||
                txtFathersName.getText().isEmpty() || txtNId.getText().isEmpty()){
                throw new SabteAhvalException(CustomExceptionMessage.EMPTY_PARAMETERS, "FrmRegistrationNationalCardInformation", "");
            }
            if(!Utility.isNumeric(txtNId.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.NOT_NUMBER, "FrmRegistrationNationalCardInformation", "");
            }
            if(Utility.containsNumber(txtFirstName.getText()) || Utility.containsNumber(txtLastName.getText()) || 
                    Utility.containsNumber(txtFathersName.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.CONTAIN_NUMBER, "FrmRegistrationNationalCardInformation", "");
            }  
            if(txtNId.getText().length() != 10){
                throw new SabteAhvalException(CustomExceptionMessage.INVALID_LENGTH, "FrmRegistrationNationalCardInformation", "");
            }
        
            NationalCard nationalCard=new NationalCard();
            nationalCard.setNid(txtNId.getText());
            nationalCard.setFirstName(txtFirstName.getText());
            nationalCard.setLastName(txtLastName.getText());
            nationalCard.setFatherName(txtFathersName.getText());
            int jalaliMonth = cmbNationalCardBirthdateMounth.getSelectedIndex()+1;
            nationalCard.setBirthdate(Utility.jalaliString2Date(cmbNationalCardBirthdateYear.getSelectedItem().toString()
                    + "-" + jalaliMonth + "-" + cmbNationalCardBirthdateDay.getSelectedItem().toString()));
            int jalaliExpMonth = cmbNationalCardExpireMounth.getSelectedIndex()+1;
            nationalCard.setExpireDate(Utility.jalaliString2Date(cmbNationalCardExpireYear.getSelectedItem().toString()
                    + "-" +jalaliExpMonth + "-" + cmbNationalCardExpireYear.getSelectedItem().toString()));
            nationalCard.setIsIssued(false);
            nationalCard.setIsReplica(false);
            int nationalCardId = nationalController.create(nationalCard);

            Documents documents = new Documents();
            documents.setDiscriminatorColumn('N');
            documents.setDiscriminatorColumnId(nationalCardId);
            documents.setLogDate(new Date());
            documents.setResponsibleId(this.frmMain.getResponsibleInformation());
            documents.setCosts(new BigInteger("0"));
            documents.setDescription(EventLogDescription.REGISTER_NATIONAL_CARD.name());
            documentsJpaController.create(documents);

            JOptionPane.showMessageDialog(this, "عملیات ثبت با موفقیت انجام شد","نتیجه ثبت",JOptionPane.INFORMATION_MESSAGE);

            fillJTable();
        }catch(SabteAhvalException e){
            JOptionPane.showMessageDialog(this, e.getCustomExceptionMessage().getPersianMsg(), e.getCustomExceptionMessage().getTitle(), JOptionPane.WARNING_MESSAGE); 
        }
        
    }//GEN-LAST:event_btnNationalCardAddActionPerformed

    private void btnNationalCardEditeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNationalCardEditeActionPerformed
        // TODO add your handling code here:
        try{
            
                    if(txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() ||
                txtFathersName.getText().isEmpty() || txtNId.getText().isEmpty()){
                throw new SabteAhvalException(CustomExceptionMessage.EMPTY_PARAMETERS, "FrmRegistrationNationalCardInformation", "");
            }
            if(!Utility.isNumeric(txtNId.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.NOT_NUMBER, "FrmRegistrationNationalCardInformation", "");
            }
            if(Utility.containsNumber(txtFirstName.getText()) || Utility.containsNumber(txtLastName.getText()) || 
                    Utility.containsNumber(txtFathersName.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.CONTAIN_NUMBER, "FrmRegistrationNationalCardInformation", "");
            }  
            if(txtNId.getText().length() != 10){
                throw new SabteAhvalException(CustomExceptionMessage.INVALID_LENGTH, "FrmRegistrationNationalCardInformation", "");
            }
        
            int selectedRow = tblNationalCard.getSelectedRow();
            int id = (int) model.getValueAt(selectedRow, 0);
            NationalCard nationalCard=new NationalCard();
            nationalCard.setId(id);
             nationalCard.setNid(txtNId.getText());
            nationalCard.setFirstName(txtFirstName.getText());
            nationalCard.setLastName(txtLastName.getText());
            nationalCard.setFatherName(txtFathersName.getText());
            int jalaliMonth = cmbNationalCardBirthdateMounth.getSelectedIndex();
            nationalCard.setBirthdate(Utility.jalaliString2Date(cmbNationalCardBirthdateYear.getSelectedItem().toString()+"-"+jalaliMonth+"-"+cmbNationalCardBirthdateDay.
            getSelectedItem().toString()));

            int ExpirejalaliMonth = cmbNationalCardExpireMounth.getSelectedIndex();
            nationalCard.setExpireDate(Utility.jalaliString2Date(cmbNationalCardExpireYear.getSelectedItem().toString()+"-"+ExpirejalaliMonth+"-"+cmbNationalCardExpireYear.
            getSelectedItem().toString()));
            nationalCard.setIsIssued(false);
            nationalCard.setIsReplica(false);
            nationalController.edit(nationalCard);
            Documents documents = new Documents();
            documents.setDiscriminatorColumn('N');
            documents.setDiscriminatorColumnId(id);
            documents.setLogDate(new Date());
            documents.setResponsibleId(this.frmMain.getResponsibleInformation());
            documents.setCosts(new BigInteger("0"));
            documents.setDescription(EventLogDescription.EDIT_NATIONAL_CARD.name());
            documentsJpaController.create(documents);
            JOptionPane.showMessageDialog(this, "عملیات ویرایش با موفقیت انجام شد","نتیجه ویرایش",JOptionPane.INFORMATION_MESSAGE);
           
             fillJTable();
        }catch(SabteAhvalException e){
            JOptionPane.showMessageDialog(this, e.getCustomExceptionMessage().getPersianMsg(), e.getCustomExceptionMessage().getTitle(), JOptionPane.WARNING_MESSAGE); 
        }
        
    }//GEN-LAST:event_btnNationalCardEditeActionPerformed

    private void tblNationalCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNationalCardMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblNationalCard.getSelectedRow();
        int id = (int) model.getValueAt(selectedRow, 0);
        NationalCard nationalCard=nationalController.findNationalCard(id);
        txtNId.setText(nationalCard.getNid());
        txtFirstName.setText(nationalCard.getFirstName());
        txtLastName.setText(nationalCard.getLastName());
        txtFathersName.setText(nationalCard.getFatherName());
        ComboNationalCardReplica.setSelectedIndex(nationalCard.getIsReplica()?0:1);
    }//GEN-LAST:event_tblNationalCardMouseClicked

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
            java.util.logging.Logger.getLogger(FrmRegistrationNationalCardInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrationNationalCardInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrationNationalCardInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrationNationalCardInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FrmRegistrationNationalCardInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboNationalCardReplica;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNationalCardAdd;
    private javax.swing.JButton btnNationalCardEdite;
    private javax.swing.JButton btnNationalCardRemove;
    private javax.swing.JComboBox<String> cmbNationalCardBirthdateDay;
    private javax.swing.JComboBox<String> cmbNationalCardBirthdateMounth;
    private javax.swing.JComboBox<String> cmbNationalCardBirthdateYear;
    private javax.swing.JComboBox<String> cmbNationalCardExpireDay;
    private javax.swing.JComboBox<String> cmbNationalCardExpireMounth;
    private javax.swing.JComboBox<String> cmbNationalCardExpireYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNationalCard;
    private javax.swing.JTextField txtFathersName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNId;
    // End of variables declaration//GEN-END:variables
}
