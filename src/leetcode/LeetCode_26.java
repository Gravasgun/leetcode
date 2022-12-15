package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_26 {
    /**
     *26.删除有序数组中的重复项
     * 给你一个升序排列的数组nums,请你原地删除重复出现的元素，使每个元素只出现一次
     * 返回删除后数组的新长度。元素的相对顺序应该保持一致。
     * @param nums
     * @return
     */
    public int removeDuplicatesMethodOne(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = 0;
        for (int num : nums) {
            if (set.add(num)) {
                nums[length++] = num;
            }
        }
        return length;
    }

    public int removeDuplicatesMethodTwo(int[] nums) {
        //慢指针，从左到右更新数组的元素
        int slow = 0;
        //快指针，寻找不重复的元素
        for (int fast=1;fast< nums.length;fast++){
            //只要找到了与慢指针不重复的元素，就更新慢指针后一位元素的值，因为至少要保留一个不重复的元素，所以从后一位开始
            if (nums[slow]!=nums[fast]){
                nums[++slow]=nums[fast];
            }
        }
        return ++slow;
    }

    @Test
    public void test(){
        int [] nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicatesMethodTwo(nums);
        System.out.println(count);
    }
}
