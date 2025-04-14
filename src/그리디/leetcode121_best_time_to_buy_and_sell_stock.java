package 그리디;

public class leetcode121_best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        int ret = 0;
        int min = 987654321;
        int max = 0;

        for (int price : prices) {
            if (price < min) {
                ret = Math.max(ret, max - min);
                min = price;
                max = price;
            } else if (price > max) {
                max = price;
            }
        }

        return Math.max(ret, max - min);
    }
}