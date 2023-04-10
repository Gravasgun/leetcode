package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94.二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class Leetcode_94 {
    public List<Integer> inorderTraversalMethodOne(TreeNode root) {
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

    /**
     * 方法二：迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalMethodTwo(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // 创建一个整数列表用于存储中序遍历结果
        Stack<TreeNode> stack = new Stack<>(); // 创建一个栈用于遍历二叉树
        if (root == null) { // 如果根节点为空，直接返回空列表
            return list;
        }
        TreeNode temp = root; // 将根节点赋值给temp
        while (temp != null || !stack.isEmpty()) { // 当temp不为空或栈不为空时，执行循环体内的操作
            if (temp != null) { // 如果temp不为空
                stack.push(temp); // 将temp入栈
                temp=temp.left; // 让temp指向它的左子节点
            }else { // 如果temp为空
                temp=stack.pop(); // 将栈顶元素弹出并赋值给temp
                list.add(temp.val); // 将temp的值添加到列表中
                temp=temp.right; // 让temp指向它的右子节点
            }
        }
        return list; // 返回中序遍历结果
    }
}