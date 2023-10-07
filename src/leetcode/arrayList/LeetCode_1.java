package leetcode.arrayList;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {
    /**
     * 1.两数之和
     * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *
     * 方法一：暴力法
     * 遍历数组中的每一对数字，检查它们的和是否等于目标值。
     *
     * @param nums 整数数组
     * @param target 目标值
     * @return 包含两个整数下标的数组，表示找到的结果
     */
    public int[] twoSumMethodOne(int[] nums, int target) {
        int[] result = new int[2];
        // 遍历数组
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 检查当前两个数字的和是否等于目标值
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        // 如果没有找到结果，则返回默认值
        return result;
    }

    /**
     * 方法二：哈希表法
     * 使用哈希表存储已经遍历过的数字，同时查找目标值是否在哈希表中。
     *
     * @param nums 整数数组
     * @param target 目标值
     * @return 包含两个整数下标的数组，表示找到的结果
     */
    public int[] twoSumMethodTwo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 计算当前数字与目标值的差值
            int complement = target - nums[i];
            // 检查差值是否已经存在于哈希表中
            if (map.containsKey(complement)) {
                // 如果存在，则返回当前数字的下标和差值对应数字的下标
                return new int[]{i, map.get(complement)};
            }
            // 将当前数字和其下标存入哈希表中
            map.put(nums[i], i);
        }
        // 如果没有找到结果，则返回默认值
        return new int[]{-1, -1};
    }
}
