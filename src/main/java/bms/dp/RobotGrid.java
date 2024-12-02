package bms.dp;

import org.junit.jupiter.api.Test;

import java.util.*;

public class RobotGrid {

    protected static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                return ((Point) o).x == this.x && ((Point) o).y == this.y;
            }
            return false;
        }


    }

    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path) {

        if (m < 0 || n < 0)
            return false;

        if (maze[m][n])
            return false;

        if ((m == 0) && (n == 0))
            return true;
        else {
            computePath(m, n - 1, maze, path);
            computePath(m - 1, n, maze, path);
            path.add(new Point(m, n));
        }
        return false;
    }


    @Test
    public void mazeTest() {

        int m = 6;
        int n = 6;
        boolean[][] maze = new boolean[m][n];
        maze[2][1] = true;
        maze[2][2] = true;
        maze[2][3] = true;
        maze[2][4] = true;
        maze[2][5] = true;
        maze[3][5] = true;
        Set<Point> pointSet = new HashSet<>();

        computePath(m,n,maze,pointSet);

        System.out.println("done");
    }

}
