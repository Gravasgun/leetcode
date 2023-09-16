package shenxinfu;

import java.util.*;

public class Main {
    static List<List<String>> result = new ArrayList<>();
    static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        //System.out.println(s);
        String differentString = getDifferentString(s);
        //System.out.println(differentString);
        getCombinationNum(differentString.toCharArray());
        System.out.println(result.size()-1);
    }

    private static List<List<String>> getCombinationNum(char[] chars) {
        if (chars == null || chars.length == 0) {
            return result;
        }
        backTrack(chars, 0);
        return result;
    }

    private static void backTrack(char[] chars, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= chars.length) {
            return;
        }
        for (int i = startIndex; i < chars.length; i++) {
            path.add(String.valueOf(chars[i])); // 将当前元素加入当前子集
            backTrack(chars, i + 1); // 递归生成下一个子集，起始索引为当前元素的下一个位置
            path.remove(path.size() - 1); // 回溯操作，将最后一个加入的元素移除，继续生成下一个子集
        }
    }


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