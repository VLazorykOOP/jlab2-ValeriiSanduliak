import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);
    static void printMenu(){
        System.out.println("|   MENU SELECTION         |");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Task1          |");
        System.out.println("|        2. Task2          |");
        System.out.println("|        3. Task3          |");
        System.out.println("|        4. Exit           |");
    }
    public static void main(String[] args) {
        System.out.println("Java Lab 2 ");
	// write your code here
        int ch =1;
        while (ch!=5){
            printMenu();
            System.out.print("Select option:");
            ch = in.nextInt();
            switch (ch){
                //case 1 : Task1() ;break;
                case 2: VeryLongNumber.Task2(); break;
                case 3: Line.Task3();break;
                case 4: return;
            }
        }

    }
}
