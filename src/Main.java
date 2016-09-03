import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<Country>> countryMap = new HashMap<String, ArrayList<Country>>();
        File f = new File("Countries/src/countries.txt");
        //There is an issue with my file path.I cant get the program to recognize my file without using the full path.
        // I believe it is a GITHUB issue.I seem to have Countries\\Countries and it is throwing off the file
        Scanner fileScanner = new Scanner(f);

        readFile(countryMap, fileScanner);

        String userInput = userInput();

        writeFile(countryMap, userInput);


    }

    public static String userInput(){
        System.out.println("Pick a lowercase letter to receive a list of countries that begin with that letter:\n");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        System.out.println("Printing a list of countries starting with the letter " + userInput);
        return userInput;

    }

    public static void writeFile (HashMap<String, ArrayList<Country>> countryMap, String userInput) throws IOException {


        String fileName = userInput + "_countries.txt";
        ArrayList<Country> fileText = countryMap.get(userInput);
        File outPut = new File(fileName);
        FileWriter fw = new FileWriter(outPut);
        fw.write(fileText.toString());
        fw.close();
    }




    public static void readFile(HashMap<String, ArrayList<Country>> countryMap, Scanner fileScanner){
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            String letter = String.valueOf(country.name.charAt(0));

            if (!countryMap.containsKey(letter)) {
                countryMap.put(letter, new ArrayList<Country>());
            }
            countryMap.get(letter).add(country);
        }
    }

}
