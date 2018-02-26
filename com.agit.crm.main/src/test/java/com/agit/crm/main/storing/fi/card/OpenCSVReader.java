///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.agit.crm.main.storing.fi.card;
//
//import java.io.File;
//import java.io.IOException;
//import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
//import org.junit.Test;
//
///**
// *
// * @author BayuHS
// */
//@Test
//public class OpenCSVReader {
//
// public static void main(String[] argv) throws IOException
//    {
//        // Path of folder where files are located
//        String folder_path =
//               "C:\\Users\\Anannya Uberoi\\Desktop\\myfolder";
// 
//        // creating new folder
//        File myfolder = new File(folder_path);
// 
//        File[] file_array = myfolder.listFiles();
//        for (int i = 0; i < file_array.length; i++)
//        {
// 
//            if (file_array[i].isFile())
//            {
// 
//                File myfile = new File(folder_path +
//                         "\\" + file_array[i].getName());
//                String long_file_name = file_array[i].getName();
//                String[] tokens = long_file_name.split("\\s");
//                String new_file_name = tokens[1];
//                System.out.println(long_file_name);
//                System.out.print(new_file_name);
// 
//                // file name format: "Snapshot 11 (12-05-2017 11-57).png"
//                // To Shorten it to "11.png", get the substring which
//                // starts after the first space character in the long
//                // _file_name.
//                myfile.renameTo(new File(folder_path +
//                             "\\" + new_file_name + ".png"));
//            }
//        }
//    }
//}
