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
    public VeryLongNumber subtract(VeryLongNumber other){
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
}
