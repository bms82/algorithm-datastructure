package bms.programmers;

import org.junit.jupiter.api.Test;

public class HoFSong {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int minValueIdx = 0;
        for (int i = 0; i < k; i++) {
            if (score[minValueIdx] > score[i]) {
                minValueIdx = i;
            }
            answer[i] = score[minValueIdx];
        }
        for (int i = k; i < score.length; i++) {
            answer[i] = score[minValueIdx];
            if (score[i] > score[minValueIdx]) {
                score[minValueIdx] = score[i];
                minValueIdx = 0;
                for (int j = 0; j < k; j++) {
                    if (score[minValueIdx] > score[j]) {
                        minValueIdx = j;
                        answer[i] = score[minValueIdx];
                    }
                }
            }
        }

        return answer;
    }

    @Test
    public void testCase() {

        int k1 = 3;
        int[] score1 = new int[]{10, 100, 20, 150, 1, 100, 200};
        int[] answer1 = new int[]{10, 10, 10, 20, 20, 100, 100};
        assert solution(k1, score1) == answer1;



    }
}
