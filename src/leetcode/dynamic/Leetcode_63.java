package leetcode.dynamic;

/**
 * 63.不同路径II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class Leetcode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 创建dp数组
        // dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径
        int[][] result = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 处理第一行
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                // 第一行没有障碍物，设置路径数量为1
                result[0][i] = 1;
            }
        }
        // 处理第一列
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                // 第一列没有障碍物，设置路径数量为1
                result[i][0] = 1;
            }
        }
        // 动态规划计算其余格子的路径数量
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                // 如果当前格子有障碍物，则路径数量为0
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else if (obstacleGrid[i][j - 1] == 1) {
                    // 如果左侧格子有障碍物，则只能从上方格子到达
                    result[i][j] = result[i - 1][j];
                } else if (obstacleGrid[i - 1][j] == 1) {
                    // 如果上方格子有障碍物，则只能从左侧格子到达
                    result[i][j] = result[i][j - 1];
                } else if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 1) {
                    // 如果左侧和上方格子都有障碍物，则无法到达当前格子
                    result[i][j] = 0;
                } else {
                    // 左方和上方都没有障碍物的情况
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        // 返回右下角格子的路径数量作为结果
        return result[result.length - 1][result[0].length - 1];
    }
}