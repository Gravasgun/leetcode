package leetcode.back_track;

import java.util.*;

/**
 * 47.全排列II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */

public class Leetcode_47 {
    List<List<Integer>> result = new ArrayList<>();  // 用于存储最终的排列结果
    List<Integer> paths = new ArrayList<>();  // 用于存储当前的排列路径
    boolean[] used;  // 记录元素的使用情况

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];  // 初始化used数组，默认值为false
        Arrays.sort(nums);  // 对输入数组进行排序，以便去重
        backTrack(nums);  // 开始回溯生成排列
        return result;
    }

    private void backTrack(int[] nums) {
        if (paths.size() == nums.length) {  // 当路径长度等于数组长度时，表示已经生成了一个排列
            result.add(new ArrayList<>(paths));  // 将当前排列加入结果集
            return;
        }
        Set<Integer> set = new HashSet<>();  // 用于去重的集合
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {  // 如果集合中已经包含了当前元素，跳过该元素
                continue;
            }
            if (used[i]) {  // 如果当前元素已经被使用过，跳过该元素
                continue;
            }
            set.add(nums[i]);  // 将当前元素加入集合中，表示已经使用过
            used[i] = true;  // 将当前元素标记为已使用
            paths.add(nums[i]);  // 将当前元素加入路径中
            backTrack(nums);  // 递归生成下一个位置的元素
            paths.remove(paths.size() - 1);  // 回溯，移除当前位置的元素
            used[i] = false;  // 将当前元素标记为未使用，以便后续位置的元素使用
        }
    }
}