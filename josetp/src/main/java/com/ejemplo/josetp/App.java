package com.ejemplo.josetp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class App 
{
	public static void main(String[] args)
    {
        writePDF();
    }    
    private static void writePDF() { 
        Document document = new Document();
        try {
        	String path = new File(".").getCanonicalPath();
        	String FILE_NAME = path + "xD.pdf"; //nombre de archivo       	
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open(); 
            Paragraph paragraphHello = new Paragraph();
            paragraphHello.add("Esto es una prueba de texto");
            paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED); //justificado
            document.add(paragraphHello);
            Paragraph paragraphLorem = new Paragraph(); //nuevo parrafo
            paragraphLorem.add("Parrafo 1 test."
            		+ "Texto parrafo 1."
            		+ "Texto parrafo 1."
            		+ "Texto parrafo 1."
            		+ "Fin Texto parrafo 1. ");
            
            java.util.List<Element> paragraphList = new ArrayList<>();           
            paragraphList = paragraphLorem.breakUp();
            Font f = new Font();
            f.setFamily(FontFamily.COURIER.name());
            f.setStyle(Font.BOLDITALIC);
            f.setSize(8);
            document.add(paragraphLorem);
            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		} 
    }
}