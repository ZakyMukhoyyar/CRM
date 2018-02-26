package com.agit.crm.application.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author SembiringiO
 */
public class Zip {

    private static Logger log = Logger.getLogger(Zip.class.getName());

    public static void zipFile(String inputFile, File zip) throws Exception {
        FileInputStream in = new FileInputStream(inputFile);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                inputFile + ".zip"));
        out.putNextEntry(new ZipEntry(zip.getName()));

        byte[] b = new byte[1024];
        int count;
        while ((count = in.read(b)) > 0) {
            out.write(b, 0, count);
        }
        out.close();
        in.close();
        zip.delete();
    }

    private static void addFileToZip(ZipArchiveOutputStream zipo, File file) {
        FileInputStream fin = null;
        try {

            log.info("Zip file " + file.getName());
            ArchiveEntry entry = zipo.createArchiveEntry(file, file.getName());
            zipo.putArchiveEntry(entry);
            fin = new FileInputStream(file);
            if (file.isFile()) {
                IOUtils.copy(fin, zipo);
                zipo.closeArchiveEntry();
            }
        } catch (IOException e) {
//			log.error("Error adding file to archive", e);
        } finally {
            if (fin != null) {
                IOUtils.closeQuietly(fin);
            }
        }
    }

    public static File createArchiveZip(String date, String inputPath,
            String filterExt, String imagePath, String archivePath,
            boolean archive, String prefix_zip) throws Exception {
        String zipName = null;
        if (date != null) {
            zipName = prefix_zip.concat(date).concat(".zip");
        } else {
            zipName = prefix_zip.concat(".zip");
        }

        ZipArchiveOutputStream zipo = new ZipArchiveOutputStream(
                new FileOutputStream(inputPath + zipName));
        File[] files = null;
        try {
            Dir dir = new Dir(inputPath, filterExt);
            files = dir.listFilesByDate();

            for (int index = 0; index < files.length; index++) {
                File file = files[index];
                if (!file.isDirectory()) {
                    addFileToZip(zipo, file);
                }
                if (archive) {
                    archive(file, new File(archivePath.concat(file.getName())));
                } else {
                    file.delete();
                }

            }
            if (imagePath != null) {
                dir = new Dir(imagePath, "jpeg");
                files = dir.listFilesByDate();
                for (int index = 0; index < files.length; index++) {
                    File file = files[index];
                    if (!file.isDirectory()) {
                        addFileToZip(zipo, file);
                    }
                    if (archive) {
                        archive(file,
                                new File(archivePath.concat(file.getName())));
                    } else {
                        file.delete();
                    }
                }
            }
        } catch (Exception e) {
//			log.error(Zip.class, e);
            throw e;
        } finally {

            zipo.flush();
            zipo.finish();
            zipo.close();

        }
        return new File(inputPath, zipName);
    }

    public static File createArchiveZip(String date, String inputPath,
            String filterExt, String archivePath, boolean archive,
            String prefix_zip, File file) throws Exception {
        String zipName = null;
        if (date != null) {
            zipName = prefix_zip.concat(date).concat(".zip");
        } else {
            zipName = prefix_zip.concat(".zip");
        }

        ZipArchiveOutputStream zip = new ZipArchiveOutputStream(
                new FileOutputStream(archivePath + zipName));
        File[] files = null;
        File[] filesArchive = null;
        try {
            Dir dir = new Dir(inputPath, filterExt);

            files = dir.listFilesByDate();

            if (archive) {
                archive(file, new File(archivePath.concat(file.getName())));
            } else {
                file.delete();
            }

            Dir dirZip = new Dir(archivePath, filterExt);
            filesArchive = dirZip.listFilesByDate();
            createZip(filesArchive, zip);
        } catch (Exception e) {
//			log.error(Zip.class, e);
            throw e;
        }
        return new File(inputPath, zipName);
    }

    public static void archive(File source, File target) throws Exception {
        Dir.move(source, target);
    }

    public static void createZip(File[] files, ZipArchiveOutputStream zipo)
            throws IOException {
        for (int index = 0; index < files.length; index++) {
            File file = files[index];
            if (!file.isDirectory()) {
                addFileToZip(zipo, file);
                zipo.flush();
                zipo.finish();
                zipo.close();
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void unZipFile(String inputPath, String zipFile) {

        byte[] buffer = new byte[1024];

        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(
                    inputPath.concat("/" + zipFile)));
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File(inputPath + File.separator + fileName);
//				log.debug("Unzip file : " + zipFile);
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                ze = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();

//			log.debug("Process UnZip : " + zipFile + " ..DONE");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static File zipCreationAES(String fileZip, String inputPath,
            String filterExt, String imagePath, String archivePath,
            boolean archive, String password, String pdfPath, String serverType)
            throws Exception {

        File[] files = null;
        ZipFile zipFile = null;
        try {

            zipFile = new ZipFile(inputPath.concat(fileZip).concat(".zip"));
            Dir dir = new Dir(inputPath, filterExt);
            files = dir.listFilesByDate();
            ArrayList filesToAdd = new ArrayList();
            for (int index = 0; index < files.length; index++) {
                File file = files[index];
                if (!file.isDirectory()) {
                    File f = new File(inputPath.concat(file.getName()));
                    filesToAdd.add(f);
//					log.debug("put file " + f.getName() + " to Zip.. ");

                }
            }

            if (imagePath != null) {
                dir = new Dir(imagePath, "jpeg");
                files = dir.listFilesByDate();
                for (int index = 0; index < files.length; index++) {
                    File file = files[index];
                    if (!file.isDirectory()) {
                        File f = new File(imagePath.concat(file.getName()));
                        filesToAdd.add(f);
                        //					log.debug("put file " + f.getName() + " to Zip.. ");
                    }
                }

            }

            if (null != pdfPath) {
                dir = new Dir(pdfPath.concat("CREATION/"), "*.pdf");
                files = dir.listFilesByDate();
                for (int index = 0; index < files.length; index++) {
                    File file = files[index];
                    if (!file.isDirectory()) {
                        File f = new File(pdfPath.concat("CREATION/").concat(
                                file.getName()));
                        filesToAdd.add(f);
//						log.debug("put file " + f.getName() + " to Zip.. ");
                    }
                }
            }

            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set
            // compression
            // method
            // to
            // deflate
            // compression
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
            if (null == password) {
                password = "qwertyuiop";
            }
            parameters.setPassword(password);
            zipFile.addFiles(filesToAdd, parameters);

            dir = new Dir(inputPath, filterExt);
            files = dir.listFilesByDate();
            for (int index = 0; index < files.length; index++) {
                File f = files[index];
                if (archive) {
                    archive(f, new File(archivePath.concat(f.getName())));
//					log.debug("move file " + f.getName() + " to " + archivePath);
                } else {
                    f.delete();
                    //	log.debug("delete file " + f.getName() + " .... ");
                }
            }

            if (imagePath != null) {
                dir = new Dir(inputPath, "jpeg");
                files = dir.listFilesByDate();
                for (int index = 0; index < files.length; index++) {
                    File f = files[index];

                    if (serverType.equalsIgnoreCase("PROD")) {
                        Dir.move(f, new File(imagePath.concat(f.getName())));
                    } else {
                        archive(f, new File(archivePath.concat("IMAGE/")
                                .concat(f.getName())));
                        Thread.sleep(1000);
                        f.delete();
                    }

                }
            }

            if (pdfPath != null) {
                dir = new Dir(pdfPath.concat("CREATION/"), "pdf");
                files = dir.listFilesByDate();
                for (int index = 0; index < files.length; index++) {
                    File f = files[index];
                    if (serverType.equalsIgnoreCase("PROD")) {
                        archive(f, new File(pdfPath.concat(f.getName())));
                        Thread.sleep(1000);
                        f.delete();
                    } else {
                        Dir.move(f, new File(pdfPath.concat(f.getName())));
                    }

                }
            }

        } catch (ZipException e) {
            e.printStackTrace();
        }

        return zipFile.getFile();
    }

    public static void unzipCreationAES(String inputPath, String fileZip,
            String password) {

        try {

            ZipFile zipFile = new ZipFile(inputPath.concat(fileZip));
            if (zipFile.isEncrypted()) {
                if (null == password) {
                    password = "qwertyuiop";
                }
                zipFile.setPassword(password);
            }
            // zipFile.extractFile("Ronan_Keating_-_In_This_Life.mp3",
            // "c:\\ZipTest\\");
            // zipFile.extractFile("FolderToAdd\\myvideo.avi", "c:\\ZipTest\\");
            zipFile.extractAll(inputPath);

        } catch (ZipException e) {
            e.printStackTrace();
        }

    }

}
