package io.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by max.lu on 2016/3/24.
 */
public class DeZip {
    public static void main(String[] args) throws IOException {
        multiFiles();
    }

    private static void multiFiles() throws IOException {
        String deZipTo = "E:\\test3";
        File file = new File("E:\\test2\\test3.zip");
        File outFile;
        InputStream in;
        OutputStream out;
        ZipFile zipFile = new ZipFile(file);
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            outFile = new File(deZipTo + File.separator + entry.getName());
            if (!outFile.exists()) {
                if (!outFile.getParentFile().exists()) {
                    outFile.getParentFile().mkdirs();
                }
                outFile.createNewFile();
            }
            in = zipFile.getInputStream(entry);
            out = new FileOutputStream(outFile);
            int temp;
            while ((temp = in.read()) != -1) {
                out.write(temp);
            }
            in.close();
            out.close();
        }
        System.out.println("success");
    }


    private static void singleFile() throws IOException {
        File file1 = new File("E:\\test2\\deZip.txt");
        File file2 = new File("E:\\test\\test.zip");
        ZipFile zipFile = new ZipFile(file2);
        ZipEntry entry = zipFile.getEntry("test1.txt");
        InputStream in = zipFile.getInputStream(entry);
        OutputStream out = new FileOutputStream(file1);
        int temp;
        while ((temp = in.read()) != -1) {
            out.write(temp);
        }
        in.close();
        out.close();
    }

    private static void getZipFile() throws IOException {
        File file = new File("E:\\test\\test.zip");
        ZipFile zipFile = new ZipFile(file);
        System.out.println(zipFile.getName());
        System.out.println(zipFile.getEntry("test.txt"));
    }
}
