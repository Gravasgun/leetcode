package leetcode.dynamic;

/**
 * 714.买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class Leetcode_714 {
    public int maxProfit(int[] prices, int fee) {
        // 如果价格数组长度为1，则无法进行交易，利润为0
        if (prices.length == 1) {
            return 0;
        }
        // 创建一个二维数组来存储结果
        // result[i][j] 表示在第i天进行第j次交易时的最大利润
        // j=0 表示持有股票
        // j=1 表示不持有股票
        int[][] result = new int[prices.length][2];
        // 初始化第一天的情况
        result[0][0] = -prices[0];  // 第一天持有股票，利润为负的股票价格
        result[0][1] = 0;           // 第一天不持有股票，利润为0
        // 遍历每一天的价格
        for (int i = 1; i < result.length; i++) {
            // 计算持有股票时的最大利润
            // 可能的情况有两种：
            // 1. 前一天已经持有股票，今天不变
            // 2. 前一天不持有股票，今天买入股票，利润减去股票价格
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][1] - prices[i]);
            // 计算不持有股票时的最大利润
            // 可能的情况有两种：
            // 1. 前一天已经不持有股票，今天不变
            // 2. 前一天持有股票，今天卖出股票，利润增加股票价格减去手续费
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] + prices[i] - fee);
        }
        // 返回最后一天的最大利润
        return Math.max(result[result.length - 1][0], result[result.length - 1][1]);
    }
}