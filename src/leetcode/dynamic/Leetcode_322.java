package leetcode.dynamic;

/**
 * 322.零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 本题求：装满背包的最少物品的个数
 */
public class Leetcode_322 {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        // dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
        int[] result = new int[amount + 1];
        // 初始化dp数组，将所有元素初始化为一个较大的值（max）
        for (int i = 0; i < result.length; i++) {
            result[i] = max;
        }
        // 设置金额为0时需要的最少硬币数量为0
        result[0] = 0;
        // 遍历硬币数组(物品)
        for (int i = 0; i < coins.length; i++) {
            // 遍历金额数组(背包)
            for (int j = coins[i]; j < result.length; j++) {
                // 检查如果使用当前硬币可以得到金额j
                if (result[j - coins[i]] != max) {
                    // 更新最小硬币数量
                    result[j] = Math.min(result[j], result[j - coins[i]] + 1);
                }
            }
        }
        // 如果结果数组的最后一个元素仍为max，表示无法凑出目标金额
        return result[result.length - 1] == max ? -1 : result[result.length - 1];
    }
}