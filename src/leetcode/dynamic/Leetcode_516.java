package leetcode.dynamic;

public class Leetcode_516 {
    public int longestPalindromeSubseq(String s) {
        int[][] result = new int[s.length()][s.length()];
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }
        for (int i = result.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < result[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    result[i][j] = result[i + 1][j - 1] + 2;
                } else {
                    result[i][j] = Math.max(result[i + 1][j], result[i][j - 1]);
                }
            }
        }
        return result[0][result[0].length - 1];
    }
}
