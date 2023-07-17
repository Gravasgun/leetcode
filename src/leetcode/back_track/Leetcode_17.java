package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_17 {
    List<String> result = new ArrayList<>(); // 存储最终的结果列表
    StringBuilder sb = new StringBuilder(); // 辅助构建字符串

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result; // 若输入为空或长度为0，则直接返回结果列表
        }
        // 数字与对应字母的映射关系
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTrack(digits, numString, 0); // 进行回溯算法
        return result; // 返回结果列表
    }

    private void backTrack(String digits, String[] numString, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String str = numString[Integer.parseInt(String.valueOf(digits.charAt(index)))];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTrack(digits, numString, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
