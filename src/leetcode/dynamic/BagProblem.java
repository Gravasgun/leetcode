package leetcode.dynamic;

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

    private static void testBagProblem(int[] weights, int[] values, int bagSize) {
        // result[i][j]:背包容量为j时，放入第[0,i]件物品的最大价值为result[i][j]
        int[][] result = new int[weights.length][bagSize + 1];
        // 初始化第一行
        for (int i = weights[0]; i < result[0].length; i++) {
            result[0][i] = values[0];
        }
        // 填充dp数组
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // 如果当前物品的重量大于了背包容量 最大价值只能继承上一个物品的最大价值
                if (weights[i] > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    // 当前物品重量小于等于背包容量 此时可以选择放入或者不放入 取最大价值
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - weights[i]] + values[i]);
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

    private static void testBagProblem2(int[] weights, int[] values, int bagSize) {
        // result[j]:背包容量为j的最大价值为result[j]
        int[] result = new int[bagSize + 1];
        // 先遍历物品 再遍历背包 遍历背包的时候倒序遍历
        for (int i = 0; i < weights.length; i++) {
            for (int j = result.length - 1; j >= weights[i]; j--) {
                result[j] = Math.max(result[j], result[j - weights[i]] + values[i]);
            }
        }
        // 遍历dp数组
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
