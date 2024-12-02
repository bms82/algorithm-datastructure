package bms.programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WallpaperDrag {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        answer[0] = wallpaper[0].length();
        answer[2] = 0;
        answer[1] = wallpaper.length;
        answer[3] = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                if (answer[1] > i) {
                    answer[1] = i;
                }
                if (answer[3] < i) {
                    answer[3] = i;
                }
                if (wallpaper[i].indexOf("#") < answer[0])
                    answer[0] = wallpaper[i].indexOf("#");
                if (wallpaper[i].lastIndexOf("#") < answer[2])
                    answer[2] = wallpaper[i].lastIndexOf("#");
            }
        }

        return answer;
    }

    @Test
    public void testCase() {

        /*

        [".#...", "..#..", "...#."] 	[0, 1, 3, 4]
        ["..........", ".....#....", "......##..", "...##.....", "....#....."] 	[1, 3, 5, 8]
        [".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."] 	[0, 0, 7, 9]
        ["..", "#."] 	[1, 0, 2, 1]
         */






    }

}
