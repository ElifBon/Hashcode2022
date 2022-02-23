import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // The name of the file to open.

        String []fileList= new String[]{
          "a",
          "b",
          "c",
          "d",
          "e"
        };

        for(int i = 0;i<fileList.length; i++){
            List<String> lines = readFile("src/in/" + fileList[i] + ".txt");

            writeFile("src/out/" + fileList[i] + ".out", lines);
        }


    }

    private static void writeFile(String filePath, List<String> lines) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(int i=0;i<lines.size();i++){
                printWriter.println(lines.get(i));
            }


            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readFile(String filePath) {


        List<String> lines = new ArrayList<>();

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }

            // Always close files.
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }


}