import java.io.File;
import java.io.FileNotFoundException;
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

    }
}