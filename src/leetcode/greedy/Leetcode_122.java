package leetcode.greedy;

import java.util.Arrays;

/**
 * 122.买卖股票的最佳时机II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class Leetcode_122 {
    /**
     * 方法一：贪心
     * 假如第0天买入，第3天卖出，那么利润为：prices[3] - prices[0]
     * 相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])
     * 收集正利润的区间，就是股票买卖的区间，而我们只需要关注最终利润，不需要记录区间
     * 局部最优：收集每天的正利润，
     * 全局最优：求得最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfitMethodOne(int[] prices) {
        // 创建一个数组来存储价格差值（利润）
        int[] profit = new int[prices.length - 1];
        // 记录profit数组的索引
        int index = 0;
        // 遍历价格数组
        for (int i = 1; i < prices.length; i++) {
            // 计算当前价格与前一个价格之间的差值（利润）
            int diff = prices[i] - prices[i - 1];
            // 如果差值大于0，表示可以获得利润
            if (diff > 0) {
                // 将利润存储到profit数组中
                profit[index++] = diff;
            }
        }
        // 使用流的方式计算profit数组中所有元素的和，即最大利润
        return Arrays.stream(profit).sum();
    }

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
