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
public class ReportPDFFactory implements ReportFactoryI {
      public void gen() throws Exception
    {
    ReportPDF pdf=new ReportPDF();
    pdf.generate();
    }
}