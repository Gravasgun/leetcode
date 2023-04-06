package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 145.二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class Leetcode_145 {
    /**
     * 后序遍历二叉树，返回遍历结果
     *
     * @param root 二叉树的根节点
     * @return 遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list); // 调用后序遍历方法
        return list; // 返回遍历结果
    }

    /**
     * 后序遍历二叉树，并将遍历结果存入 list 中
     *
     * @param temp 当前节点
     * @param list 存储遍历结果的列表
     */
    public void postOrder(TreeNode temp, List<Integer> list) {
        if (temp == null) { // 如果当前节点为空，直接返回
            return;
        }
        postOrder(temp.left, list); // 递归遍历左子树
        postOrder(temp.right, list); // 递归遍历右子树
        list.add(temp.val); // 将当前节点的值添加到遍历结果中
    }
}
