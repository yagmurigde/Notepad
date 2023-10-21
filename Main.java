import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        //Create a new file
        File file = new File("src/notes.txt");
        //Check whether file exists or not
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println(file.getName() + "already exists!!");
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        Scanner scan = new Scanner(System.in);

        //Display existing text
        BufferedReader readText = new BufferedReader(new FileReader(file));
        String text;
        while ((text = readText.readLine()) != null) {
            System.out.println("Existing text: " + text);
        }

        //User entry
        System.out.println("Type something: ");
        String words = scan.nextLine();

        //to write words to doc (note that we choose true to save previous texts)
        try {
            FileWriter writeFile = new FileWriter(file, true);
            PrintWriter printFile = new PrintWriter(writeFile);
            writeFile.write(words);
            writeFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //to read entries
        try {
            FileReader readFile = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(readFile);
            String readingText = buffReader.readLine();
            System.out.println("Text: " + readingText);
            buffReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
