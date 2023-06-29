package leetcode.dynamic;

public class Leetcode_70 {
    public int climbStairsMethodOne(int n) {
        if (n <= 2) {
            return n;
        }
        // result[i]:爬到第i阶台阶有result[i]种方法
        int[] result = new int[n + 1];
        // 初始化dp数组
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        // 填充dp数组 result[0] result[1] result[2] 都已经被初始化
        // 所以从左到右 从result[3]开始填充
        for (int i = 3; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        // 返回爬到第n阶台阶的方法的数量
        return result[result.length - 1];
    }

    public int climbStairsMethodTwo(int n) {
        // 每次可以爬的最大台阶数 weight的值可以随意进行更改 爬楼梯进阶版
        int weight = 2;
        // 爬到第i阶台阶有dp[i]种方法
        int[] result = new int[n + 1];
        // 爬到第0阶台阶有0种方法
        result[0] = 1;
        // 爬到第1阶台阶有1种方法
        result[1] = 1;
        // 求排列数 先遍历背包 再遍历物品
        for (int i = 2; i < result.length; i++) {
            for (int j = 1; j <= weight; j++) {
                // 背包容量大于等于物品的重量的情况下 才可以放入物品
                if (i >= j) {
                    result[i] += result[i - j];
                }
            }
        }
        return result[result.length - 1];
    }
}
