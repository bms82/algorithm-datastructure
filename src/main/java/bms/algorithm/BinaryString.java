package bms.algorithm;

public class BinaryString {

    // n은 flips의 길이
    // flips 는 1 <= n <= 5 * 10000
    // flips는 최대 n까지 간다.

    public static int numTimesAllBlue(int[] flips) {
        int right = 0;
        int count = 0;
        for (int i = 0; i < flips.length; ++i) {
            right = Math.max(right, flips[i]);
            if (right == i + 1) ++count;
        }
        return count;
    }

    class Solution {
        // for문
        // 1. 인덱스마다 표시해둔다.
        // 2. 1번인덱스가 표시되면 그때부터 count한다.
        // 3.

        public int numTimesAllBlue(int[] flips) {
            // 1번이 나오는 부분을 먼저 찾고, 거기부터 2, 3, 4, .. 가 나왔는지 찾는다?
            boolean[] lights = new boolean[flips.length];
            int startIdx = 0;
            int checkPoint = 0;
            int count = 0;
            int lightCount = 0;
            for (int i = 0; i < flips.length; i++) {
                int num = flips[i] - 1;
                lights[num] = true;
                if (lights[0] && lights[i - 1]) {
                    count++;
                }
            }
            return count;
        }


    }

    public static void main(String[] args) {
        int[] flips = new int[]{1,2,3,4};
        System.out.println(numTimesAllBlue(flips));
        flips = new int[]{4, 1,2,3};
        System.out.println(numTimesAllBlue(flips));
        flips = new int[]{3,2,4,1,5};
        System.out.println(numTimesAllBlue(flips));
        flips = new int[]{1,2,3,4,7,6,5,8};
        System.out.println(numTimesAllBlue(flips));


    }

}
