package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90.子集II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class Leetcode_90 {
    List<List<Integer>> result = new ArrayList<>(); // 存储所有子集结果的列表
    List<Integer> subSet = new ArrayList<>(); // 当前正在构建的子集

    /**
     * 生成给定数组的所有子集，其中可能包含重复的元素
     * @param nums 给定的整数数组
     * @return 包含所有子集的列表
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result; // 数组为空或长度为0，直接返回结果列表
        }
        Arrays.sort(nums); // 对数组进行排序，以处理重复元素
        backTrack(nums, 0); // 调用回溯方法生成子集
        return result; // 返回结果列表
    }

    /**
     * 回溯方法，生成子集
     * @param nums 给定的整数数组
     * @param startIndex 当前回溯的起始索引
     */
    private void backTrack(int[] nums, int startIndex) {
        result.add(new ArrayList<>(subSet)); // 将当前子集加入到结果列表中
        for (int i = startIndex; i < nums.length; i++) {
            if (startIndex != i && nums[i] == nums[i - 1]) {
                continue; // 跳过重复的元素，避免生成重复的子集
            }
            subSet.add(nums[i]); // 将当前元素加入到子集中
            backTrack(nums, i + 1); // 递归调用回溯，更新起始索引为i+1
            subSet.remove(subSet.size() - 1); // 回溯，移除最后一个元素，进行下一轮回溯
        }
    }
}