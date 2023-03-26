import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private final File file = new File("listOfGames.txt");
    ArrayList<String> content;
    public FileManager(){
        this.content = this.readFile();



    }

    public void updateList(ArrayList<String> newList){
        ArrayList<String> update = new ArrayList<>();
        for(String S: newList){
            update.add(checkInput(S));
        }
        this.content = update;
    }

    public ArrayList<String> getList(){
        return this.content;
    }

    private ArrayList<String> readFile(){
        ArrayList<String> file = new ArrayList<>();
        try {
            Scanner reader = new Scanner(this.file);
            while(reader.hasNextLine()){
                file.add(reader.nextLine());
            }
        } catch (FileNotFoundException e){
            this.createFile();
        }
        return file;
    }

    private void createFile(){
        try {
            if(file.createNewFile()){
                System.out.println("File created.");
            }else{
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    private void writeToFile(ArrayList<String> list){
        try {
            FileWriter writer = new FileWriter(file);
            for (String s : list) {
                writer.write(checkInput(s) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    private String checkInput(String input){
        //Check the input so that it does not contain harmful content

        return input;
    }
}
