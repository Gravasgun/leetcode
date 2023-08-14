package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_131 {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }
        backTrack(s, 0);
        return result;
    }

    private void backTrack(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
                backTrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            if (s.charAt(i) != s.charAt(endIndex--)) {
                return false;
            }
        }
        return true;
    }

}
