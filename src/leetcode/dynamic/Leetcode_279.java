package leetcode.dynamic;

/**
 * 279.完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说
 * 其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 本题和 322.零钱兑换 这道题几乎是一模一样
 */
public class Leetcode_279 {
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        // dp[j]：和为j的完全平方数的最少数量为dp[j]
        int[] result = new int[n + 1];
        // 初始化dp数组，将所有元素初始化为一个较大的值（max）
        for (int i = 0; i < result.length; i++) {
            result[i] = max;
        }
        // 设置数字0所需的最少完全平方数数量为0
        result[0] = 0;
        // 遍历从0到n的数字(物品)
        for (int i = 0; i * i <= n; i++) {
            // 遍历结果数组(背包)
            for (int j = i * i; j < result.length; j++) {
                // 检查如果使用当前完全平方数可以得到数字j
                if (result[j - (i * i)] != max) {
                    // 更新最小完全平方数数量
                    result[j] = Math.min(result[j], result[j - (i * i)] + 1);
                }
            }
        }
        // 如果结果数组的最后一个元素仍为max，表示无法凑出目标数字
        return result[result.length - 1] == max ? -1 : result[result.length - 1];
    }
}