package leetcode.tree;

/**
 * 106.从中序与后序遍历序列构造二叉树
 * 给定两个整数数组inorder和postorder，其中inorder是二叉树的中序遍历，postorder是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 */
public class Leetcode_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 如果后序遍历序列为空，则返回null
        if (postorder.length == 0) {
            return null;
        }
        // 根据后序遍历序列中最后一个元素创建根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        // 如果后序遍历序列长度为1，则该节点为叶子节点，返回该节点
        if (postorder.length == 1) {
            return root;
        }
        // 通过中序遍历序列确定根节点在其中的位置
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == rootValue) {
                break;
            }
        }
        // 根据中序遍历序列将原序列分成左子树和右子树两个序列
        int[] leftInorderList = new int[index];
        for (int i = 0; i < index; i++) {
            leftInorderList[i] = inorder[i];
        }

        int[] rightInorderList = new int[inorder.length - index - 1];
        int rightInorderIndex = 0;
        for (int i = index + 1; i < inorder.length; i++) {
            rightInorderList[rightInorderIndex++] = inorder[i];
        }

        // 根据左子树和右子树的中序遍历序列，将后序遍历序列分成左子树和右子树两个序列
        int[] leftPostorderList = new int[leftInorderList.length];
        for (int i = 0; i < leftPostorderList.length; i++) {
            leftPostorderList[i] = postorder[i];
        }

        int[] rightPostorderList = new int[rightInorderList.length];
        int rightPostOrderIndex = 0;
        for (int i = leftPostorderList.length; i < postorder.length - 1; i++) {
            rightPostorderList[rightPostOrderIndex++] = postorder[i];
        }
        // 递归地构造左子树和右子树
        TreeNode leftNode = buildTree(leftInorderList, leftPostorderList);
        TreeNode rightNode = buildTree(rightInorderList, rightPostorderList);
        // 将左子树和右子树分别作为根节点的左右孩子
        root.left = leftNode;
        root.right = rightNode;
        // 返回根节点
        return root;
    }
}


