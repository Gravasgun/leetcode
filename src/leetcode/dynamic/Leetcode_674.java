package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_674 {
    public int findLengthOfLCISMethodOne(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < result.length; i++) {
            if (nums[i] > nums[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        return Arrays.stream(result).max().getAsInt();
    }

    /**
     * 计算给定数组的最长连续递增子序列的长度
     *
     * @param nums 给定的数组
     * @return 最长连续递增子序列的长度
     */
    public static int findLengthOfLCISMethodTwo(int[] nums) {
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
