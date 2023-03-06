import java.util.Scanner;

public class Main {
    public static void Task1() {
        System.out.println("--Test class Money---");
        // 500.0, 200.0, 100.0, 50.0, 20.0, 10.0, 5.0, 2.0, 1.0, 0.5, 0.25, 0.1, 0.05, 0.02, 0.01
        Money money1 = new Money(new int[]{1,2,0,0,0,0,0,0,0,0,1,0,0,0,0});  //900 uah 25 kop
        Money money2 = new Money(new int[]{1,1,0,1,0,0,0,0,0,1,1,0,0,0,0});  //750 uah 75 kop
        System.out.println("Money1: "+money1);
        System.out.println("Money2: "+money2);
        Money add  = money1.add(money2);
        System.out.println("Money1 add Money2 : "+ add);
        Money sub  = money1.subtract(money2);
        System.out.println("Money1 sub Money2 : "+ sub);
        Money div  = money1.divide(money2);
        System.out.println("Money1 divide Money2 : "+ div);
        Money div_d  = money1.divide(2.0);
        System.out.println("Money1 divide double : "+ div_d);
        if(money1.equals(money2)){
            System.out.println("Money1 equals Money2");
        }
        else if(money1.greaterThan(money2)){
            System.out.println("Money1 greater than Money2");
        }
        else if(money1.lessThan(money2)){
            System.out.println("Money1 less than Money2");
        }
    }
    public static void Task2() {
        Scanner in = new Scanner(System.in);
        System.out.println("--Test class Very long number---");
        System.out.print("Input s1 : ");
        String s1 = in.nextLine();
        System.out.print("Input s2 : ");
        String s2 = in.nextLine();
        VeryLongNumber p1 = new VeryLongNumber(s1);
        System.out.println("p1: "+p1.toString());
        VeryLongNumber p2 = new VeryLongNumber(s2);
        System.out.println("p2: "+p2.toString());
        System.out.print("p1  add p2 : "+p1.add(p2)+"\n");
        System.out.print("p1  sub p2 : "+p1.subtract(p2)+"\n");
        System.out.print("p1  multiply p2: "+p1.multiply(p2)+"\n");
        System.out.print("p1  divide p2: "+p1.divide(p2)+"\n");
        System.out.print("p1  pow 12: "+p1.pow(12)+"\n");
        System.out.print("p2  pow 13: "+p2.pow(13)+"\n");
        if(p1.equals(p2)){
            System.out.print("p1 equals p2\n");
        }
        else System.out.print("p1 not equals p2\n");
    }
    public static void Task3() {
        Line line1 = new Line(2, 3, -8);
        Line line2 = new Line(-3, 2, 7);
        double x =1;
        double y =2;
        System.out.println("Point {"+x+","+y+"} constrains line1 : "+line1.contains(x, y));
        System.out.println("Line 1 : "+line1.toString());
        System.out.println("Line 2 : "+line2.toString());
        double[] intersectionPoint = line1.Intersection(line2);
        if (intersectionPoint == null) {
            System.out.println("Lines are parallel");
        } else {
            System.out.println("Crossing point: (" + intersectionPoint[0] + ", " + intersectionPoint[1] + ")");
        }
        if(line1.equals(line2)){
            System.out.println("Equals");
        }
        else System.out.println("Not equals");
    }

    static void printMenu(){
        System.out.println("|--------------------------|");
        System.out.println("|           MENU           |");
        System.out.println("|--------------------------|");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Task1          |");
        System.out.println("|        2. Task2          |");
        System.out.println("|        3. Task3          |");
        System.out.println("|        4. Exit           |");
        System.out.println("|--------------------------|");
    }

    public static void main(String[] args) {
        System.out.println("Java Lab 2 ");
        Scanner in = new Scanner(System.in);
        int ch =1;
        while (ch!=5){
            printMenu();
            System.out.print("Select option:");
            ch = in.nextInt();
            switch (ch){
                case 1: Task1() ;break;
                case 2: Task2() ;break;
                case 3: Task3() ;break;
                case 4: return;
            }

        }

    }
}
