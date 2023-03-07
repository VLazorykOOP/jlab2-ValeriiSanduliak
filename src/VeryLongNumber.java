import java.util.Scanner;
import java.util.*;
import static java.lang.Long.reverse;
import java.lang.String;
public class VeryLongNumber{
    private String number;

    public VeryLongNumber(String number) {
        this.number = number;
    }

    public VeryLongNumber add(VeryLongNumber other) {
        String result = "";
        int carry = 0;
        int i = this.number.length() - 1;
        int j = other.number.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = (i >= 0) ? (this.number.charAt(i) - '0') : 0;
            int b = (j >= 0) ? (other.number.charAt(j) - '0') : 0;
            int sum = a + b + carry;
            result = (sum % 10) + result;
            carry = sum / 10;
            i--;
            j--;
        }
        return new VeryLongNumber(result);
    }

    public VeryLongNumber subtract(VeryLongNumber other) {
        String result = "";
        int borrow = 0;
        int i = this.number.length() - 1;
        int j = other.number.length() - 1;
        while (i >= 0 || j >= 0) {
            int a = (i >= 0) ? (this.number.charAt(i) - '0') : 0;
            int b = (j >= 0) ? (other.number.charAt(j) - '0') : 0;
            int diff = a - b - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result = diff + result;
            i--;
            j--;
        }
        return new VeryLongNumber(result);
    }

    public VeryLongNumber multiply(VeryLongNumber other) {
        String result = "0";
        for (int i = other.number.length() - 1; i >= 0; i--) {
            int digit = other.number.charAt(i) - '0';
            int carry = 0;
            StringBuilder partialResult = new StringBuilder();
            for (int j = this.number.length() - 1; j >= 0; j--) {
                int a = this.number.charAt(j) - '0';
                int product = a * digit + carry;
                partialResult.insert(0, product % 10);
                carry = product / 10;
            }
            if (carry > 0) {
                partialResult.insert(0, carry);
            }
            for (int k = 0; k < other.number.length() - 1 - i; k++) {
                partialResult.append('0');
            }
            result = new VeryLongNumber(result).add(new VeryLongNumber(partialResult.toString())).number;
        }
        return new VeryLongNumber(result);
    }
    public VeryLongNumber divide(VeryLongNumber divisor) {
        String dividend = this.number;
        String quotient = "";
        if (divisor.number.equals("0")) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        while(dividend.length() > divisor.number.length()){
            String s ="0";
            divisor = new VeryLongNumber(s + divisor);

        }
        int i = 0;
        int divLen = divisor.number.length();
        String partialDividend = dividend.substring(0, divLen);
        while (i < dividend.length() - divLen + 1) {
            int digit = 0;
            while (partialDividend.compareTo(divisor.number) >= 0) {
                digit++;
                partialDividend = new VeryLongNumber(partialDividend).subtract(divisor).number;
            }
            quotient += digit;
            i++;
            if (i < dividend.length() - divLen + 1) {
                partialDividend = partialDividend + dividend.charAt(i + divLen - 1);
            }
        }
        quotient = quotient.replaceAll("^0+", "");
        return new VeryLongNumber(quotient);
    }
    public VeryLongNumber pow(int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Negative exponent");
        }
        if (exponent == 0) {
            return new VeryLongNumber("1");
        }
        VeryLongNumber square = this.multiply(this);
        if (exponent % 2 == 0) {
            return square.pow(exponent / 2);
        } else {
            return this.multiply(square.pow(exponent / 2));
        }
    }
    public boolean equals(VeryLongNumber other) {
        String a = this.number;
        String b = other.number;
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return number;
    }
}

