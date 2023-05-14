package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Leetcode_78 {
    List<List<Integer>> result = new ArrayList<>(); // 存储最终结果的列表
    List<Integer> subSet = new ArrayList<>(); // 当前正在生成的子集

    /**
     * 返回给定整数数组的所有可能子集
     * @param nums 给定的整数数组
     * @return 所有可能的子集列表
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result; // 数组为空，直接返回空列表
        }
        backTrack(nums, 0); // 开始生成子集
        return result;
    }

    /**
     * 回溯算法生成子集
     * @param nums 给定的整数数组
     * @param startIndex 当前回溯的起始索引
     */
    private void backTrack(int[] nums, int startIndex) {
        result.add(new ArrayList<>(subSet)); // 将当前子集添加到结果集中
        if (startIndex >= nums.length) {
            return; // 超出数组范围，结束递归
        }
        for (int i = startIndex; i < nums.length; i++) {
            subSet.add(nums[i]); // 将当前元素加入当前子集
            backTrack(nums, i + 1); // 递归生成下一个子集，起始索引为当前元素的下一个位置
            subSet.remove(subSet.size() - 1); // 回溯操作，将最后一个加入的元素移除，继续生成下一个子集
        }
    }
}