/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Anda
 */
public class Report2 implements Report{
    Model model=new Model();

      @Override
      public void generate()
      {
          
 String COMMA_DELIMITER = ",";
String NEW_LINE_SEPARATOR = "\n";
String FILE_HEADER = "title"+COMMA_DELIMITER+" author";


FileWriter fileWriter = null;

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
    
    fileWriter = new FileWriter("hello1.csv");
    fileWriter.append(FILE_HEADER.toString());
    fileWriter.append(NEW_LINE_SEPARATOR);
    
    fileWriter.append(title);
    fileWriter.append(COMMA_DELIMITER);
    fileWriter.append(author);
    fileWriter.append(NEW_LINE_SEPARATOR);
    
    
} catch (Exception e) {
    
    System.out.println("Error in CsvFileWriter !!!");
    e.printStackTrace();
    
} finally {
    
    try {
        
        fileWriter.flush();
        fileWriter.close();
        
    } catch (IOException e) {
        
        System.out.println("Error while flushing/closing fileWriter !!!");
        
        e.printStackTrace();
    }
    
}
}
}

