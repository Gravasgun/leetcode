package leetcode.dynamic;

public class Leetcode_392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int[][] result = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = result[i][j - 1];
                }
            }
        }
        return result[result.length - 1][result[0].length - 1] == s.length();
    }
}
