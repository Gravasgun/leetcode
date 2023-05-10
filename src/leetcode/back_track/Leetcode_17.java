package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 17.电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
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
        // 当处理的索引等于电话号码长度时，表示已经生成了一个完整的字母组合，将其添加到结果列表中
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        // digits.charAt(index) - '0' 的操作将字符转换为相应的数字。字符类型可以与整数类型进行运算，通过减去字符 '0' 的 ASCII 值，可以得到对应的数字。
        String str = numString[digits.charAt(index) - '0']; // 获取当前数字对应的字母集合
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)); // 将当前字母添加到字符串构建器中
            backTrack(digits, numString, index + 1); // 递归处理下一个数字所对应的字符串
            sb.deleteCharAt(sb.length() - 1); // 回溯，删除最后添加的字母，以便处理下一个字母
        }
    }
}
