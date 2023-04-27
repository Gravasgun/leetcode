package leetcode.tree;

import java.util.*;

/**
 * 113.路径总和II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 */
public class Leetcode_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>(); // 用于保存结果的列表
        if (root == null) { // 特判，如果根节点为空，直接返回空列表
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>(); // 用于保存待处理节点的栈
        Stack<List<Integer>> pathStack = new Stack<>(); // 用于保存当前节点到根节点的路径的栈
        nodeStack.push(root); // 将根节点入栈
        pathStack.push(Arrays.asList(root.val)); // 根节点的路径为其本身，将其入栈
        while (!nodeStack.isEmpty()) { // 循环直到待处理节点栈为空
            TreeNode temp = nodeStack.pop(); // 取出待处理节点栈的栈顶节点
            List<Integer> path = pathStack.pop(); // 取出路径栈的栈顶路径
            if (temp.left == null && temp.right == null && targetSum == path.stream().mapToInt(Integer::intValue).sum()) {
                // 如果栈顶节点是叶子节点，并且根节点到该叶子节点的路径和等于目标和，将该路径添加到结果列表中
                result.add(path);
            }
            if (temp.right != null) { // 如果栈顶节点的右子节点不为空
                nodeStack.push(temp.right); // 将右子节点入栈
                List<Integer> rightPath = new ArrayList<>(path); // 将该节点到根节点的路径复制一份
                rightPath.add(temp.right.val); // 将右子节点的值添加到该节点到根节点的路径中
                pathStack.push(rightPath); // 将该节点到根节点的路径入栈
            }
            if (temp.left != null) { // 如果栈顶节点的左子节点不为空，执行和右子节点同样的操作
                nodeStack.push(temp.left);
                List<Integer> leftPath = new ArrayList<>(path);
                leftPath.add(temp.left.val);
                pathStack.push(leftPath);
            }
        }
        return result; // 返回结果列表
    }
}
