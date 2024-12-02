package bms.algorithm;

import org.junit.jupiter.api.Test;

public class SameCoordinates {

    public boolean checkStraightLine(int[][] coordinates) {
        int diffX = coordinates[1][0] - coordinates[0][0];
        int diffY = coordinates[1][1] - coordinates[0][1];
        double prevGrad =  ((diffY * 1.0) / (diffX * 1.0));
        for (int i = 2;i < coordinates.length;i++) {
            diffX = coordinates[i][0] - coordinates[i-1][0];
            diffY = coordinates[i][1] - coordinates[i-1][1];
            double currGrad =  ((diffY * 1.0) / (diffX * 1.0));
            if (currGrad != prevGrad) return false;
        }
        String a = "flafjaf";

        return true;
    }

    @Test
    public void checkAns() {

        int[][] coordinates = new int[3][3];

        boolean result = checkStraightLine(coordinates);
        assert result;

    }
}
