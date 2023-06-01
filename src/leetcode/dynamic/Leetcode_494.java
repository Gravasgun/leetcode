package leetcode.dynamic;

import java.util.Arrays;

/**
 * 494.目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class Leetcode_494 {
    /**
     * left(正数)、right(负数)、sum(数组和)、target(目标和)
     * left + right = sum
     * left - right = target
     * left = (sum + target) / 2
     * 问题可以转换为01背包问题 问题就是在集合nums中找出和为left的组合
     *
     * @param nums   输入的整数数组
     * @param target 目标和
     * @return 和为目标和的组合数
     */
    public int findTargetSumWays(int[] nums, int target) {
        // 计算数组的总和
        int sum = Arrays.stream(nums).sum();
        // 如果 (sum + target) 除以2的余数为1，说明无法找到符合要求的组合，直接返回0
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        // 如果 target 是负数且 sum 小于 -target，说明无法找到符合要求的组合，直接返回0
        if (target < 0 && sum < -target) {
            return 0;
        }
        // 计算目标和的一半，并取绝对值
        int size = (sum + target) / 2;
        if (size < 0) {
            size = -size;
        }
        // 创建结果数组，表示和为i的组合数
        int[] result = new int[size + 1];
        // 初始化和为0的组合数为1
        result[0] = 1;
        // 遍历数组 nums
        for (int i = 0; i < nums.length; i++) {
            // 从结果数组的最后一个元素开始向前遍历
            for (int j = result.length - 1; j >= nums[i]; j--) {
                // 更新组合数，将当前数字 nums[i] 加入到和为 j 的组合中
                result[j] += result[j - nums[i]];
            }
        }
        // 返回结果数组的最后一个元素，即表示和为目标值的组合数
        return result[result.length - 1];
    }
}