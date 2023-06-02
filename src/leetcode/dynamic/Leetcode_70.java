package leetcode.dynamic;

/**
 * 70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定的 n 是一个正整数。
 */
public class Leetcode_70 {
    /**
     * 方法一：动态规划
     *
     * @param n 楼梯的阶数
     * @return 到达楼顶的不同方法数
     */
    public int climbStairsMethodOne(int n) {
        if (n <= 2) {
            return n;
        }
        // 创建一个数组用于存储到达每个阶梯的方法数
        int[] result = new int[n];
        // 初始化前两个阶梯的方法数
        result[0] = 1;
        result[1] = 2;
        // 从第3个阶梯开始计算
        for (int i = 2; i < result.length; i++) {
            // 到达第i个阶梯的方法数等于到达第i-1个阶梯的方法数加上到达第i-2个阶梯的方法数
            result[i] = result[i - 1] + result[i - 2];
        }
        // 返回到达楼顶的方法数，即到达第n个阶梯的方法数
        return result[result.length - 1];
    }

    /**
     * 方法二：递归
     *
     * @param n 楼梯的阶数
     * @return 到达楼顶的不同方法数
     */
    public int climbStairsMethodTwo(int n) {
        if (n <= 2) {
            return n;
        }
        // 递归调用：到达第n个阶梯的方法数等于到达第n-1个阶梯的方法数加上到达第n-2个阶梯的方法数
        return climbStairsMethodTwo(n - 1) + climbStairsMethodTwo(n - 2);
    }

    /**
     * 爬楼梯进阶版
     * 改为一次可以爬[1,stairs]个阶梯
     * 此时就是一个完全背包问题 可以爬的阶梯数就是物品 楼顶就是背包容量
     * @param n 楼梯的阶数
     * @return 到达楼顶的不同方法数
     */
    public int climbStairsMethodThree(int n) {
        // 创建一个长度为n + 1的dp数组，表示到达台阶数为i的方式数量为dp[i]
        int[] result = new int[n + 1];
        // 最大台阶数
        int stairs = 2;
        // 将result[0]初始化为1，表示到达台阶数为0的方式数量为1
        result[0] = 1;
        // 外层循环遍历result数组
        for (int i = 1; i < result.length; i++) {
            // 内层循环遍历1到stairs之间的台阶数
            for (int j = 1; j <= stairs; j++) {
                // 判断当前台阶数i是否大于等于j
                if (i >= j) {
                    // 如果可以爬上j个台阶，
                    // 则将result[i]增加result[i - j]
                    // 表示通过爬j个台阶后到达台阶数i的方式数量
                    result[i] += result[i - j];
                }
            }
        }
        // 返回result数组的最后一个元素 表示到达楼梯顶部的不同方式的数量
        return result[result.length - 1];
    }
}