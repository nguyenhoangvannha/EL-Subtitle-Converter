/*


00:04.920 --> 00:11.750
My name is Philip and I'm an Android Developer and we're because we want to create the best online program.

00:12.060 --> 00:12.660
It's true.

---------
1
00:00:00,910 --> 00:00:03,250
That my name is Angela and I'm in Iowa.

2
00:00:03,310 --> 00:00:04,750
I'm watching his program.

3
00:00:04,920 --> 00:00:11,750
My name is Philip and I'm an Android Developer and we're because we want to create the best online program.
 */



package subtitleFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


/**
 *
 * @author nguye
 */
public class FormatVTT{
    public static String toSrt(File input){
        BufferedReader brd = null;
        FileReader frd = null;
        
        File fileOut = null;
        FileWriter fwOut = null;
        BufferedWriter bwOut = null;
        try {
            
            //in
            frd = new FileReader(input.getAbsolutePath());
            brd = new BufferedReader(frd);
            
            
            //out
            fileOut = new File(input.getAbsolutePath().substring(0, input.getAbsolutePath().lastIndexOf(".")) + ".srt");
            fwOut = new FileWriter(fileOut);
            bwOut = new BufferedWriter(fwOut);
            
            brd.readLine();
            brd.readLine();
            String line = brd.readLine();
            
            int count = 1;
            do {
                bwOut.write(count + "\n");
                count++;
                line = line.replace(".", ",");
                line = "00:" + line;
                line = line.replace("> ", "> 00:");
                bwOut.write(line + "\n");
                line = brd.readLine();
                bwOut.write(line + "\n\n");
                brd.readLine();
                line = brd.readLine();
            } while(line != null);
            
        } catch (FileNotFoundException ex) {
            return ex.toString();
        } catch (IOException ex) {
            return ex.toString();
        } finally {
            try {
                brd.close();
                frd.close();
                bwOut.close();
                fwOut.close();
            } catch (IOException ex) {
                return ex.toString();
            }
        }
        return "Converted: " + input.getName();
    }
    public static String toSrt(File input, File outputFolder){
        BufferedReader brd = null;
        FileReader frd = null;
        
        File fileOut = null;
        FileWriter fwOut = null;
        BufferedWriter bwOut = null;
        try {
            
            //in
            frd = new FileReader(input.getAbsolutePath());
            brd = new BufferedReader(frd);
            
            
            //out
            fileOut = new File(outputFolder.getAbsolutePath() + "\\" + input.getName().substring(0, input.getName().lastIndexOf(".")) + ".srt");
            fwOut = new FileWriter(fileOut);
            bwOut = new BufferedWriter(fwOut);
            
            brd.readLine();
            brd.readLine();
            String line = brd.readLine();
            
            int count = 1;
            do {
                bwOut.write(count + "\n");
                count++;
                line = line.replace(".", ",");
                line = "00:" + line;
                line = line.replace("> ", "> 00:");
                bwOut.write(line + "\n");
                line = brd.readLine();
                bwOut.write(line + "\n\n");
                brd.readLine();
                line = brd.readLine();
            } while(line != null);
            brd.close();
            frd.close();
            bwOut.close();
            fwOut.close();
        } catch (FileNotFoundException ex) {
            return ex.toString();
        } catch (IOException ex) {
            return ex.toString();
        } 
        return "Converted: " + input.getName();
    }
    public static boolean toSrtAlls(File parrentFolder , JTextArea log){
        log.append("[Folder] " + parrentFolder.getName() + "\n");
        System.out.println(log.toString() + "\n");
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
            if(getFileExt(file).equalsIgnoreCase("vtt")){
                System.out.println(file.getAbsolutePath() + "\n");
                log.append("  " + toSrt(file) + "\n");
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
                toSrtAlls(folder, log);
        }
        return true;
    }
    public static boolean toSrtAlls(File parrentFolder , File outputFolder ,JTextArea log){
        log.append("[Folder] " + parrentFolder.getName() + "\n");
        System.out.println(log.toString() + "\n");
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
            if(getFileExt(file).equalsIgnoreCase("vtt")){
                System.out.println(file.getAbsolutePath() + "\n");
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
                        toSrtAlls(folder, outFolder, log);
            }
                
        }
        return true;
    }
    public static String getFileExt(File file){
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }
    public static void myPrint(String s){
        System.out.print(s);
    }
}
