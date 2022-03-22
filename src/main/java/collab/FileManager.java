package collab;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public List<String> loadFile(String filePath) throws IOException {
        ArrayList<String> stringList = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try{
            String str;
            while ((str = br.readLine()) != null) {
                stringList.add(str);
            }
        }catch(Exception e){
            throw e;
        }finally {
            br.close();
        }
        return stringList;
    }

    public void saveFile(String filePath, String contents) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(filePath));
        printWriter.print(contents);
        printWriter.close();
    }
}
