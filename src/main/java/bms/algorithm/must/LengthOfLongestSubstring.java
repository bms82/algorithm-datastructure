package bms.algorithm.must;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #3. Length of Longest Substring
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // first check the next letter is included in the substring.
        // if not add as substring.
        // if so, start again with the current character.
        StringBuilder sb = new StringBuilder();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = sb.toString().indexOf(s.substring(i,i+1));
            if (idx > -1) {
                if (maxLen < sb.length())
                    maxLen = sb.length();
                sb = new StringBuilder(sb.subSequence(idx+1, sb.length()));
            }
            sb.append(s.charAt(i));
        }
        if (sb.length() > maxLen)
            maxLen = sb.length();
        return maxLen;
    }

    @Test
    public void checkCase() {

        String s1 = "abcabcbb";
        String ans1 = "abc";
        assert lengthOfLongestSubstring(s1) == 3;


        String s2 = "bbbbb";
        String ans2 = "b";
        assert lengthOfLongestSubstring(s2) == 1;

        String s3 = "pwwkew";
        String ans3 = "wke";
        assert lengthOfLongestSubstring(s3) == 3;


    }
}
