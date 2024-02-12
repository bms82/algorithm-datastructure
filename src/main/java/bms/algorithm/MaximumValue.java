package bms.algorithm;

public class MaximumValue {

    public int maximumValue(String[] strs) {
        int maxValue = 0;

        for (String s : strs) {
            try {
                int intValue = Integer.parseInt(s);
                if (intValue > maxValue)
                    maxValue = intValue;

            } catch (Exception e) {
                if (maxValue < s.length())
                    maxValue = s.length();
            }
        }
        return maxValue;
    }
}
