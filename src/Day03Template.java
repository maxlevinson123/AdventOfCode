import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03Template {
    public static void main(String[] args) {

        // **** DO NOT EDIT ANYTHING HERE ****
        ArrayList<String> fileData = getFileData("src/data");
        int partOneAnswer = 0;
        for (String batteries : fileData) {
            int voltage = getLargestCombination(batteries);
            partOneAnswer += voltage;
        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    // COMPLETE THIS METHOD!
    public static int getLargestCombination(String batteries) {
        int firstDigit = 0;
        int firstDigitPlace = 0;
        int secondDigit = 0;
        int secondDigitPlace = 0;
        for (int i = 0; i < batteries.length(); i++) {
            if (Integer.parseInt(batteries.substring(i, i + 1)) > firstDigit) {
                firstDigit = Integer.parseInt(batteries.substring(i, i + 1));
                firstDigitPlace = i;
            }
        }
        String newString = batteries.substring(0,firstDigitPlace) + batteries.substring(firstDigitPlace + 1);
        for (int i = 0; i < newString.length(); i++) {
            if (Integer.parseInt(newString.substring(i, i + 1)) > firstDigit) {
                secondDigit = Integer.parseInt(newString.substring(i, i + 1));
                secondDigitPlace = i;
            }
        }
        if (firstDigitPlace <= secondDigitPlace) {
            return Integer.parseInt((firstDigit + "") + (secondDigit + ""));
        }
        return Integer.parseInt((secondDigit + "") + (firstDigitPlace + ""));
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