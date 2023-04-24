package leetcode.tree;

/**
 * 100.相同的数
 * 给你两棵二叉树的根节点p和q，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Leetcode_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两棵树的当前节点都是 null，则两棵树相同，返回 true
        if (p == null && q == null) {
            return true;
        }
        // 如果只有一棵树的当前节点是 null，则两棵树不同，返回 false
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        // 如果两棵树的当前节点的值不同，则两棵树不同，返回 false
        if (p.val != q.val) {
            return false;
        }
        // 递归比较两棵树的左子树和右子树是否相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
