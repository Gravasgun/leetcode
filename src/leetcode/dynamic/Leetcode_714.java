package leetcode.dynamic;

public class Leetcode_714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] result = new int[prices.length][2];
        // 0:不持有状态的最大利润
        result[0][0] = 0;
        // 1:持有状态的最大利润
        result[0][1] = -prices[0] - fee;
        for (int i = 1; i < result.length; i++) {
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][1] + prices[i]);
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] - prices[i] - fee);
        }
        return Math.max(result[prices.length - 1][0], result[prices.length - 1][1]);
    }
}
