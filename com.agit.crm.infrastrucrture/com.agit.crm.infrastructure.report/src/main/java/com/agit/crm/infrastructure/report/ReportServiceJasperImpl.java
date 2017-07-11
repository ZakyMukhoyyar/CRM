package com.agit.crm.infrastructure.report;

import static com.agit.crm.infrastructure.report.AbstractReportServiceImpl.convertToParamMap;
import com.agit.crm.shared.report.FileReport;
import com.agit.crm.shared.report.ReportFormat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.FileResolver;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author bayutridewanto
 *
 */
public class ReportServiceJasperImpl extends AbstractReportServiceImpl<JasperReport> {

    private final Logger logger = LoggerFactory.getLogger(ReportServiceJasperImpl.class);
    private String rptResourcePrefix = null;
    private DataSource reportDataSource;

    protected final FileResolver FILE_RESOLVER = new FileResolver() {
        @Override
        public File resolveFile(String fileName) {
            try {
                return ResourceUtils.getFile(rptResourcePrefix + fileName);
            } catch (FileNotFoundException e) {
                return null;
            }
        }

    };

    @Override
    public OutputStream showReportBeanDataSource(String jasperFile, Map<String, Object> params, Collection<?> collection) throws GenericException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        showReportBeanDataSource(jasperFile, params, collection, out);
        return out;
    }

    @Override
    public OutputStream showReportJdbcDataSource(String jasperFile, Map<String, Object> params, Connection connection) throws GenericException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        showReportJdbcDataSource(jasperFile, params, connection, output);
        return output;
    }

    @Override
    public void showReportBeanDataSource(String jasperFile, Map<String, Object> params, Collection<?> collection, OutputStream suppliedStream) throws GenericException {
        InputStream in = null;
        try {
            in = ResourceUtils.getURL(this.rptResourcePrefix + jasperFile).openStream();
            if (collection != null) {
                if (params == null) {
                    params = new HashMap<>();
                }
                params.put("REPORT_FILE_RESOLVER", this.FILE_RESOLVER);
                JRDataSource dataSource = new JRBeanCollectionDataSource(collection);
                JasperRunManager.runReportToPdfStream(in, suppliedStream, params, dataSource);
            }
        } catch (IOException | JRException e) {
            logger.error("Failure", e);
            throw new GenericException(MessageCode.get(ReportService.class, "showReportBeanDataSource", true), e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public void showReportJdbcDataSource(String jasperFile, Map<String, Object> params, Connection connection, OutputStream suppliedStream) throws GenericException {
        InputStream in = null;
        try {
            in = ResourceUtils.getURL(this.rptResourcePrefix + jasperFile).openStream();
            if (connection != null) {
                if (params == null) {
                    params = new HashMap<>();
                }
                params.put("REPORT_FILE_RESOLVER", this.FILE_RESOLVER);
                JasperRunManager.runReportToPdfStream(in, suppliedStream, params, connection);
            }
        } catch (IOException | JRException e) {
            logger.error("Failure", e);
            throw new GenericException(MessageCode.get(ReportService.class, "showReportJdbcDataSource", true), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public OutputStream showReportJdbcDataSource(String jasperFile, Map<String, Object> params) throws GenericException {
        try {
            return showReportJdbcDataSource(jasperFile, params, this.reportDataSource.getConnection());
        } catch (GenericException e) {
            throw e;
        } catch (SQLException e) {
            logger.error("Failure", e);
            throw new GenericException(MessageCode.get(ReportService.class, "showReportJdbcDataSource", true), e);
        }
    }

    @Override
    public void showReportJdbcDataSource(String jasperFile, Map<String, Object> params, OutputStream suppliedStream) throws GenericException {
        try {
            showReportJdbcDataSource(jasperFile, params, this.reportDataSource.getConnection(), suppliedStream);
        } catch (GenericException e) {
            throw e;
        } catch (SQLException e) {
            logger.error("Failure", e);
            throw new GenericException(MessageCode.get(ReportService.class, "showReportJdbcDataSource", true), e);
        }
    }

    @Override
    public void showReport(String templateFile, Object reportParamsBean, Collection<?> beansCollectionDS, OutputStream rptOutput) throws GenericException {
        showReportBeanDataSource(templateFile, convertToParamMap(reportParamsBean), beansCollectionDS, rptOutput);
    }

    @Override
    public void showReport(String templateFile, Object reportParamsBean, OutputStream rptOutput) throws GenericException {
        showReportJdbcDataSource(templateFile, convertToParamMap(reportParamsBean), rptOutput);
    }

    @Override
    public OutputStream showReportJdbcDataSourceExportToPdfTxtCsvXls(ReportFormat format, String jasperFile, Map<String, Object> params) throws GenericException {
        try {
            return showReportJdbcDataSourceExportToPdfTxtCsvXls(format, jasperFile, params, this.reportDataSource.getConnection());
        } catch (GenericException e) {
            throw e;
        } catch (SQLException e) {
            logger.error("Failure", e);
            throw new GenericException(MessageCode.get(ReportService.class, "showReportJdbcDataSource", true), e);
        }
    }

    @Override
    public OutputStream showReportJdbcDataSourceExportToPdfTxtCsvXls(ReportFormat format, List<String> jasperFiles, Map<String, Object> params) throws GenericException {
        try {
            return showReportJdbcDataSourceExportToPdfTxtCsvXls(format, jasperFiles, params, this.reportDataSource.getConnection());
        } catch (GenericException e) {
            throw e;
        } catch (SQLException e) {
            logger.error("Failure", e);
            throw new GenericException(MessageCode.get(ReportService.class, "showReportJdbcDataSource", true), e);
        }
    }

    @Override
    public OutputStream showReportJdbcDataSourceExportToPdfTxtCsvXls(ReportFormat format, String jasperFile, Map<String, Object> params, Connection connection) throws GenericException {
        InputStream in = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            in = ResourceUtils.getURL(this.rptResourcePrefix + jasperFile).openStream();
            if (connection != null) {
                if (params == null) {
                    params = new HashMap<>();
                }
                params.put("REPORT_FILE_RESOLVER", this.FILE_RESOLVER);

                JRExporter exporter = new JRPdfExporter();
                if (format != null) {
                    if (format.equals(ReportFormat.XLS)) {
                        exporter = new JRXlsExporter();
                    } else if (format.equals(ReportFormat.CSV)) {
                        exporter = new JRCsvExporter();
                    } else if (format.equals(ReportFormat.TXT)) {
                        exporter = new JRTextExporter();
                        exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
                        exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
                    }
                }

                JasperPrint jasperPrint = JasperFillManager.fillReport(in, params, connection);
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
                exporter.exportReport();
            }
        } catch (IOException | JRException e) {
            logger.error("Failure", e);
            throw new GenericException(MessageCode.get(ReportService.class, "showReportJdbcDataSource", true), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    //ignore
                }
            }
        }
        return os;
    }

    @Override
    public OutputStream showReportJdbcDataSourceExportToPdfTxtCsvXls(ReportFormat format, List<String> jasperFiles, Map<String, Object> params, Connection connection) throws GenericException {
        InputStream in = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            if (connection != null) {
                if (params == null) {
                    params = new HashMap<>();
                }
                params.put("REPORT_FILE_RESOLVER", this.FILE_RESOLVER);

                JRExporter exporter = new JRPdfExporter();
                if (format != null) {
                    if (format.equals(ReportFormat.XLS)) {
                        exporter = new JRXlsExporter();
                    } else if (format.equals(ReportFormat.CSV)) {
                        exporter = new JRCsvExporter();
                    } else if (format.equals(ReportFormat.TXT)) {
                        exporter = new JRTextExporter();
                        exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
                        exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
                    }
                }

                List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();

                for (String jasperFile : jasperFiles) {
                    in = ResourceUtils.getURL(this.rptResourcePrefix + jasperFile).openStream();
                    jasperPrintList.add(JasperFillManager.fillReport(in, params, connection));
                }

                exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
                exporter.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
                exporter.exportReport();
            }
        } catch (IOException | JRException e) {
            logger.error("Failure", e);
            throw new GenericException(MessageCode.get(ReportService.class, "showReportJdbcDataSource", true), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    //ignore
                }
            }
        }
        return os;
    }    
    
    @Override
    public byte[] generateReport(ReportFormat reportFormat, FileReport fileReport, String param) throws GenericException {
        Map<String, Object> params = new HashMap<>();
        params.put("param", param);

        ByteArrayOutputStream os = (ByteArrayOutputStream) showReportJdbcDataSourceExportToPdfTxtCsvXls(reportFormat, fileReport.getJasperName(), params);
        
        /*validate object*/
        Validate.notNull(os);

        /*get the byte*/
        byte[] datastream = os.toByteArray();

        /*validate object*/
        Validate.notNull(datastream);

        return datastream;
    }

    /*DI*/
    public void setRptResourcePrefix(String rptResourcePrefix) {
        this.rptResourcePrefix = rptResourcePrefix;
    }

    public void setReportDataSource(DataSource reportDataSource) {
        this.reportDataSource = reportDataSource;
    }

}
