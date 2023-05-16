package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 131.分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 */
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
            result.add(new ArrayList<>(paths)); // 当startIndex越界时，将当前分割方案添加到结果列表中
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) { // 如果当前子串是回文串
                paths.add(s.substring(startIndex, i + 1)); // 将[0,i]回文子串添加到当前分割方案中
                backTrack(s, i + 1); // 递归处理剩余部分
                paths.remove(paths.size() - 1); // 回溯，移除最后一个回文子串，尝试其他分割方案
            }
        }
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) { // 检查回文性质：对称位置字符相等
                return false; // 不满足回文条件，返回false
            }
        }
        return true; // 子串是回文串，返回true
    }
}