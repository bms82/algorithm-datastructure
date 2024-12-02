package bms.programmers;

import org.junit.jupiter.api.Test;

public class FindSquare {

    class Solution {
        public long solution(long n) {
            long answer = -1;
            if (n == 1)
                return 4;
            long lowNum = 1;
            long highNum = n / 2;
            while (lowNum < highNum) {
                long mid = (lowNum + highNum) / 2;
                if (n / mid > mid) {
                    lowNum = mid + 1;
                } else if (n / mid < mid) {
                    highNum = mid - 1;
                } else if (n % mid == 0){
                    return (mid + 1) * (mid + 1);
                }
            }
            if (n / lowNum == lowNum && n % lowNum == 0)
                return (lowNum + 1) * (lowNum + 1);
            return answer;
        }
    }

    @Test
    public void testCase() {

        Solution solution = new Solution();
        long num1 = 121;
        assert solution.solution(num1) == 144;
        num1 = 3;
        assert solution.solution(num1) == -1;
        num1 = 1324020524;
        assert solution.solution(num1) == -1;
        num1 = 196;
        assert solution.solution(num1) == 225;
        num1 = 3600;
        assert solution.solution(num1) == 3721;
        num1 = 23261329;
        assert solution.solution(num1) == 23270976;
        num1 = 29348720;
        assert solution.solution(num1) == -1;


    }
}
