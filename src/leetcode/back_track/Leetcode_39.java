package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39.组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合,并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class Leetcode_39 {
    List<List<Integer>> result = new ArrayList<>(); // 存储最终结果的列表
    List<Integer> paths = new ArrayList<>(); // 存储当前组合的路径

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result; // 处理特殊情况：候选数组为空，直接返回空结果列表
        }
        Arrays.sort(candidates); // 对候选数组进行排序，为了后续剪枝处理
        backTrack(candidates, target, 0); // 回溯算法入口
        return result; // 返回最终的结果列表
    }

    private void backTrack(int[] candidates, int target, int startIndex) {
        int total = paths.stream().mapToInt(Integer::intValue).sum();
        if (total == target) {
            result.add(new ArrayList<>(paths)); // 当前路径的和等于目标值，将当前路径添加到结果列表中
            return; // 返回上一层递归
        }
        if (total > target) {
            return; // 当前路径的和已经大于目标值，终止当前路径的搜索
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue; // 跳过相同的数字，避免生成重复的组合
            }
            paths.add(candidates[i]); // 将当前数字加入路径中
            total += candidates[i]; // 更新当前路径的和
            backTrack(candidates, target, i); // 递归调用，继续搜索下一个数字
            total -= candidates[i]; // 恢复当前路径的和，准备搜索其他分支
            paths.remove(paths.size() - 1); // 移除当前数字，回溯到上一层
        }
    }
}
