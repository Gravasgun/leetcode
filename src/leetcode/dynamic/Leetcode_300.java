package leetcode.dynamic;

import java.util.Arrays;

/**
 * 300.最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Leetcode_300 {
    public int lengthOfLIS(int[] nums) {
        // 创建一个dp数组来记录每个位置的最长递增子序列长度
        // result[i]表示i之前包括i的 以nums[i]结尾 的最长递增子序列的长度
        int[] result = new int[nums.length];
        // 将数组 result 初始化为1，因为每个元素本身都构成长度为1的递增子序列
        Arrays.fill(nums, 1);
        // 遍历数组，计算每个位置的最长递增子序列长度
        for (int i = 1; i < result.length; i++) {
            // 如果当前数字大于前面的数字，可以将当前数字加入到前面的递增子序列中，更新最长长度
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }
        // 返回最长递增子序列的长度，即 result 数组中的最大值
        return Arrays.stream(result).max().getAsInt();
    }
}
