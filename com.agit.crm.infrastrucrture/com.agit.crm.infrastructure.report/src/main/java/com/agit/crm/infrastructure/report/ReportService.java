package com.agit.crm.infrastructure.report;

import com.agit.crm.shared.report.FileReport;
import com.agit.crm.shared.report.ReportFormat;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Report service
 *
 * @author bayutridewanto
 *
 */
public interface ReportService {

    public abstract OutputStream showReportBeanDataSource(
            String templateFile, Map<String, Object> params,
            Collection<?> collection) throws GenericException;

    public abstract OutputStream showReportJdbcDataSource(
            String jasperFile, Map<String, Object> params, Connection connection)
            throws GenericException;

    public abstract OutputStream showReportJdbcDataSource(String templateFile, Map<String, Object> params)
            throws GenericException;

    public abstract void showReportBeanDataSource(
            String templateFile, Map<String, Object> params,
            Collection<?> collection, OutputStream suppliedStream) throws GenericException;

    public abstract void showReport(
            String templateFile, Object reportParamsBean,
            Collection<?> beansCollectionDS, OutputStream rptOutput) throws GenericException;

    public abstract void showReportJdbcDataSource(
            String templateFile, Map<String, Object> params, Connection connection,
            OutputStream rptOutput)
            throws GenericException;

    public abstract void showReportJdbcDataSource(
            String templateFile, Map<String, Object> params,
            OutputStream suppliedStream)
            throws GenericException;

    public abstract void showReport(
            String templateFile, Object reportParamsBean,
            OutputStream rptOutput)
            throws GenericException;

    public abstract OutputStream showReportJdbcDataSourceExportToPdfTxtCsvXls(ReportFormat format, String jasperFile, Map<String, Object> params) throws GenericException;
    
    public abstract OutputStream showReportJdbcDataSourceExportToPdfTxtCsvXls(ReportFormat format, List<String> jasperFiles, Map<String, Object> params) throws GenericException;

    public abstract OutputStream showReportJdbcDataSourceExportToPdfTxtCsvXls(ReportFormat format, String jasperFile, Map<String, Object> params, Connection connection) throws GenericException;
    
    public abstract OutputStream showReportJdbcDataSourceExportToPdfTxtCsvXls(ReportFormat format, List<String> jasperFiles, Map<String, Object> params, Connection connection) throws GenericException;

    void flushTemplateCache();
    
    byte[] generateReport(ReportFormat reportFormat, FileReport fileReport, String param) throws GenericException;

}
