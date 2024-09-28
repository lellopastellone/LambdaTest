package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
    public static void printFile(String fname, RowProcessor r) {
        try (BufferedReader in = new BufferedReader (new FileReader(fname));){
            
            String s;
            int nrighe = 0;
            while((s = in.readLine()) != null) {
                r.execute(nrighe, s);
                nrighe++;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
