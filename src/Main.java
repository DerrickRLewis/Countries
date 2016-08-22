import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Figure8 on 8/19/2016.
 */
public class Main {

    public static ArrayList<Country> countryArrayList = new ArrayList<>();
    public static HashMap<String, ArrayList<Country>> orderedCountries = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        readFile();
//        writeFile();
//        userInput();
       // System.out.println(countryArrayList);
    }

    private static void readFile() throws IOException {
        //String csvFile = "C:\\Users\\Derrick\\Documents\\GITHUB ROOT\\Countries\\Countries\\countries.txt";
        File f = new File("C:\\Users\\Derrick\\Documents\\GITHUB ROOT\\Countries\\Countries\\countries.txt");
        Scanner scanner = new Scanner(f);
        scanner.nextLine();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");
            Country country = new Country (columns[0], columns[1]);
            countryArrayList.add(country);

                System.out.println("Country [code= " +columns[0] + " , name=" + columns[1] + "]");



    }}





    private static void userInput() throws Exception {

        System.out.println("Please enter a letter...");
        String firstLetter = scanner.nextLine();

        if (firstLetter == "") {
            throw new Exception();
        }else {
            orderedCountries.put(firstLetter, countryArrayList);
        }
    }


    static void writeFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(fileContent);
        fw.close();
    }
}
