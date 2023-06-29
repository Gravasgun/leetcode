package leetcode.dynamic;

public class Leetcode_518 {
    public int change(int amount, int[] coins) {
        // dp[i]:凑成总金额为i的组合数有dp[i]种
        int[] result = new int[amount + 1];
        // 初始化dp数组 凑成总金额为0的组合数有1种
        result[0] = 1;
        // 求组合数 先遍历物品 再遍历背包
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < result.length; j++) {
                result[j] += result[j - coins[i]];
            }
        }
        return result[result.length - 1];
    }
}
