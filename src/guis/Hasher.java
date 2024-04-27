package guis;

import java.util.ArrayList;
import java.util.List;

public class Hasher {

    static StringBuilder result = new StringBuilder();
    static StringBuilder result5 = new StringBuilder();
    static List<String> result6 = new ArrayList<>();

    public Hasher(String username, String password){
        hasher(username, password);
    }
    public static String hasher(String user, String pass){
        String plainText = user + pass;
        char[] charArray = plainText.toCharArray();
        for (char aChar : charArray) {
            result.append(
                    String.format("%8s", Long.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")
            );
        }
        String result2 = result.toString();
        double result3 = Double.parseDouble(result2) * 31;
        result3 %= 4000000007D;
        String result4 = Double.toString(result3);
        char[] newArray = result4.toCharArray();
        for (char aChar : newArray) {
            result5.append(
                    String.format("%7s", Long.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "1")
            );
        }
        int index = 0;
        while (index < result5.length()) {
            result6.add(result5.substring(index, Math.min(index + 7, result5.length())));
            index += 7;
        }
        String result9 = String.join(" ", result6);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < result5.length(); i += 8) {
            int decimal_value = binaryToDecimal(result9.substring(i, 7+i));
            res.append((char) (decimal_value));
        }
        return res.toString();
    }

    static int binaryToDecimal(String n)
    {
        // Stores the decimal value
        int dec_value = 0;

        // Initializing base value to 1
        int base = 1;

        int len = n.length();
        for (int i = len - 1; i >= 0; i--) {

            // If the current bit is 1
            if (n.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }

        // Return answer
        return dec_value;
    }
}
