package meituan; /**
 * 题目描述：
 * 小美现在有一串彩带，假定每一厘米的彩带上都是一种色彩。
 * 因为任务的需要，小美希望从彩带上截取一段，使得彩带中的颜色数量不超过K种。
 * 显然，这样的截取方法可能非常多。于是小美决定尽量长地截取一段。
 * 你的任务是帮助小美截取尽量长的一段，使得这段彩带上不同的色彩数量不超过K种。
 */

import java.util.*;

/**
 * 输入描述：第一行两个整数N,K，以空格分开，分别表示彩带有N厘米长，你截取的一段连续的彩带不能超过K种颜色。
 * 接下来一行N个整数，每个整数表示一种色彩，相同的整数表示相同的色彩。
 * 1≤N,K≤5000，彩带上的颜色数字介于[1, 2000]之间。
 * 输出描述：一行，一个整数，表示选取的彩带的最大长度。
 */


public class Main2 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int count = input.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(input.nextInt());
        }
        int result = 0;
        for (int left = 0; left < list.size() - 1; left++) {
            set.clear();
            set.add(list.get(left));
            for (int temp = left + 1; temp < list.size(); temp++) {
                set.add(list.get(temp));
                if (set.size() == count + 1) {
                    result = Math.max(result, temp - left);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}