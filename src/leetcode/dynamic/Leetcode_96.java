package leetcode.dynamic;

public class Leetcode_96 {
    public int numTrees(int n) {
        // dp[i]：节点数量为i的不同二叉搜索树的种数
        int[] result = new int[n + 1];
        // 空树
        result[0] = 1;
        // 第一层循环遍历根节点
        for (int i = 1; i < result.length; i++) {
            // 第二层循环遍历左子树
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - j - 1];
            }
        }
        return result[result.length - 1];
    }
}
