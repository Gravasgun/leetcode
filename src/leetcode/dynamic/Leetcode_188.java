package leetcode.dynamic;

public class Leetcode_188 {
    public int maxProfit(int k, int[] prices) {
        int[][] result = new int[prices.length][2 * k + 1];
        for (int i = 0; i < result[0].length; i++) {
            if (i % 2 == 0) {
                result[0][i] = 0;
            } else {
                result[0][i] = -prices[0];
            }
        }

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (j % 2 == 0) {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - 1] + prices[i]);
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - 1] - prices[i]);
                }
            }
        }
        return Math.max(result[result.length - 1][result[0].length - 2], result[result.length - 1][result[0].length - 1]);
    }
}
