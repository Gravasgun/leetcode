package leetcode.dynamic;

/**
 * 96.不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class Leetcode_96 {
    public int numTrees(int n) {
        // 创建dp数组用于存储中间结果
        // result[i] 表示由 i 个节点构成的二叉搜索树的数量
        int[] result = new int[n + 1];
        // 初始化节点数量为 0 时的情况，只有一种空树
        result[0] = 1;
        // 从节点数量为 1 开始计算到节点数量为 n
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < i; j++) {
                // 以 i 为根节点的左子树中 左子树的节点的个数可以在[0,j]范围
                // 以 i 为根节点的右子树中 右子树的节点的个数可以在[j,0]范围
                // 左子树和右子树的节点的个数相加要等于n-1，因为以i为根节点，根节点本身就占了一个节点
                // 所以剩下的节点数量是n-1，这n-1个节点分配给左右子树
                // 所以 result[i] 等于左子树的数量乘以右子树的数量的累加和
                result[i] += result[j] * result[i - 1 - j];
            }
        }
        return result[result.length - 1]; // 返回由 n 个节点构成的二叉搜索树的数量
    }
}
