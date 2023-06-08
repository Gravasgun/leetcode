package leetcode.dynamic;

/**
 * 309.最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Leetcode_309 {
    public int maxProfit(int[] prices) {
        int[][] result = new int[prices.length][3];
        // 第一天持有股票的利润
        result[0][0] = -prices[0];
        // 第一天不持有股票且不处于冷冻期的利润
        result[0][1] = 0;
        // 第一天不持有股票但处于冷冻期的利润
        result[0][2] = 0;

        for (int i = 1; i < result.length; i++) {
            // 第i天持有股票的最大利润，要么是前一天持有股票的利润，要么是前一天不持有股票且不处于冷冻期的利润减去当天的股票价格
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][1] - prices[i]);
            // 第i天不持有股票且不处于冷冻期的最大利润，要么是前一天不持有股票且不处于冷冻期的利润，要么是前一天处于冷冻期的利润
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][2]);
            // 第i天不持有股票但处于冷冻期的最大利润，是前一天持有股票的利润加上当天的股票价格(因为前一天卖出了股票)
            result[i][2] = result[i - 1][0] + prices[i];
        }
        // 返回最后一天持有股票的最大利润、不持有股票且不处于冷冻期的最大利润和不持有股票但处于冷冻期的最大利润三者中的最大值作为结果
        return Math.max(result[result.length - 1][0], Math.max(result[result.length - 1][1], result[result.length - 1][2]));
    }
}
