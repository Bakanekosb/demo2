/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.QLnhansu;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Admin
 */
public class PDF {
    public static void main(String[] args) {
       PDF p =new PDF();
       p.pdf();


    }
    public  void pdf (){
   
        try {
            com.itextpdf.text.Rectangle rg = new  com.itextpdf.text.Rectangle(600, 800, 30, 30);
             Document dc = new Document(rg);
          PdfWriter.getInstance(dc, new FileOutputStream("abc.pdf"));
          dc.open();
          dc.add(new Paragraph("Hóa Đơn Nạp Tiền Thư Viện Xpoly"));
          dc.add(new Paragraph("Hóa Đơn Nạp Tiền Thư Viện Xpoly"));
          dc.close();
            System.out.println("1");
        } catch (Exception e) {
        }
     
    }
}
