package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 216.组合总和III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class Leetcode_216 {
    List<List<Integer>> result = new ArrayList<>();  // 存储最终结果的列表
    List<Integer> paths = new ArrayList<>();  // 存储当前路径的列表

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);  // 调用回溯函数
        return result;  // 返回结果列表
    }

    private void backTracking(int k, int n, int startIndex) {
        if (paths.size() == k) {  // 如果当前路径长度等于目标长度
            if (paths.stream().mapToInt(Integer::intValue).sum() == n) {  // 如果当前路径中的数字之和等于目标值
                // 在Java中，result.add(paths)会将paths列表的引用添加到result中，而不是创建一个新的列表对象。
                // 这意味着如果后续修改了paths列表，添加到result中的路径也会随之改变，这可能导致不正确的结果。
                result.add(new ArrayList<>(paths));  // 将当前路径添加到最终结果列表中
            }
            return;  // 返回上一层递归
        }

        for (int i = startIndex; i <= 9 - (k - paths.size()) + 1; i++) {
            paths.add(i);  // 将当前数字添加到路径中
            backTracking(k, n, i + 1);  // 递归调用下一层
            paths.remove(paths.size() - 1);  // 移除当前数字，回溯到上一层
        }
    }
}