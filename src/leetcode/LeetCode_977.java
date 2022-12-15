package leetcode;

import java.util.Arrays;

public class LeetCode_977 {
    /**
     * 977.有序数组的平方
     * 给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        for (int i=0;i< nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
