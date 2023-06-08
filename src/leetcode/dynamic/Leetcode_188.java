package leetcode.dynamic;

/**
 * 188.买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格，和一个整型 k 。
 * 设计一个算法来计算你所能获取的最大利润。
 * 你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Leetcode_188 {
    public int maxProfit(int k, int[] prices) {
        // 创建一个二维数组来存储结果
        // result[i][j] 表示在第i天进行第j次交易时的最大利润
        // j=0 表示未进行任何交易
        // j=1 表示进行了一次买入操作
        // j=2 表示进行了一次卖出操作
        // j=3 表示进行了两次买入操作
        // j=4 表示进行了两次卖出操作
        // 以此类推，直到 j=2k 表示进行了k次卖出操作
        int[][] result = new int[prices.length][(2 * k) + 1];

        // 初始化第一天的情况
        // 对于奇数列 j，表示进行买入操作，利润为负的股票价格
        for (int i = 1; i < result[0].length; i += 2) {
            result[0][i] = -prices[0];
        }

        // 遍历每一天的价格
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (j % 2 == 0) {
                    // 当 j 为偶数时，表示进行卖出操作
                    // 可能的情况有两种：
                    // 1. 前一天已经进行了相同次数的卖出操作，今天不变
                    // 2. 前一天进行了相同次数的买入操作，今天卖出，利润增加股票价格
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