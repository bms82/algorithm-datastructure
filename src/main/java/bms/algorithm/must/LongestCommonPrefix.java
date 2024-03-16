package bms.algorithm.must;

/**
 * LeetCode #14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    // Constraint
    // C1. strs length range from 1 to 200
    // C2. item length range from 0 to 200
    // Procedure
    // P1. With strs[0] as base, find the substring that fits the other substring.
    // P2. Check every thing and shorten the substring as it does not fit.
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        String ans = strs[0];
        for(int i = 1;i < strs.length;i++) {
            while(strs[i].indexOf(ans) != 0) {
                ans = ans.substring(0,ans.length() - 1);
            }
        }
        return ans;
    }
}
}
