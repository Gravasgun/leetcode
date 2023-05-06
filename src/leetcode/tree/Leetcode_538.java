package leetcode.tree;

/**
 * 538.把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class Leetcode_538 {
    int pre;  // 用于保存之前处理的节点值的和

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;  // 如果根节点为空，直接返回null
        }
        convert(root);  // 执行转换操作
        return root;  // 返回转换后的根节点
    }

    private void convert(TreeNode root) {
        if (root == null) {
            return;  // 如果当前节点为空，直接返回
        }
        convert(root.right);  // 递归处理右子树，先处理较大的节点
        root.val += pre;  // 将当前节点的值加上之前处理的节点值之和
        pre = root.val;  // 更新pre为当前节点值，供下一次处理使用
        convert(root.left);  // 递归处理左子树，处理较小的节点
    }
}
