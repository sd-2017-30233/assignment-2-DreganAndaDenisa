/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.SAXException;

/**
*
* @author Administrateur
*/
public class Report1 implements Report
{ 
     private Model model=new Model();
    @Override
    public void generate() throws Exception
{ 
     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        org.w3c.dom.Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("/Users/Anda/Documents/NetBeansProjects/Bookstore/book.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
               
		String title=model.getBookForReport(doc,xpath);
                String author=model.getBookAForReport(doc,xpath);
              Document document=new Document(); 
PdfWriter.getInstance(document,new FileOutputStream("hello.pdf")); 
document.open(); 
document.add(new Paragraph("Titlul cartii care nu e pe stoc :"+title));
document.add(new Paragraph("Autorul cartii care nu e pe stoc :"+author));

document.close();
               // System.out.println(author);
               //JOptionPane.showMessageDialog(null, "Autorul cartii este: "+author+"\nGenul: "+genre+"\nPretul: "+price+"\nCantitatea"+quan, null, JOptionPane.INFORMATION_MESSAGE);
         } catch (ParserConfigurationException | SAXException | IOException re) {
            re.printStackTrace();
        }
                         
    
    
    
    }
}
