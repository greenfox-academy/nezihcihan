// Write a program that opens a file called "my-file.txt", then prints
// each of lines form the file.
// If the program is unable to read the file (for example it does not exists),
// then it should print an error message like: "Unable to read file: my-file.txt"
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
public class PrintEachLine {
    public static void main(String[] args) {
        try { // Required by Files.readAllLines(filePath);
            // Reads the content from `myFile.txt` in the `assets`
            // folder line by line to a String List
            Path filePath = Paths.get("my-file.txt");
            List<String> lines = Files.readAllLines(filePath);
            System.out.println(lines); // Prints the all lines of the file
        }
        catch (Exception e) {
            System.out.println("Unable to read the file!");
        }
    }
}
