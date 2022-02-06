package com.mycompany.trackpackfirst;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.*;

public class JFrameFirst extends javax.swing.JFrame {

    public static String dt;
    public static String dts;

    ImageIcon icona;
    String ID;
    String ID2;
    String ID3;
    String ID4;
    String ID5;
    String ID6;
    String ID7;
    String ID8;
    String ID9;
    String ID10;

    public void currentDate() {
        GregorianCalendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        date.setText(day + "/" + (month + 1) + "/" + year);

    }

    public JFrameFirst() throws IOException {
        try {
            this.frame4 = new CommentsJFrame();
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
            initComponents();
            currentDate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFrameFirst.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JFrameFirst.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add() {
        ID = id.getText().toString();
        ID2 = id2.getText().toString();
        ID3 = id3.getText().toString();
        ID4 = id4.getText().toString();
        ID5 = id5.getText().toString();
        ID6 = id6.getText().toString();
        ID7 = id7.getText().toString();
        ID8 = id8.getText().toString();
        ID9 = id9.getText().toString();
        ID10 = id10.getText().toString();
        switch (count.getText()) {
            case "1":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);

                        pstmt.setString(1, ID);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());
                        
                        pstmt.executeUpdate();

                        conn.close();
                        JOptionPane.showMessageDialog(null, "Добавихте запис " + ID + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Вече съществува запис " + ID + "!");
                    }
                } else {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());
                        
                        pstmt.executeUpdate();

                        conn.close();
                        JOptionPane.showMessageDialog(null, "Добавихте запис " + ID + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Вече съществува запис " + ID + "!");
                    }
                }
                break;
            case "2":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, numWh.getText());
                        
                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка!");
                    }
                } else {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, oldDate.getText());
                        pstmt2.setString(5, numWh.getText());
                        
                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                }
                break;
            case "3":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                } else {
                    try {
                     
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        pstmt.setString(1, ID);
                        pstmt2.setString(1, ID2);
                        pstmt3.setString(1, ID3);
                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());

                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, oldDate.getText());
                        pstmt2.setString(5, numWh.getText());

                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, oldDate.getText());
                        pstmt3.setString(5, numWh.getText());
                        
                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                }
                break;
            case "4":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                } else {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, oldDate.getText());
                        pstmt2.setString(5, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, oldDate.getText());
                        pstmt3.setString(5, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, oldDate.getText());
                        pstmt4.setString(5, numWh.getText());
                        
                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                }

                break;
            case "5":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, numWh.getText());
                       
                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                } else {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, oldDate.getText());
                        pstmt2.setString(5, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, oldDate.getText());
                        pstmt3.setString(5, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, oldDate.getText());
                        pstmt3.setString(5, numWh.getText());
                       
                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, oldDate.getText());
                        pstmt5.setString(5, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                }

                break;
            case "6":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, numWh.getText());

                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                } else {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, oldDate.getText());
                        pstmt2.setString(5, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, oldDate.getText());
                        pstmt3.setString(5, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, oldDate.getText());
                        pstmt4.setString(5, numWh.getText());

                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, oldDate.getText());
                        pstmt5.setString(5, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, oldDate.getText());
                        pstmt6.setString(5, numWh.getText());
                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                }

                break;
            case "7":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);
                        PreparedStatement pstmt7 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, numWh.getText());

                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, numWh.getText());

                        pstmt7.setString(1, ID7);
                        pstmt7.setString(2, status);
                        pstmt7.setString(3, location.getText());
                        pstmt7.setString(4, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();
                        pstmt7.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                } else {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);
                        PreparedStatement pstmt7 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, oldDate.getText());
                        pstmt2.setString(5, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, oldDate.getText());
                        pstmt3.setString(5, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, oldDate.getText());
                        pstmt4.setString(5, numWh.getText());
                        
                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, oldDate.getText());
                        pstmt5.setString(5, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, oldDate.getText());
                        pstmt6.setString(5, numWh.getText());

                        pstmt7.setString(1, ID7);
                        pstmt7.setString(2, status);
                        pstmt7.setString(3, location.getText());
                        pstmt7.setString(4, oldDate.getText());
                        pstmt7.setString(5, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();
                        pstmt7.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                }

                break;
            case "8":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);
                        PreparedStatement pstmt7 = conn.prepareStatement(sql);
                        PreparedStatement pstmt8 = conn.prepareStatement(sql);
                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, numWh.getText());

                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, numWh.getText());

                        pstmt7.setString(1, ID7);
                        pstmt7.setString(2, status);
                        pstmt7.setString(3, location.getText());
                        pstmt7.setString(4, numWh.getText());

                        pstmt8.setString(1, ID8);
                        pstmt8.setString(2, status);
                        pstmt8.setString(3, location.getText());
                        pstmt8.setString(4, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();
                        pstmt7.executeUpdate();
                        pstmt8.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "," + ID8 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                } else {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);
                        PreparedStatement pstmt7 = conn.prepareStatement(sql);
                        PreparedStatement pstmt8 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, oldDate.getText());
                        pstmt2.setString(5, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, oldDate.getText());
                        pstmt3.setString(5, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, oldDate.getText());
                        pstmt4.setString(5, numWh.getText());
                        
                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, oldDate.getText());
                        pstmt5.setString(5, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, oldDate.getText());
                        pstmt6.setString(5, numWh.getText());

                        pstmt7.setString(1, ID7);
                        pstmt7.setString(2, status);
                        pstmt7.setString(3, location.getText());
                        pstmt7.setString(4, oldDate.getText());
                        pstmt7.setString(5, numWh.getText());

                        pstmt8.setString(1, ID8);
                        pstmt8.setString(2, status);
                        pstmt8.setString(3, location.getText());
                        pstmt8.setString(4, oldDate.getText());
                        pstmt8.setString(5, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();
                        pstmt7.executeUpdate();
                        pstmt8.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "," + ID8 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                }

                break;
            case "9":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP(),?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);
                        PreparedStatement pstmt7 = conn.prepareStatement(sql);
                        PreparedStatement pstmt8 = conn.prepareStatement(sql);
                        PreparedStatement pstmt9 = conn.prepareStatement(sql);
                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, numWh.getText());

                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, numWh.getText());

                        pstmt7.setString(1, ID7);
                        pstmt7.setString(2, status);
                        pstmt7.setString(3, location.getText());
                        pstmt7.setString(4, numWh.getText());

                        pstmt8.setString(1, ID8);
                        pstmt8.setString(2, status);
                        pstmt8.setString(3, location.getText());
                        pstmt8.setString(4, numWh.getText());

                        pstmt8.setString(1, ID8);
                        pstmt8.setString(2, status);
                        pstmt8.setString(3, location.getText());
                        pstmt8.setString(4, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();
                        pstmt7.executeUpdate();
                        pstmt8.executeUpdate();
                        pstmt9.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "," + ID8 + "," + ID9 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                } else {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);
                        PreparedStatement pstmt7 = conn.prepareStatement(sql);
                        PreparedStatement pstmt8 = conn.prepareStatement(sql);
                        PreparedStatement pstmt9 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, oldDate.getText());
                        pstmt2.setString(5, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, oldDate.getText());
                        pstmt3.setString(5, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, oldDate.getText());
                        pstmt4.setString(5, numWh.getText());
                        
                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, oldDate.getText());
                        pstmt5.setString(5, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, oldDate.getText());
                        pstmt6.setString(5, numWh.getText());

                        pstmt7.setString(1, ID7);
                        pstmt7.setString(2, status);
                        pstmt7.setString(3, location.getText());
                        pstmt7.setString(4, oldDate.getText());
                        pstmt7.setString(5, numWh.getText());

                        pstmt8.setString(1, ID8);
                        pstmt8.setString(2, status);
                        pstmt8.setString(3, location.getText());
                        pstmt8.setString(4, oldDate.getText());
                        pstmt8.setString(5, numWh.getText());

                        pstmt9.setString(1, ID9);
                        pstmt9.setString(2, status);
                        pstmt9.setString(3, location.getText());
                        pstmt9.setString(4, oldDate.getText());
                        pstmt9.setString(5, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();
                        pstmt7.executeUpdate();
                        pstmt8.executeUpdate();
                        pstmt9.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "," + ID8 + "," + ID9 + "!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                }

                break;
            case "10":
                if (oldDate.getText().equals("")) {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into opakovki values(?,?,?,CURRENT_TIMESTAMP,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);
                        PreparedStatement pstmt7 = conn.prepareStatement(sql);
                        PreparedStatement pstmt8 = conn.prepareStatement(sql);
                        PreparedStatement pstmt9 = conn.prepareStatement(sql);
                        PreparedStatement pstmt10 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, numWh.getText());

                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, numWh.getText());

                        pstmt7.setString(1, ID7);
                        pstmt7.setString(2, status);
                        pstmt7.setString(3, location.getText());
                        pstmt7.setString(4, numWh.getText());

                        pstmt8.setString(1, ID8);
                        pstmt8.setString(2, status);
                        pstmt8.setString(3, location.getText());
                        pstmt8.setString(4, numWh.getText());

                        pstmt9.setString(1, ID9);
                        pstmt9.setString(2, status);
                        pstmt9.setString(3, location.getText());
                        pstmt9.setString(4, numWh.getText());

                        pstmt10.setString(1, ID9);
                        pstmt10.setString(2, status);
                        pstmt10.setString(3, location.getText());
                        pstmt10.setString(4, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();
                        pstmt7.executeUpdate();
                        pstmt8.executeUpdate();
                        pstmt9.executeUpdate();
                        pstmt10.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "," + ID8 + "," + ID9 + "," + ID10 + "!");
                    } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                } else {
                    try {
                        Class.forName("org.h2.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                        String sql = "insert into OPAKOVKI values(?,?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql);
                        PreparedStatement pstmt3 = conn.prepareStatement(sql);
                        PreparedStatement pstmt4 = conn.prepareStatement(sql);
                        PreparedStatement pstmt5 = conn.prepareStatement(sql);
                        PreparedStatement pstmt6 = conn.prepareStatement(sql);
                        PreparedStatement pstmt7 = conn.prepareStatement(sql);
                        PreparedStatement pstmt8 = conn.prepareStatement(sql);
                        PreparedStatement pstmt9 = conn.prepareStatement(sql);
                        PreparedStatement pstmt10 = conn.prepareStatement(sql);

                        String status = null;
                        if (yes.isSelected()) {
                            status = yes.getText();
                        }
                        if (no.isSelected()) {
                            status = no.getText();
                        }
                        pstmt.setString(1, ID);
                        pstmt.setString(2, status);
                        pstmt.setString(3, location.getText());
                        pstmt.setString(4, oldDate.getText());
                        pstmt.setString(5, numWh.getText());

                        pstmt2.setString(1, ID2);
                        pstmt2.setString(2, status);
                        pstmt2.setString(3, location.getText());
                        pstmt2.setString(4, oldDate.getText());
                        pstmt2.setString(5, numWh.getText());

                        pstmt3.setString(1, ID3);
                        pstmt3.setString(2, status);
                        pstmt3.setString(3, location.getText());
                        pstmt3.setString(4, oldDate.getText());
                        pstmt3.setString(5, numWh.getText());

                        pstmt4.setString(1, ID4);
                        pstmt4.setString(2, status);
                        pstmt4.setString(3, location.getText());
                        pstmt4.setString(4, oldDate.getText());
                        pstmt4.setString(5, numWh.getText());

                        pstmt5.setString(1, ID5);
                        pstmt5.setString(2, status);
                        pstmt5.setString(3, location.getText());
                        pstmt5.setString(4, oldDate.getText());
                        pstmt5.setString(5, numWh.getText());

                        pstmt6.setString(1, ID6);
                        pstmt6.setString(2, status);
                        pstmt6.setString(3, location.getText());
                        pstmt6.setString(4, oldDate.getText());
                        pstmt6.setString(5, numWh.getText());

                        pstmt7.setString(1, ID7);
                        pstmt7.setString(2, status);
                        pstmt7.setString(3, location.getText());
                        pstmt7.setString(4, oldDate.getText());
                        pstmt7.setString(5, numWh.getText());

                        pstmt8.setString(1, ID8);
                        pstmt8.setString(2, status);
                        pstmt8.setString(3, location.getText());
                        pstmt8.setString(4, oldDate.getText());
                        pstmt8.setString(5, numWh.getText());

                        pstmt9.setString(1, ID9);
                        pstmt9.setString(2, status);
                        pstmt9.setString(3, location.getText());
                        pstmt9.setString(4, oldDate.getText());
                        pstmt9.setString(5, numWh.getText());

                        pstmt9.setString(1, ID10);
                        pstmt9.setString(2, status);
                        pstmt9.setString(3, location.getText());
                        pstmt9.setString(4, oldDate.getText());
                        pstmt9.setString(5, numWh.getText());

                        pstmt.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        pstmt5.executeUpdate();
                        pstmt6.executeUpdate();
                        pstmt7.executeUpdate();
                        pstmt8.executeUpdate();
                        pstmt9.executeUpdate();
                        pstmt10.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Добавихте записи " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "," + ID8 + "," + ID9 + "," + ID10 + "!");
                    } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                        JOptionPane.showMessageDialog(null, "Дублирана опаковка" + e);
                    }
                }

                break;
            case "":
                JOptionPane.showMessageDialog(null, "Невалиден брой опаковки");
                break;
        }
    }

    public void update() throws ClassNotFoundException {

        ID = id.getText().toString();
        ID2 = id2.getText().toString();
        ID3 = id3.getText().toString();
        ID4 = id4.getText().toString();
        ID5 = id5.getText().toString();
        ID6 = id6.getText().toString();
        ID7 = id7.getText().toString();
        ID8 = id8.getText().toString();
        ID9 = id9.getText().toString();
        ID10 = id10.getText().toString();
        switch (count.getText()) {
            case "":
                JOptionPane.showMessageDialog(null, "Невалиден брой опаковки");
                break;
            case "1":
               try {
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh = ?where IDopakovka ='" + id.getText().toString() + "'";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }

                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());

                pstmt.executeUpdate();

                int rowAffected = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Актуализирахте опаковка " + ID);
                conn.close();
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Несъществуващ запис!");
            }
            break;
            case "2":
               try {
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID + "'";
                String sql2 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID2 + "'";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }
                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());

                pstmt2.setString(1, status);
                pstmt2.setString(2, location.getText());
                pstmt2.setString(3, numWh.getText());

                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                conn.close();

                JOptionPane.showMessageDialog(null, "Актуализирахте опаковки " + ID + "," + ID2 + "!");

            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Несъществуващ запис!");
            }
            break;
            case "3":
               try {
                //Class.forName("com.mysql.jdbc.Driver");
                //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin123");
                //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                //Connection conn = DriverManager.getConnection("jdbc:derby:D:\\Projects\\data");
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID + "'";
                String sql2 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID2 + "'";
                String sql3 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID3 + "'";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }
                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());

                pstmt2.setString(1, status);
                pstmt2.setString(2, location.getText());
                pstmt2.setString(3, numWh.getText());

                pstmt3.setString(1, status);
                pstmt3.setString(2, location.getText());
                pstmt3.setString(3, numWh.getText());

                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
                int rowAffected = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Актуализирахте опаковка " + ID + "," + ID2 + "," + ID3 + "!");

            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Несъществуващ запис!");
            }
            break;
            case "4":
               try {
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID + "'";
                String sql2 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID2 + "'";
                String sql3 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID3 + "'";
                String sql4 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID4 + "'";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }
                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());

                pstmt2.setString(1, status);
                pstmt2.setString(2, location.getText());
                pstmt2.setString(3, numWh.getText());

                pstmt3.setString(1, status);
                pstmt3.setString(2, location.getText());
                pstmt3.setString(3, numWh.getText());

                pstmt4.setString(1, status);
                pstmt4.setString(2, location.getText());
                pstmt4.setString(3, numWh.getText());

                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
                pstmt4.executeUpdate();
                int rowAffected = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Актуализирахте опаковка " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Несъществуващ запис!");
            }
            break;
            case "5":
               try {
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID + "'";
                String sql2 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID2 + "'";
                String sql3 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID3 + "'";
                String sql4 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID4 + "'";
                String sql5 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID5 + "'";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                PreparedStatement pstmt5 = conn.prepareStatement(sql5);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }
                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());

                pstmt2.setString(1, status);
                pstmt2.setString(2, location.getText());
                pstmt2.setString(3, numWh.getText());

                pstmt3.setString(1, status);
                pstmt3.setString(2, location.getText());
                pstmt3.setString(3, numWh.getText());

                pstmt4.setString(1, status);
                pstmt4.setString(2, location.getText());
                pstmt4.setString(3, numWh.getText());

                pstmt5.setString(1, status);
                pstmt5.setString(2, location.getText());
                pstmt5.setString(3, numWh.getText());

                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
                pstmt4.executeUpdate();
                pstmt5.executeUpdate();
                int rowAffected = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Актуализирахте опаковка " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Несъществуващ запис!");
            }
            break;
            case "6":
               try {
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID + "'";
                String sql2 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID2 + "'";
                String sql3 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID3 + "'";
                String sql4 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID4 + "'";
                String sql5 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID5 + "'";
                String sql6 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID6 + "'";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                PreparedStatement pstmt5 = conn.prepareStatement(sql5);
                PreparedStatement pstmt6 = conn.prepareStatement(sql6);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }
                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());

                pstmt2.setString(1, status);
                pstmt2.setString(2, location.getText());
                pstmt2.setString(3, numWh.getText());

                pstmt3.setString(1, status);
                pstmt3.setString(2, location.getText());
                pstmt3.setString(3, numWh.getText());
                pstmt3.setString(4, ID3);

                pstmt4.setString(1, status);
                pstmt4.setString(2, location.getText());
                pstmt4.setString(3, numWh.getText());

                pstmt5.setString(1, status);
                pstmt5.setString(2, location.getText());
                pstmt5.setString(3, numWh.getText());

                pstmt6.setString(1, status);
                pstmt6.setString(2, location.getText());
                pstmt6.setString(3, numWh.getText());

                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
                pstmt4.executeUpdate();
                pstmt5.executeUpdate();
                pstmt6.executeUpdate();
                int rowAffected = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Актуализирахте опаковка " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Несъществуващ запис!");
            }
            break;
            case "7":
               try {
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID + "'";
                String sql2 = "update app.opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID2 + "'";
                String sql3 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID3 + "'";
                String sql4 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID4 + "'";
                String sql5 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID5 + "'";
                String sql6 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID6 + "'";
                String sql7 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID7 + "'";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                PreparedStatement pstmt5 = conn.prepareStatement(sql5);
                PreparedStatement pstmt6 = conn.prepareStatement(sql6);
                PreparedStatement pstmt7 = conn.prepareStatement(sql7);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }
                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());

                pstmt2.setString(1, status);
                pstmt2.setString(2, location.getText());
                pstmt2.setString(3, numWh.getText());

                pstmt3.setString(1, status);
                pstmt3.setString(2, location.getText());
                pstmt3.setString(3, numWh.getText());

                pstmt4.setString(1, status);
                pstmt4.setString(2, location.getText());
                pstmt4.setString(3, numWh.getText());

                pstmt5.setString(1, status);
                pstmt5.setString(2, location.getText());
                pstmt5.setString(3, numWh.getText());

                pstmt6.setString(1, status);
                pstmt6.setString(2, location.getText());
                pstmt6.setString(3, numWh.getText());

                pstmt7.setString(1, status);
                pstmt7.setString(2, location.getText());
                pstmt7.setString(3, numWh.getText());

                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
                pstmt4.executeUpdate();
                pstmt5.executeUpdate();
                pstmt6.executeUpdate();
                pstmt7.executeUpdate();
                int rowAffected = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Актуализирахте опаковка " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Несъществуващ запис!");
            }
            break;
            case "8":
               try {
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID + "'";
                String sql2 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID2 + "'";
                String sql3 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID3 + "'";
                String sql4 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID4 + "'";
                String sql5 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID5 + "'";
                String sql6 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID6 + "'";
                String sql7 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID7 + "'";
                String sql8 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID8 + "'";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                PreparedStatement pstmt5 = conn.prepareStatement(sql5);
                PreparedStatement pstmt6 = conn.prepareStatement(sql6);
                PreparedStatement pstmt7 = conn.prepareStatement(sql7);
                PreparedStatement pstmt8 = conn.prepareStatement(sql8);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }
                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());

                pstmt2.setString(1, status);
                pstmt2.setString(2, location.getText());
                pstmt2.setString(3, numWh.getText());

                pstmt3.setString(1, status);
                pstmt3.setString(2, location.getText());
                pstmt3.setString(3, numWh.getText());

                pstmt4.setString(1, status);
                pstmt4.setString(2, location.getText());
                pstmt4.setString(3, numWh.getText());

                pstmt5.setString(1, status);
                pstmt5.setString(2, location.getText());
                pstmt5.setString(3, numWh.getText());

                pstmt6.setString(1, status);
                pstmt6.setString(2, location.getText());
                pstmt6.setString(3, numWh.getText());

                pstmt7.setString(1, status);
                pstmt7.setString(2, location.getText());
                pstmt7.setString(3, numWh.getText());

                pstmt8.setString(1, status);
                pstmt8.setString(2, location.getText());
                pstmt8.setString(3, numWh.getText());

                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
                pstmt4.executeUpdate();
                pstmt5.executeUpdate();
                pstmt6.executeUpdate();
                pstmt7.executeUpdate();
                pstmt8.executeUpdate();
                int rowAffected = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Актуализирахте опаковка " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "," + ID8 + "!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Несъществуващ запис!");
            }
            break;
            case "9":
               try {
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID + "'";
                String sql2 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID2 + "'";
                String sql3 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID3 + "'";
                String sql4 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID4 + "'";
                String sql5 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID5 + "'";
                String sql6 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID6 + "'";
                String sql7 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID7 + "'";
                String sql8 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID8 + "'";
                String sql9 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID9 + "'";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                PreparedStatement pstmt5 = conn.prepareStatement(sql5);
                PreparedStatement pstmt6 = conn.prepareStatement(sql6);
                PreparedStatement pstmt7 = conn.prepareStatement(sql7);
                PreparedStatement pstmt8 = conn.prepareStatement(sql8);
                PreparedStatement pstmt9 = conn.prepareStatement(sql9);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }
                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());

                pstmt2.setString(1, status);
                pstmt2.setString(2, location.getText());
                pstmt2.setString(3, numWh.getText());

                pstmt3.setString(1, status);
                pstmt3.setString(2, location.getText());
                pstmt3.setString(3, numWh.getText());

                pstmt4.setString(1, status);
                pstmt4.setString(2, location.getText());
                pstmt4.setString(3, numWh.getText());

                pstmt5.setString(1, status);
                pstmt5.setString(2, location.getText());
                pstmt5.setString(3, numWh.getText());

                pstmt6.setString(1, status);
                pstmt6.setString(2, location.getText());
                pstmt6.setString(3, numWh.getText());

                pstmt7.setString(1, status);
                pstmt7.setString(2, location.getText());
                pstmt7.setString(3, numWh.getText());

                pstmt8.setString(1, status);
                pstmt8.setString(2, location.getText());
                pstmt8.setString(3, numWh.getText());

                pstmt9.setString(1, status);
                pstmt9.setString(2, location.getText());
                pstmt9.setString(3, numWh.getText());

                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
                pstmt4.executeUpdate();
                pstmt5.executeUpdate();
                pstmt6.executeUpdate();
                pstmt7.executeUpdate();
                pstmt8.executeUpdate();
                pstmt9.executeUpdate();
                int rowAffected = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Актуализирахте опаковка " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "," + ID8 + "," + ID9 + "!");

            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            break;
            case "10":
               try {
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.getConnection("jdbc:h2:./database/db;IFEXISTS=TRUE", "test", "test");
                String sql = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID + "'";
                String sql2 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID2 + "'";
                String sql3 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID3 + "'";
                String sql4 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID4 + "'";
                String sql5 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID5 + "'";
                String sql6 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID6 + "'";
                String sql7 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID7 + "'";
                String sql8 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID8 + "'";
                String sql9 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID9 + "'";
                String sql10 = "update opakovki set Status =?, Location = ?, datestamp = CURRENT_TIMESTAMP, numWh =? where IDopakovka ='" + ID10 + "'";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                PreparedStatement pstmt5 = conn.prepareStatement(sql5);
                PreparedStatement pstmt6 = conn.prepareStatement(sql6);
                PreparedStatement pstmt7 = conn.prepareStatement(sql7);
                PreparedStatement pstmt8 = conn.prepareStatement(sql8);
                PreparedStatement pstmt9 = conn.prepareStatement(sql9);
                PreparedStatement pstmt10 = conn.prepareStatement(sql10);
                String status = null;
                if (yes.isSelected()) {
                    status = yes.getText();
                }
                if (no.isSelected()) {
                    status = no.getText();
                }
                pstmt.setString(1, status);
                pstmt.setString(2, location.getText());
                pstmt.setString(3, numWh.getText());
                pstmt.setString(4, ID);

                pstmt2.setString(1, status);
                pstmt2.setString(2, location.getText());
                pstmt2.setString(3, numWh.getText());
                pstmt2.setString(4, ID2);

                pstmt3.setString(1, status);
                pstmt3.setString(2, location.getText());
                pstmt3.setString(3, numWh.getText());
                pstmt3.setString(4, ID3);

                pstmt4.setString(1, status);
                pstmt4.setString(2, location.getText());
                pstmt4.setString(3, numWh.getText());
                pstmt4.setString(4, ID4);

                pstmt5.setString(1, status);
                pstmt5.setString(2, location.getText());
                pstmt5.setString(3, numWh.getText());
                pstmt5.setString(4, ID5);

                pstmt6.setString(1, status);
                pstmt6.setString(2, location.getText());
                pstmt6.setString(3, numWh.getText());
                pstmt6.setString(4, ID6);

                pstmt7.setString(1, status);
                pstmt7.setString(2, location.getText());
                pstmt7.setString(3, numWh.getText());
                pstmt7.setString(4, ID7);

                pstmt8.setString(1, status);
                pstmt8.setString(2, location.getText());
                pstmt8.setString(3, numWh.getText());
                pstmt8.setString(4, ID8);

                pstmt9.setString(1, status);
                pstmt9.setString(2, location.getText());
                pstmt9.setString(3, numWh.getText());
                pstmt9.setString(4, ID9);

                pstmt10.setString(1, status);
                pstmt10.setString(2, location.getText());
                pstmt10.setString(3, numWh.getText());
                pstmt10.setString(4, ID10);

                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
                pstmt4.executeUpdate();
                pstmt5.executeUpdate();
                pstmt6.executeUpdate();
                pstmt7.executeUpdate();
                pstmt8.executeUpdate();
                pstmt9.executeUpdate();
                pstmt10.executeUpdate();
                int rowAffected = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Актуализирахте опаковки " + ID + "," + ID2 + "," + ID3 + "," + ID4 + "," + ID5 + "," + ID6 + "," + ID7 + "," + ID8 + "," + ID9 + "," + ID10 + "!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Несъществуващ запис!");
            }
            break;
        }

    }

    CommentsJFrame frame4;
    WarehouseJFrame frame = new WarehouseJFrame();
    ClientsJFrame frame2 = new ClientsJFrame();
    AllJFrame frame3 = new AllJFrame();

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        group = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        proba = new javax.swing.JLabel();
        coments = new javax.swing.JButton();
        yes = new javax.swing.JRadioButton();
        no = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        oldDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numWh = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        id2 = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        id5 = new javax.swing.JTextField();
        id3 = new javax.swing.JTextField();
        id7 = new javax.swing.JTextField();
        id6 = new javax.swing.JTextField();
        id9 = new javax.swing.JTextField();
        id8 = new javax.swing.JTextField();
        id4 = new javax.swing.JTextField();
        id10 = new javax.swing.JTextField();
        count = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PackTrack");
        setBackground(new java.awt.Color(0, 102, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Номер на опаковка/и");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Статус");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Клиент");

        location.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("ДОБАВИ НОВА");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("Склад");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton4.setText("Всички");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton5.setText("Клиенти");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        date.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N

        proba.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        proba.setForeground(new java.awt.Color(0, 0, 0));
        proba.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proba.setText("Меню");
        proba.setToolTipText("");
        proba.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        proba.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        proba.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        coments.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        coments.setText("Особени");
        coments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(proba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(coments, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proba, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(coments, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        group.add(yes);
        yes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        yes.setText("Y");

        group.add(no);
        no.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        no.setText("X");

        jButton6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton6.setText("АКТУАЛИЗИРАЙ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Дата");

        oldDate.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Брой");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Складова разписка №");

        numWh.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        clear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        clear.setText("ИЗЧИСТИ");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        id2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        id.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        id5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        id3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        id7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        id6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        id9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        id8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        id4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        id10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        count.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        count.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countActionPerformed(evt);
            }
        });
        count.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                countKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("1");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("2");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("3");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("4");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setText("5");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setText("6");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setText("7");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setText("8");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setText("9");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel18.setText("10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(yes)
                                        .addGap(18, 18, 18)
                                        .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(location)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(95, 95, 95)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(108, 108, 108)))
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addGap(4, 4, 4)
                                .addComponent(numWh, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(oldDate, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(count))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(id6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id7, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(218, 218, 218)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                                        .addGap(12, 12, 12)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(id3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(id4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(id9, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(id5)
                                .addComponent(id10, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {no, yes});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numWh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(oldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(yes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(id2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(id3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(id4, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(id5, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id6, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(id7, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(id8, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(id9, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(id10, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {count, jLabel4, jLabel5, location});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {no, yes});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {numWh, oldDate});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.setSize(800, 800);
        frame.setTitle("Склад");
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        frame3.setVisible(true);
        frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame3.setSize(800, 800);
        frame3.setTitle("Всички");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame2.setSize(800, 800);
        frame2.setTitle("Клиенти");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        add();

        // TODO add your handling code here:

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            update();
            // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Неуспешно актуализиране! Несъществуващ запис!");
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        numWh.setText("");
        oldDate.setText("");
        location.setText("");
        count.setText("");
        id.setText("");
        id2.setText("");
        id3.setText("");
        id4.setText("");
        id5.setText("");
        id6.setText("");
        id7.setText("");
        id8.setText("");
        id9.setText("");
        id10.setText("");
        id.setEnabled(true);
        id2.setEnabled(true);
        id3.setEnabled(true);
        id4.setEnabled(true);
        id5.setEnabled(true);
        id6.setEnabled(true);
        id7.setEnabled(true);
        id8.setEnabled(true);
        id9.setEnabled(true);
        id10.setEnabled(true);


    }//GEN-LAST:event_clearActionPerformed

    private void comentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentsActionPerformed
        frame4.setVisible(true);
        frame4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame4.setSize(700, 700);
        frame4.setTitle("Опаковки с коментар");

    }//GEN-LAST:event_comentsActionPerformed
    public void countCheck() {
        switch (count.getText()) {

            case "1":
                id2.setEnabled(false);
                id3.setEnabled(false);
                id4.setEnabled(false);
                id5.setEnabled(false);
                id6.setEnabled(false);
                id7.setEnabled(false);
                id8.setEnabled(false);
                id9.setEnabled(false);
                id10.setEnabled(false);
                break;
            case "2":
                id3.setEnabled(false);
                id4.setEnabled(false);
                id5.setEnabled(false);
                id6.setEnabled(false);
                id7.setEnabled(false);
                id8.setEnabled(false);
                id9.setEnabled(false);
                id10.setEnabled(false);
                break;
            case "3":

                id4.setEnabled(false);
                id5.setEnabled(false);
                id6.setEnabled(false);
                id7.setEnabled(false);
                id8.setEnabled(false);
                id9.setEnabled(false);
                id10.setEnabled(false);
                break;
            case "4":
                id5.setEnabled(false);
                id6.setEnabled(false);
                id7.setEnabled(false);
                id8.setEnabled(false);
                id9.setEnabled(false);
                id10.setEnabled(false);
                break;
            case "5":
                id6.setEnabled(false);
                id7.setEnabled(false);
                id8.setEnabled(false);
                id9.setEnabled(false);
                id10.setEnabled(false);
                break;
            case "6":
                id7.setEnabled(false);
                id8.setEnabled(false);
                id9.setEnabled(false);
                id10.setEnabled(false);
                break;
            case "7":
                id8.setEnabled(false);
                id9.setEnabled(false);
                id10.setEnabled(false);
                break;
            case "8":
                id9.setEnabled(false);
                id10.setEnabled(false);
                break;
            case "9":

                id10.setEnabled(false);
                break;
            case "10":
                id.setEnabled(true);
                id2.setEnabled(true);
                id3.setEnabled(true);
                id4.setEnabled(true);
                id5.setEnabled(true);
                id6.setEnabled(true);
                id7.setEnabled(true);
                id8.setEnabled(true);
                id9.setEnabled(true);
                id10.setEnabled(true);
                break;
        }
    }
    private void countKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_countKeyReleased
        countCheck();

        // TODO add your handling code here:
    }//GEN-LAST:event_countKeyReleased

    private void countActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(JFrameFirst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameFirst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameFirst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameFirst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        LocalDateTime dt = LocalDateTime.now();
        dt.toString();

        final String urll = "res/logo.png";

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameFirst().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(JFrameFirst.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton coments;
    private javax.swing.JTextField count;
    private javax.swing.JLabel date;
    private javax.swing.ButtonGroup group;
    private javax.swing.JTextField id;
    private javax.swing.JTextField id10;
    private javax.swing.JTextField id2;
    private javax.swing.JTextField id3;
    private javax.swing.JTextField id4;
    private javax.swing.JTextField id5;
    private javax.swing.JTextField id6;
    private javax.swing.JTextField id7;
    private javax.swing.JTextField id8;
    private javax.swing.JTextField id9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField location;
    private javax.swing.JRadioButton no;
    private javax.swing.JTextField numWh;
    private javax.swing.JTextField oldDate;
    private javax.swing.JLabel proba;
    private javax.swing.JRadioButton yes;
    // End of variables declaration//GEN-END:variables
}
