package leetcode.arrayList.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_18 {
    /**
     * 18.四数之和
     * 给你一个由n个整数组成的数组nums，和一个目标值target。
     * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
     * （若两个四元组元素一一对应，则认为两个四元组重复）：
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //如果第一个数都大于target，那数组中肯定找不出
            //nums[i]>0是为了排除这种情况 [-4,-1,0,0] target= -5
            if (nums[i] > 0 && nums[i] > target && target > 0) {
                return result;
            }

            //对nums[i]去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                //nums[j]去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //nums[right]去重
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //nums[left]去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        //移动指针
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
