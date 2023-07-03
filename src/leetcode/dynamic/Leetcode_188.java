package leetcode.dynamic;

public class Leetcode_188 {
    public int maxProfit(int k, int[] prices) {
        // result[i][j] 表示在第i天进行第j次交易时的最大利润
        // j=0 表示未进行任何交易
        // j=1 表示进行了一次买入操作
        // j=2 表示进行了一次卖出操作
        // j=3 表示进行了两次买入操作
        // j=4 表示进行了两次卖出操作
        // 以此类推，直到 j=2k 表示进行了k次卖出操作
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
                // 当 j 为偶数时，表示进行卖出操作(不持有)
                // 可能的情况有两种：
                // 1. 前一天已经进行了相同次数的卖出操作(不持有)，今天不变
                // 2. 前一天进行了相同次数的买入操作，今天卖出，利润增加股票价格
                if (j % 2 == 0) {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - 1] + prices[i]);
                } else {
                    // 当 j 为奇数时，表示进行买入操作
                    // 可能的情况有两种：
                    // 1. 前一天已经进行了相同次数的买入操作，今天不变
                    // 2. 前一天进行了相同次数的卖出操作，今天买入，利润减去股票价格
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - 1] - prices[i]);
                }
            }
        }
        // 返回最后一天进行k次卖出操作时的最大利润
        // 最大利润要么是最后一天进行k次卖出操作的情况，要么是最后一天进行k-1次卖出操作的情况
        return Math.max(result[result.length - 1][result[0].length - 2], result[result.length - 1][result[0].length - 1]);
    }
}
