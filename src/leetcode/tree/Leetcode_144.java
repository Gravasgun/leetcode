package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

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
}
