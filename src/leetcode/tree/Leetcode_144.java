package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144.二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class Leetcode_144 {

    /**
     * 对给定的二叉树执行先序遍历，并返回遍历结果。
     *
     * @param root 给定的二叉树根节点
     * @return 先序遍历结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 创建一个ArrayList对象，用于存放遍历结果
        List<Integer> list = new ArrayList<>();
        // 调用preOrder方法，执行先序遍历
        preOrder(root, list);
        // 返回遍历结果
        return list;
    }

    /**
     * 递归遍历二叉树，将遍历结果存放在给定的List对象中。
     *
     * @param temp 当前遍历到的节点
     * @param list 用于存放遍历结果的List对象
     */
    public void preOrder(TreeNode temp, List<Integer> list) {
        // 如果当前节点为空，直接返回
        if (temp == null) {
            return;
        }
        // 将当前节点的值加入List对象中
        list.add(temp.val);
        // 递归遍历当前节点的左子树
        preOrder(temp.left, list);
        // 递归遍历当前节点的右子树
        preOrder(temp.right, list);
    }
}
