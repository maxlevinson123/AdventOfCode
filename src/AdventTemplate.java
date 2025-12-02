import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventTemplate {
    public static void main(String[] args) {

        // get a list of Strings from the data file we created
        ArrayList<String> fileData = getFileData("src/data");

        // go through the list line by line
        int a = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String current = fileData.get(i);
            System.out.println("Processing line: " + current);
            if (current.substring(0,1).equals("L")) {
                a -= Integer.parseInt(current.substring(1));
            }
            if (current.substring(0,1).equals("L")) {
                a += Integer.parseInt(current.substring(1));
            }
            if (a >= 100) {
                a -= 100;
            }
            if (a < 0) {
                
            }
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
