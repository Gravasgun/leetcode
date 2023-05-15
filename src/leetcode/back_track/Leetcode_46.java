package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 * 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列。你可以按任意顺序返回答案。
 */
public class Leetcode_46 {
    List<List<Integer>> result = new ArrayList<>();  // 用于存储结果的列表
    List<Integer> paths = new ArrayList<>();  // 用于存储当前路径的列表

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {  // 若数组为空，则直接返回结果列表
            return result;
        }
        backTrack(nums);  // 调用回溯方法
        return result;  // 返回结果列表
    }

    private void backTrack(int[] nums) {
        if (paths.size() == nums.length) {  // 如果当前路径的长度等于数组的长度，表示已经生成了一个排列
            result.add(new ArrayList<>(paths));  // 将当前路径加入到结果列表中
        }
        for (int i = 0; i < nums.length; i++) {  // 遍历数组中的每个数字
            if (paths.contains(nums[i])) {  // 如果当前路径已经包含该数字，说明该数字已经被使用过，直接跳过
                continue;
            }
            paths.add(nums[i]);  // 将当前数字加入到当前路径中
            backTrack(nums);  // 递归生成下一个数字的排列
            paths.remove(paths.size() - 1);  // 回溯，移除最后一个加入的数字，尝试其他可能的排列
        }
    }
}