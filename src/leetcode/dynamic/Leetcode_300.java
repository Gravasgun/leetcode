package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_300 {
    public int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }
        return Arrays.stream(result).max().getAsInt();
    }
}
