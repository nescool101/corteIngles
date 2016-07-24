/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author nestor
 */

public class MainJasper
{
    /**
     * @param args argumentos recibidos por la linea de comandos
     */
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/corteing", "root", "");
       
//       JasperCompileManager.compileReport("C:\\Users\\TOSHIBA-PC\\Documents\\NetBeansProjects\\TestCorteIngles\\reporteDos.jasper");

        JasperReport reporte = (JasperReport) JRLoader.loadObject("C:\\Users\\TOSHIBA-PC\\Documents\\NetBeansProjects\\TestCorteIngles\\reporteDos.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
       
        JRExporter exporter = new JRPdfExporter();
  /**
   *  JasperReport jasperReport = JasperCompileManager.compileReport("/home/abcd/report/R_D1.jrxml");
    System.out.println("Filling report...");
    JasperFillManager.fillReportToFile(jasperReport,new HashMap<String, Object> (), con);
  
   */      
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportePDF.pdf"));
        exporter.exportReport();
    }
}


  