package leetcode.tree;

import java.util.*;

public class Leetcode_145 {
    public List<Integer> postorderTraversalMethodOne(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode temp, List<Integer> list) {
        if (temp == null) {
            return;
        }
        postOrder(temp.left, list);
        postOrder(temp.right, list);
        list.add(temp.val);
    }

    public List<Integer> postorderTraversalMethodTwo(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
