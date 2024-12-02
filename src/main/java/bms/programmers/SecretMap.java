package bms.programmers;

import org.junit.jupiter.api.Test;

public class SecretMap {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int baseValue = (int) Math.pow(2, n-1);
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            while (baseValue > 0) {
                if (arr1[i] < baseValue && arr2[i] < baseValue) {
                    sb.append(" ");
                } else {
                    if (arr1[i] >= baseValue)
                        arr1[i] -= baseValue;
                    if (arr2[i] >= baseValue)
                        arr2[i] -= baseValue;
                    sb.append("#");
                }
                baseValue /= 2;
            }
            baseValue = (int) Math.pow(2, n-1);
            answer[i] = sb.toString();
        }
        return answer;
    }

    private String convertInt2Binary(int base, int num) {
        StringBuilder binaryStr = new StringBuilder();
        int baseValue = (int) Math.pow(2, base);
        while (num > 0) {
            if (num / baseValue == 1) {
                binaryStr.append("#");
                num -= baseValue;
            } else
                binaryStr.append(" ");

        }
        return binaryStr.toString();


    }

    @Test
    public void testCase() {

        int n =	5;
        int[] arr1 =	new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};
        solution(n, arr1, arr2);

    }

}
