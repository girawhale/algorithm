package 그리디;

public class leetcode122_best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        int ret = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ret += prices[i] - prices[i - 1];
            }
        }
        return ret;
    }
}