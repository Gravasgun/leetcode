package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 93.复原IP地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class Leetcode_93 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() > 12 || s.length() == 0) {
            return result;
        }
        backTrack(s, 0, 0);
        return result;
    }

    private void backTrack(String s, int startIndex, int pointNumber) {
        // 如果已经有3个点号，且剩余部分是一个合法的IP地址，则添加到结果列表
        if (pointNumber == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        // 在当前位置尝试添加点号，然后继续递归
        for (int i = startIndex; i < s.length(); i++) {
            // 判断从startIndex到i的子串是否是一个合法的数字
            if (isValid(s, startIndex, i)) {
                // 在i位置添加点号
                /**
                 * 在每次递归时，我们会在当前位置尝试添加一个点号，并将点号添加到字符串 s 中。
                 * 如果我们从 startIndex 开始处理，那么随着递归的进行，字符串 s 的长度将会不断缩小。
                 * 这会导致后续的递归处理只能在缩小后的字符串上进行，无法获取完整的原始字符串。
                 * 所以在下行代码中选择0而不是startIndex
                 */
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNumber++;
                // 递归处理下一个点号后的位置
                // 因为加了一个"."，所以回溯的startIndex应该是i+2
                backTrack(s, i + 2, pointNumber);
                // 回溯，去掉添加的点号
                pointNumber--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                // 不是合法的数字，直接退出循环
                break;
            }
        }
    }

    private boolean isValid(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }
        // 以0开头的多位数不合法
        if (s.charAt(startIndex) - '0' == 0 && endIndex != startIndex) {
            return false;
        }
        // 将子串转换为数字
        int number = Integer.parseInt(s.substring(startIndex, endIndex + 1));
        // 判断数字是否在0~255之间
        if (number < 0 || number > 255) {
            return false;
        }
        return true;
    }
}