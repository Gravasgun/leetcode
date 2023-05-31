package leetcode.dynamic;

/**
 * 01背包问题
 * 给定一组物品，每个物品有自己的重量和价值。现有一个容量为bagSize的背包，
 * 需要在不超过背包容量的前提下，选择一些物品放入背包中，使得放入的物品总价值最大化。
 * 限制条件：
 * 每个物品要么完全放入背包，要么不放入。
 * 每个物品只有一个副本可用。
 * 背包只能装下一定重量的物品，超过背包容量的物品无法放入。
 */

public class BagProblem {
    public static void main(String[] args) {
        // 物品的重量
        int[] weights = new int[]{1, 3, 4};
        // 物品的价值
        int[] values = new int[]{15, 20, 30};
        // 背包的最大容量
        int bagSize = 4;
        // 动态规划方法
        //testBagProblem(weights, values, bagSize);
        testBagProblem2(weights, values, bagSize);
    }

    /**
     * 一维数组解决01背包问题
     *
     * @param weights 物品的重量
     * @param values  物品的价值
     * @param bagSize 背包的最大容量
     */
    private static void testBagProblem2(int[] weights, int[] values, int bagSize) {
        // 创建dp数组 含义：容量为j的背包的最大价值为dp[j]
        int[] result = new int[bagSize + 1];
        // 初始化dp数组 只要保证初始值不会大于动态规划所得到的值就可以
        result[0] = 0;
        // 先遍历物品再遍历背包 不能颠倒 如果颠倒 那么背包中只能添加一个物品
        for (int i = 0; i < weights.length; i++) {
            // 倒叙遍历背包的容量，目的是保证物品不会被重复添加
            for (int j = bagSize; j >= weights[i]; j--) {
                result[j] = Math.max(result[j], result[j - weights[i]] + values[i]);
            }
        }
        //遍历dp数组
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     * 二维数组解决01背包问题
     *
     * @param weights 物品的重量
     * @param values  物品的价值
     * @param bagSize 背包的最大容量
     */
    private static void testBagProblem(int[] weights, int[] values, int bagSize) {
        // 创建dp数组 dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
        int[][] result = new int[weights.length][bagSize + 1];
        // 初始化第一行，表示只考虑第一个物品时，背包容量从1到bagSize的情况下的最大价值
        for (int i = weights[0]; i < result[0].length; i++) {
            result[0][i] = values[0];
        }
        // 动态规划 填充dp数组 计算背包容量从1到bagSize，考虑不同物品的情况下的最大价值
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // 当前物品的重量大于背包容量，无法放入背包，继承上一行的最大价值
                if (weights[i] > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    // 当前物品的重量小于等于背包容量，可以选择放入或不放入背包，取两种情况下的最大价值
                    result[i][j] = Math.max(result[i - 1][j], (result[i - 1][j - weights[i]] + values[i]));
                }
            }
        }
        // 打印结果数组
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }
}