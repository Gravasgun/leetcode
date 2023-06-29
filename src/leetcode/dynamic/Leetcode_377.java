package leetcode.dynamic;

public class Leetcode_377 {
    public int combinationSum4(int[] nums, int target) {
        // dp[i]:总和为i的元素组合个数为dp[i]
        int[] result = new int[target + 1];
        // dp[i]:总和为i的元素组合个数为dp[i] 即什么都不选
        result[0] = 1;
        //求排列个数 先遍历背包 再遍历物品
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // 如果背包容量大于等于物品重量
                if (nums[j] <= i) {
                    result[i] += result[i - nums[j]];
                }
            }
        }
        return result[result.length - 1];
    }
}
