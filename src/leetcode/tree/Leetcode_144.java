package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        preorderHelper(root, list);
        return list;
    }

    private void preorderHelper(TreeNode temp, List<Integer> list) {
        if (temp == null) {
            return;
        }
        list.add(temp.val);
        preorderHelper(temp.left, list);
        preorderHelper(temp.right, list);
    }

    public List<Integer> preorderTraversalMethodTwo(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
