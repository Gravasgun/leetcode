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
}