package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
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
}
