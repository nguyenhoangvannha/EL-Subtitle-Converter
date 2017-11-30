/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template inputFile, choose Tools | Templates
 * and open the template in the editor.
 */
package subtitle.convert;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import subtitleFile.FormatASS;
import subtitleFile.FormatSCC;
import subtitleFile.FormatSRT;
import subtitleFile.FormatSTL;
import subtitleFile.FormatTTML;
import subtitleFile.FormatVTT;
import static subtitleFile.FormatVTT.toSrt;
import subtitleFile.TimedTextFileFormat;
import subtitleFile.TimedTextObject;

/**
 *
 * @author nguye
 */
public class ConvertPro {
    public static StringBuilder log = new StringBuilder();
    public static void convert(String saveToPath, File inputFile,String outputFileType) {
        boolean isVTT = false;
	String inputFormat = getFileExt(inputFile);
        if("VTT".equalsIgnoreCase(inputFormat)){
            FormatVTT.toSrt(inputFile);
            if("SRT".equalsIgnoreCase(outputFileType)){
                return;
            } else {
                inputFile = new File(inputFile.getAbsolutePath().substring(0, inputFile.getAbsolutePath().lastIndexOf(".") + 1) + "srt");
                inputFormat = "srt";
                isVTT = true;
            }
        }
        
        String  outputFileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf(".") + 1) + outputFileType;
        String  outputFormat = getFileExt(new File(outputFileName));
	TimedTextObject tto;
        TimedTextFileFormat ttff;
        OutputStream output;
        try {
            if ("SRT".equalsIgnoreCase(inputFormat)) {
                ttff = new FormatSRT();
            } else if ("STL".equalsIgnoreCase(inputFormat)) {
                ttff = new FormatSTL();
            } else if ("SCC".equalsIgnoreCase(inputFormat)) {
                ttff = new FormatSCC();
            } else if ("XML".equalsIgnoreCase(inputFormat)) {
                ttff = new FormatTTML();
            } else if ("ASS".equalsIgnoreCase(inputFormat)) {
                ttff = new FormatASS();
            } else {
                if(isVTT) inputFile.delete();
                throw new Exception("Unrecognized input format: " + inputFormat + " only [SRT,STL,SCC,XML,ASS] are possible");
            }

            InputStream is = new FileInputStream(inputFile);
            tto = ttff.parseFile(inputFile.getName(), is);

            if ("SRT".equalsIgnoreCase(outputFormat)) {
                IOClass.writeFileTxt(saveToPath, outputFileName, tto.toSRT());
            } else if ("STL".equalsIgnoreCase(outputFormat)) {
                output = new BufferedOutputStream(new FileOutputStream(outputFileName));
                output.write(tto.toSTL());
                output.close();
            } else if ("SCC".equalsIgnoreCase(outputFormat)) {
                IOClass.writeFileTxt(saveToPath,outputFileName, tto.toSCC());
            } else if ("XML".equalsIgnoreCase(outputFormat)) {
                IOClass.writeFileTxt(saveToPath,outputFileName, tto.toTTML());
            } else if ("ASS".equalsIgnoreCase(outputFormat)) {
                IOClass.writeFileTxt(saveToPath,outputFileName, tto.toASS());
            } else {
                if(isVTT) inputFile.delete();
                throw new Exception("Unrecognized input format: " + outputFormat + " only [SRT,STL,SCC,XML,ASS] are possible");
            }

        } catch (Exception e) {
            if(isVTT) inputFile.delete();
            e.printStackTrace();
        }
        if(isVTT) inputFile.delete();
    }
    
    public static String getFileExt(File file){
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }
    
    public static boolean convertAlls(File parrentFolder, String inputFileType , String outputFileType){
        
        log.append("[Folder] " + parrentFolder.getName() + "\n");
        if(!parrentFolder.isDirectory()){
            return false;
        }
        File[] files = parrentFolder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
        for(File file: files){
            if(getFileExt(file).equalsIgnoreCase(inputFileType)){
                convert(parrentFolder.getAbsolutePath() , file, outputFileType );
                log.append("  Converted: " + file.getName() + "\n");
            }
        }
        File[] folders = parrentFolder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for(File folder: folders){
            if(!folder.isHidden())
                convertAlls(folder,inputFileType,outputFileType);
        }
        return true;
    }
    
    public static boolean convertAlls(File parrentFolder , File outputFolder, String inputFileType , String outputFileType ){
        log.append("[Folder] " + parrentFolder.getName() + "\n");
        if(!parrentFolder.isDirectory()){
            return false;
        }
        File[] files = parrentFolder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
        for(File file: files){
            if(getFileExt(file).equalsIgnoreCase(inputFileType)){
                convert(outputFolder.getAbsolutePath(), file, outputFileType);
                log.append("  " + toSrt(file, outputFolder) + "\n");
            }
        }
        File[] folders = parrentFolder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for(File folder: folders){
            if(!folder.isHidden() && folder.canRead() && !folder.getName().equalsIgnoreCase(outputFolder.getName()))
            {
                File outFolder = new File(outputFolder.getAbsolutePath() + "\\" + folder.getName());
                        outFolder.mkdir();
                        convertAlls(folder, outFolder, inputFileType, outputFileType);
            }
                
        }
        return true;
    }
}
