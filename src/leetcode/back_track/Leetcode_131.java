package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_131 {
    List<List<String>> result = new ArrayList<>(); // 存储所有分割方案的列表
    List<String> paths = new ArrayList<>(); // 存储当前分割方案的列表

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result; // 处理特殊情况：空字符串
        }
        backTrack(s, 0); // 启动回溯算法
        return result; // 返回分割方案列表
    }

    private void backTrack(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                paths.add(s.substring(startIndex, i + 1));
                backTrack(s, i + 1);
                paths.remove(paths.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; j > i; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
