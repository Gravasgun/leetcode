package leetcode.tree;

/**
 * 105.从前序与中序遍历序列构造二叉树
 * 给定两个整数数组preorder和inorder，其中preorder是二叉树的先序遍历,inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Leetcode_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 如果前序遍历序列为空，返回空节点
        if (preorder.length == 0) {
            return null;
        }
        // 取前序遍历序列的第一个值作为根节点的值
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        // 如果前序遍历序列长度为1，直接返回根节点
        if (preorder.length == 1) {
            return root;
        }

        // 在中序遍历序列中查找根节点的值，找到后可以确定左右子树的中序遍历序列
        int index = 0;
        for (; index < inorder.length; index++) {
            if (rootValue == inorder[index]) {
                break;
            }
        }

        // 构建左子树的中序遍历序列
        int[] leftInorderList = new int[index];
        for (int i = 0; i < leftInorderList.length; i++) {
            leftInorderList[i] = inorder[i];
        }

        // 构建右子树的中序遍历序列
        int[] rightInorderList = new int[inorder.length - 1 - index];
        int rightInorderIndex = 0;
        for (int i = index + 1; i < inorder.length; i++) {
            rightInorderList[rightInorderIndex++] = inorder[i];
        }

        // 构建左子树的前序遍历序列
        int[] leftPreorderList = new int[leftInorderList.length];
        int leftPreorderIndex = 0;
        for (int i = 1; i < 1 + leftPreorderList.length; i++) {
            leftPreorderList[leftPreorderIndex++] = preorder[i];
        }

        // 构建右子树的前序遍历序列
        int[] rightPreorderList = new int[preorder.length - 1 - leftPreorderList.length];
        int rightPreorderIndex = 0;
        for (int i = leftPreorderIndex + 1; i < preorder.length; i++) {
            rightPreorderList[rightPreorderIndex++] = preorder[i];
        }

        // 递归构建左子树和右子树，并将其作为根节点的左右子节点
        TreeNode leftNode = buildTree(leftPreorderList, leftInorderList);
        TreeNode rightNode = buildTree(rightPreorderList, rightInorderList);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
