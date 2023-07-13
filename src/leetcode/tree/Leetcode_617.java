package leetcode.tree;

public class Leetcode_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果root1为空，则直接返回root2
        if (root1 == null) {
            return root2;
        }
        // 如果root2为空，则直接返回root1
        if (root2 == null) {
            return root1;
        }
        // 创建一个新的节点，节点的值为root1和root2节点的值之和
        TreeNode root = new TreeNode(root1.val + root2.val);
        // 递归合并root1和root2的左子树
        TreeNode leftNode = mergeTrees(root1.left, root2.left);
        // 递归合并root1和root2的右子树
        TreeNode rightNode = mergeTrees(root1.right, root2.right);
        // 将合并后的左子树和右子树设置为新节点的左子树和右子树
        root.left = leftNode;
        root.right = rightNode;
        // 返回合并后的新树的根节点
        return root;
    }
}
