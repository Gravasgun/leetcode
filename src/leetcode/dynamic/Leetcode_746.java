package leetcode.dynamic;

/**
 * 746.使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class Leetcode_746 {
    public int minCostClimbingStairs(int[] cost) {
        // 创建一个结果数组，长度为 cost.length + 1，用于存储到达每个阶梯的最小花费
        // i表示第i个台阶 result[i]表示到达第i个台阶最少的花费
        // 楼梯的顶部是cost.length+1 所以dp数组的长度就应该是cost.length+1
        int[] result = new int[cost.length + 1];
        // 初始化结果数组的前两个元素为0，因为到达起始位置不花费
        result[0] = 0;
        result[1] = 0;
        // 遍历从第三个阶梯开始到达每个阶梯的最小花费
        for (int i = 2; i < result.length; i++) {
            // 当前阶梯的最小花费等于 前一个阶梯爬到当前阶梯的花费 和 前两个阶梯爬到当前阶梯的花费 中的较小值
            result[i] = Math.min(cost[i - 1] + result[i - 1], cost[i - 2] + result[i - 2]);
        }
        // 返回结果数组中最后一个元素，即到达顶部的最小花费
        return result[result.length - 1];
    }
}
