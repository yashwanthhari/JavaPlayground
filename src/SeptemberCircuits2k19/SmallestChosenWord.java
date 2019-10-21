package SeptemberCircuits2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestChosenWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tok = reader.readLine().split(" ");
        String[] str = reader.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // Find first smallest character.
        while (i < str[1].length() && str[1].charAt(i) > str[2].charAt(0)) i++;
        for (; i < str[1].length(); i++) {
            // Pop characters from stack greater than current
            while (sb.length() > 0 && str[1].charAt(i) < sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            }
            // Append if smaller than first char of str2
            if (str[1].charAt(i) < str[2].charAt(0))
                sb.append(str[1].charAt(i));
            // Append if equal and second char of str2 >= current and last char of str2 != curr
            else if ((str[1].charAt(i) == str[2].charAt(0)) && (str[1].charAt(i) != str[2].charAt(str[2].length() - 1)) && (str[1].charAt(i) <= str[2].charAt(1))) {
                sb.append(str[1].charAt(i));
            }
        }
        System.out.println(str[0].concat(sb.toString()).concat(str[2]));
    }
}



