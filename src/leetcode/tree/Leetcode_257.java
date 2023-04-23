package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257.二叉树的所有路径
 * 给你一个二叉树的根节点root，按任意顺序 ，返回所有从根节点到叶子节点的路径。
 */
public class Leetcode_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        // 创建一个空的列表来存储结果
        List<String> result = new ArrayList<>();
        // 如果根节点为空，直接返回结果列表
        if (root == null) {
            return result;
        }
        // 创建一个栈用于保存遍历到的节点和路径信息
        Stack<Object> stack = new Stack<>();
        // 将根节点和根节点值的字符串形式压入栈中
        stack.push(root);
        stack.push(root.val + "");
        // 当栈非空时进行循环
        while (!stack.isEmpty()) {
            // 从栈顶弹出一个路径
            String path = (String) stack.pop();
            // 从栈顶弹出一个节点
            TreeNode node = (TreeNode) stack.pop();
            // 如果该节点是叶子节点，将路径加入结果列表
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            // 如果该节点有右子节点，将右子节点和路径信息压入栈中
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            // 如果该节点有左子节点，将左子节点和路径信息压入栈中
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        // 返回结果列表
        return result;
    }
}
