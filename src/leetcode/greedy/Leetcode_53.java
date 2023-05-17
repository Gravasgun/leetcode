package leetcode.greedy;

/**
 * 53.最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class Leetcode_53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE; // 用于记录当前的最大和，初始值设置为整数的最小值
        int sum = 0; // 用于记录当前连续子数组的和

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // 将当前元素加到 sum 上
            result = Math.max(sum, result); // 更新最大和 result，取 sum 和 result 中较大的值作为新的 result

            if (sum <= 0) {
                sum = 0; // 如果 sum 小于等于 0，则将 sum 重置为 0，因为负数对后续子数组的和只会产生负面影响，将其舍弃
            }
        }
        return result; // 返回最大子序和
    }
}