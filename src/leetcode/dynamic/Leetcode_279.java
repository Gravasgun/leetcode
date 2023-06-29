package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_279 {
    public int numSquares(int n) {
        // dp[i]:和为i的完全平方数的最少数量为dp[i]
        int[] result = new int[n + 1];
        // 题目求最少 所以初始化dp数组为最大值
        Arrays.fill(result, Integer.MAX_VALUE);
       // dp[0]:和为0的完全平方数的最少数量为0
        result[0] = 0;
        // 求组合数 先遍历物品 再遍历背包
        for (int i = 0; i * i <= n; i++) {
            for (int j = i * i; j < result.length; j++) {
                // 如果使用当前完全平方数可以得到数字j
                if (result[j - i * i] != Integer.MAX_VALUE) {
                    result[j] = Math.min(result[j], result[j - i * i] + 1);
                }
            }
        }
        return result[result.length - 1] == Integer.MAX_VALUE ? -1 : result[result.length - 1];
    }
}
