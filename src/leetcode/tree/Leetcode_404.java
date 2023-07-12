package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_404 {
    List<Integer> list = new ArrayList<>();

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            list.add(root.left.val);
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
