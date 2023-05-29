package leetcode.dynamic;

/**
 * 343.整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 */
public class Leetcode_343 {
    public int integerBreak(int n) {
        // 创建dp数组用于保存将数字拆分后得到的乘积的最大值
        // dp[i]：分拆数字i，可以得到的最大乘积为dp[i]
        int[] result = new int[n + 1];
        // 初始情况，将数字2拆分后得到的乘积最大为1
        result[2] = 1;
        // 从数字3开始计算拆分后的乘积最大值
        for (int i = 3; i < result.length; i++) {
            // 遍历所有可能的拆分情况
            for (int j = 1; j < i; j++) {
                // 比较 当前的拆分情况 j乘以拆分剩余部分的乘积最大值 和 j乘以(i - j)的值，取较大者
                // j * dp[i - j]，相当于是拆分(i - j)
                result[i] = Math.max(result[i], Math.max(j * result[i - j], j * (i - j)));
            }
        }
        // 返回将数字n拆分后得到的乘积的最大值
        return result[result.length - 1];
    }
}
