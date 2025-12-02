import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventTemplate {
    public static void main(String[] args) {

        // get a list of Strings from the data file we created
        ArrayList<String> fileData = getFileData("src/data");

        // go through the list line by line
        int a = 50;
        int countPartOne = 0;
        int countPartTwo = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String current = fileData.get(i);
            System.out.println("Processing line: " + current);

            int currentNumber = Integer.parseInt(current.substring(1));
            String direction = current.substring(0, 1);

            for (int j = 0; j < currentNumber; j++) {
                if (direction.equals("L")) {
                    a--;
                }
                if (direction.equals("R")) {
                    a ++;
                }
                if (a < 0) {
                    a = 99;
                }
                if (a > 99) {
                    a = 0;
                }
                if (a == 0) {
                    countPartTwo++;
                }
            }
            if (a == 0) {
                countPartOne ++;
            }
        }
        System.out.println(countPartOne);
        System.out.println(countPartTwo);
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
