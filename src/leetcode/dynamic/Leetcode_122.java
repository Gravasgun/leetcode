package leetcode.dynamic;

/**
 * 122.买卖股票的最佳时机II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class Leetcode_122 {
    /**
     * 方法二：动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfitMethodTwo(int[] prices) {
        // 创建一个二维数组来存储结果
        // result[i][0] 表示在第i天持有股票时的最大利润
        // result[i][1] 表示在第i天不持有股票时的最大利润
        int[][] result = new int[prices.length][2];
        // 初始化第一天的情况
        result[0][0] = -prices[0];  // 在第一天买入股票，所以利润为负的股票价格
        result[0][1] = 0;           // 在第一天不买入股票，所以利润为0
        // 遍历每一天的价格
        for (int i = 1; i < result.length; i++) {
            // 计算第i天持有股票时的最大利润
            // 可能的情况有两种：
            // 1. 前一天持有股票，今天不卖出，保持不变
            // 2. 前一天不持有股票，今天买入，利润减去股票价格
            result[i][0] = Math.max(result[i - 1][1] - prices[i], result[i - 1][0]);
            // 计算第i天不持有股票时的最大利润
            // 可能的情况有两种：
            // 1. 前一天不持有股票，今天保持不变
            // 2. 前一天持有股票，今天卖出，利润增加股票价格
            result[i][1] = Math.max(result[i - 1][1], result[i][0] + prices[i]);
        }
        // 返回最后一天的最大利润
        // 最大利润要么是最后一天不持有股票的情况，要么是最后一天持有股票的情况
        return Math.max(result[result.length - 1][0], result[result.length - 1][1]);
    }
}
