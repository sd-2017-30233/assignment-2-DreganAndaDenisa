/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import javax.swing.JOptionPane;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;

/**
 *
 * @author Anda
 */
public class Model {
   protected static String getBookTitleByAuthor(Document doc, XPath xpath, String author) {
        String title = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[author='" + author + "']/title/text()");
            
            title = (String) expr.evaluate(doc, XPathConstants.STRING);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return title;
    }
   
     protected static String getBookGenreByAuthor(Document doc, XPath xpath, String author) {
        String genre = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[author='" + author + "']/genre/text()");
            
            genre = (String) expr.evaluate(doc, XPathConstants.STRING);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return genre;
    }
   
     protected static Double getBookPriceByAuthor(Document doc, XPath xpath, String author) {
        Double price = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[author='" + author + "']/price/text()");
            
            price = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return price;
    }
     
     protected static Double getBookQuantityByAuthor(Document doc, XPath xpath, String author) {
        Double quan = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[author='" + author + "']/quantity/text()");
            
            quan = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return quan;
    }
     
    protected static String getBookAuthorByTitle(Document doc, XPath xpath, String title) {
        String author = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[title='" + title + "']/author/text()");
            
            author = (String) expr.evaluate(doc, XPathConstants.STRING);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return author;
    }
    
     protected static String getBookGenreByTitle(Document doc, XPath xpath, String title) {
        String genre = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[title='" + title + "']/genre/text()");
            
            genre = (String) expr.evaluate(doc, XPathConstants.STRING);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return genre;
    }
     
     
     protected static Double getBookPriceByTitle(Document doc, XPath xpath, String title) {
        Double price = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[title='" + title + "']/price/text()");
            
                price = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return price;
    }
     
      protected static Double getBookQuantityByTitle(Document doc, XPath xpath, String title) {
        Double quantity = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[title='" + title + "']/quantity/text()");
            
                quantity = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return quantity;
    }
    
    protected static String getBookAuthorByGenre(Document doc, XPath xpath, String genre) {
        String author = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[genre='" + genre + "']/author/text()");
            
            author = (String) expr.evaluate(doc, XPathConstants.STRING);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        
        return author;
    }
    
     protected static String getBookTitleByGenre(Document doc, XPath xpath, String genre) {
        String title = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[genre='" + genre + "']/title/text()");
            
            title = (String) expr.evaluate(doc, XPathConstants.STRING);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        
        return title;
    }
   
      protected static Double getBookPriceByGenre(Document doc, XPath xpath, String genre) {
        Double price = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[genre='" + genre + "']/price/text()");
            
            price = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        
        return price;
    }
      
        protected static Double getBookQuantityByGenre(Document doc, XPath xpath, String genre) {
        Double quantity = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[genre='" + genre + "']/quantity/text()");
            
            quantity = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        
        return quantity;
    }
     
     protected static Integer getEmployeeIdByName(Document doc, XPath xpath, String name) {
        Integer id = null;
        try {
            XPathExpression expr =
                xpath.compile("/bookstore/employee[name='" + name + "']/id/text()");
            id = (Integer) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

       return id;
    }
     
        protected static Double getEmployeeAgeByName(Document doc, XPath xpath, String name) {
        Double age = null;
        try {
            XPathExpression expr =
                xpath.compile("/bookstore/employee[name='" + name + "']/age/text()");
            age = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

       return age;
    }
     
      protected static Double getQuantityByTitle(Document doc, XPath xpath, String title) {
        Double quant = null;
        try {
            XPathExpression expr =
                xpath.compile("/bookstore/book[title='" + title + "']/quantity/text()");
            quant = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

       return quant;
    }
   
        protected static Double getIdBookByTitle(Document doc, XPath xpath, String title) {
        Double id = null;
        try {
            XPathExpression expr =
                xpath.compile("/bookstore/book[title='" + title + "']/id/text()");
            id = (Double)expr.evaluate(doc, XPathConstants.NUMBER);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

       return id;
    }
      
        
          protected static String getBookByTitle(Document doc, XPath xpath, String title) {
        String author = null;
        String genre = null;
        Integer price=null;
            Integer quantity=null;
        Integer year=null;
        try {
            XPathExpression expr =
                xpath.compile("/bookstore/book[title='" + title + "']/author/text()");
            author =(String) expr.evaluate(doc, XPathConstants.STRING);
            
            
            xpath.compile("/bookstore/book[title='" + title + "']/genre/text()");
            genre =(String) expr.evaluate(doc, XPathConstants.STRING);
            
            
             xpath.compile("/bookstore/book[title='" + title + "']/price/text()");
            price =(Integer) expr.evaluate(doc, XPathConstants.NUMBER);
            
            xpath.compile("/bookstore/book[title='" + title + "']/quantity/text()");
            quantity =(Integer) expr.evaluate(doc, XPathConstants.NUMBER);
            
             xpath.compile("/bookstore/book[title='" + title + "']/year/text()");
            year =(Integer) expr.evaluate(doc, XPathConstants.NUMBER);
            
             JOptionPane.showMessageDialog(null, "Autorul cartii este: "+author+ "\nGenul este"+genre+"\n Pretul este"+price+"\n An aparitie: "+year+"\n Cantitatea existenta: "+quantity, null, JOptionPane.INFORMATION_MESSAGE);
            
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

       return "ok";
    }
      
            protected static String getBookForReport(Document doc, XPath xpath) {
        String title = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("/bookstore/book[quantity=0.0]/title/text()");
            
            title = (String) expr.evaluate(doc, XPathConstants.STRING);
           
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return title;
    }
            
             protected static String getBookAForReport(Document doc, XPath xpath) {
        String author  = null;
        try {
           // System.out.println(author);
            XPathExpression expr =
                xpath.compile("//book[quantity=0.0]/author/text()");
            
            author = (String) expr.evaluate(doc, XPathConstants.STRING);
         //  System.out.println(author);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return author;
    }
          
          
          
          
      
        
}
