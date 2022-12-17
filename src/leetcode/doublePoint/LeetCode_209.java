package leetcode.doublePoint;

import org.junit.Test;

public class LeetCode_209 {
    /**
     * 209. 长度最小的子数组
     * 给定一个含有n个正整数的数组和一个正整数target。
     * 找出该数组中满足其和≥target的长度最小的连续子数组，并返回其长度。如果不存在符合条件的子数组，返回0。
     *
     * @param target
     * @param nums
     * @return
     */
    //双循环暴力解法
    public int minSubArrayLenMethodOne(int target, int[] nums) {
        //最终的结果
        int result = Integer.MAX_VALUE;
        //子序列之和
        int sum = 0;
        //子序列的长度
        int subLength = 0;
        for (int i = 0; i < nums.length; i++) {
            //每次一把sum归零
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                //子序列和
                sum += nums[j];
                //一旦发现子序列和超过了target，更新result
                if (sum >= target) {
                    subLength = j - i + 1;
                    result = result < subLength ? result : subLength;
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //双指针
    public int minSubArrayLenMethodTwo(int target, int[] nums) {
        //最终的结果
        int result = Integer.MAX_VALUE;
        //子序列之和
        int sum = 0;
        //左指针
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            //子序列和
            sum += nums[right];
            //当子序列的和>target时，从数组左边开始，将子序列的和做递减操作
            while (sum >= target) {
                //更新长度
                result = Math.min(right-left+1, result);
                //更新子序列的和
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}
