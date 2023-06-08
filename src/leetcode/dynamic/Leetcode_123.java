package leetcode.dynamic;

/**
 * 123.买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Leetcode_123 {
    public int maxProfit(int[] prices) {
        // 创建一个二维数组来存储结果
        // result[i][j] 表示在第i天进行第j次交易时的最大利润
        // j=0 表示未进行任何交易
        // j=1 表示第一次持有
        // j=2 表示第一次不持有
        // j=3 表示第二次持有
        // j=4 表示第二次不持有
        int[][] result = new int[prices.length][5];
        // 初始化第一天的情况
        result[0][0] = 0;           // 未进行任何交易，利润为0
        result[0][1] = -prices[0];  // 第一次买入，利润为负的股票价格
        result[0][2] = 0;           // 第一次卖出，利润为0
        result[0][3] = -prices[0];  // 第二次买入，利润为负的股票价格
        result[0][4] = 0;           // 第二次卖出，利润为0

        // 遍历每一天的价格
        for (int i = 1; i < result.length; i++) {
            // 计算进行第一次持有时的最大利润
            // 可能的情况有两种：
            // 1. 前一天已经第一次持有，今天不变
            // 2. 前一天未进行任何交易，今天买入，利润减去股票价格
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] - prices[i]);

            // 计算进行第一次不持有时的最大利润
            // 可能的情况有两种：
            // 1. 前一天已经第一次不持有，今天不变
            // 2. 前一天已经第一次持有，今天卖出，利润增加股票价格
            result[i][2] = Math.max(result[i - 1][2], result[i - 1][1] + prices[i]);

            // 计算进行第二次持有时的最大利润
            // 可能的情况有两种：
            // 1. 前一天已经第二次持有，今天不变
            // 2. 前一天已经第一次不持有，今天买入，利润减去股票价格
            result[i][3] = Math.max(result[i - 1][3], result[i - 1][2] - prices[i]);

            // 计算进行第二次不持有时的最大利润
            // 可能的情况有两种：
            // 1. 前一天已经第二次不持有，今天不变
            // 2. 前一天已经第二次持有，今天卖出，利润增加股票价格
            result[i][4] = Math.max(result[i - 1][4], result[i - 1][3] + prices[i]);
        }
        // 返回最后一天进行两次卖出操作时的最大利润
        return Math.max(result[result.length - 1][3], result[result.length - 1][4]);
    }
}
