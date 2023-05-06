package leetcode.tree;

/**
 * 450.删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 */
public class Leetcode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 有五种情况
        // 1.如果根节点为空，说明没找到要删除的节点
        if (root == null) {
            return null;
        }
        // 如果根节点的值等于要删除的值
        if (root.val == key) {
            // 2.如果根节点是叶子节点，即左右子节点都为空
            if (root.left == null && root.right == null) {
                return null; // 直接返回null，表示删除该节点
            }
            // 3.如果根节点只有右子节点
            else if (root.left == null && root.right != null) {
                return root.right; // 返回右子节点，表示删除该节点
            }
            // 4.如果根节点只有左子节点
            else if (root.left != null && root.right == null) {
                return root.left; // 返回左子节点，表示删除该节点
            }
            // 5.如果根节点既有左子节点又有右子节点
            else {
                TreeNode temp = root; // 创建一个临时节点，用于寻找右子树中最小的节点
                temp = temp.right; // 先将临时节点指向右子节点
                while (temp.left != null) { // 循环找到右子树中最小的节点
                    temp = temp.left;
                }
                temp.left = root.left; // 将根节点的左子树接到右子树中最小节点的左子树上
                return root.right; // 返回右子节点，表示删除该节点
            }
        }
        // return的逻辑是：向递归的上一层返回删除后的父节点，比如：
        // 当递归到叶子节点时，会返回 null，然后将该 null 值返回给该叶子节点的父节点。这样，父节点就可以接收到子节点的返回值，并将自己的左子节点或右子节点指向该返回值，从而完成删除操作。
        // 以下的两行代码表示：当前节点的父节点接受子节点的返回值，并指向子节点
        // 如果根节点的值不等于要删除的值，则递归删除左右子树中的节点
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root; // 返回根节点
    }
}
