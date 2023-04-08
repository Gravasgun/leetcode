package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144.二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class Leetcode_144 {

    /**
     * 方法一：递归
     * 对给定的二叉树执行先序遍历，并返回遍历结果。
     *
     * @param root 给定的二叉树根节点
     * @return 先序遍历结果
     */
    public List<Integer> preorderTraversalMethodOne(TreeNode root) {
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

    /**
     * 方法二：迭代
     * @param root 根节点
     * @return list 用于存放遍历结果的List对象
     */
    public List<Integer> preorderTraversalMethodTwo(TreeNode root) {
        // 创建一个ArrayList对象，用于存放遍历结果
        List<Integer> list = new ArrayList<>();
        // 创建一个栈对象，用于辅助实现遍历
        Stack<TreeNode> stack = new Stack<>();
        // 如果二叉树为空，直接返回空列表
        if (root == null) {
            return list;
        }
        // 将二叉树的根节点压入栈中
        stack.push(root);
        // 循环遍历栈中的节点
        while (!stack.isEmpty()) {
            // 取出栈顶节点，并将其值加入List对象中
            TreeNode node = stack.pop();
            list.add(node.val);
            // 如果该节点有右子树，则将其右子树压入栈中
            if (node.right != null) {
                stack.push(node.right);
            }
            // 如果该节点有左子树，则将其左子树压入栈中
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        // 返回遍历结果
        return list;
    }
}
