package shenxinfu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述：
 * 给定一个字符串，你需要生成该字符串的所有字符排列并输出。排列是指将字符串中的字符重新排列，得到不同的排列组合。
 * 输入示例：
 * 输入: "abc"
 * 输出示例：
 * ["abc", "acb", "bac", "bca", "cab", "cba"]
 */
public class Main2 {
    // 用于存储结果的列表
    static List<List<String>> result = new ArrayList<>();
    // 用于存储当前路径的列表
    static List<String> paths = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        // 调用排列方法
        permute(s.toCharArray());
        for (int i = 0; i < result.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.get(i).size(); j++) {
                // 将排列结果组合成字符串并输出
                sb.append(result.get(i).get(j));
            }
            System.out.println(sb);
        }
    }

    public static List<List<String>> permute(char[] chars) {
        // 若数组为空，则直接返回结果列表
        if (chars == null || chars.length == 0) {
            return result;
        }
        // 调用回溯方法生成排列
        backTrack(chars);
        // 返回结果列表
        return result;
    }

    private static void backTrack(char[] chars) {
        // 如果当前路径的长度等于数组的长度，表示已经生成了一个排列
        if (paths.size() == chars.length) {
            // 将当前路径加入到结果列表中
            result.add(new ArrayList<>(paths));
            return;
        }
        // 遍历数组中的每个字符
        for (int i = 0; i < chars.length; i++) {
            // 如果当前路径已经包含该字符，说明该字符已经被使用过，直接跳过
            if (paths.contains(String.valueOf(chars[i]))) {
                continue;
            }
            // 将当前字符加入到当前路径中
            paths.add(String.valueOf(chars[i]));
            // 递归生成下一个字符的排列
            backTrack(chars);
            // 回溯，移除最后一个加入的字符，尝试其他可能的排列
            paths.remove(paths.size() - 1);
        }
    }
}
