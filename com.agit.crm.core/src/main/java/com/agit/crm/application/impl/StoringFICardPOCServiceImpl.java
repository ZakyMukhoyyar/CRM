/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools 1 Templates
 * and open the template in the editor.
 */
package com.agit.crm.application.impl;

import au.com.bytecode.opencsv.CSVReader;
import com.agit.crm.application.util.Dir;
import com.agit.crm.application.util.Zip;
import com.agit.crm.common.application.StoringFICardPOCService;
import com.agit.crm.common.dto.storing.fi.card.poc.StoringFICardPOCDTO;
import com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOC;
import com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOCRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.storing.fi.card.poc.StoringFICardPOCDTOAssembler;
import com.agit.crm.shared.status.StatusResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.Validate;

/**
 *
 * @author BayuHS
 */
public class StoringFICardPOCServiceImpl implements StoringFICardPOCService {

    private StoringFICardPOCService storingFICardPOCService;
    private StoringFICardPOCRepository storingFICardPOCRepository;
    private StoringFICardPOCDTOAssembler storingFICardPOCDTOAssembler;

    public void setStoringFICardPOCService(StoringFICardPOCService storingFICardPOCService) {
        this.storingFICardPOCService = storingFICardPOCService;
    }

    public void setStoringFICardPOCRepository(StoringFICardPOCRepository storingFICardPOCRepository) {
        this.storingFICardPOCRepository = storingFICardPOCRepository;
    }

