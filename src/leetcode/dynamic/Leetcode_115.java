package leetcode.dynamic;

public class Leetcode_115 {
    public int numDistinct(String s, String t) {
        int[][] result = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = 1;
        }
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}
