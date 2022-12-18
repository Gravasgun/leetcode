package leetcode.arrayList.doublePoint;

import java.util.Arrays;

public class LeetCode_977 {
    /**
     * 977.有序数组的平方
     * 给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     *
     * @param nums
     * @return
     */
    public int[] sortedSquaresMethodOne(int[] nums) {
        for (int i=0;i< nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquaresMethodTwo(int[] nums) {
        //左值针
        int left = 0;
        //右指针
        int right = nums.length - 1;
        //新数组的下标
        int index = right;
        int[] arr = new int[nums.length];
        while (left <= right) {
            if ((nums[left] * nums[left]) > (nums[right] * nums[right])) {
                arr[index--] = nums[left] * nums[left];
                ++left;
            } else {
                arr[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return arr;
    }
}
