package leetcode.dynamic;

/**
 * 377.组合总和Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 本题是求排列 而518.零钱兑换II 是求组合
 */
public class Leetcode_377 {
    public int combinationSum4(int[] nums, int target) {
        // 创建一个长度为target + 1的dp数组，用于存储计算结果
        // dp[i]: 凑成目标正整数为i的排列个数为dp[i]
        int[] result = new int[target + 1];
        // 将result[0]初始化为1，表示组成目标值为0的组合数量为1
        result[0] = 1;
        // 外层循环遍历result数组(背包)，内层循环遍历nums数组(物品)
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // 判断当前目标值i是否大于等于nums[j]
                if (i >= nums[j]) {
                    // 如果可以使用nums[j]来组成目标值i，
                    // 则将result[i]增加result[i - nums[j]]
                    // 表示将nums[j]加入组合后仍然可以组成目标值i
                    result[i] += result[i - nums[j]];
                }
            }
        }
        // 返回result数组的最后一个元素，
        // 表示使用给定数组中的元素组成目标值的所有可能组合的数量
        return result[result.length - 1];
    }
}
