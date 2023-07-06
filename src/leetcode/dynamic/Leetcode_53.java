package leetcode.dynamic;

public class Leetcode_53 {
    public int maxSubArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = Math.max(result[i - 1] + nums[i], nums[i]);
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
