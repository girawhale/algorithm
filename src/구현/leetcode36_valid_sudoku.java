package 구현;

import java.util.HashSet;
import java.util.Set;

public class leetcode36_valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int ii = 0; ii <= 2; ii++) {
                    for (int jj = 0; jj <= 2; jj++) {
                        if (board[i + ii][j + jj] != '.' && set.contains(board[i + ii][j + jj])) {
                            return false;
                        }
                        set.add(board[i + ii][j + jj]);
                    }
                }
                set.clear();
            }
        }


        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(new leetcode36_valid_sudoku().isValidSudoku(board)); // 출력: true
    }
}