package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_17 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTrack(digits, strings, 0);
        return result;
    }

    private void backTrack(String digits, String[] strings, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String s = strings[Integer.parseInt(String.valueOf(digits.charAt(index)))];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backTrack(digits, strings, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
