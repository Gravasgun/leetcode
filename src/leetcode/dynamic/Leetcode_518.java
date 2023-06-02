package leetcode.dynamic;

/**
 * 518.零钱兑换II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 本题求装满背包有多少种方法
 * 本题和 494.目标和 最大的差别就是：
 * 494.目标和是01背包问题，每个物品只能选一次，所以在遍历背包的时候，494.目标和是倒序遍历
 * 而本题是完全背包问题，每个物品可以选择多次，所以在遍历背包的时候，本题是从第一个物品的重量开始正序遍历
 */
public class Leetcode_518 {
    public int change(int amount, int[] coins) {
        // 创建一个长度为 amount + 1 的dp数组来记录组合数
        int[] result = new int[amount + 1];
        // 初始化第一个元素为 1，表示金额为 0 的情况下有一种组合方式，即不选择任何硬币
        result[0] = 1;
        // 本题只能先遍历物品再遍历背包 这样遍历得出来的是组合数
        // 如果先遍历背包，再遍历物品 得出来的是排列数
        // 遍历硬币数组(先遍历物品)
        for (int i = 0; i < coins.length; i++) {
            // 遍历从当前硬币面额开始到总金额的范围(再遍历背包)
            for (int j = coins[i]; j < result.length; j++) {
                // 计算组合数，当前背包容量为 j 的组合数等于之前金额 (j - coins[i]) 的组合数加上当前硬币 coins[i] 的组合数
                result[j] += result[j - coins[i]];
            }
        }
        // 返回总金额 amount 的组合数
        return result[result.length - 1];
    }
}