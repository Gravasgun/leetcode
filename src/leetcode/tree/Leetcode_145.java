package leetcode.tree;

import java.util.*;

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
    public List<Integer> postorderTraversalMethodOne(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list); // 调用后序遍历方法
        return list; // 返回遍历结果
    }

    /**
     * 方法一：递归
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

    /**
     * 方法二：迭代
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalMethodTwo(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // 存储遍历结果的列表
        Stack<TreeNode> stack = new Stack<>(); // 存储待遍历节点的栈
        if (root == null) { // 特判空树的情况
            return list;
        }
        stack.push(root); // 将根节点入栈
        while (!stack.isEmpty()) { // 当栈不为空时，继续遍历
            TreeNode node = stack.pop(); // 取出栈顶元素
            list.add(node.val); // 将栈顶元素的值添加到遍历结果中
            if (node.left != null) { // 如果左子树不为空，将左子树入栈
                stack.push(node.left);
            }
            if (node.right != null) { // 如果右子树不为空，将右子树入栈
                stack.push(node.right);
            }
        }
        Collections.reverse(list); // 翻转遍历结果
        return list; // 返回遍历结果
    }
}
