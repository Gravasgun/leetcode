package leetcode.dynamic;

public class Leetcode_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] result = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}
