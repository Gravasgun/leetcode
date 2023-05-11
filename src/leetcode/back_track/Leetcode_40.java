package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.组合总和II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 */
public class Leetcode_40 {
    List<List<Integer>> result = new ArrayList<>(); // 存储最终结果的列表
    List<Integer> paths = new ArrayList<>(); // 存储当前路径的列表
    int sum = 0; // 当前路径的和

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates); // 对候选数组进行排序
        backTrack(candidates, target, 0); // 调用回溯方法
        return result;
    }

    private void backTrack(int[] candidates, int target, int startIndex) {
        if (sum == target) { // 当 当前路径的和等于目标值时，将当前路径加入到结果集中
            result.add(new ArrayList<>(paths));
            return;
        }
        if (sum > target) { // 当 当前路径的和大于目标值时，回溯到上一层
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) { // 遍历候选数组
            if (sum > target || candidates[i] > target) { // 当前路径和大于目标值或当前候选数大于目标值时，结束当前循环
                break;
            }
            if (i > startIndex && candidates[i] == candidates[i - 1]) { // 跳过重复的候选数，避免生成重复的组合
                continue;
            }
            sum += candidates[i]; // 将当前候选数加入到当前路径中
            paths.add(candidates[i]);
            backTrack(candidates, target, i + 1); // 递归调用回溯方法，搜索下一层的解
            sum -= candidates[i]; // 回溯，将当前候选数从当前路径中移除
            paths.remove(paths.size() - 1);
        }
    }
}
