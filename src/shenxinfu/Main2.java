package shenxinfu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static List<List<String>> result = new ArrayList<>();  // 用于存储结果的列表
    static List<String> paths = new ArrayList<>();  // 用于存储当前路径的列表

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        permute(s.toCharArray());
        for (int i = 0; i < result.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.get(i).size(); j++) {
                sb.append(result.get(i).get(j));
            }
            System.out.println(sb);
        }
    }

    public static List<List<String>> permute(char[] chars) {
        if (chars == null || chars.length == 0) {  // 若数组为空，则直接返回结果列表
            return result;
        }
        backTrack(chars);  // 调用回溯方法
        return result;  // 返回结果列表
    }

    private static void backTrack(char[] chars) {
        if (paths.size() == chars.length) {  // 如果当前路径的长度等于数组的长度，表示已经生成了一个排列
            result.add(new ArrayList<>(paths));// 将当前路径加入到结果列表中
            return;
        }
        for (int i = 0; i < chars.length; i++) {  // 遍历数组中的每个字符
            if (paths.contains(String.valueOf(chars[i]))) {  // 如果当前路径已经包含该字符，说明该字符已经被使用过，直接跳过
                continue;
            }
            paths.add(String.valueOf(chars[i]));  // 将当前字符加入到当前路径中
            backTrack(chars);  // 递归生成下一个字符的排列
            paths.remove(paths.size() - 1);  // 回溯，移除最后一个加入的数字，尝试其他可能的排列
        }
    }
}
