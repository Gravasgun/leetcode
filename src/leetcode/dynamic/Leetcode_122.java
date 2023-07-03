package leetcode.dynamic;

public class Leetcode_122 {
    public int maxProfit(int[] prices) {
        // result[i][0]:第i天持有股票的最高利润
        // result[i][1]:第i天不持有股票的最高利润
        int[][] result = new int[prices.length][2];
        result[0][0] = -prices[0];
        result[0][1] = 0;
        for (int i = 1; i < result.length; i++) {
            // 第i天持有股票的最高利润 = 前一天持有股票 或 当天买入
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][1] - prices[i]);
            // 第i天不持有股票的最高利润 = 前一天不有股票 或 当天卖出
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] + prices[i]);
        }
        return Math.max(result[result.length - 1][0], result[result.length - 1][1]);
    }
}
