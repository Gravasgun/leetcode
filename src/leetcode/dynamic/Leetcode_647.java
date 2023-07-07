package leetcode.dynamic;

public class Leetcode_647 {
    public int countSubstrings(String s) {
        int count = 0;
        boolean[][] result = new boolean[s.length()][s.length()];
        for (int i = result.length - 1; i >= 0; i--) {
            for (int j = i; j < result[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        result[i][j] = true;
                        count++;
                    } else if (result[i + 1][j - 1]) {
                        result[i][j]=true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
