package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z]","").toLowerCase();
        int strLen = s.length();
        if (strLen < 2) return  true;
        Stack<Character> vStack = new Stack<>();
        if (strLen % 2 == 1) {
            s = s.substring(0, strLen/2) + s.substring(strLen/2 +1);
            strLen--;
        }
        for (int i = 0;i < strLen /2;i++) {
            vStack.push(s.charAt(i));
        }
        for (int j = strLen / 2; j < strLen; j++) {
            if (vStack.pop().equals(s.charAt(j))) continue;
            return false;
        }
        return true;
    }

    @Test
    public void isValid() {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        assert result;

    }
}
