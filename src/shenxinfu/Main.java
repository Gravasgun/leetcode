package shenxinfu;

import java.util.*;

/**
 * 题目描述：
 * 给定一个字符串，你需要计算这个字符串中不同字符的所有可能组合数目，然后输出组合数。
 * 输入示例：
 * abac
 * 输出示例：
 * 5 解释：不同字符的组合有 ["a", "b", "c", "ab", "ac"]，共有5种组合。
 */
public class Main {

    // 存储所有组合结果的列表
    static List<List<String>> result = new ArrayList<>();
    // 存储当前组合路径的列表
    static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        // 获取字符串中不同字符的子串
        String differentString = getDifferentString(s);
        // 计算不同字符的组合数
        getCombinationNum(differentString.toCharArray());
        // 输出组合数（减1是因为空集合也被计算在内）
        System.out.println(result.size() - 1);
    }

    // 计算组合数的主函数
    private static List<List<String>> getCombinationNum(char[] chars) {
        if (chars == null || chars.length == 0) {
            return result;
        }
        // 回溯算法生成所有组合
        backTrack(chars, 0);
        return result;
    }

    // 回溯算法的核心函数
    private static void backTrack(char[] chars, int startIndex) {
        // 将当前组合加入结果列表
        result.add(new ArrayList<>(path));
        if (startIndex >= chars.length) {
            return;
        }
        for (int i = startIndex; i < chars.length; i++) {
            // 将当前元素加入当前子集
            path.add(String.valueOf(chars[i]));
            // 递归生成下一个子集，起始索引为当前元素的下一个位置
            backTrack(chars, i + 1);
            // 回溯操作，将最后一个加入的元素移除，继续生成下一个子集
            path.remove(path.size() - 1);
        }
    }

    // 获取字符串中不同字符的子串
    private static String getDifferentString(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}