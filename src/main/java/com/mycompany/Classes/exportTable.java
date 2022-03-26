package com.mycompany.Classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LL
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.*;
import javax.swing.*;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.StringEnumAbstractBase;
import com.itextpdf.text.pdf.*;
import static java.awt.Frame.NORMAL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class exportTable {
    exportTable(){}
    
     public void openFile(String file){
    try{
    File path =new File(file);
    java.awt.Desktop.getDesktop().open(path);
    
    
            }catch(Exception e){}
    
    }
    public void export(JTable jt) throws FileNotFoundException, IOException{
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.showSaveDialog(jt);
    File saveFile = fileChooser.getSelectedFile();
    if(saveFile != null){
    saveFile=new File(saveFile.toString()+".xlsx");
    Workbook wb = new XSSFWorkbook();
    XSSFSheet sheet = (XSSFSheet) wb.createSheet("opakovki");
    Row rowCol = sheet.createRow(0);
        for (int i = 0; i < jt.getColumnCount(); i++) {
            Cell cell = rowCol.createCell(i);
            cell.setCellValue(jt.getColumnName(i));
        }
        for (int j = 0; j < jt.getRowCount(); j++) {
            Row row = sheet.createRow(j+1);
            for (int k = 0; k < jt.getColumnCount(); k++) {
                Cell cell = row.createCell(k);
                if(jt.getValueAt(j, k)!= null){
                cell.setCellValue(jt.getValueAt(j,k).toString());
                
                }
            }
        }
        FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
        wb.write(out);
        wb.close();
        out.close();
        openFile(saveFile.toString());
        
   //row createrow
    
    
    }else{JOptionPane.showMessageDialog(null, "error");}
    } 
    public void exportPdf(JTable jt) throws FileNotFoundException, IOException{
  JFileChooser fileChooser = new JFileChooser();
    fileChooser.showSaveDialog(jt);
    File saveFile = fileChooser.getSelectedFile();
    if(saveFile != null){
    saveFile=new File(saveFile.toString()+".pdf");
    }try{
    Document doc = new Document();
    PdfWriter.getInstance(doc, new FileOutputStream(saveFile));
    doc.open();
    PdfPTable tbl = new PdfPTable(5);
            tbl.addCell("Warehouse num");
            tbl.addCell("Pack");
            tbl.addCell("Status");
            tbl.addCell("Client");
            tbl.addCell("Date");
            for (int i = 0; i < jt.getRowCount(); i++) {
                String num = jt.getValueAt(i, 0).toString();
                String id = jt.getValueAt(i, 1).toString();
                String status = jt.getValueAt(i, 2).toString();
                String location = jt.getValueAt(i, 3).toString();
                String date = jt.getValueAt(i, 4).toString();
                tbl.addCell(num);
                tbl.addCell(id);
                tbl.addCell(status);
                tbl.addCell(location);
                tbl.addCell(date); 
    }
            doc.add(tbl);
            doc.close();
    }catch(Exception e){
        System.out.println(e);}
    }


}
    
   
    
/*String path = "";
        JFileChooser fch = new JFileChooser();
        fch.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = fch.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = fch.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "pdfExport.pdf"));
            doc.open();

            PdfPTable tbl = new PdfPTable(5);
            tbl.addCell("Складова Разписка");
            tbl.addCell("Опаковка");
            tbl.addCell("Статус");
            tbl.addCell("Клиент");
            tbl.addCell("Дата");
            for (int i = 0; i < AllFrameTable.getRowCount(); i++) {
                String num = AllFrameTable.getValueAt(i, 0).toString();
                String id = AllFrameTable.getValueAt(i, 1).toString();
                String status = AllFrameTable.getValueAt(i, 2).toString();
                String location = AllFrameTable.getValueAt(i, 3).toString();
                String date = AllFrameTable.getValueAt(i, 4).toString();
                tbl.addCell(num);
                tbl.addCell(id);
                tbl.addCell(status);
                tbl.addCell(location);
                tbl.addCell(date);
            }
            doc.add(tbl);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AllJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(AllJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();*/