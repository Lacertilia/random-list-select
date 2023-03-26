import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileManager fm = new FileManager();
        ArrayList<String> list = fm.getList();
        while(true){
            printOptions();
            getInput();
        }

    }

    private static void getInput() {
        //Add check for what User writes in response to the options list
    }

    private static void printOptions() {
        System.out.println("1: Show list");
        System.out.println("2: Add item to list");
        System.out.println("3: Remove item from list");
        System.out.println("4: Update file with new list");
        System.out.println("5: Print random item from list");
        System.out.println("6: Exit");
    }

    private static void printList(ArrayList<String> list){
        for(String s: list){
            System.out.println(s);
        }
    }

}