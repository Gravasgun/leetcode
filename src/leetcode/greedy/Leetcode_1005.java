package leetcode.greedy;

import java.util.Arrays;

/**
 * 1005.K次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 */
public class Leetcode_1005 {
    // 局部最优：让绝对值大的负数变为正数，当前数值达到最大
    // 全局最优：整个数组和达到最大
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums); // 对数组进行排序
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) { // 如果当前数字小于0并且还有剩余的取反次数
                nums[i] = -1 * nums[i]; // 将当前数字取反
                k--; // 取反次数减1
            }
        }
        Arrays.sort(nums); // 再次对数组进行排序
        if (k > 0 && k % 2 == 1) { // 如果剩余取反次数大于0且为奇数
            nums[0] = -1 * nums[0]; // 将数组中最小的元素取反
        }
        return Arrays.stream(nums).sum(); // 计算数组中所有元素的和并返回
    }
}