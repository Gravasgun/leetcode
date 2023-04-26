package leetcode.tree;

/**
 * 572.另一棵树的子树
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 */
public class Leetcode_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        // 判断当前的两棵树是否相同
        boolean isSameTree = isSameTree(root, subRoot);
        if (isSameTree) {
            return true;
        } else {
            //再递归比较其中一颗树的左子树和左子树与另一棵树是否相同
            boolean isLeftSubTree = isSubtree(root.left, subRoot);
            boolean isRightSubTree = isSubtree(root.right, subRoot);
            return isLeftSubTree || isRightSubTree;
        }
    }

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
