package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94.二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class Leetcode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // 创建一个整数列表用于存储中序遍历结果
        inOrder(root, list); // 调用辅助方法进行中序遍历
        return list; // 返回中序遍历结果
    }

    public void inOrder(TreeNode temp, List list) {
        if (temp == null) { // 如果节点为空，直接返回
            return;
        }
        inOrder(temp.left, list); // 先遍历左子树
        list.add(temp.val); // 将当前节点的值添加到列表中
        inOrder(temp.right, list); // 再遍历右子树
    }
}