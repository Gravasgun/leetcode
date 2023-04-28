package leetcode.tree;

/**
 * 617.合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 */
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
