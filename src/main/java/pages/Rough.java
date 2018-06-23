package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rough {
    public static void main(String[] args) {
        final String REGEX = "[^a-z]";
        final String INPUT = "nishant^&**tiger";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);   // get a matcher object

        String word = m.replaceAll("");
//        System.out.print(word);
        for (int i = word.length() - 1; i >= 0; i--) {

            System.out.print(word.charAt(i));
        }
    }
}
