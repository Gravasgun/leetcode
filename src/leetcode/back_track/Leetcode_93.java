package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_93 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() > 12) {
            return result;
        }
        backTrack(s, 0, 0);
        return result;
    }

    private void backTrack(String s, int startIndex, int pointNum) {
        // 如果已经有3个点号，且剩余部分是一个合法的IP地址，则添加到结果列表
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                backTrack(s, i + 2, ++pointNum);
                s = s.substring(0, i + 1) + s.substring(i + 2);
                pointNum--;
            } else {
                break;
            }
        }
    }

    private boolean isValid(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }
        if (s.charAt(startIndex) - '0' == 0 && endIndex > startIndex) {
            return false;
        }
        int num = Integer.parseInt(s.substring(startIndex, endIndex + 1));
        if (num < 0 || num > 255) {
            return false;
        }
        return true;
    }
}
