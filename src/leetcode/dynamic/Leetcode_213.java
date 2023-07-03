package leetcode.dynamic;

public class Leetcode_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 返回[0,nums.length-2]和[1,nums.length-1]的最大金额
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private int robHelper(int[] nums, int startIndex, int endIndex) {
        // result[i]:[startIndex,i]范围内的最大金额
        int[] result = new int[endIndex - startIndex + 1];
        // 初始化
        result[0] = nums[startIndex];
        if (endIndex - startIndex >= 1) {
            result[1] = Math.max(nums[startIndex], nums[startIndex + 1]);
        }
        // 填充dp数组
        for (int i = 2; i < result.length; i++) {
            result[i] = Math.max(result[i - 1], result[i - 2] + nums[i + startIndex]);
        }
        return result[result.length - 1];
    }
}
