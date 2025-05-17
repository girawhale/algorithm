package 비트;

public class leetcode289_game_of_life {
    public void gameOfLife(int[][] board) {
        int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dj = {-1, 0, 1, -1 ,1, -1, 0, 1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int ii = i + di[k];
                    int jj = j + dj[k];
                    if (ii < 0 || ii >= board.length || jj < 0 || jj >= board[0].length) continue;
                    int value = board[ii][jj];
                    if ((value & 1) == 1) count++;
                }

                int value = board[i][j] & 1;
                if (value == 1 &&(count == 2 || count == 3)) {
                    board[i][j] |= 2;
                } else if (value == 0 && (count == 3)) {
                    board[i][j] |= 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = (board[i][j] & 2) == 0 ? 0 : 1;
            }
        }
    }
}