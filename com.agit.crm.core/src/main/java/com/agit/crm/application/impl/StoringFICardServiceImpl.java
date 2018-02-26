/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.application.impl;

import au.com.bytecode.opencsv.CSVReader;
import com.agit.crm.application.util.Dir;
import com.agit.crm.application.util.Zip;
import com.agit.crm.common.application.StoringFICardService;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTO;
import com.agit.crm.domain.storing.fi.card.StoringFICard;
import com.agit.crm.domain.storing.fi.card.StoringFICardBuilder;
import com.agit.crm.domain.storing.fi.card.StoringFICardRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.storing.fi.card.StoringFICardDTOAssembler;
import com.agit.crm.shared.status.StatusResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.Validate;

/**
 *
 * @author BayuHS
 */
public class StoringFICardServiceImpl implements StoringFICardService {

    private StoringFICardRepository storingFICardRepository;
    private StoringFICardDTOAssembler storingFICardDTOAssembler;
    private StoringFICardService storingFICardService;

    public void setStoringFICardRepository(StoringFICardRepository storingFICardRepository) {
        this.storingFICardRepository = storingFICardRepository;
    }

    public void setStoringFICardDTOAssembler(StoringFICardDTOAssembler storingFICardDTOAssembler) {
        this.storingFICardDTOAssembler = storingFICardDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(StoringFICardDTO storingFICard) {
        StoringFICard t = storingFICardRepository.findByID(storingFICard.getStoringFICardID());

        if (t == null) {
            t = storingFICardDTOAssembler.toDomain(storingFICard);
        } else {
            StoringFICard newStoring = storingFICardDTOAssembler.toDomain(storingFICard);
            t.assignNewStoring(newStoring);

        }
        storingFICardRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(StoringFICardDTO storingFICard) {
        StoringFICard p = storingFICardDTOAssembler.toDomain(storingFICard);
        storingFICardRepository.deleteData(p);
    }

    @Override
    public StoringFICardDTO getDummyData() {
        StoringFICard storingFICard = new StoringFICardBuilder()
                .setStoringFICardID("storingFICardID01")
                .setPointCheck1("|")
                .setPointCheck2("|")
                .setPointCheck3("|")
                .setPointCheck4("X")
                .setPointCheck5("O")
                .setStatusResult(StatusResult.G)
                .createStoringFICard();
        return storingFICardDTOAssembler.toDTO(storingFICard);
    }

    @Override
    public StoringFICardDTO findByID(String storingFICardID) {
        Validate.notNull(storingFICardRepository);
        StoringFICard b = (StoringFICard) storingFICardRepository.findByID(storingFICardID);
        if (b != null) {
            return storingFICardDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<StoringFICardDTO> findAll() {
        Validate.notNull(storingFICardRepository);
        return storingFICardDTOAssembler.toDTOs(storingFICardRepository.findAll());
    }

    @Override
    public List<StoringFICardDTO> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eventScheduler() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String ABS_OUTBOX_LOC = "D:\\BOX\\OUTBOX\\";
        String ABS_PROCESS_LOC = "D:\\BOX\\PROCESS\\";
        String ABS_ARCHIVE_LOC = "D:\\BOX\\ARCHIVE\\";
        String ABS_FAILED_LOC = "D:\\BOX\\FAILED\\";
        String fileName = null;
        String ABS_ext = ".csv";
        
        Validate.notNull(storingFICardRepository);

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
                        List<StoringFICard> storingFICards = processDataEmp(tmp.getAbsolutePath().toString());
                        if (storingFICards != null) {
                            saveTemp(storingFICards);
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

    public void saveTemp(List<StoringFICard> storingFICards) throws FileNotFoundException {
        for (StoringFICard storingFICard : storingFICards) {
            if (storingFICard.getPointCheck1().equalsIgnoreCase("|")
//                    && storingFICard.getPointCheck2().equalsIgnoreCase("|")
                    && storingFICard.getPointCheck3().equalsIgnoreCase("|")
                    && storingFICard.getPointCheck4().equalsIgnoreCase("|")
                    && storingFICard.getPointCheck5().equalsIgnoreCase("|")) {
                storingFICard.setStatusResult(StatusResult.G);
            } else {
                storingFICard.setStatusResult(StatusResult.NG);
            }
            storingFICardRepository.saveOrUpdate(storingFICard);
        }

    }

    private CSVReader readCsv(String pathFile) throws IOException {
        CSVReader csvr = null;
        csvr = new CSVReader(new FileReader(pathFile), ',');
        return csvr;
    }

    private List<StoringFICard> processDataEmp(String pathFile)
            throws IOException {
        List<StoringFICard> storingFICards = new ArrayList<>();
        CSVReader csvr = readCsv(pathFile);
        List<String[]> records = null;
        records = csvr.readAll();
        int count = 1;
        try {
            for (String[] record : records) {
                StoringFICard mstemplmnts = new StoringFICard();
                mstemplmnts.setStoringFICardID(record[0]);
                mstemplmnts.setPointCheck1(record[1]);
//                mstemplmnts.setPointCheck2(record[2]);
                mstemplmnts.setPointCheck3(record[3]);
                mstemplmnts.setPointCheck4(record[4]);
                mstemplmnts.setPointCheck5(record[5]);
                System.out.println("Read Row " + count++);
                storingFICards.add(mstemplmnts);
            }
        } catch (Exception e) {
            String error = "Error at row " + count + " from total " + records.size();
        } finally {
            csvr.close();
        }

        return storingFICards;
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
