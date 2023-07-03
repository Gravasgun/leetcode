package leetcode.dynamic;

public class Leetcode_123 {
    public int maxProfit(int[] prices) {
        int[][] result = new int[prices.length][5];
        result[0][0] = 0;
        result[0][1] = -prices[0];
        result[0][2] = 0;
        result[0][3] = -prices[0];
        result[0][4] = 0;
        for (int i = 1; i < result.length; i++) {
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] - prices[i]);
            result[i][2] = Math.max(result[i - 1][2], result[i - 1][1] + prices[i]);
            result[i][3] = Math.max(result[i - 1][3], result[i - 1][2] - prices[i]);
            result[i][4] = Math.max(result[i - 1][4], result[i - 1][3] + prices[i]);
        }
        return Math.max(result[result.length - 1][3], result[result.length - 1][4]);
    }
}
