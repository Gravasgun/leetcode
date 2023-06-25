package leetcode;

public class Leetcode_509 {
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
        // 创建一个dp数组用于存储计算过的斐波那契数
        // dp[i]：第i个数的斐波那契数值是dp[i]
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
