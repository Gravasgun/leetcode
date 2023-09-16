package leetcode.dynamic;

public class Leetcode_647 {
    public int countSubstringsMethodOne(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (flag(s.substring(i, j + 1))) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean flag(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public int countSubstringsMethodTwo(String s) {
        int count = 0;
        boolean[][] result = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        count++;
                        result[i][j] = true;
                    } else if (result[i + 1][j - 1]) {
                        count++;
                        result[i][j] = true;
                    }
                }
            }
        }
        return count;
    }
}
