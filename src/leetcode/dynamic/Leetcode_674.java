package leetcode.dynamic;

import java.util.Arrays;

/**
 * 674.最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r
 * 都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class Leetcode_674 {
    public int findLengthOfLCISMethodOne(int[] nums) {
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

    /**
     * 计算给定数组的最长连续递增子序列的长度
     *
     * @param nums 给定的数组
     * @return 最长连续递增子序列的长度
     */
    public int findLengthOfLCISMethodTwo(int[] nums) {
        int result = 1; // 最长连续递增子序列的初始长度为1
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = 1; // 用于记录当前递增子序列的长度
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    temp += 1; // 当前元素大于前一个元素，递增子序列长度加1
                    i++; // 移动指针到下一个元素
                    result = Math.max(result, temp); // 更新最长连续递增子序列的长度
                } else {
                    break; // 当前元素小于等于前一个元素，不再满足递增条件，跳出内层循环
                }
            }
        }
        return result; // 返回最长连续递增子序列的长度
    }
}