package leetcode.back_track;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 491.递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class Leetcode_491 {
    // 存储所有递增子序列的结果列表
    List<List<Integer>> result = new ArrayList<>();
    // 当前正在构建的递增子序列
    List<Integer> subSequence = new ArrayList<>();

    // 寻找给定数组的递增子序列的入口方法
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        backTrack(nums, 0);
        return result;
    }

    // 回溯方法，用于构建递增子序列
    private void backTrack(int[] nums, int startIndex) {
        // 如果当前子序列长度大于1，则将其加入结果列表中
        if (subSequence.size() > 1) {
            result.add(new ArrayList<>(subSequence));
        }

        // 使用Map记录当前层级中已经遇到的元素，以避免重复
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 如果当前子序列不为空，并且当前元素小于子序列中的最后一个元素，则跳过该元素，保证递增
            if (!subSequence.isEmpty() && subSequence.get(subSequence.size() - 1) > nums[i]) {
                continue;
            }

            // 如果Map中已经存在当前元素，则跳过该元素，避免重复
            if (map.containsKey(nums[i])) {
                continue;
            } else {
                map.put(nums[i], 1);
            }

            // 将当前元素加入到当前子序列中
            subSequence.add(nums[i]);
            // 递归调用backTrack方法，继续向后构建子序列
            backTrack(nums, i + 1);
            // 回溯：移除最后一个添加的元素，以便进行下一轮迭代
            subSequence.remove(subSequence.size() - 1);
        }
    }
}