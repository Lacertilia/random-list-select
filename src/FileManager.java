import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

    private final File file = new File("listOfGames.txt");
    ArrayList<String> content;
    public FileManager(){
        this.content = this.readFile();



    }

    public void updateList(ArrayList<String> newList){
        ArrayList<String> update = new ArrayList<>();
        for(String S: newList){
            if(checkInput(S).equals("")){
                update.add(S);
            }
        }
        this.content = update;
        this.writeToFile(this.content);
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
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        if(m.find()){
            System.out.println("There is a special character in your line, Please only use A-Z, a-z, 0-9");
            return "";
        }else{
            return input;
        }
    }
}
