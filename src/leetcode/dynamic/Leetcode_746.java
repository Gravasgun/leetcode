package leetcode.dynamic;

public class Leetcode_746 {
    public int minCostClimbingStairs(int[] cost) {
        // result[i]:到达第i阶台阶所需的最低花费为result[i]
        int[] result = new int[cost.length + 1];
        // 初始化dp数组
        result[0] = 0;
        result[1] = 0;
        // 填充dp数组
        for (int i = 2; i < result.length; i++) {
            result[i] = Math.min(result[i - 1] + cost[i - 1], result[i - 2] + cost[i - 2]);
        }
        // 返回到达楼顶的最少花费
        return result[result.length - 1];
    }
}
