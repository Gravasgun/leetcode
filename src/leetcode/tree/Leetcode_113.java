package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 用于存储符合条件的路径的列表
        List<List<Integer>> result = new ArrayList<>();
        // 如果根节点为空，则直接返回空的结果列表
        if (root == null) {
            return result;
        }
        // 用于存储当前路径的列表
        List<Integer> paths = new ArrayList<>();
        // 进行回溯搜索
        backTracking(root, targetSum, result, paths);
        // 返回最终结果
        return result;
    }

    private void backTracking(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> paths) {
        // 将当前节点的值添加到路径列表中
        paths.add(root.val);
        // 如果当前节点为叶子节点且路径和等于目标和，则将该路径添加到结果列表中
        if (root.left == null && root.right == null && paths.stream().mapToInt(Integer::intValue).sum() == targetSum) {
            result.add(new ArrayList<>(paths));
            // 回溯到上一层节点
            return;
        }
        if (root.left != null) {
            // 递归处理左子树
            backTracking(root.left, targetSum, result, paths);
            // 回溯到上一层节点之前，将当前节点从路径列表中移除
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            // 递归处理右子树
            backTracking(root.right, targetSum, result, paths);
            // 回溯到上一层节点之前，将当前节点从路径列表中移除
            paths.remove(paths.size() - 1);
        }
    }
}
