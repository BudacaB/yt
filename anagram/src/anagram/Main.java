package anagram;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    String s1 = "angered ";
	    String s2 = "enrageD";

	    if (anagramCheck(s1, s2)) {
            System.out.println("Anagrams");
        }
	    else {
            System.out.println("Not anagrams");
        }
    }

    static boolean anagramCheck(String s1, String s2) {

        s1 = s1.toLowerCase().replace(" ", "");
        s2 = s2.toLowerCase().replace(" ", "");

        // checking length
        if (s1.length() != s2.length()) {
            return false;
        }

        // transform to arrays
        char string1ToArray[] = s1.toCharArray();
        char string2ToArray[] = s2.toCharArray();

        // sorting
        Arrays.sort(string1ToArray);
        Arrays.sort(string2ToArray);

        for (int i = 0; i < s1.length(); i++) {
            if (string1ToArray[i] != string2ToArray[i]) {
                return false;
            }
        }
        return true;
    }
}
