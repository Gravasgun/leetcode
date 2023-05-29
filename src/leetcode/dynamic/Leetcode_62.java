package leetcode.dynamic;

/**
 * 62.不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class Leetcode_62 {
    public int uniquePaths(int m, int n) {
        // 创建一个dp数组用于存储计算结果
        // dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径
        int[][] result = new int[m][n];
        // 第一列的所有格子只能沿着一条路径到达，因此设置为1
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }
        // 第一行的所有格子只能沿着一条路径到达，因此设置为1
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }
        // 使用递推公式计算当前格子的唯一路径数量
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        // 返回右下角格子的唯一路径数量作为结果
        return result[m - 1][n - 1];
    }
}
