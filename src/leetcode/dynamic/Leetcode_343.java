package leetcode.dynamic;

public class Leetcode_343 {
    public int integerBreak(int n) {
        // result[i]:拆分数字i的最大乘积为result[i]
        int[] result = new int[n + 1];
        // 初始化dp数组
        result[2] = 1;
        // 填充dp数组
        for (int i = 3; i < result.length; i++) {
            for (int j = 1; j < i; j++) {
                result[i] = Math.max(result[i], Math.max(j * (i - j), j * result[i - j]));
            }
        }
        // 返回拆分数字i的最大乘积 result[i]
        return result[result.length - 1];
    }
}
