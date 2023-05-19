package leetcode.greedy;

import java.util.Arrays;

/**
 * 135.分发糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class Leetcode_135 {
    public int candy(int[] ratings) {
        // 创建一个与ratings数组长度相同的candies数组，用来记录每个孩子分配的糖果数量
        int[] candies = new int[ratings.length];
        // 初始化每个孩子的糖果数量为1
        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }
        // 第一次贪心：
        // 局部最优：只要右边评分比左边大，右边的孩子就多一个糖果
        // 全局最优：相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果
        // 正向遍历，处理当前孩子评分比前一个孩子高的情况
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // 如果当前孩子的评分比前一个孩子高，则糖果数量设为前一个孩子的糖果数量加一
                candies[i] = candies[i - 1] + 1;
            }
        }
        // 第二次贪心：
        // 局部最优：取candies[i + 1] + 1 和 candies[i] 最大的糖果数量，保证第i个小孩的糖果数量既大于左边的也大于右边的
        // 全局最优：相邻的孩子中，评分高的孩子获得更多的糖果
        // 反向遍历，处理当前孩子评分比后一个孩子高的情况
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // 如果当前孩子的评分比后一个孩子高，并且当前孩子的糖果数量不大于后一个孩子的糖果数量加一
                // 则将当前孩子的糖果数量设为后一个孩子的糖果数量加一
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        // 返回糖果数组中所有元素的和，即为分发的糖果总数
        return Arrays.stream(candies).sum();
    }
}