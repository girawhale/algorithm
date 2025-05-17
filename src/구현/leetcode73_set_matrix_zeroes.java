package 구현;

import java.util.ArrayList;
import java.util.List;

public class leetcode73_set_matrix_zeroes {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeroes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroes.add(new int[]{i, j});
                }
            }
        }

        for (int[] zero : zeroes) {
            for (int i = 0; i < matrix.length; i++) matrix[i][zero[1]] = 0;
            for (int j = 0; j < matrix[0].length; j++) matrix[zero[0]][j] = 0;
        }
    }

    public void setZeroes2(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}