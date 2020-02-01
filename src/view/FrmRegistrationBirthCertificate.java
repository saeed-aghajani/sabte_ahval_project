/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.EventLogDescription;
import common.CustomExceptionMessage;
import common.SabteAhvalException;
import common.Utility;
import controller.BirthCertificateJpaController;
import controller.DocumentsJpaController;
import controller.exceptions.NonexistentEntityException;
import java.awt.ComponentOrientation;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.DocumentFilter;
import javax.swing.text.InternationalFormatter;
import model.BirthCertificate;
import model.Documents;

/**
 *
 * @author saeed
 */
public final class FrmRegistrationBirthCertificate extends javax.swing.JFrame {

    /**
     * Creates new form frmBirthCertificateIssuance
     */
    FrmMain frmMain;
    
    boolean permitJalaliUpdate = false;
    boolean permitHijriUpdate = false;
    DefaultTableModel model;
    BirthCertificateJpaController birthCertificateController;
    DocumentsJpaController documentsJpaController;
    
    public FrmRegistrationBirthCertificate(FrmMain frmMain) {
        initComponents();
        this.frmMain = frmMain;
        setWindowInMiddle();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model=(DefaultTableModel)tblRegisterBirthCertificate.getModel();
        tblRegisterBirthCertificate.setModel(model);
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SabteAhvalPU");
        birthCertificateController=new BirthCertificateJpaController(emf);
        documentsJpaController = new DocumentsJpaController(emf);
        tblRegisterBirthCertificate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        fillJTable();
        setCurrentDate();
        permitJalaliUpdate = true;
        permitHijriUpdate = true;
    }
     private void setWindowInMiddle(){
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
     
    public void fillJTable(){
        model.setRowCount(0);                
        List<BirthCertificate> birthCertificateList = birthCertificateController.findBirthCertificates();
        for(int i=0; i<birthCertificateList.size(); i++){
            model.addRow(new Object[]{birthCertificateList.get(i).getId(),birthCertificateList.get(i).getFirstName(),
            birthCertificateList.get(i).getLastName(),birthCertificateList.get(i).getCertificateNumber(),
            birthCertificateList.get(i).getFatherName(),
            Utility.gregorian2jalali(birthCertificateList.get(i).getBirthdate())});
        }        
    }

    private void setCurrentDate(){
        String strJalali = Utility.gregorian2jalali(new Date());
        String[] Jalaliparts = strJalali.split("-");
        for(int years = 1300; years <= Integer.parseInt(Jalaliparts[0]); years++) {
            cmbJalaliYear.addItem(years+"");
            cmbCertificatRegisterYear.addItem(years+"");
        }
        
        String strHijri = Utility.gregorian2hijri(new Date());
        String[] Hijriparts = strHijri.split("-");
         for(int years = 1300; years <= Integer.parseInt(Hijriparts[0]); years++) {
            cmbHijriYear.addItem(years+"");
        }
         
         
        cmbJalaliYear.setSelectedIndex(Integer.parseInt(Jalaliparts[0])-1300);        
        cmbJalaliMonth.setSelectedIndex(Integer.parseInt(Jalaliparts[1])-1);
        cmbJalaliDay.setSelectedIndex(Integer.parseInt(Jalaliparts[2])-1);
        cmbCertificatRegisterYear.setSelectedIndex(Integer.parseInt(Jalaliparts[0])-1300);
        cmbCertificatRegisterMounth.setSelectedIndex(Integer.parseInt(Jalaliparts[1])-1);
        cmbCertificatRegisterDay.setSelectedIndex(Integer.parseInt(Jalaliparts[2])-1);
        
        
        cmbHijriYear.setSelectedIndex(Integer.parseInt(Hijriparts[0])-1300);
        cmbHijriMonth.setSelectedIndex(Integer.parseInt(Hijriparts[1])-1);
        cmbHijriDay.setSelectedIndex(Integer.parseInt(Hijriparts[2])-1);
        cmbCertificatRegisterMounth.setSelectedIndex(Integer.parseInt(Jalaliparts[1])-1);
        cmbCertificatRegisterDay.setSelectedIndex(Integer.parseInt(Jalaliparts[2])-1);
        
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
        jTable1 = new javax.swing.JTable();
        lblCertificateName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblCertificateFamilyName = new javax.swing.JLabel();
        txtlLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCertNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSeri = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSeryal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBirthLocation = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFathersName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMothersName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cmbCertificateGender = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnCertificateAdd = new javax.swing.JButton();
        btnCertificateEdite = new javax.swing.JButton();
        btnCertificateRemove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegisterBirthCertificate = new javax.swing.JTable();
        cmbJalaliMonth = new javax.swing.JComboBox<>();
        cmbJalaliDay = new javax.swing.JComboBox<>();
        cmbHijriMonth = new javax.swing.JComboBox<>();
        cmbHijriDay = new javax.swing.JComboBox<>();
        cmbCertificatRegisterMounth = new javax.swing.JComboBox<>();
        cmbCertificatRegisterDay = new javax.swing.JComboBox<>();
        cmbJalaliYear = new javax.swing.JComboBox<>();
        cmbCertificatRegisterYear = new javax.swing.JComboBox<>();
        cmbHijriYear = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ثبت شناسنامه");

        lblCertificateName.setText("نام ");

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        lblCertificateFamilyName.setText("نام خانوادگی");

        jLabel3.setText("شماره شناسنامه");

        jLabel4.setText("سری");

        jLabel5.setText("سریال");

        jLabel6.setText("محل تولد");

        txtBirthLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthLocationActionPerformed(evt);
            }
        });

        jLabel7.setText("سال شمسی");

        jLabel8.setText("سال قمری");

        jLabel9.setText("ماه");

        jLabel10.setText("روز");

        jLabel11.setText("ماه");

        jLabel12.setText("روز");

        jLabel13.setText("نام پدر");

        jLabel14.setText("نام مادر");

        jLabel15.setText("جنسیت");

        cmbCertificateGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "مرد", "زن" }));

        jLabel16.setText("سال ثبت");

        jLabel17.setText("ماه");

        jLabel18.setText("روز");

        btnCertificateAdd.setText("ثبت");
        btnCertificateAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificateAddActionPerformed(evt);
            }
        });

        btnCertificateEdite.setText("ویراییش");
        btnCertificateEdite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificateEditeActionPerformed(evt);
            }
        });

        btnCertificateRemove.setText("حذف");
        btnCertificateRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificateRemoveActionPerformed(evt);
            }
        });

        tblRegisterBirthCertificate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "شناسه", "نام", "نام خانوادگی", "شماره شناسنامه", "نام پدر", "تاریخ تولد"
            }
        ));
        tblRegisterBirthCertificate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegisterBirthCertificateMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRegisterBirthCertificate);

        cmbJalaliMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));
        cmbJalaliMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJalaliMonthActionPerformed(evt);
            }
        });

        cmbJalaliDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cmbJalaliDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJalaliDayActionPerformed(evt);
            }
        });

        cmbHijriMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "محرم", "صفر", "ربیع الاول", "ربیع الثانی", "جمادی‌الاول", "جمادی‌الثانی", "رجب", "شعبان", "رمضان", "شوال", "ذیقعده", "ذیحجه" }));
        cmbHijriMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHijriMonthActionPerformed(evt);
            }
        });

        cmbHijriDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cmbHijriDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHijriDayActionPerformed(evt);
            }
        });

        cmbCertificatRegisterMounth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));

        cmbCertificatRegisterDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbJalaliYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJalaliYearActionPerformed(evt);
            }
        });

        cmbHijriYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHijriYearActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(cmbHijriMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbJalaliMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbCertificatRegisterDay, 0, 80, Short.MAX_VALUE)
                            .addComponent(cmbHijriDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbJalaliDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCertificatRegisterMounth, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbJalaliYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbCertificatRegisterYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbCertificateGender, 0, 94, Short.MAX_VALUE)
                    .addComponent(txtMothersName)
                    .addComponent(txtFathersName)
                    .addComponent(cmbHijriYear, 0, 96, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtBirthLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtlLastName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCertNumber, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSeri, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSeryal, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblCertificateName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblCertificateFamilyName))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCertificateRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btnCertificateEdite, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnCertificateAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCertificateName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cmbJalaliMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbJalaliDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbJalaliYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCertificateFamilyName)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8)
                    .addComponent(cmbHijriMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHijriDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHijriYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCertNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13)
                    .addComponent(txtFathersName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSeri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtMothersName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSeryal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cmbCertificateGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCertificatRegisterMounth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCertificatRegisterDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(txtBirthLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbCertificatRegisterYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCertificateAdd)
                    .addComponent(btnCertificateEdite)
                    .addComponent(btnCertificateRemove)
                    .addComponent(btnBack))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateHijriByJalali(){
        if(!permitHijriUpdate)
            return;
        try{
            permitJalaliUpdate = false;
            int jalaliMonth = cmbJalaliMonth.getSelectedIndex()+1;
            String hijriDate=Utility.jalali2hijri(cmbJalaliYear.getSelectedItem().toString()
                   +"-"+jalaliMonth+"-"+cmbJalaliDay.getSelectedItem().toString());
            System.out.println(cmbJalaliDay.getSelectedItem().toString());
            String[] parts=hijriDate.split("-");
            cmbHijriYear.setSelectedIndex(Integer.parseInt(parts[0])-1300);
            cmbHijriMonth.setSelectedIndex(Integer.parseInt(parts[1])-1);
            cmbHijriDay.setSelectedIndex(Integer.parseInt(parts[2])-1);
            permitJalaliUpdate = true;
        }catch(Exception e){
            
        }
    }
    
    private void updateJalaliByHijri(){
        if(!permitJalaliUpdate)
            return;
        try{
            permitHijriUpdate = false;
            int hijriMonth = cmbHijriMonth.getSelectedIndex()+1;
            String jalaliDate=Utility.hijri2jalali(cmbHijriYear.getSelectedItem().toString()
                   +"-"+hijriMonth+"-"+cmbHijriDay.getSelectedItem().toString());
            String[] parts=jalaliDate.split("-");
            cmbJalaliYear.setSelectedIndex(Integer.parseInt(parts[0])-1300);
            cmbJalaliMonth.setSelectedIndex(Integer.parseInt(parts[1])-1);
            cmbJalaliDay.setSelectedIndex(Integer.parseInt(parts[2])-1);
            permitHijriUpdate = true;
        }catch(Exception e){
            
        }
    }
    
    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btnCertificateAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificateAddActionPerformed
        // TODO add your handling code here:
        try{
            if(txtSeri.getText().isEmpty() || txtBirthLocation.getText().isEmpty() ||
                txtCertNumber.getText().isEmpty() || txtFathersName.getText().isEmpty() ||
                txtMothersName.getText().isEmpty() || txtFirstName.getText().isEmpty() ||
                txtSeryal.getText().isEmpty() || txtlLastName.getText().isEmpty()){
                throw new SabteAhvalException(CustomExceptionMessage.EMPTY_PARAMETERS, "FrmRegistrationBirthCertificate", "");
            }
            if(!Utility.isNumeric(txtCertNumber.getText()) || !Utility.isNumeric(txtSeryal.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.NOT_NUMBER, "FrmRegistrationBirthCertificate", "");
            }
            if(Utility.containsNumber(txtBirthLocation.getText()) || Utility.containsNumber(txtFathersName.getText()) || 
                    Utility.containsNumber(txtMothersName.getText()) || Utility.containsNumber(txtFirstName.getText())
                    || Utility.containsNumber(txtlLastName.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.CONTAIN_NUMBER, "FrmRegistrationBirthCertificate", "");
            }           
                                    
            BirthCertificate birthcertificate=new BirthCertificate();
            birthcertificate.setFirstName(txtFirstName.getText());
            birthcertificate.setLastName(txtlLastName.getText());
            birthcertificate.setCertificateNumber(txtCertNumber.getText());
            birthcertificate.setSeri(txtSeri.getText());
            birthcertificate.setSeryal(txtSeryal.getText());
            birthcertificate.setBirthLocation(txtBirthLocation.getText());
            int jalaliMonth = cmbJalaliMonth.getSelectedIndex()+1;
            birthcertificate.setBirthdate(Utility.jalaliString2Date(cmbJalaliYear.getSelectedItem().toString()
                    +"-"+jalaliMonth+"-"+cmbJalaliDay.getSelectedItem().toString()));
            birthcertificate.setFatherName(txtFathersName.getText());
            birthcertificate.setMotherName(txtMothersName.getText());
            birthcertificate.setGender(cmbCertificateGender.getSelectedIndex() == 0 ? 'M' : 'F');
            int registerJalaliMonth = cmbCertificatRegisterMounth.getSelectedIndex()+1;

            birthcertificate.setRegisterDate(Utility.jalaliString2Date(cmbCertificatRegisterYear.getSelectedItem().toString()+"-"+registerJalaliMonth+"-"+cmbCertificatRegisterDay.getSelectedItem().toString()));
            birthcertificate.setIsIssued(false);
            birthcertificate.setIsDelivered(false);

            int certId = birthCertificateController.create(birthcertificate);
            Documents documents = new Documents();
            documents.setDiscriminatorColumn('C');
            documents.setDiscriminatorColumnId(certId);
            documents.setLogDate(new Date());
            documents.setResponsibleId(this.frmMain.getResponsibleInformation());
            documents.setDescription(EventLogDescription.REGISTER_BIRTH_CERTIFICATE.name());
            documents.setCosts(new BigInteger("0"));
            documentsJpaController.create(documents);
            JOptionPane.showMessageDialog(this, "عملیات ثبت با موفقیت انجام شد","نتیجه ثبت",JOptionPane.INFORMATION_MESSAGE);        

            fillJTable();
        }catch(SabteAhvalException e){
            JOptionPane.showMessageDialog(this, e.getCustomExceptionMessage().getPersianMsg(), e.getCustomExceptionMessage().getTitle(), JOptionPane.WARNING_MESSAGE); 
        }
        
    }//GEN-LAST:event_btnCertificateAddActionPerformed

    private void cmbHijriDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHijriDayActionPerformed
        // TODO add your handling code here:
        updateJalaliByHijri();
    }//GEN-LAST:event_cmbHijriDayActionPerformed

    private void txtBirthLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthLocationActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtBirthLocationActionPerformed

    private void btnCertificateEditeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificateEditeActionPerformed
        // TODO add your handling code here:
        try{
            if(txtSeri.getText().isEmpty() || txtBirthLocation.getText().isEmpty() ||
                txtCertNumber.getText().isEmpty() || txtFathersName.getText().isEmpty() ||
                txtMothersName.getText().isEmpty() || txtFirstName.getText().isEmpty() ||
                txtSeryal.getText().isEmpty() || txtlLastName.getText().isEmpty()){
                throw new SabteAhvalException(CustomExceptionMessage.EMPTY_PARAMETERS, "FrmRegistrationBirthCertificate", "");
            }
            if(!Utility.isNumeric(txtCertNumber.getText()) || !Utility.isNumeric(txtSeryal.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.NOT_NUMBER, "FrmRegistrationBirthCertificate", "");
            }
            if(Utility.containsNumber(txtBirthLocation.getText()) || Utility.containsNumber(txtFathersName.getText()) || 
                    Utility.containsNumber(txtMothersName.getText()) || Utility.containsNumber(txtFirstName.getText())
                    || Utility.containsNumber(txtlLastName.getText())){
                throw new SabteAhvalException(CustomExceptionMessage.CONTAIN_NUMBER, "FrmRegistrationBirthCertificate", "");
            }   
        
            int selectedRow=tblRegisterBirthCertificate.getSelectedRow();
            int id=(int)model.getValueAt(selectedRow, 0);
            BirthCertificate birthcertificate=new BirthCertificate();
            birthcertificate.setId(id);
            birthcertificate.setFirstName(txtFirstName.getText());
            birthcertificate.setLastName(txtlLastName.getText());
            birthcertificate.setFatherName(txtFathersName.getText());
            birthcertificate.setMotherName(txtMothersName.getText());
            birthcertificate.setCertificateNumber(txtCertNumber.getText());
            birthcertificate.setSeri(txtSeri.getText());
            birthcertificate.setSeryal(txtSeryal.getText());
            birthcertificate.setBirthLocation(txtBirthLocation.getText());
            birthcertificate.setGender(cmbCertificateGender.getSelectedIndex() == 0 ? 'M' : 'F');
            int jalalyMounth=cmbJalaliMonth.getSelectedIndex()+1;
            birthcertificate.setBirthdate(Utility.jalaliString2Date(cmbJalaliYear.getSelectedItem().toString()+"-"+jalalyMounth+"-"+cmbJalaliDay.getSelectedItem().toString()));
            int registerJalaliMonth = cmbCertificatRegisterMounth.getSelectedIndex()+1;
            birthcertificate.setIssueDate(Utility.jalaliString2Date(cmbCertificatRegisterYear.getSelectedItem().toString()+"-"+registerJalaliMonth+"-"+cmbCertificatRegisterDay.getSelectedItem().toString()));
            birthCertificateController.create(birthcertificate);
            
            birthCertificateController.edit(birthcertificate);
            Documents documents = new Documents();
            documents.setDiscriminatorColumn('C');
            documents.setDiscriminatorColumnId(id);
            documents.setLogDate(new Date());
            documents.setResponsibleId(this.frmMain.getResponsibleInformation());
            documents.setDescription(EventLogDescription.EDIT_BIRTH_CERTIFICATE.name());
            documents.setCosts(new BigInteger("0"));
            documentsJpaController.create(documents);
            JOptionPane.showMessageDialog(this, "عملیات ویرایش با موفقیت انجام شد","نتیجه ویرایش",JOptionPane.INFORMATION_MESSAGE); 
           
            fillJTable();
        }catch(SabteAhvalException e){
            JOptionPane.showMessageDialog(this, e.getCustomExceptionMessage().getPersianMsg(), e.getCustomExceptionMessage().getTitle(), JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_btnCertificateEditeActionPerformed

    private void btnCertificateRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificateRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow=tblRegisterBirthCertificate.getSelectedRow();
        int id=(int)model.getValueAt(selectedRow, 0);
        try {
            birthCertificateController.destroy(id);
            Documents documents = new Documents();
            documents.setDiscriminatorColumn('C');
            documents.setDiscriminatorColumnId(id);
            documents.setLogDate(new Date());
            documents.setResponsibleId(this.frmMain.getResponsibleInformation());
            documents.setDescription(EventLogDescription.REMOVE_BIRTH_CERTIFICATE.name());
            documents.setCosts(new BigInteger("0"));
            documentsJpaController.create(documents);
            JOptionPane.showMessageDialog(this, "عملیات حذف با موفقیت انجام شد","نتیجه حذف",JOptionPane.INFORMATION_MESSAGE); 
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FrmRegistrationBirthCertificate.class.getName()).log(Level.SEVERE, null, ex);
        }
         fillJTable();
    }//GEN-LAST:event_btnCertificateRemoveActionPerformed

    private void tblRegisterBirthCertificateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegisterBirthCertificateMouseClicked
        // TODO add your handling code here:
        int selectedRow=tblRegisterBirthCertificate.getSelectedRow();
        int id=(int)model.getValueAt(selectedRow, 0);
        BirthCertificate birthcertificate=birthCertificateController.findBirthCertificate(id);
        txtFirstName.setText(birthcertificate.getFirstName());
        txtlLastName.setText(birthcertificate.getLastName());
        txtCertNumber.setText(birthcertificate.getCertificateNumber());
        txtSeri.setText(birthcertificate.getSeri());
        txtSeryal.setText(birthcertificate.getSeryal());
        txtBirthLocation.setText(birthcertificate.getBirthLocation());
        txtFathersName.setText(birthcertificate.getFatherName());
        txtMothersName.setText(birthcertificate.getMotherName());
        cmbCertificateGender.setSelectedIndex(birthcertificate.getGender()=='M'?0:1);
        
        
        
        
                
        String gregorianBirthdate = Utility.getDateInNumberFormat(birthcertificate.getBirthdate());
        String[] jalaliBirthdateParts = Utility.gregorian2jalali(gregorianBirthdate).split("-");
        String[] hijriBirthdateParts = Utility.gregorian2hijri(gregorianBirthdate).split("-");
        String[] jalaliIssueDateParts = Utility.gregorian2jalali(Utility.getDateInNumberFormat(birthcertificate.getIssueDate())).split("-");
        cmbJalaliYear.setSelectedIndex(Integer.parseInt(jalaliBirthdateParts[0]));
        cmbJalaliMonth.setSelectedIndex(Integer.parseInt(jalaliBirthdateParts[1]));
        cmbJalaliDay.setSelectedIndex(Integer.parseInt(jalaliBirthdateParts[2]));
        cmbCertificatRegisterYear.setSelectedIndex(Integer.parseInt(jalaliBirthdateParts[0]));
        cmbCertificatRegisterMounth.setSelectedIndex(Integer.parseInt(jalaliBirthdateParts[1]));
        cmbCertificatRegisterDay.setSelectedIndex(Integer.parseInt(jalaliBirthdateParts[2]));
        
    }//GEN-LAST:event_tblRegisterBirthCertificateMouseClicked

    private void cmbJalaliYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJalaliYearActionPerformed
        updateHijriByJalali();
    }//GEN-LAST:event_cmbJalaliYearActionPerformed

    private void cmbJalaliMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJalaliMonthActionPerformed
        updateHijriByJalali();
    }//GEN-LAST:event_cmbJalaliMonthActionPerformed

    private void cmbJalaliDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJalaliDayActionPerformed
        updateHijriByJalali();
    }//GEN-LAST:event_cmbJalaliDayActionPerformed

    private void cmbHijriYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHijriYearActionPerformed
        // TODO add your handling code here:
        updateJalaliByHijri();
    }//GEN-LAST:event_cmbHijriYearActionPerformed

    private void cmbHijriMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHijriMonthActionPerformed
        // TODO add your handling code here:
        updateJalaliByHijri();
    }//GEN-LAST:event_cmbHijriMonthActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
       frmMain.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private static JSpinner makeDigitsOnlySpinnerUsingDocumentFilter() {
    JSpinner spinner = new JSpinner(new SpinnerNumberModel());
    JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor) spinner
        .getEditor();
    JFormattedTextField textField = jsEditor.getTextField();
    DocumentFilter digitOnlyFilter = new DocumentFilter() {
      @Override
      public void insertString(FilterBypass fb, int offset, String string,
          AttributeSet attr) throws BadLocationException {
        if (stringContainsOnlyDigits(string)) {
          super.insertString(fb, offset, string, attr);
        }
      }
      @Override
      public void remove(FilterBypass fb, int offset, int length)
          throws BadLocationException {
        super.remove(fb, offset, length);
      }
      @Override
      public void replace(FilterBypass fb, int offset, int length, String text,
          AttributeSet attrs) throws BadLocationException {
        if (stringContainsOnlyDigits(text)) {
          super.replace(fb, offset, length, text, attrs);
        }
      }
      private boolean stringContainsOnlyDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
          if (!Character.isDigit(text.charAt(i))) {
            return false;
          }
        }
        return true;
      }
    };

    NumberFormat format = NumberFormat.getPercentInstance();
    format.setGroupingUsed(false);
    format.setGroupingUsed(true);
    format.setMaximumIntegerDigits(10);
    format.setMaximumFractionDigits(2);
    format.setMinimumFractionDigits(5);
    textField.setFormatterFactory(new DefaultFormatterFactory(
        new InternationalFormatter(format) {
          @Override
          protected DocumentFilter getDocumentFilter() {
            return digitOnlyFilter;
          }
        }));
    return spinner;
  }
    
    
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
            java.util.logging.Logger.getLogger(FrmRegistrationBirthCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrationBirthCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrationBirthCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrationBirthCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new FrmRegistrationBirthCertificate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCertificateAdd;
    private javax.swing.JButton btnCertificateEdite;
    private javax.swing.JButton btnCertificateRemove;
    private javax.swing.JComboBox<String> cmbCertificatRegisterDay;
    private javax.swing.JComboBox<String> cmbCertificatRegisterMounth;
    private javax.swing.JComboBox<String> cmbCertificatRegisterYear;
    private javax.swing.JComboBox<String> cmbCertificateGender;
    private javax.swing.JComboBox<String> cmbHijriDay;
    private javax.swing.JComboBox<String> cmbHijriMonth;
    private javax.swing.JComboBox<String> cmbHijriYear;
    private javax.swing.JComboBox<String> cmbJalaliDay;
    private javax.swing.JComboBox<String> cmbJalaliMonth;
    private javax.swing.JComboBox<String> cmbJalaliYear;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCertificateFamilyName;
    private javax.swing.JLabel lblCertificateName;
    private javax.swing.JTable tblRegisterBirthCertificate;
    private javax.swing.JTextField txtBirthLocation;
    private javax.swing.JTextField txtCertNumber;
    private javax.swing.JTextField txtFathersName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtMothersName;
    private javax.swing.JTextField txtSeri;
    private javax.swing.JTextField txtSeryal;
    private javax.swing.JTextField txtlLastName;
    // End of variables declaration//GEN-END:variables
}
