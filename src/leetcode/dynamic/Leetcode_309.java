package leetcode.dynamic;

public class Leetcode_309 {
    public int maxProfit(int[] prices) {
        int[][] result = new int[prices.length][3];
        // 0:冷冻期
        result[0][0] = 0;
        // 1:持有
        result[0][1] = -prices[0];
        // 2:不持有
        result[0][2] = 0;
        for (int i = 1; i < result.length; i++) {
            // 第i天处于冷冻期说明 i-1天卖出了股票
            result[i][0] = result[i - 1][1] + prices[i];
            // 第i天持有股票 说明 要么i-1天已经持有该股票 要么就是第i天买入股票
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][2] - prices[i]);
            // 第i天不持有股票 说明 要么 i-1天不持有股票
            // 要么第i-1天处于冷冻期(第i天不能购买 -> 第i-1天就是一定不持有 -> 不能由i-1天持有状态推导)
            result[i][2] = Math.max(result[i - 1][0], result[i - 1][2]);
        }
        return Math.max(result[result.length - 1][0], Math.max(result[result.length - 1][1], result[result.length - 1][2]));
    }
}
