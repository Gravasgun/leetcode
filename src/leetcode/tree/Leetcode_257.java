package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, result, paths);
        return result;
    }

    private void traversal(TreeNode root, List<String> result, List<Integer> paths) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i) + "->");
            }
            sb.append(paths.get(paths.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, result, paths);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, result, paths);
            paths.remove(paths.size() - 1);
        }
    }
}
