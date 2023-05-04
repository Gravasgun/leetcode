package leetcode.tree;

/**
 * 235.二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 */
public class Leetcode_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为空，返回null
        if (root == null) {
            return null;
        }
        // 如果根节点的值比p和q节点的值都大，说明p和q节点都在左子树中，递归查找左子树
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            // 如果左子树中找到了最近公共祖先，则直接返回
            if (left != null) {
                return left;
            }
        }
        // 如果根节点的值比p和q节点的值都小，说明p和q节点都在右子树中，递归查找右子树
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 如果右子树中找到了最近公共祖先，则直接返回
            if (right != null) {
                return right;
            }
        }
        // 当前节点的值介于p和q节点之间，所以当前节点就是p和q节点的最近公共祖先
        return root;
    }
}
