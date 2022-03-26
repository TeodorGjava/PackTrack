package com.mycompany.Classes;


import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;
import static com.microsoft.schemas.office.excel.STObjectType.Enum.table;
import java.awt.Desktop;
import java.io.BufferedOutputStream;
import org.apache.poi.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.awt.Desktop;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.io.File;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author LL
 */
public class AllJFrame extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    PreparedStatement prs;
    ResultSet rs;
    BufferedOutputStream out;
    FileOutputStream FOS;
    File file;
    String num;
    /**
     * Creates new form AllJFrame
     */
    exportTable export = new exportTable();

    public AllJFrame() {

        initComponents();
        show_id();
        currentDate();

    }

    public void coment() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin123");
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Connection conn = DriverManager.getConnection("jdbc:derby:D:\\Projects\\coment");
            Class.forName("org.h2.Driver");
             Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE","test","test");
            DefaultTableModel model = (DefaultTableModel) AllFrameTable.getModel();
            int row = AllFrameTable.getSelectedRow();
             num = (AllFrameTable.getModel().getValueAt(row, 1).toString());
            String comment = (AllFrameTable.getModel().getValueAt(row, 5).toString());
            System.out.println(comment);

            String q = "insert into coments values(?,?,CURRENT_TIMESTAMP)";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.setString(1, num);
            pst.setString(2, comment);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Създаден е коментар за опаковка "+num+"!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Вече има коментар за "+num+"!");
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void currentDate() {
        GregorianCalendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        date.setText(day + "/" + (month + 1) + "/" + year);

    }

    public ArrayList<Vsichki> opakovki() {
        ArrayList<Vsichki> list = new ArrayList<>();
        try {
            //Class.forName("com.mysql.jdbc.Driver");
           // Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           // Connection conn = DriverManager.getConnection("jdbc:derby:D:\\Projects\\data");
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE","test","test");
           String query1 = "SELECT * from opakovki";
//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin123");
            //String query1 = "SELECT * from opakovki";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query1);
            Vsichki vsichki = null;
            while (rs.next()) {
                vsichki = new Vsichki(rs.getString("IDopakovka"), rs.getString("Status"), rs.getString("Location"), rs.getString("datestamp"), rs.getString("numWh"));
                list.add(vsichki);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
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
        AllFrameTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        coment = new javax.swing.JButton();
        saveAs = new javax.swing.JButton();
        pdf = new javax.swing.JButton();
        refreshInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AllFrameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Складова Разписка", "Опаковка/и", "Статус", "Клиент", "Дата/час", "Коментар"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(AllFrameTable);

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("Търсене:");

        date.setBackground(new java.awt.Color(0, 102, 102));
        date.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        date.setForeground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(483, 483, 483)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        delete.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        delete.setText("Изтрий");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        delete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deleteKeyReleased(evt);
            }
        });

        coment.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        coment.setText("Добави Коментар");
        coment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentActionPerformed(evt);
            }
        });

        saveAs.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        saveAs.setText(".XLS");
        saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsActionPerformed(evt);
            }
        });

        pdf.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        pdf.setText(".pdf");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        refreshInfo.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        refreshInfo.setText("Обнови");
        refreshInfo.setIconTextGap(0);
        refreshInfo.setPreferredSize(new java.awt.Dimension(40, 42));
        refreshInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(coment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveAs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refreshInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(coment, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {coment, delete, pdf, refreshInfo, saveAs});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       
        try {
            //Class.forName("com.mysql.jdbc.Driver");
           // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin123");
          //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Connection conn = DriverManager.getConnection("jdbc:derby:D:\\Projects\\data");
            Class.forName("org.h2.Driver");
             Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE","test","test");
             
           int row = AllFrameTable.getSelectedRow();
            String value = (AllFrameTable.getModel().getValueAt(row, 1).toString());
            String query1 = "DELETE FROM opakovki where IDopakovka='" + value + "'";
            PreparedStatement pst = conn.prepareStatement(query1);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) AllFrameTable.getModel();
            model.setRowCount(0);
            show_id();
            JOptionPane.showMessageDialog(null, "Изтрихте " + value);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void comentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentActionPerformed
        coment();
        

    }//GEN-LAST:event_comentActionPerformed


    private void saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsActionPerformed

        try {
            export.export(AllFrameTable);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_saveAsActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        try {
            export.exportPdf(AllFrameTable);
        } catch (IOException ex) {
            Logger.getLogger(AllJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pdfActionPerformed
public void refreshInfo(){
DefaultTableModel model = (DefaultTableModel)AllFrameTable.getModel();
   model.setRowCount(0);
   show_id();
   


}
    private void refreshInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshInfoActionPerformed
    refreshInfo();        // TODO add your handling code here:
    }//GEN-LAST:event_refreshInfoActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

        String searchTxt = search.getText();
        search(searchTxt);
    }//GEN-LAST:event_searchKeyReleased

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void deleteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteKeyReleased
    public void show_id() {
        ArrayList<Vsichki> list1 = opakovki();
        DefaultTableModel model = (DefaultTableModel) AllFrameTable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list1.size(); i++) {
            row[0] = list1.get(i).getNumWh();
            row[1] = list1.get(i).getID();
            row[2] = list1.get(i).getStatus();
            row[3] = list1.get(i).getLocation();
            row[4] = list1.get(i).getdatestamp();
            model.addRow(row);

        }
    }
    
//search

    public void search(String str) {
        model = (DefaultTableModel) AllFrameTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        AllFrameTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));

    }

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AllFrameTable;
    private javax.swing.JButton coment;
    private javax.swing.JLabel date;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pdf;
    private javax.swing.JButton refreshInfo;
    private javax.swing.JButton saveAs;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
