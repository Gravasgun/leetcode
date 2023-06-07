package leetcode.dynamic;

/**
 * 121.买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Leetcode_121 {
    /**
     * 方法一：暴力法
     * 遍历所有的买入和卖出日期组合，计算利润并更新最大利润
     *
     * @param prices 价格数组
     * @return 最大利润
     */
    public int maxProfitMethodOne(int[] prices) {
        int max = Integer.MIN_VALUE;
        // 遍历所有的买入和卖出日期组合
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // 如果当前卖出价格减去买入价格大于0，则计算利润并更新最大利润
                if (prices[j] - prices[i] > 0) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        // 如果最大利润仍然是初始值Integer.MIN_VALUE，则表示没有盈利，返回0；否则返回最大利润
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    /**
     * 方法二：贪心法
     * 维护一个最小买入价格，同时计算每个卖出日期的利润并更新最大利润
     *
     * @param prices 价格数组
     * @return 最大利润
     */
    public int maxProfitMethodTwo(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            // 更新最小买入价格
            min = Math.min(min, prices[i]);
            // 计算当前卖出日期的利润并更新最大利润
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }

    /**
     * 方法三：动态规划
     * 使用动态规划思想，维护一个二维数组result，其中result[i][0]表示第i天持有股票的最大利润，result[i][1]表示第i天不持有股票的最大利润
     *
     * @param prices 价格数组
     * @return 最大利润
     */
    public int maxProfitMethodThree(int[] prices) {
        int[][] result = new int[prices.length][2];
        // 第0天持有股票的最大利润为买入股票的负值
        result[0][0] = -prices[0];
        // 第0天不持有股票的最大利润为0
        result[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 当前持有股票的最大利润为前一天持有或当天买入的较大值
            result[i][0] = Math.max(result[i - 1][0], -prices[i]);
            // 当前不持有股票的最大利润为前一天不持有或当天卖出的较大值
            result[i][1] = Math.max(result[i - 1][1], result[i][0] + prices[i]);
        }
        // 返回最后一天持有或不持有股票的较大值作为最大利润
        return Math.max(result[result.length - 1][0], result[result.length - 1][1]);
    }
}