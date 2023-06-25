package leetcode.dynamic;

public class Leetcode_70 {
    public int climbStairs(int n) {
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
}
