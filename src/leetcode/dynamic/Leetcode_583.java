package leetcode.dynamic;

public class Leetcode_583 {
    public int minDistance(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = i;
        }
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.min(result[i - 1][j] + 1, Math.min(result[i][j - 1] + 1, result[i - 1][j - 1] + 2));
                }
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}
