package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i]:凑成i金额所需的硬币个数为dp[i]
        int[] result = new int[amount + 1];
        // 题目求最小值 所以要把dp数组填充为最大值
        Arrays.fill(result, Integer.MAX_VALUE);
        // 凑成"0"金额所需的硬币个数为0 这里不能是最大值 不然没办法递推
        result[0] = 0;
        // 组合问题 先遍历物品 再遍历背包
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < result.length; j++) {
                // 如果使用当前硬币可以得到金额j
                if (result[j - coins[i]] != Integer.MAX_VALUE) {
                    result[j] = Math.min(result[j], result[j - coins[i]] + 1);
                }
            }
        }
        return result[result.length - 1] == Integer.MAX_VALUE ? -1 : result[result.length - 1];
    }
}
