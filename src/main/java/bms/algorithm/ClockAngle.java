package bms.algorithm;
import org.junit.jupiter.api.Test;

/**
 * LeetCode #1344. Angle Between Hands of a Clock
 */

public class ClockAngle {

    class Solution {
        // C1. hour between 1 ~ 12, minutes between 0 ~ 59
        // C2. find the smaller angle betwegit en the two hands
        // Procedure
        // P1. first get the minute angle and hourangle from 12:00
        // P2. 1minute = 6 degrees. 1 hour = 30degrees. plus the 1 minute moves 0.5degrees of hour hand
        // P3. finding smaller angle. first subtract two angles and find the absolute difference.
        // P4. if larger than 180, find the difference between 360 and the absolute difference.
        public double angleClock(int hour, int minutes) {
            double hourAngle = hour * 30 + minutes * 0.5f;
            double minuteAngle = minutes * 6.0f;
            double ans = Math.abs(hourAngle - minuteAngle);
            if (ans > 180.0f)
                return 360 - ans;
            return ans;

        }
    }

    @Test
    public void checkAns() {
        Solution solution = new Solution();
        double anse1 = solution.angleClock(12, 30);
        assert anse1 == 165.0f;

        double anse2 = solution.angleClock(3, 30);
        assert anse2 == 75.0f;

        double anse3 = solution.angleClock(3, 15);
        assert anse3 == 7.5f;

    }
}
