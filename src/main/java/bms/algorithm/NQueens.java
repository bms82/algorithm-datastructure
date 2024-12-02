package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #51. N-Queens
 */
public class NQueens {

    // Solve using backtrack algorithm
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // 판 구성 완료 (base case)
        List<List<String>> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<String> rowBoard = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                rowBoard.add(".");
            }
            board.add(rowBoard);
        }
        // 경로: board에서 row보다 작은 행은 퀸 배치 성공
        // 선택리스트: row 번째 행의 모든 열은 퀸 배치를 선택.
        // 종료 조건 row가 board의 마지막 행을 넘으면 체스판이 가득 참.
        backtrack(board, 0);
        return res;
    }

    boolean backtrack(List<List<String>> board, int row) {
        if (row == board.size()) {
            pushBack(res, board, row);
            return true;
        }
        int n = board.get(0).size();
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            // 선택하기
            board.get(row).remove(col);
            board.get(row).add(col, "Q");
            if (backtrack(board, row+1))
                return true;
            board.get(row).remove(col);
            board.get(row).add(col, ".");
        }
        return false;
    }

    void pushBack(List<List<String>> res, List<List<String>> board, int row) {
        res.add(board.get(row - 1));
    }

    // board의 board.get(row).get(col)에 퀸 배치 여부 확인.
    boolean isValid(List<List<String>> board, int row, int col) {
        int n = board.size();
        // 같은 열에 퀸이 있는지 확인.
        for (int i = 0; i < row; i++) {
            if (board.get(i).get(col).equals("Q")) {
                return false;
            }
        }
        // 오른쪽 위 퀸 충돌 여부 확인.
        for (int i = row - 1, j = col + 1;  i >= 0 && j < n; j++, i--) {
            if (board.get(i).get(j).equals("Q"))
                return false;
        }
        // 왼쪽 위 퀸 충돌 여부 확인
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; j--, i--) {
            if (board.get(i).get(j).equals("Q"))
                return false;
        }
        return true;
    }

    @Test
    public void testNQueen() {

        int n = 8;
        List<List<String>> res = solveNQueens(n);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }
}
