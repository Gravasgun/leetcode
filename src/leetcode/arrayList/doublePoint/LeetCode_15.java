package leetcode.arrayList.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15 {
    /**
     * 15.三数之和
     * 给你一个整数数组nums，判断是否存在三元组[nums[i], nums[j], nums[k]]满足
     * i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0。
     * 请你返回所有和为0且不重复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int left = 0; left < nums.length; left++) {
            //如果排序后的第一个数都大于0了，那么就不可能出现三元组了
            if (nums[left] > 0) {
                return result;
            }

            //去重left
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }

            int temp = left + 1;
            int right = nums.length - 1;
            while (temp < right) {
                int sum = nums[left] + nums[temp] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    temp++;
                } else {
                    result.add(Arrays.asList(nums[left], nums[temp], nums[right]));
                    //找到三元组之后去重temp和right
                    while (temp < right && nums[temp] == nums[temp + 1]) {
                        temp++;
                    }
                    while (temp < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //移动指针
                    right--;
                    temp++;
                }
            }
        }
        return result;
    }

}
