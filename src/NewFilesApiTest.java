import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class NewFilesApiTest {
    public static void main(String[] args)  {

        //Creating a new file
        Path newFile = Paths.get("test1");
        try {
            Files.deleteIfExists(newFile);
            newFile = Files.createFile(newFile);
        } catch (IOException ex) {
            System.out.println("Error creating file");
        }
        System.out.println(Files.exists(newFile));

        //Writing to file
        try(BufferedWriter writer = Files.newBufferedWriter(
                newFile, Charset.defaultCharset())){
            writer.append("This is first line");
            writer.newLine();
            writer.append("This is second line");
            writer.newLine();
            writer.append("This is third line");
            writer.newLine();
            writer.flush();
        }catch(IOException exception){
            System.out.println("Error writing to file");
        }

        //Reading from file
        try(BufferedReader reader = Files.newBufferedReader(
                newFile, Charset.defaultCharset())){
            String lineFromFile = "";
            System.out.println("The contents of file are: ");
            while((lineFromFile = reader.readLine()) != null){
                System.out.println(lineFromFile);
            }

        }catch(IOException exception){
            System.out.println("Error while reading file");
        }

        // Copy file
        Path source = Paths.get("test1");
        Path target = Paths.get("test1_new");
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Exception while copying usng new API");
        }
        System.out.println("File created: " + Files.exists(target));

        //Reading all the lines from a file into a List
        Path sourcePath = Paths.get("test1");
        try {
            List<String> linesReadNew =
                    Files.readAllLines(sourcePath,
                            Charset.defaultCharset());

            System.out.println("Lines read using new style:");
            for(String s : linesReadNew){
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("IO Error");
        }


    }

}