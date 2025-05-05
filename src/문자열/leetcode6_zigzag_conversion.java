package 문자열;

import java.util.Arrays;

public class leetcode6_zigzag_conversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        char[][] arr = new char[numRows][length];

        int[] dj = {0, +1};
        int[] di = {1, -1};

        int i = 0, j = 0, d = 0;
        for (char c : s.toCharArray()) {
            arr[i][j] = c;

            if (i + di[d] >= numRows || i + di[d] < 0) {
                d = (d + 1) % 2;
            }

            i += di[d];
            j += dj[d];
        }

        StringBuilder sb = new StringBuilder();
        for (int ii = 0; ii < numRows; ii++) {
            for (int jj = 0; jj < length; jj++) {
                if (arr[ii][jj] == '\u0000') continue;
                sb.append(arr[ii][jj]);
            }
        }

        return sb.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] result = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            result[i] = new StringBuilder();
        }

        boolean down = false;
        int row = 0;

        for (char c : s.toCharArray()) {
            result[row].append(c);

            if (row == numRows - 1 || row == 0) {
                down = !down;
            }
            row += down? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(result[i].toString());
        }

        return sb.toString();
    }
}