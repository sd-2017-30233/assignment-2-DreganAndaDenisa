/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Anda
 */
public class Controller {
     
    private GUI gui;
    private Model model=new Model();
    	 public Controller(GUI gui) {
             
	        this.gui = gui;
	        gui.searchAuthor(new searchAuthorListener());
                gui.searchTitle(new searchTitleListener());
                gui.searchGenre(new searchGenreListener());
                gui.sellBook(new sellListener());
                
                
                gui.addBook(new insertBookListener());
                  gui.updateBook(new updateBookListener());
                gui.deleteBook(new deleteBookListener());
                gui.viewBook(new viewBook());
                gui.addUser(new insertEmployeeListener());
                 gui.updateUser(new updateEmployeeListener());
                gui.deleteUser(new deleteEmployeeListener());
                gui.viewUser(new viewEmpl());
                
                gui.report1(new reportListener());
	    }
	 
    
     class searchAuthorListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e)  {
			
             String author=gui.getAuthor();
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
               
		String titlee=model.getBookTitleByAuthor(doc,xpath,author);
                String genre=model.getBookGenreByAuthor(doc,xpath,author);
                Double price=model.getBookPriceByAuthor(doc,xpath,author);
                Double quan=model.getBookQuantityByAuthor(doc,xpath,author);
              //  System.out.println(titlee);
                JOptionPane.showMessageDialog(null, "Titlul cartii este: "+titlee+"\nGenul: "+genre+"\nPretul: "+price+"\nCantitatea"+quan, null, JOptionPane.INFORMATION_MESSAGE); 
               
         } catch (ParserConfigurationException | SAXException | IOException re) {
            re.printStackTrace();
        }
                          
                    }
}
     
     
     
        class searchTitleListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e)  {
			
             String title=gui.getTitle();
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
               
		String author=model.getBookAuthorByTitle(doc,xpath,title);
                String genre=model.getBookGenreByTitle(doc,xpath,title);
                 Double price=model.getBookPriceByTitle(doc,xpath,title);
                Double quan=model.getBookQuantityByTitle(doc,xpath,title);
               // System.out.println(author);
               JOptionPane.showMessageDialog(null, "Autorul cartii este: "+author+"\nGenul: "+genre+"\nPretul: "+price+"\nCantitatea"+quan, null, JOptionPane.INFORMATION_MESSAGE);
         } catch (ParserConfigurationException | SAXException | IOException re) {
            re.printStackTrace();
        }
                          
                    }
}
        
        
         class searchGenreListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e)  {
			
             String genre=gui.getGenre();
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
               
		String author=model.getBookAuthorByGenre(doc,xpath,genre);
                String title=model.getBookTitleByGenre(doc,xpath,genre);
                Double price=model.getBookPriceByGenre(doc,xpath,genre);
                Double quantity=model.getBookQuantityByGenre(doc,xpath,genre);
              //  System.out.println(author);
               JOptionPane.showMessageDialog(null, "Autorul cartii este: "+author+"\nTitlul este:"+title+"\nPretul: "+price+"\nCantitatea"+quantity, null, JOptionPane.INFORMATION_MESSAGE);
         } catch (ParserConfigurationException | SAXException | IOException re) {
            re.printStackTrace();
        }
                          
                    }
         }
         
         
         
         class sellListener implements ActionListener{
         
         @Override
		public void actionPerformed(ActionEvent e)  {
                 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        String title=gui.getTitle();
        Integer qu=gui.getQuantity();
        
         String xmlFilePath = "C:\\Users\\Anda\\Documents\\NetBeansProjects\\Bookstore\\book.xml";
                    try{
                     
            builder = factory.newDocumentBuilder();
            doc = builder.parse("C:/Users/Anda/Documents/NetBeansProjects/Bookstore/book.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath);
               
	Double quant=model.getQuantityByTitle(document,xpath,title);
        System.out.println(quant);
        Double idb=model.getIdBookByTitle(document,xpath,title);    
        System.out.println(idb.intValue());
         
                if(quant-qu>=0){JOptionPane.showMessageDialog(null, "Carte vanduta cu succes!", null, JOptionPane.INFORMATION_MESSAGE);}
                    else {JOptionPane.showMessageDialog(null, "Cantitate insuficienta!", null, JOptionPane.ERROR_MESSAGE);
     }
            
            int bun=(idb).intValue();
            //System.out.println(bun);
            Node employee = document.getElementsByTagName("book").item(bun-1);

             NodeList nodes = employee.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {

                Node element = nodes.item(i);

                if ("quantity".equals(element.getNodeName())&& quant-qu>0) {
                    
 String ceva=String.valueOf(quant-qu);
 
 element.setTextContent(ceva);
 System.out.println(element.getTextContent());
                }
              
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
          DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);
           // JOptionPane.showMessageDialog(null, "Carte vanduta cu succces!", null, JOptionPane.INFORMATION_MESSAGE);
     }
       
                    }   catch (ParserConfigurationException pce) {

            pce.printStackTrace();

        } catch (TransformerException tfe) {

            tfe.printStackTrace();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        } catch (SAXException sae) {

            sae.printStackTrace();

          }
           
         }
         }
         
         
         
          class insertBookListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e)  {
		boolean ok=false;	
         String genre=gui.getGenread();
         String title=gui.getTitlead();
         String author=gui.getAuthorad();
         Integer year=gui.getYearad();
         Integer price=gui.getPricead();
         Integer quantity=gui.getQuantityad();
         
         
           String xmlFilePath = "C:\\Users\\Anda\\Documents\\NetBeansProjects\\Bookstore\\book.xml";
  try {
   Integer idb=gui.getIdbad();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath);
            Node books = document.getElementsByTagName("book").item(idb-1);
            Node new1=document.createElement("genre");
             Node new2=document.createElement("title");
             Node new3=document.createElement("author");
             Node new4=document.createElement("year");
             Node new5=document.createElement("price");
             Node new6=document.createElement("quantity");
             
             
             Node nodes = books.appendChild(new1);
             Node nodes2 = books.appendChild(new2);
             Node nodes3 = books.appendChild(new3);
             Node nodes4 = books.appendChild(new4);
              Node nodes5 = books.appendChild(new5);
             Node nodes6 = books.appendChild(new6);
             
             
             NodeList nodestot = books.getChildNodes();

            for (int i = 0; i < nodestot.getLength(); i++) {

                Node element = nodestot.item(i);

                if ("genre".equals(element.getNodeName())) {
ok=true;
                    element.setTextContent(genre);
                }
                 if ("title".equals(element.getNodeName())) {
ok=true;
                    element.setTextContent(title);
                  //   JOptionPane.showMessageDialog(null, "Cartea a fost adaugata cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
           
                }
                 
                  if ("author".equals(element.getNodeName())) {
ok=true;
                    element.setTextContent(author);
                }
                  
                  
                if ("year".equals(element.getNodeName())) {
ok=true;
                    element.setTextContent(year.toString());
                }
                 if ("price".equals(element.getNodeName())) {
ok=true;
                    element.setTextContent((price.toString()));
                }
                 
                  if ("quantity".equals(element.getNodeName())) {
ok=true;
                    element.setTextContent(quantity.toString());
                }
            }
             
           if(ok==true)
             { JOptionPane.showMessageDialog(null, "Cartea a fost adaugata cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
             }
             else{JOptionPane.showMessageDialog(null, "Cartea nu a fost adaugata cu succes!", null, JOptionPane.ERROR_MESSAGE);}
           
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
          DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);


        } catch (ParserConfigurationException pce) {

            pce.printStackTrace();

        } catch (TransformerException tfe) {

            tfe.printStackTrace();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        } catch (SAXException sae) {

            sae.printStackTrace();

        }

    }

                   
}
         
         
         
         class updateBookListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e)  {
			boolean ok=true;
         String genre=gui.getGenread();
         
           String xmlFilePath = "C:\\Users\\Anda\\Documents\\NetBeansProjects\\Bookstore\\book.xml";
  try {
   Integer idb=gui.getIdbad();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath);
            Node books = document.getElementsByTagName("book").item(idb-1);

             NodeList nodes = books.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {

                Node element = nodes.item(i);

                if ("genre".equals(element.getNodeName())) {
ok=true;
                    element.setTextContent(genre);
                      //JOptionPane.showMessageDialog(null, "Cartea a fost actualizata cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                }
               }
            
    if(ok==true)
             { JOptionPane.showMessageDialog(null, "Cartea a fost actualizata cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
             }
             else{JOptionPane.showMessageDialog(null, "Cartea nu a fost actualizata cu succes!", null, JOptionPane.ERROR_MESSAGE);}
                   
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
          DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);


        } catch (ParserConfigurationException pce) {

            pce.printStackTrace();

        } catch (TransformerException tfe) {

            tfe.printStackTrace();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        } catch (SAXException sae) {

            sae.printStackTrace();

        }

    }

                   
}
          
          class deleteBookListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e)  {
			boolean ok=false;
                    String xmlFilePath = "C:\\Users\\Anda\\Documents\\NetBeansProjects\\Bookstore\\book.xml";
  try {
            Integer idb=gui.getIdbad();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath);
            Node books = document.getElementsByTagName("book").item(idb-1);

             NodeList nodes = books.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {

                Node element = nodes.item(i);
                if ("genre".equals(element.getNodeName())) {
ok=true;
                    books.removeChild(element);

                }
                
                 if ("title".equals(element.getNodeName())) {
ok=true;
                    books.removeChild(element);
//JOptionPane.showMessageDialog(null, "Cartea a fost stearsa cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
                
    
                }
                 if ("author".equals(element.getNodeName())) {
ok=true;
                    books.removeChild(element);

                }
                 if ("year".equals(element.getNodeName())) {
ok=true;
                    books.removeChild(element);

                }
                 if ("price".equals(element.getNodeName())) {
ok=true;
                    books.removeChild(element);

                }
                 if ("quantity".equals(element.getNodeName())) {
ok=true;
                    books.removeChild(element);
             }
                
               

            }
            
            if(ok==true)
             { JOptionPane.showMessageDialog(null, "Cartea a fost stearsa cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
             }
             else{JOptionPane.showMessageDialog(null, "Cartea nu a fost stearsa cu succes!", null, JOptionPane.ERROR_MESSAGE);}
           

            // write the DOM object to the file

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();

            DOMSource domSource = new DOMSource(document);

 

            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException pce) {

            pce.printStackTrace();

        } catch (TransformerException tfe) {

            tfe.printStackTrace();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        } catch (SAXException sae) {

            sae.printStackTrace();

        }

    }
    
                    
                }
         
          
          class viewBook implements ActionListener {
              
              
              @Override
		public void actionPerformed(ActionEvent e)  {
                
                    
                     String title=gui.getTitlead();
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
               
	String author=model.getBookAuthorByTitle(doc,xpath,title);
                String genre=model.getBookGenreByTitle(doc,xpath,title);
                 Double price=model.getBookPriceByTitle(doc,xpath,title);
                Double quan=model.getBookQuantityByTitle(doc,xpath,title);
               // System.out.println(author);
               JOptionPane.showMessageDialog(null, "Autorul cartii este: "+author+"\nGenul: "+genre+"\nPretul: "+price+"\nCantitatea"+quan, null, JOptionPane.INFORMATION_MESSAGE);
         } catch (ParserConfigurationException | SAXException | IOException re) {
            re.printStackTrace();
        }
                          
                    
                    
                }
              
              
          }
         
         
         
           class insertEmployeeListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e)  {
			
         String name=gui.getNameu();
         Integer age=gui.getAgeu();
        boolean ok=false;
         
         
           String xmlFilePath = "C:\\Users\\Anda\\Documents\\NetBeansProjects\\Bookstore\\employee.xml";
  try {
   Integer ide=gui.getIde();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath);
            Node books = document.getElementsByTagName("employee").item(ide-1);
            Node new1=document.createElement("name");
             Node new2=document.createElement("age");
            
             
             
             Node nodes = books.appendChild(new1);
             Node nodes2 = books.appendChild(new2);
        
             
             NodeList nodestot = books.getChildNodes();

            for (int i = 0; i < nodestot.getLength(); i++) {

                Node element = nodestot.item(i);

                if ("name".equals(element.getNodeName())) {
    ok=true;
                    element.setTextContent(name);
                }
                 if ("age".equals(element.getNodeName())) {
ok=true;
                    element.setTextContent(age.toString());
                }
              
                 
       
            
            }
             if(ok==true)
             { JOptionPane.showMessageDialog(null, "Employee a fost adaugat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
             }
             else{JOptionPane.showMessageDialog(null, "Employee nu a fost adaugat cu succes!", null, JOptionPane.ERROR_MESSAGE);}
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
          DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);


        } catch (ParserConfigurationException pce) {

            pce.printStackTrace();

        } catch (TransformerException tfe) {

            tfe.printStackTrace();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        } catch (SAXException sae) {

            sae.printStackTrace();

        }

    }

                   
}
         
         
          
          
          
          
          class updateEmployeeListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e)  {
			boolean ok=false;
         String nume=gui.getNameu();
         
           String xmlFilePath = "C:\\Users\\Anda\\Documents\\NetBeansProjects\\Bookstore\\employee.xml";
  try {
   Integer ide=gui.getIde();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath);
            Node employee = document.getElementsByTagName("employee").item(ide-1);

             NodeList nodes = employee.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {

                Node element = nodes.item(i);

                if ("name".equals(element.getNodeName())) {
ok=true;
                    element.setTextContent(nume);
        
                }
            
            }
            if(ok==true)
            {  JOptionPane.showMessageDialog(null, "Employee a fost actualizat cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
            }
              else{JOptionPane.showMessageDialog(null, "Employee nu a fost actualizat cu succes!", null, JOptionPane.ERROR_MESSAGE);}
             
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
          DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);


        } catch (ParserConfigurationException pce) {

            pce.printStackTrace();

        } catch (TransformerException tfe) {

            tfe.printStackTrace();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        } catch (SAXException sae) {

            sae.printStackTrace();

        }

    }

                   
}
          
          class deleteEmployeeListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e)  {
			boolean ok=false;
                    String xmlFilePath = "C:\\Users\\Anda\\Documents\\NetBeansProjects\\Bookstore\\employee.xml";
  try {
            Integer ide=gui.getIde();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath);
            Node employee = document.getElementsByTagName("employee").item(ide-1);

             NodeList nodes = employee.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {

                Node element = nodes.item(i);
                if ("name".equals(element.getNodeName())) {

                    employee.removeChild(element);
                    ok=true;
              }
                
                 if ("age".equals(element.getNodeName())) {

                    employee.removeChild(element);
                    ok=true;

                }

            }
 if(ok==true){JOptionPane.showMessageDialog(null, "Employee a fost sters cu succes!", null, JOptionPane.INFORMATION_MESSAGE);
 }
   else{JOptionPane.showMessageDialog(null, "Employee nu a fost sters cu succes!", null, JOptionPane.ERROR_MESSAGE);}
             
   
            // write the DOM object to the file

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();

            DOMSource domSource = new DOMSource(document);

 

            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException pce) {

            pce.printStackTrace();

        } catch (TransformerException tfe) {

            tfe.printStackTrace();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        } catch (SAXException sae) {

            sae.printStackTrace();

        }

    }
    
                    
                }
          
          
          
           class viewEmpl implements ActionListener {
              
              
              @Override
		public void actionPerformed(ActionEvent e)  {
                
                    
                     String name=gui.getNameu();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("/Users/Anda/Documents/NetBeansProjects/Bookstore/employee.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
               
	Double varsta=model.getEmployeeAgeByName(doc,xpath,name);
            
               // System.out.println(author);
               JOptionPane.showMessageDialog(null, "Varsta angajatului cu numele "+name+" este: "+varsta, null, JOptionPane.INFORMATION_MESSAGE);
         } catch (ParserConfigurationException | SAXException | IOException re) {
            re.printStackTrace();
        }
                          
                    
                    
                }
              
              
          }
         
         public class reportListener implements ActionListener
         {
              @Override
		public void actionPerformed(ActionEvent e)  {
                
                    String format=gui.getFormat();
                    
                     ReportFactory rFactory = new ReportFactory();
if(format.equals("pdf")){
      //get an object of Circle and call its draw method.
      ReportFactoryI r1 = rFactory.getReport(format);
try{
      //call draw method of Circle
      r1.gen();
       JOptionPane.showMessageDialog(null, "S-a create fisierul cu formatul "+format, null, JOptionPane.INFORMATION_MESSAGE);
}
catch (Exception ee) {
ee.printStackTrace();

}}
if(format.equals("csv")){
      //get an object of Rectangle and call its draw method.
          ReportFactoryI r2 = rFactory.getReport(format);
try{
      //call draw method of Circle
      r2.gen();
        JOptionPane.showMessageDialog(null, "S-a create fisierul cu formatul "+format, null, JOptionPane.INFORMATION_MESSAGE);
      
}
catch (Exception ee) {
ee.printStackTrace();

}}
  
    
                }
         }
         
         }
          

     
                         


