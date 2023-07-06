package leetcode.dynamic;

public class Leetcode_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] result = new int[nums1.length + 1][nums2.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                    max = Math.max(max, result[i][j]);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
