package bms.algorithm;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #744. Find Smallest Letter Greater than Target
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length;
        int mid = low + ((high-low)/2);
        while (high - low > 1) {
            if (target >= letters[mid]) {
                low = mid;
            } else {
                high = mid;
            }
            mid = low + ((high-low)/2);
        }
        if (letters[mid] == target && high < letters.length)
            return letters[high];
        if (letters[low] > target)
            return letters[low];
        if (letters[mid] < target && mid < letters.length -1)
            return letters[mid+1];
        return letters[0];
    }

    @Test
    public void checkCase() {
        char[] case1 = new char[]{'c','f','j'};
        char target1 = 'a';
        char[] case2 = new char[]{'c','f','j'};
        char target2 = 'c';
        char[] case3 = new char[]{'x','x','y','y'};
        char target3 = 'z';
        char[] case4 = new char[]{'c','f','j'};
        char target4 = 'd';


        char ans1 = nextGreatestLetter(case1, target1);
        assert ans1 == 'c';
        char ans2 = nextGreatestLetter(case2, target2);
        assert ans2 == 'f';
        char ans3 = nextGreatestLetter(case3, target3);
        assert ans3 == 'x';
        char ans4 = nextGreatestLetter(case4, target4);
        assert ans4 == 'f';

    }
}
