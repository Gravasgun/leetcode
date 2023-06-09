package leetcode.dynamic;

import java.util.Arrays;

/**
 * 674.最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r
 * 都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class Leetcode_674 {
    public int findLengthOfLCIS(int[] nums) {
        // 创建一个dp数组来记录以每个位置结尾的最长连续递增子序列的长度
        int[] result = new int[nums.length];
        // 将数组 result 初始化为1，因为每个元素本身都构成长度为1的连续递增子序列
        Arrays.fill(result, 1);
        // 遍历数组，计算以每个位置结尾的最长连续递增子序列的长度
        for (int i = 1; i < result.length; i++) {
            // 如果当前数字大于前一个数字，则可以将当前数字加入到前面的连续递增子序列中
            if (nums[i] > nums[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        // 返回最长连续递增子序列的长度，即 result 数组中的最大值
        return Arrays.stream(result).max().getAsInt();
    }
}