    public void setStoringFICardPOCDTOAssembler(StoringFICardPOCDTOAssembler storingFICardPOCDTOAssembler) {
        this.storingFICardPOCDTOAssembler = storingFICardPOCDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(StoringFICardPOCDTO storingFICardPOC) {
        StoringFICardPOC t = storingFICardPOCRepository.findByID(storingFICardPOC.getFrameNumber());

        if (t == null) {
            t = storingFICardPOCDTOAssembler.toDomain(storingFICardPOC);
        } else {
            StoringFICardPOC newStoring = storingFICardPOCDTOAssembler.toDomain(storingFICardPOC);
            t.assignNewStoringPoc(newStoring);

        }
        storingFICardPOCRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(StoringFICardPOCDTO storingFICard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools 1 Templates.
    }

    @Override
    public StoringFICardPOCDTO findByID(String storingFICardPocID) {
        Validate.notNull(storingFICardPOCRepository);
        StoringFICardPOC b = (StoringFICardPOC) storingFICardPOCRepository.findByID(storingFICardPocID);
        if (b != null) {
            return storingFICardPOCDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<StoringFICardPOCDTO> findAll() {
        Validate.notNull(storingFICardPOCRepository);
        return storingFICardPOCDTOAssembler.toDTOs(storingFICardPOCRepository.findAll());
    }

    @Override
    public void eventStoringPOCScheduler() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String ABS_OUTBOX_LOC = "D:\\BOX\\OUTBOX\\";
        String ABS_PROCESS_LOC = "D:\\BOX\\PROCESS\\";
        String ABS_ARCHIVE_LOC = "D:\\BOX\\ARCHIVE\\";
        String ABS_FAILED_LOC = "D:\\BOX\\FAILED\\";
        String fileName = null;
        String ABS_ext = ".txt";

        Validate.notNull(storingFICardPOCRepository);

        File[] files = null;
        Dir dir = new Dir(ABS_OUTBOX_LOC, ABS_ext);
        files = dir.listFiles();
        if (files.length > 0) {
            for (int index = 0; index < files.length; index++) {
                try {
                    File file = files[index];
                    if (!file.exists()) {
                        continue;
                    }
                    fileName = file.getName();
                    fileName = fileName.substring(0, fileName.indexOf("."));
                    File tmp = new File(ABS_PROCESS_LOC.concat(fileName + ".PRC"));
                    copyFileUsingFileStreams(file, tmp);
                    try {
                        List<StoringFICardPOC> storingFICardPOCs = processDataEmp(tmp.getAbsolutePath().toString());
                        if (storingFICardPOCs != null) {
                            saveTemp(storingFICardPOCs);
                            Zip.createArchiveZip(sdf.format(new Date()), ABS_OUTBOX_LOC, ABS_ext, ABS_ARCHIVE_LOC, true, "ARCHIVE_" + file.getName().substring(0, file.getName().indexOf(".")) + "_", file);
                        }
                    } catch (Exception e) {
                        File tmp2 = new File(ABS_FAILED_LOC.concat(fileName + ABS_ext));
                        copyFileUsingFileStreams(file, tmp2);
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    cleanDirOutputAfterProcess(ABS_PROCESS_LOC);

                } catch (IOException ex) {
                    Logger.getLogger(StoringFICardServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }

    public void saveTemp(List<StoringFICardPOC> storingFICardPOCs) throws FileNotFoundException {
        for (StoringFICardPOC storingFICardPOC : storingFICardPOCs) {
            if (storingFICardPOC.getStage4PoinCheck5().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage1PoinCheck1().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage1PoinCheck2().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage1PoinCheck3().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage1PoinCheck4().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage1PoinCheck5().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage1PoinCheck6().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage2PoinCheck1().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage2PoinCheck2().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage2PoinCheck3().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage2PoinCheck4().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage2PoinCheck5().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage3PoinCheck1().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage3PoinCheck2().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage4PoinCheck1().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage4PoinCheck2().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage4PoinCheck3().equalsIgnoreCase("1")
                    && storingFICardPOC.getStage4PoinCheck4().equalsIgnoreCase("1")) {
                storingFICardPOC.setStatusResult(StatusResult.G);
            } else {
                storingFICardPOC.setStatusResult(StatusResult.NG);
            }
            storingFICardPOCRepository.saveOrUpdate(storingFICardPOC);
        }

    }

    private List<StoringFICardPOC> processDataEmp(String pathFile)
            throws IOException {
        List<StoringFICardPOC> storingFICardPOCs = new ArrayList<>();
        CSVReader csvr = readCsv(pathFile);
        List<String[]> records = null;
        records = csvr.readAll();
        int count = 1;
        try {
            for (String[] record : records) {
                StoringFICardPOC storingFICardPOC = new StoringFICardPOC();
                storingFICardPOC.setStoringFICardPocID(record[3]);
                storingFICardPOC.setFiCard(record[1]);
                storingFICardPOC.setFrameNumber(record[3]);
                storingFICardPOC.setFileName(record[5]);
                storingFICardPOC.setStage1(record[7]);
                storingFICardPOC.setStage2(record[9]);
                storingFICardPOC.setStage3(record[11]);
                storingFICardPOC.setStage4(record[13]);
                storingFICardPOC.setStage4PoinCheck5(record[15]);
                storingFICardPOC.setStage1PoinCheck1(record[17]);
                storingFICardPOC.setStage1PoinCheck2(record[19]);
                storingFICardPOC.setStage1PoinCheck3(record[21]);
                storingFICardPOC.setStage1PoinCheck4(record[23]);
                storingFICardPOC.setStage1PoinCheck5(record[25]);
                storingFICardPOC.setStage1PoinCheck6(record[27]);
                storingFICardPOC.setStage2PoinCheck1(record[29]);
                storingFICardPOC.setStage2PoinCheck2(record[31]);
                storingFICardPOC.setStage2PoinCheck3(record[33]);
                storingFICardPOC.setStage2PoinCheck4(record[35]);
                storingFICardPOC.setStage2PoinCheck5(record[37]);
                storingFICardPOC.setStage3PoinCheck1(record[39]);
                storingFICardPOC.setStage3PoinCheck2(record[41]);
                storingFICardPOC.setStage4PoinCheck1(record[43]);
                storingFICardPOC.setStage4PoinCheck2(record[45]);
                storingFICardPOC.setStage4PoinCheck3(record[47]);
                storingFICardPOC.setStage4PoinCheck4(record[49]);
                storingFICardPOC.setPathFile(record[48]);
                storingFICardPOC.setCreatedBy("SYSTEM");
                storingFICardPOC.setCreatedDate(new Date());

                System.out.println("Read Row " + count++);
                storingFICardPOCs.add(storingFICardPOC);
            }
        } catch (Exception e) {
            String error = "Error at row " + count + " from total " + records.size();
        } finally {
            csvr.close();
        }

        return storingFICardPOCs;
    }

    private CSVReader readCsv(String pathFile) throws IOException {
        CSVReader csvr = null;
        csvr = new CSVReader(new FileReader(pathFile), ',');
        return csvr;
    }

    private void cleanDirOutputAfterProcess(String path) {
        Dir dir = new Dir(path, ".PRC");
        File[] files = dir.listFiles();

        if (files.length > 0) {
            for (int index = 0; index < files.length; index++) {
                File file = files[index];
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

}
