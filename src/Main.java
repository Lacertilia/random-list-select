import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    private ArrayList<String> readFile(){
        ArrayList<String> file = new ArrayList<>();
        File input = new File("listofGames.txt");
        try {
            Scanner reader = new Scanner(input);
            while(reader.hasNextLine()){
                file.add(reader.nextLine());
            }
        } catch (FileNotFoundException e){
            this.createFile();
        }
        return file;
    }

    private void createFile(){
        File file = new File("listOfGames.txt");
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
}