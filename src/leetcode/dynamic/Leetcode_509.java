package leetcode.dynamic;

/**
 * 509.斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class Leetcode_509 {
    /**
     * 方法一：递归
     *
     * @param n 输入的斐波那契数的索引
     * @return 第 n 个斐波那契数
     */
    public int fibMethodOne(int n) {
        // 基本情况：当 n 等于 0 时，返回 0
        if (n == 0) {
            return 0;
        }
        // 基本情况：当 n 等于 1 时，返回 1
        if (n == 1) {
            return 1;
        }
        // 递归调用：计算第 n 个斐波那契数，即前两个数的和
        return fibMethodOne(n - 1) + fibMethodOne(n - 2);
    }

    /**
     * 方法二：动态规划
     *
     * @param n 输入的斐波那契数的索引
     * @return 第 n 个斐波那契数
     */
    public int fibMethodTwo(int n) {
        if (n <= 1) {
            return n;
        }
        // 创建一个数组用于存储计算过的斐波那契数
        int[] result = new int[n + 1];
        // 初始化前两个斐波那契数
        result[0] = 0;
        result[1] = 1;
        // 从第2个斐波那契数开始计算
        for (int i = 2; i < result.length; i++) {
            // 计算第 i 个斐波那契数，即前两个数的和
            result[i] = result[i - 1] + result[i - 2];
        }
        // 返回第 n 个斐波那契数
        return result[result.length - 1];
    }
}