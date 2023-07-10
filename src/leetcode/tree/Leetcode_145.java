package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
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
}
