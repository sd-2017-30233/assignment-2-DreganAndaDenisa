/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author Anda
 */
public class ReportFactory {
    

    public Report getReport(String reportType){
      if(reportType == null){
         return null;
      }		
      if(reportType.equalsIgnoreCase("pdf")){
         return new Report1();
         
      } else if(reportType.equalsIgnoreCase("csv")){
         return new Report2();
}
        return null;
    }
}
