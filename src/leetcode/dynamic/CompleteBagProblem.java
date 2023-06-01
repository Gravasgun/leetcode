package leetcode.dynamic;

/**
 * 完全背包问题
 * 给定一组物品，每个物品有对应的重量和价值，以及一个背包的最大容量。
 * 目标是选择物品放入背包，使得放入背包的物品的总价值最大化，同时考虑背包的容量限制
 * 物品可以无限次被使用
 */
public class CompleteBagProblem {
    public static void main(String[] args) {
        // 物品的重量
        int[] weights = new int[]{1, 3, 4};
        // 物品的价值
        int[] values = new int[]{15, 20, 30};
        // 背包的最大容量
        int bagSize = 4;
        // 动态规划方法
        testBagProblem(weights, values, bagSize);
    }

    private static void testBagProblem(int[] weights, int[] values, int bagSize) {
        // 创建一个长度为背包容量+1的dp数组，用于记录每个背包容量下的最大价值
        int[] result = new int[bagSize + 1];
        //可以先遍历物品 也可以先遍历背包 顺序换了不影响 只会影响for循环中的条件
        // 遍历每个物品
        for (int i = 0; i < weights.length; i++) {
            // 从物品的重量开始遍历，直到背包容量
            for (int j = weights[i]; j < result.length; j++) {
                // 计算当前背包容量下的最大价值，比较两种情况：不选择当前物品和选择当前物品
                // 如果不选择当前物品，则最大价值与上一次计算的结果相同
                // 如果选择当前物品，则最大价值为上一次计算的结果加上当前物品的价值
                result[j] = Math.max(result[j], result[j - weights[i]] + values[i]);
            }
        }
        // 打印结果数组中的每个元素，即每个背包容量下的最大价值
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}