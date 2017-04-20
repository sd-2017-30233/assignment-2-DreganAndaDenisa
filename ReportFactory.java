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
    

    public ReportFactoryI getReport(String reportType){
      if(reportType == null){
         return null;
      }		
      if(reportType.equalsIgnoreCase("pdf")){
         return new ReportPDFFactory();
         
      } else if(reportType.equalsIgnoreCase("csv")){
         return new ReportCSVFactory();
}
        return null;
    }
}
