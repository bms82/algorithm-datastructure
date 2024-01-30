package bms.algorithm;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #1859. Sorting the Sentence
 */
public class SortSentences {
    // Constraints
    // C1. s.length < 200;
    // C2. upper and lower letters + space, and numbers only
    // C3. number from 1 ~ 9
    // Procedure
    // P1. split the string based on space.
    // P2. separate the last number and save it in order;
    // P3. concatenate the words.

    public String sortSentence(String s) {

        String[] splitS = s.split(" ");
        String[] ansSplit = new String[splitS.length];
        for (String s1 : splitS) {
            int order = Integer.parseInt(s1.substring(s1.length()-1));
            ansSplit[order-1] = s1.substring(0, s1.length()-1);
        }
        StringBuilder sb = new StringBuilder();
        for (String s1 : ansSplit) {
            if (s1 == null)
                break;
            sb.append(s1).append(" ");
        }
        return sb.toString().trim();
    }

    @Test
    public void checkCase() {

        String s1 = "is2 sentence4 This1 a3";
        assert sortSentence(s1).equals("This is a sentence");

        String s2 = "Myself2 Me1 I4 and3";
        assert sortSentence(s2).equals("Me Myself and I");

    }

}
