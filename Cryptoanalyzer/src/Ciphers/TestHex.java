package Ciphers;

public class TestHex {

    public static void main(String[] args) {
        //System.out.println(decimal2hex(238765723));

       // System.out.println(Integer.decode("0x4d2"));   // output 1234
//and vice versa
       // System.out.println(Integer.toHexString(1234)); //  output is 4d2);
    }


    public static String decimal2hex(int d) {
        String digits = "0123456789ABCDEF";
        if (d <= 0) return "0";
        int base = 16;   // flexible to change in any base under 16
        String hex = "";
        while (d > 0) {
            int digit = d % base;              // rightmost digit
            hex = digits.charAt(digit) + hex;  // string concatenation
            d = d / base;
        }
        return hex;
    }

}
