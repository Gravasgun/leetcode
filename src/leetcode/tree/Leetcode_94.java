package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_94 {
    public List<Integer> inorderTraversalMethodOne(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode temp, List<Integer> list) {
        if (temp == null) {
            return;
        }
        inorder(temp.left, list);
        list.add(temp.val);
        inorder(temp.right, list);
    }

    public List<Integer> inorderTraversalMethodTwo(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
