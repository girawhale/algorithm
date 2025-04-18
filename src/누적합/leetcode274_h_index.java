package 누적합;

public class leetcode274_h_index {
    public int hIndex(int[] citations) {
        int[] counts = new int[1001];

        for (int citation : citations) {
            counts[citation]++;
        }

        int total = 0;
        for (int i = 1000; i >= 0; i--) {
            total += counts[i];

            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}