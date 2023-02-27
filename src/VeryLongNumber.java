import java.math.BigInteger;
import java.util.Scanner;

public class VeryLongNumber {
    private BigInteger number;
    public  VeryLongNumber(String s){
        this.number = new BigInteger(s);
    }
    public VeryLongNumber(BigInteger s){
        this.number = s;
    }
    public VeryLongNumber add(VeryLongNumber other){
        BigInteger res = number.add(other.number);
        return new VeryLongNumber(res);
    }
    public VeryLongNumber minus(VeryLongNumber other){
        BigInteger res = number.subtract(other.number);
        return new VeryLongNumber(res);
    }
    public VeryLongNumber multiply(VeryLongNumber other){
        BigInteger res = number.multiply(other.number);
        return new VeryLongNumber(res);
    }
    public VeryLongNumber divide(VeryLongNumber other){
        BigInteger res = number.divide(other.number);
        return new VeryLongNumber(res);
    }
    public VeryLongNumber pow(int step){
        BigInteger res = number.pow(step);
        return new VeryLongNumber(res);
    }
    public BigInteger getNumber(){
        return number;
    }
    @Override
    public boolean equals(Object obj) {
        if ( obj instanceof VeryLongNumber ) {
            VeryLongNumber that = (VeryLongNumber) obj;
            return number.equals(that.number);
        }
        return false;
    }
    @Override
    public String toString(){
        return number.toString();
    }

    public static void Task2() {
        Scanner in = new Scanner(System.in);
        String s1 = "12345678901123";
        System.out.println("s1 :" + s1);
        System.out.print("Input s2 : ");
        String s2 = in.nextLine();
        System.out.println("s2 :" + s2);
        // Constructor 1 param:
        VeryLongNumber p1 = new VeryLongNumber(s1);
        System.out.println(p1.toString());
        VeryLongNumber p2 = new VeryLongNumber(s2);
        System.out.println(p2.toString());
        //  add():
        System.out.print("p1  add p2 : "+p1.add(p2)+"\n");
        // minus():
        System.out.print("p1  minus p2 : "+p1.minus(p2)+"\n");
        // multiply():
        System.out.print("p1  multiply p2: "+p1.multiply(p2)+"\n");
        // devide():
        System.out.print("p1  divide p2: "+p1.divide(p2)+"\n");
        // pow() :
        System.out.print("p1  pow 12: "+p1.pow(12)+"\n");
        System.out.print("p2  pow 13: "+p2.pow(13)+"\n");
        if(p1.equals(p2)){
            System.out.print("p1 equals p2\n");
        }
        else System.out.print("p1 not equals p2\n");

    }
}
