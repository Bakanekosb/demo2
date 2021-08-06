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
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.pdf.PdfWriter;
import com.xpoly.helper.EzHelper;
import com.xpoly.helper.LoginHelper;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Admin
 */
public class PDF {

    public static void main(String[] args) {
        PDF p = new PDF();
        p.pdf();

    }

    public void pdf() {
        com.itextpdf.text.Rectangle pageSize = new RectangleReadOnly(250, 450);
        Document dc = new Document(pageSize);

        try {
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(dc, new FileOutputStream("hoadon.pdf"));

            // mở file để thực hiện viết
            dc.open();
            dc.add(new Paragraph("hoa don nap tien thu vien Xpoly\n \n"));
            dc.add(new Paragraph(EzHelper.now() + ""));
            dc.add(new Paragraph("hoa don so"));
            dc.add(new Paragraph("tai khoan duoc nap tien : " ));
            dc.add(new Paragraph("So tien duoc nap :  "));
            dc.add(new Paragraph("Nguoi nap tien  " + LoginHelper.USER));
            
            // đóng file
            dc.close();

        } catch (DocumentException | FileNotFoundException e) {
        }

    }
}
