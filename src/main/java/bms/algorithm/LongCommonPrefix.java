package bms.algorithm;

import org.junit.jupiter.api.Test;

public class LongCommonPrefix {

    String[] strs = new String[]{"flower","flow","flight"};


    @Test
    public void longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length < 1)  return;
        String ans = "";
        String s1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length();j++) {
                if (strs[i].charAt(j) == s1.charAt(j)) {
                    ans += strs[i].charAt(j);
                } else {
                    break;
                }
            }
            s1 = ans;
            ans = "";
        }

        // return s1;
        System.out.println(s1);
    }
}
