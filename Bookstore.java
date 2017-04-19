/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author Anda
 */
public class Bookstore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
         try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
	           public void run()
	           {
	        	GUI view=new GUI();
			Controller controller = new Controller(view);
	       		view.setVisible(true);
	           }
	       });
        
        

        
        
    /*    try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
	           public void run()
	           {
	        	GUI userInterface = new GUI();
	       		userInterface.setVisible(true);
	           }
	       });
	
  */

        /*
        // TODO code application logic here
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("/Users/Anda/Documents/NetBeansProjects/Bookstore/book.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();

            String title = getBookTitleByAuthor(doc, xpath,"Giada De Laurentiis");
           // String name=getEmployeeNameById(doc,xpath,3);
            //System.out.println("Empl name is: " + name);
            System.out.println("Book title is: " + title);
         } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        
        /* try {

	File fXmlFile = new File("/Users/Anda/Documents/NetBeansProjects/Bookstore/employee.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("employee");

	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println(" Id : " + eElement.getAttribute("id"));
			System.out.println("First Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
			System.out.println("Age : " + eElement.getElementsByTagName("age").item(0).getTextContent());
			//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }*/
        
      /*  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
       try{
            builder = factory.newDocumentBuilder();
            doc = builder.parse("/Users/Anda/Documents/NetBeansProjects/Bookstore/book.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
        String title = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[quantity=0.0]/title/text()");
            
            title = (String) expr.evaluate(doc, XPathConstants.STRING);
           System.out.println(title);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
} catch (ParserConfigurationException | SAXException | IOException re) {
            re.printStackTrace();

    
    }*/
    }
    
    
      protected static String getBookTitleByAuthor(Document doc, XPath xpath, String author) {
        String title = null;
        try {
            System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[author='" + author + "']/title/text()");
            
            title = (String) expr.evaluate(doc, XPathConstants.STRING);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return title;
    }
    
    
    private static String getEmployeeNameById(Document doc, XPath xpath, int id) {
        String name = null;
        try {
            XPathExpression expr =
                xpath.compile("/bookstore/employee[@id='" + id + "']/name/text()");
            name = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return name;
    }
}
    

